import { SERVER_CONTEXT, authApi } from "../configs/ApiConfig";

const endpoints = {
    'save-and-calculate-holland-result': `${SERVER_CONTEXT}/api/v1/responses/holland`,
}

export const saveAndCalculateHollandResult = (response: any) => authApi().post(`${endpoints['save-and-calculate-holland-result']}`, response);