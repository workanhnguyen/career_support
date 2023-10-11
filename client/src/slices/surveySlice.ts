import { createSlice } from "@reduxjs/toolkit";
import { SurveyState } from "../interfaces/SurveyState";

const surveyState: SurveyState = {
    surveys: []
}

export const surveySlice = createSlice({
  name: "survey",
  initialState: surveyState,
  reducers: {
    saveSurveys: (state, action) => {
      state.surveys = action.payload;
    },
    saveQuestionsOfSurvey: (state, action) => {
        const existingSurvey = state.surveys.find(survey => survey.id === action.payload.surveyId);
        existingSurvey && (existingSurvey.questions = action.payload.questions);
    },
    // saveOptionsOfQuestion: (state, action) => {
    //   state.questions = state.questions.map((question) =>
    //     question.id === action.payload.questionId
    //       ? (question = { ...question, options: action.payload.options })
    //       : question
    //   );
    // },
  },
});

export const { saveSurveys } = surveySlice.actions;
export default surveySlice.reducer;
