import { useState } from 'react';
import { UserRegisterForm } from '../interfaces/UserRegisterForm';
import { register } from '../apis/AuthApi';

function useUserRegistration() {
  const [isRegistering, setIsRegistering] = useState<boolean>(false);
  const [registrationError, setRegistrationError] = useState<string | unknown>(null);

  const registerUser = async (userData: UserRegisterForm) => {
    

    try {
      setIsRegistering(true);
      setRegistrationError(null);

      await register(userData); 

    } catch (error: any) {
      setRegistrationError(error.message);
    } finally {
      setIsRegistering(false);
    }
  };

  return {
    isRegistering,
    registrationError,
    registerUser,
  };
}

export default useUserRegistration;
