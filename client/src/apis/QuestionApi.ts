import { SERVER_CONTEXT, authApi } from "../configs/ApiConfig";

const endpoints = {
    'get-options-by-question-id': `${SERVER_CONTEXT}/api/v1/questions`,
}

export const getOptionsByQuestionId = (questionId: number) => authApi().get(`${endpoints['get-options-by-question-id']}/${questionId}/options`);