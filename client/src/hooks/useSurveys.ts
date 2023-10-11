import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";

import { getAllSurveys } from "../apis/SurveyApi";
import { saveSurveys } from "../slices/surveySlice";

function useSurveys() {
  const dispatch = useDispatch();

  const [isSurveysLoading, setIsSurveysLoading] = useState<boolean>(false);

  useEffect(() => {
    const fetch = async () => {
      setIsSurveysLoading(true);

      try {
        let response = await getAllSurveys();
        response.status === 200 && dispatch(saveSurveys(response.data));
      } catch (error) {
        console.log(error);
      } finally {
        setIsSurveysLoading(false);
      }
    };

    fetch();
  }, []);
  return { isSurveysLoading };
}

export default useSurveys;
