import ApiConfig, { SERVER_CONTEXT, authApi } from "../configs/ApiConfig";
import { UserLoginForm } from "../interfaces/UserLoginForm";
import { UserRegisterForm } from "../interfaces/UserRegisterForm";

const endpoints = {
  login: `${SERVER_CONTEXT}/api/v1/auth/authenticate`,
  register: `${SERVER_CONTEXT}/api/v1/auth/register`,
  currentUser: `${SERVER_CONTEXT}/api/v1/users/current-user`,
};

export const login = (body: UserLoginForm) => ApiConfig.post(endpoints["login"], body);
export const register = (body: UserRegisterForm) => ApiConfig.post(endpoints["register"], body);
export const getCurrentUser = () => authApi().get(endpoints['currentUser']);