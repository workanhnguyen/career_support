import { SERVER_CONTEXT, authApi } from "../configs/ApiConfig";

const endpoints = {
    'save-and-calculate-holland-result': `${SERVER_CONTEXT}/api/v1/responses/holland`,
    'get-all-survey-histories': `${SERVER_CONTEXT}/api/v1/responses/by-current-user`,
    'get-repsonse-holland-detail': `${SERVER_CONTEXT}/api/v1/responses/holland/detail`,
}

export const saveAndCalculateHollandResult = (response: any) => authApi().post(`${endpoints['save-and-calculate-holland-result']}`, response);
export const getAllSurveyHistories = () => authApi().get(`${endpoints['get-all-survey-histories']}`);
export const getHollandResultDetail = (responseId: number) => authApi().get(`${endpoints['get-repsonse-holland-detail']}?responseId=${responseId}`);