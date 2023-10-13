import { useEffect, useState } from "react";

import { HollandResult } from "../interfaces/HollandResult";
import { getHollandResultDetail } from "../apis/ResponseApi";

function useSurveyDetail(responseId: number) {
  const [surveyDetail, setSurveyDetail] = useState<HollandResult[]>([]);
  const [isSurveyDetailLoading, setIsSurveyDetailLoading] =
    useState<boolean>(false);
  useEffect(() => {
    const fetch = async () => {
      try {
        setIsSurveyDetailLoading(true);
        let res = await getHollandResultDetail(responseId);
        res.status === 200 && setSurveyDetail(res.data);
      } catch (error) {
      } finally {
        setIsSurveyDetailLoading(false);
      }
    };

    fetch();
  }, [responseId]);
  return { surveyDetail, isSurveyDetailLoading };
}

export default useSurveyDetail;
