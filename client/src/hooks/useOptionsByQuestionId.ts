// import { useEffect, useState } from "react";
// import { getQuestionsBySurveyId } from "../apis/SurveyApi";
// import { useDispatch } from "react-redux";
// import { saveOptionsOfQuestion, saveQuestionsOfSurvey } from "../slices/surveySlice";
// import { getOptionsByQuestionId } from "../apis/QuestionApi";

// function useOptionsByQuestionId(surveyId: number, questionId: number) {
//   const dispatch = useDispatch();
//   const [isOptionsLoading, setIsOptionsLoading] = useState<boolean>(false);

//   useEffect(() => {
//     const fetchQuestions = async () => {
//       try {
//         setIsOptionsLoading(true);
//         let response = await getOptionsByQuestionId(questionId);
//         console.log(surveyId, questionId);
//         response.status === 200 &&
//           dispatch(
//             saveOptionsOfQuestion({ surveyId, questionId, options: response.data })
//           );
//       } catch (error) {
//       } finally {
//         setIsOptionsLoading(false);
//       }
//     };

//     questionId && fetchQuestions();
//   }, [questionId]);
//   return { isOptionsLoading };
// }

// export default useOptionsByQuestionId;
