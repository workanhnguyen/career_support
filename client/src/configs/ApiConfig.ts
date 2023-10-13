import axios, { AxiosInstance } from "axios";
import Cookies from "universal-cookie";

export const SERVER_CONTEXT: string = "http://localhost:8085/server";

const cookies = new Cookies();

export const authApi = (): AxiosInstance => {
  return axios.create({
    baseURL: SERVER_CONTEXT,
    headers: {
      Authorization: "Bearer " + cookies.get("jwt_token"),
    },
  });
};

export default axios.create({
  baseURL: SERVER_CONTEXT,
});
