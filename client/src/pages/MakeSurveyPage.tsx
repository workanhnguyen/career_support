import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../interfaces/RootState";
import { useParams } from "react-router-dom";
import { Survey } from "../interfaces/Survey";
import { useQuestionsBySurveyId } from "../hooks";
import { Backdrop, Button, Container } from "@mui/material";
import ArrowForwardIosIcon from '@mui/icons-material/ArrowForwardIos';
import ArrowBackIosIcon from '@mui/icons-material/ArrowBackIos';
import { Header, QuestionData } from "../components";
// import useOptionsByQuestionId from "../hooks/useOptionsByQuestionId";
import { getOptionsByQuestionId } from "../apis/QuestionApi";
// import { saveOptionsOfQuestion } from "../slices/surveySlice";
import { Question } from "../interfaces/Question";
import { Option } from "../interfaces/Option";
import { persistor } from "../app/store";

const MakeSurveyPage: React.FC = () => {
  const { surveyId } = useParams();
  const dispatch = useDispatch();
  const currentSurvey = useSelector(
    (state: RootState) => state.survey.currentSurvey
  );
  const [survey, setSurvey] = useState<Survey | undefined>(undefined);
  const [response, setResponse] = useState<Response[]>([])
  const [questionIndex, setQuestionIndex] = useState<number>(0);
  const [isAllowToSwitchQuestion, setIsAllowToSwitchQuestion] = useState<boolean>(false);

  const [isOpenConfirmationDialog, setIsOpenConfirmationDialog] = useState<boolean>(false);

  console.log(isAllowToSwitchQuestion);
  return (
    <>
      <main className="w-full flex flex-col mb-5">
        <Container>
          <Header />
          <Container maxWidth="md">
            <section className="w-full mt-10">
              <QuestionData
                isAllowToSwitchQuestion={isAllowToSwitchQuestion}
                onCheckAllowSwitchQuestion={setIsAllowToSwitchQuestion}
                questionIndex={questionIndex}
                question={currentSurvey?.questions[questionIndex]}
              />
            </section>
            <section className={`w-full flex ${questionIndex === 0 ? 'justify-end' : 'justify-between'} mt-6`}>
              {questionIndex > 0 && (
                <Button
                  onClick={() => setQuestionIndex((prev) => prev - 1)}
                  variant="contained"
                  disableElevation
                  disabled={!isAllowToSwitchQuestion}
                  startIcon={<ArrowBackIosIcon />}
                >
                  Câu trước
                </Button>
              )}
              {questionIndex < currentSurvey?.questions?.length - 1 && (
                <Button
                  onClick={() => setQuestionIndex((prev) => prev + 1)}
                  variant="contained"
                  disableElevation
                  disabled={!isAllowToSwitchQuestion}
                  endIcon={<ArrowForwardIosIcon />}
                >
                  Câu tiếp theo
                </Button>
              )}
            </section>
          </Container>
        </Container>
      </main>
    </>
  );
};

export default MakeSurveyPage;
