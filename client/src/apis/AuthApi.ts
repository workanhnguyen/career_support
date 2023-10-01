import ApiConfig, { SERVER_CONTEXT } from "../configs/ApiConfig";
import { UserRegisterForm } from "../interfaces/UserRegisterForm";

const endpoints = {
    'register': `${SERVER_CONTEXT}/api/v1/auth/register`
}

export const register = (body: UserRegisterForm) => ApiConfig.post(endpoints['register'], body);