import { useEffect, useState } from 'react'
import { Survey } from '../interfaces/Survey';
import { getAllSurveys } from '../apis/SurveyApi';

function useSurveys() {
    const [surveys, setSurveys] = useState<Survey[]>([]);
    const [isSurveyLoading, setIsSurveyLoading] = useState<boolean>(false);
  
    useEffect(() => {
      const fetch = async () => {
        setIsSurveyLoading(true);
  
        try {
          let response = await getAllSurveys();
          response.status === 200 && setSurveys(response.data);
        } catch (error) {
          console.log(error);
        } finally {
          setIsSurveyLoading(false);
        }
      };
  
      fetch();
    }, []);
    return { surveys, isSurveyLoading };
}

export default useSurveys