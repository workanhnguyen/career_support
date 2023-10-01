import React from "react";
import { Box, Button, Divider } from "@mui/material";
import { Link } from "react-router-dom";

const Header: React.FC = () => {
  return (
    <Box>
      <header className="w-full h-16 flex justify-between items-center">
        <img className="w-24" src="https://res.cloudinary.com/dduhlnft3/image/upload/v1696069111/frontend/logo-header-removebg-preview_dgsyuy.png" alt="logo-scoss" />
        <div className="flex">
          <Link to='/login'><Button variant="contained" disableElevation size="large">Đăng nhập</Button></Link>
        </div>
      </header>
      <Divider />
    </Box>
  );
};

export default Header;
