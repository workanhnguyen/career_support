import React, { useState } from "react";
import { useSelector } from "react-redux";

import { Box, Button, Container } from "@mui/material";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import ArrowBackIosIcon from "@mui/icons-material/ArrowBackIos";
import DoneAllIcon from "@mui/icons-material/DoneAll";

import { Header, QuestionData } from "../components";
import { RootState } from "../interfaces/RootState";

const MakeSurveyPage: React.FC = () => {
  const currentSurvey = useSelector(
    (state: RootState) => state.survey.currentSurvey
  );
  const response = useSelector((state: RootState) => state.response);
  const [questionIndex, setQuestionIndex] = useState<number>(0);
  const [isAllowToSwitchQuestion, setIsAllowToSwitchQuestion] =
    useState<boolean>(false);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
  };

  return (
    <main className="w-full flex flex-col mb-5">
      <Container>
        <Header />
        <Container maxWidth="md">
          <section className="w-full mt-10">
            <QuestionData
              onCheckAllowSwitchQuestion={setIsAllowToSwitchQuestion}
              questionIndex={questionIndex}
              question={currentSurvey?.questions[questionIndex]}
            />
          </section>
          <Box
            component="form"
            onSubmit={handleSubmit}
            className={`w-full flex ${
              questionIndex === 0 ? "justify-end" : "justify-between"
            } mt-6`}
          >
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
            {questionIndex === currentSurvey?.questions?.length - 1 && (
              <Button
                type="submit"
                variant="contained"
                disableElevation
                color="success"
                disabled={!isAllowToSwitchQuestion}
                endIcon={<DoneAllIcon />}
              >
                Hoàn thành...
              </Button>
            )}
          </Box>
        </Container>
      </Container>
    </main>
  );
};

export default MakeSurveyPage;
