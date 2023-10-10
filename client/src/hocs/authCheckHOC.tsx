import React from "react";
import { useSelector } from "react-redux";
import { AlreadyLogin } from "../components";

const authCheckHOC = (WrappedComponent: React.ComponentType) => {
  return () => {
    const jwtToken: string = useSelector((state: any) => state.auth.jwtToken);
    console.log(jwtToken);

    if (jwtToken !== "") {
      return <AlreadyLogin />;
    }
    return <WrappedComponent />;
  };
};

export default authCheckHOC;
