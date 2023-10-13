import React from "react";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import { useSelector } from "react-redux";

import {
  HollandResultDetailPage,
  HollandResultPage,
  HomePage,
  LandingPage,
  LoginPage,
  MakeSurveyPage,
  PersonalPage,
  RegisterPage,
  SurveyStarterPage,
} from "./pages";
import { RootState } from "./interfaces/RootState";

const App: React.FC = () => {
  const jwtToken = useSelector((state: RootState) => state.auth.jwtToken);

  return (
    <BrowserRouter>
      <Routes>
        {/* Public routes */}
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/" element={<LandingPage />} />

        {/* Authenticated routes */}
        {jwtToken !== "" && (
          <>
            <Route path="/home" element={<HomePage />} />
            <Route path="/surveys/:surveyId" element={<SurveyStarterPage />} />
            <Route
              path="/surveys/:surveyId/quiz"
              element={<MakeSurveyPage />}
            />
            <Route path="/surveys/result" element={<HollandResultPage />} />
            <Route
              path="/surveys/result/:responseId"
              element={<HollandResultDetailPage />}
            />
            <Route path="/profile" element={<PersonalPage />} />
          </>
        )}

        {/* Redirect if path is not existed */}
        <Route path="*" element={<Navigate to="/login" />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
