import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../interfaces/RootState";
import { useParams } from "react-router-dom";
import { Survey } from "../interfaces/Survey";
import { useQuestionsBySurveyId } from "../hooks";
import { Button, Container } from "@mui/material";
import { Header } from "../components";
// import useOptionsByQuestionId from "../hooks/useOptionsByQuestionId";
import { getOptionsByQuestionId } from "../apis/QuestionApi";
// import { saveOptionsOfQuestion } from "../slices/surveySlice";
import { Question } from "../interfaces/Question";
import { Option } from "../interfaces/Option";

const MakeSurveyPage: React.FC = () => {
  const { surveyId } = useParams();
  const dispatch = useDispatch();
  const currentSurvey = useSelector((state: RootState) => state.survey.currentSurvey);
  const [survey, setSurvey] = useState<Survey | undefined>(undefined);
  const [questions, setQuestions] = useState<Question[]>([]);
  const [questionIndex, setQuestionIndex] = useState<number>(0);
  //   const {} = useOptionsByQuestionId(Number(surveyId), Number(survey?.questions[questionIndex]?.id));

//   useEffect(() => {
//     const fetchQuestions = async () => {
//       console.log(survey?.questions[questionIndex]?.id);
//       try {
//         if (survey?.questions[questionIndex]?.id) {
//           // setIsOptionsLoading(true);
//           let response = await getOptionsByQuestionId(
//             survey?.questions[questionIndex].id
//           );
//           console.log(surveyId, survey?.questions[questionIndex].id);
//           response.status === 200 &&
//             dispatch(
//               saveOptionsOfQuestion({
//                 surveyId,
//                 questionId: survey?.questions[questionIndex].id,
//                 options: response.data,
//               })
//             );
//         }
//       } catch (error) {
//       } finally {
//         // setIsOptionsLoading(false);
//       }
//     };

//     fetchQuestions();
//   }, [survey?.questions[questionIndex]]);

//   useEffect(() => {
//     if (surveyId) {
//       const existingSurvey = surveys.find(
//         (survey: Survey) => survey.id === parseInt(surveyId)
//       );
//       setSurvey(existingSurvey);
//       setQuestions(existingSurvey?.questions || []);
//     }
//   }, [surveyId]);

//   useEffect(() => {}, [survey?.questions[questionIndex].options]);

  console.log(currentSurvey);

  return (
    <main className="w-full flex flex-col">
      <Container>
        <Header />
        <section>
          <p>
            <span>Câu {questionIndex + 1}: </span>
            <span>{currentSurvey?.questions[questionIndex]?.content}</span>
          </p>
          {currentSurvey &&
            currentSurvey.questions[questionIndex].options.map(
              (option: Option, index: number) => (
                <p key={index}>{option.content}</p>
              )
            )}
        </section>
        <Button onClick={() => setQuestionIndex((prev) => prev + 1)}>
          Câu tiếp theo
        </Button>
      </Container>
    </main>
  );
};

export default MakeSurveyPage;
