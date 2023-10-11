import { useEffect, useState } from "react";
import { getQuestionsBySurveyId } from "../apis/SurveyApi";
import { useDispatch } from "react-redux";
import { saveCurrentSurvey } from "../slices/surveySlice";

function useQuestionsBySurveyId(surveyId: number) {
  const dispatch = useDispatch();
  const [isQuestionsLoading, setIsQuestionsLoading] = useState<boolean>(false);

  useEffect(() => {
    const fetchQuestions = async () => {
      try {
        setIsQuestionsLoading(true);
        let response = await getQuestionsBySurveyId(surveyId);
        response.status === 200 &&
          dispatch(
            saveCurrentSurvey(response.data)
          );
      } catch (error) {
      } finally {
        setIsQuestionsLoading(false);
      }
    };

    fetchQuestions();
  }, [surveyId]);
  return { isQuestionsLoading };
}

export default useQuestionsBySurveyId;
