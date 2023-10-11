import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../interfaces/RootState";
import { Response } from "../interfaces/Response";
import { Question } from "../interfaces/Question";
import { initResponse } from "../slices/responseSlice";

function useInitResponse() {
    const dispatch = useDispatch();
  const currentSurvey = useSelector(
    (state: RootState) => state.survey.currentSurvey
  );
  const currentUser = useSelector((state: RootState) => state.auth.currentUser);
  useEffect(() => {
    if (currentSurvey && currentUser) {
        const response: Response = {
            userId: currentUser.id,
            surveyId: currentSurvey.id,
            questions: currentSurvey.questions?.map((question: Question) => {
                return { id: question.id, options: question.options.map((option) => {
                    return { id: option.id, checked: false }
                })}
            })
        };
        dispatch(initResponse(response));
    }
  }, [currentSurvey]);
  return {};
}

export default useInitResponse;
