import { createSlice } from "@reduxjs/toolkit";
import { SurveyState } from "../interfaces/SurveyState";
import { Survey } from "../interfaces/Survey";
import { Question } from "../interfaces/Question";
import { Option } from "../interfaces/Option";

const surveyState: SurveyState = {
  surveys: [],
  currentSurvey: {},
};

export const surveySlice = createSlice({
  name: "survey",
  initialState: surveyState,
  reducers: {
    saveSurveys: (state, action) => {
      console.log(action.payload);
      const surveysToAdd = action.payload.map((survey: Survey) => {
        return {
          ...survey,
          questions: [],
        };
      });
      console.log(surveysToAdd);

      state.surveys = surveysToAdd;
    },

    saveCurrentSurvey: (state, action) => {
      state.currentSurvey = action.payload
      console.log(action.payload);
    },
    // saveQuestionsOfSurvey: (state, action) => {
    //   const surveyId = action.payload.surveyId;
    //   const questionsToAdd = action.payload.questions.map((question: Question) => ({
    //     ...question,
    //     options: [],
    //   }));
    //   const surveyIndex = state.surveys.findIndex((survey) => survey.id === surveyId);

    //   if (surveyIndex !== -1) {
    //     state.surveys[surveyIndex].questions = questionsToAdd;
    //   }
    // },
    // saveOptionsOfQuestion: (state, action) => {
    //   const surveyId = action.payload.surveyId;
    //   const questionId = action.payload.questionId;
    //   const options = action.payload.options;

    //   const surveyIndex = state.surveys.findIndex((survey) => survey.id === parseInt(surveyId));
    //   if (surveyIndex !== -1) {
    //     const questionIndex = state.surveys[surveyIndex].questions.findIndex((question) => question.id === parseInt(questionId));

    //     if (questionIndex !== -1) {
    //       state.surveys[surveyIndex].questions[questionIndex].options = options;
    //       console.log(state.surveys[surveyIndex].questions[questionIndex].options)
    //     }
    //   }
    // },
  },
});

export const { saveSurveys, saveCurrentSurvey } = surveySlice.actions;
export default surveySlice.reducer;
