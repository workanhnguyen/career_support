import { createSlice } from "@reduxjs/toolkit";
import { SurveyState } from "../interfaces/SurveyState";
import { Survey } from "../interfaces/Survey";

const surveyState: SurveyState = {
  surveys: [],
  currentSurvey: {},
};

export const surveySlice = createSlice({
  name: "survey",
  initialState: surveyState,
  reducers: {
    saveSurveys: (state, action) => {
      const surveysToAdd = action.payload.map((survey: Survey) => {
        return {
          ...survey,
          questions: [],
        };
      });

      state.surveys = surveysToAdd;
    },

    saveCurrentSurvey: (state, action) => {
      state.currentSurvey = action.payload;
    },
  },
});

export const { saveSurveys, saveCurrentSurvey } = surveySlice.actions;
export default surveySlice.reducer;
