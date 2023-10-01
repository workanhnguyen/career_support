import { configureStore } from "@reduxjs/toolkit";
import authSlice from "../slices/authSlice";

export const rootReducer = {
    auth: authSlice
}

export const store = configureStore({
    reducer: rootReducer,
})