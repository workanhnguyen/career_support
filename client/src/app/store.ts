import { configureStore } from "@reduxjs/toolkit";
import authSlice from "../slices/authSlice";

const rootReducer = {
    auth: authSlice
}

export const store = configureStore({
    reducer: rootReducer,
})