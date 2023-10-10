import { useState } from "react";
import { useDispatch } from "react-redux";

import { saveCurrentUser, saveJwtToken } from "../slices/authSlice";
import { getCurrentUser } from "../apis/UserApi";
import { login } from "../apis/AuthApi";
import { UserLoginForm } from "../interfaces/UserLoginForm";

function useUserLogin() {
  const dispatch = useDispatch();

  const [isLogging, setIsLogging] = useState<boolean>(false);
  const [loginErrorMessage, setLoginErrorMessage] = useState<string>("");

  const loginUser = async (loginData: UserLoginForm) => {
    try {
      setIsLogging(true);
      setLoginErrorMessage("");

      let jwtTokenResponse = await login(loginData);
      if (jwtTokenResponse.status === 200) {
        dispatch(saveJwtToken(jwtTokenResponse.data.token));

        let currentUserResponse = await getCurrentUser();
        currentUserResponse.status === 200 && dispatch(saveCurrentUser(currentUserResponse.data))
      }

    } catch (error: any) {
      setLoginErrorMessage("Email hoặc mật khẩu không chính xác");
    } finally {
      setIsLogging(false);
      setTimeout(() => setLoginErrorMessage(""), 2000);
    }
  };
  return { loginUser, isLogging, loginErrorMessage };
}

export default useUserLogin;
