import React from "react";
import { useSelector } from "react-redux";

import { AlreadyLogin } from "../components";
import { RootState } from "../interfaces/RootState";

const authCheckHOC = (WrappedComponent: React.ComponentType) => {
  return () => {
    const jwtToken: string = useSelector((state: RootState) => state.auth.jwtToken);

    if (jwtToken !== "") {
      return <AlreadyLogin />;
    }
    return <WrappedComponent />;
  };
};

export default authCheckHOC;
