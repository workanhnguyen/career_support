import React from "react";

import { CircularProgress } from "@mui/material";

const LoadingOverlay: React.FC = () => {
  return (
    <div className="fixed top-0 bottom-0 left-0 right-0 w-full h-screen flex justify-center items-center bg-black/20">
      <CircularProgress sx={{ color: "white" }} size={50} />
    </div>
  );
};

export default LoadingOverlay;
