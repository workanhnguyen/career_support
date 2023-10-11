import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";

import { Survey } from "../interfaces/Survey";
import { getAllSurveys } from "../apis/SurveyApi";
import { saveSurveys } from "../slices/surveySlice";

function useSurveys() {
  const dispatch = useDispatch();

  const [isSurveyLoading, setIsSurveyLoading] = useState<boolean>(false);

  useEffect(() => {
    const fetch = async () => {
      setIsSurveyLoading(true);

      try {
        let response = await getAllSurveys();

        response.status === 200 && dispatch(saveSurveys(response.data));
      } catch (error) {
        console.log(error);
      } finally {
        setIsSurveyLoading(false);
      }
    };

    fetch();
  }, []);
  return { isSurveyLoading };
}

export default useSurveys;
