import React, { useState } from 'react'
import { HollandResult } from '../interfaces/HollandResult';

function useSurveyDetail() {
    const [surveyDetail, setSurveyDetail] = useState<HollandResult[]>([])
  return {};
}

export default useSurveyDetail