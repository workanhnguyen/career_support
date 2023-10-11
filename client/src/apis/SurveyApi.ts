import { SERVER_CONTEXT, authApi } from "../configs/ApiConfig";

const endpoints = {
    'get-all-surveys': `${SERVER_CONTEXT}/api/v1/surveys`
}

export const getAllSurveys = () => authApi().get(endpoints['get-all-surveys']);