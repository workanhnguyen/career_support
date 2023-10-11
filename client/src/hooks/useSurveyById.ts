import { useEffect, useState } from "react";
import { Survey } from "../interfaces/Survey";
import { getSurveyById } from "../apis/SurveyApi";
import { useDispatch } from "react-redux";
import { saveCurrentSurvey } from "../slices/surveySlice";

function useSurveyById(surveyId: number) {
  const dispatch = useDispatch();
  const [survey, setSurvey] = useState<Survey | null>(null);
  const [isSurveyLoading, setIsSurveyLoading] = useState<boolean>(false);

  useEffect(() => {
    const fetch = async () => {
      setIsSurveyLoading(true);
      try {
        let response = await getSurveyById(surveyId);
        // console.log(response.data)
        if (response.status === 200) {
          setSurvey(response.data);
          dispatch(saveCurrentSurvey(response.data));
        }
      } catch (error) {
        console.log(error);
      } finally {
        setIsSurveyLoading(false);
      }
    };

    fetch();
  }, [surveyId]);
  return { survey, isSurveyLoading };
}

export default useSurveyById;
