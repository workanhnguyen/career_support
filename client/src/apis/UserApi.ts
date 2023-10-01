import { SERVER_CONTEXT, authApi } from "../configs/ApiConfig";

const endpoints = {
  currentUser: `${SERVER_CONTEXT}/api/v1/users/current-user`,
};

export const getCurrentUser = () => authApi().get(endpoints['currentUser']);