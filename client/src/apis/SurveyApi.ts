import { SERVER_CONTEXT, authApi } from "../configs/ApiConfig";

const endpoints = {
    'get-all-surveys': `${SERVER_CONTEXT}/api/v1/surveys`,
    'get-by-id': `${SERVER_CONTEXT}/api/v1/surveys`,
    'get-questions-by-survey-id': `${SERVER_CONTEXT}/api/v1/surveys`,
}

export const getAllSurveys = () => authApi().get(endpoints['get-all-surveys']);
export const getSurveyById = (surveyId: number) => authApi().get(`${endpoints['get-by-id']}/${surveyId}`)
export const getQuestionsBySurveyId = (surveyId: number) => authApi().get(`${endpoints['get-questions-by-survey-id']}/${surveyId}/questions`);