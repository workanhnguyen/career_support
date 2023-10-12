import { createSlice } from "@reduxjs/toolkit";
import { Response } from "../interfaces/Response";

export const responseState: Response = {
  userId: 0,
  surveyId: 0,
  questions: [
    {
      id: 0,
      options: [
        {
          id: 0,
          checked: false,
        },
      ],
    },
  ],
};

export const responseSlice = createSlice({
  name: "response",
  initialState: responseState,
  reducers: {
    initResponse: (_, action) => {
      return { ...action.payload };
    },
    toggleCheckOptionResponse: (state, action) => {
      return {
        ...state,
        questions: state.questions.map((question) => {
          if (question.id === action.payload.questionId) {
            const updatedOptions = question.options.map((option) => {
              if (option.id === action.payload.optionId) {
                return { ...option, checked: !option.checked };
              }
              return option;
            });
    
            return { ...question, options: updatedOptions };
          }
          return question;
        }),
      };
    }
  },
});

export const { toggleCheckOptionResponse, initResponse } = responseSlice.actions;
export default responseSlice.reducer;
