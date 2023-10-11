import { createSlice } from "@reduxjs/toolkit";
import { SurveyState } from "../interfaces/SurveyState";
import { Survey } from '../interfaces/Survey';

const surveyState: SurveyState = {
    surveys: []
}

export const surveySlice = createSlice({
  name: "survey",
  initialState: surveyState,
  reducers: {
    saveSurveys: (state, action) => {
        const tempArray: Survey[] = action.payload;
        tempArray.forEach((survey: Survey) => {
            state.surveys.push({...survey, questions: []})
        })
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
