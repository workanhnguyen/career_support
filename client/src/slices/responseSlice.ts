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
    initResponse: (state, action) => {
      return {...action.payload};
    },
    toggleCheck: (state, action) => {
      // Create a new state object with updated data
      return {
        ...state,
        questions: state.questions.map((question) => {
          if (question.id === action.payload.questionId) {
            const updatedOptions = question.options.map((option) => {
              if (option.id === action.payload.optionId) {
                // Create a new option object with the 'checked' property updated
                return { ...option, checked: !option.checked };
              }
              return option;
            });
    
            // Create a new question object with the updated options
            return { ...question, options: updatedOptions };
          }
          return question;
        }),
      };
    }
  },
});

export const { toggleCheck, initResponse } = responseSlice.actions;
export default responseSlice.reducer;
