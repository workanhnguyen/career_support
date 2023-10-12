import React, { useEffect } from "react";
import { Question } from "../interfaces/Question";
import { Option } from "../interfaces/Option";
import { Checkbox, FormControlLabel, FormGroup, Paper, colors } from "@mui/material";
import { useDispatch, useSelector } from "react-redux";
import { toggleCheckOptionResponse } from "../slices/responseSlice";
import { RootState } from "../interfaces/RootState";

type QuestionProps = {
  questionIndex: number;
  question: Question;
};

const QuestionData: React.FC<QuestionProps> = ({ questionIndex, question }) => {
  const dispatch = useDispatch();

  const response = useSelector((state: RootState) => state.response);

  const handleToggleOption = (optionId: number) => {
    dispatch(toggleCheckOptionResponse({ questionId: question.id, optionId }))
  }

  const handleChecked = (optionId: number) => {
    const existingResponse = response.questions[questionIndex].options.find(option => option.id === optionId);
    return existingResponse?.checked;
  }

  useEffect(() => {}, [response]);
  console.log(response.questions[questionIndex].options)
  return (
    <>
      <p className="text-lg font-semibold">
        <span>Câu {questionIndex + 1}: </span>
        <span>{question.content}</span>
      </p>
      <FormGroup className="gap-3 mt-5">
        {question?.options.map((option: Option, index: number) => (
          <Paper key={index} className="w-full gap-2 items-center p-2 hover:bg-gray-200 cursor-pointer">
            <FormControlLabel control={<Checkbox onChange={() => handleToggleOption(option.id)} checked={handleChecked(option.id)} />} label={option.content} sx={{ marginLeft: '2px', width: '100%' }} />
          </Paper>
        ))}
      </FormGroup>
    </>
  );
};

export default QuestionData;
