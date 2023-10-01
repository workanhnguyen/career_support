import { useState } from 'react';
import { UserRegisterForm } from '../interfaces/UserRegisterForm';
import { register } from '../apis/AuthApi';

function useUserRegistration() {
  const [isRegistering, setIsRegistering] = useState<boolean>(false);
  const [registrationMessage, setRegistrationMessage] = useState<string | unknown>('');
  const [registrationType, setRegistrationType] = useState<boolean>(false);


  const registerUser = async (userData: UserRegisterForm) => {
    

    try {
      setIsRegistering(true);
      setRegistrationMessage('');

      await register(userData); 
      setRegistrationType(true);
      setRegistrationMessage("Đăng ký thành công! Vui lòng kiểm tra email để kích hoạt tài khoản!");
    } catch (error: any) {
      setRegistrationType(false);
      switch(error.response.status) {
        case 406:
          setRegistrationMessage("Email đã được sử dụng");
      }
    } finally {
      setIsRegistering(false);
      setTimeout(() => setRegistrationMessage(''), 2000);
    }
  };

  return {
    isRegistering,
    registrationMessage,
    registerUser,
    registrationType
  };
}

export default useUserRegistration;
