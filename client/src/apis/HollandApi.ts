import ApiConfig, { SERVER_CONTEXT } from "../configs/ApiConfig";

const endpoints = {
    'get-all-hollands': `${SERVER_CONTEXT}/api/v1/hollands`
}

export const getAllHollands = () => ApiConfig.get(endpoints['get-all-hollands']);