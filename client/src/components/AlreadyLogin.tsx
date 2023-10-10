import React from "react";

import CheckCircleIcon from "@mui/icons-material/CheckCircle";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const AlreadyLogin: React.FC = () => {
  const navigate = useNavigate();
  return (
    <div className="w-full h-screen flex flex-col justify-center items-center gap-4">
      <CheckCircleIcon sx={{ fontSize: "120px" }} color="success" />
      <p className="text-xl">Bạn đã đăng nhập rồi!</p>
      <Button variant="outlined" onClick={() => navigate(-1)}>
        Quay lại
      </Button>
    </div>
  );
};

export default AlreadyLogin;
