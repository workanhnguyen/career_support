import { useEffect, useState } from "react";

import { SurveyHistory } from "../interfaces/SurveyHistory";
import { getAllSurveyHistories } from "../apis/ResponseApi";

function useSurveyHistories() {
  const [surveyHistories, setSurveyHistories] = useState<SurveyHistory[]>([]);
  const [isSurveyHistoryLoading, setIsSurveyHistoryLoading] =
    useState<boolean>(false);
  useEffect(() => {
    const fetch = async () => {
      try {
        setIsSurveyHistoryLoading(true);

        let response = await getAllSurveyHistories();
        response.status === 200 && setSurveyHistories(response.data);
      } catch (error) {
      } finally {
        setIsSurveyHistoryLoading(false);
      }
    };

    fetch();
  }, []);
  return { surveyHistories, isSurveyHistoryLoading };
}

export default useSurveyHistories;
