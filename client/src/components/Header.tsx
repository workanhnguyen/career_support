import React from "react";
import { Box, Button, Divider } from "@mui/material";

import { logoHeader } from "../assets";

const Header: React.FC = () => {
  return (
    <Box>
      <header className="w-full h-16 flex justify-between items-center px-6">
        <img className="w-24" src={logoHeader} alt="logo-scoss" />
        <div className="flex gap-3">
          <Button variant="outlined">Đăng nhập</Button>
          <Button variant="contained" disableElevation>
            Đăng ký
          </Button>
        </div>
      </header>
      <Divider />
    </Box>
  );
};

export default Header;
