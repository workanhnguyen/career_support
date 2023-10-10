import React, { ComponentType } from 'react'
import { useSelector } from 'react-redux'
import { Navigate } from 'react-router-dom'

const withAuth = (WrappedComponent: ComponentType) => {
  const AuthenticatedComponent: React.FC = (props) => {
    const isAuthenticated = useSelector((state: any) => state.auth.jwtToken);
    console.log(isAuthenticated);

    if (isAuthenticated !== '')  {
      return <h1>Bạn đã đăng nhập rồi</h1>;
    }
    return <WrappedComponent {...props} />
  }

  return AuthenticatedComponent;
}

export default withAuth