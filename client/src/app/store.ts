import { configureStore } from "@reduxjs/toolkit";
import authSlice from "../slices/authSlice";
import surveySlice from "../slices/surveySlice";

const rootReducer = {
    auth: authSlice,
    survey: surveySlice
}

export const store = configureStore({
    reducer: rootReducer,
})