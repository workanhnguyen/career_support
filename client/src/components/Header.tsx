import React from "react";
import { Avatar, Box, Button, Divider, Menu, MenuItem } from "@mui/material";
import { Link } from "react-router-dom";
import { User } from "../interfaces/User";
import { useSelector } from "react-redux";
import { RootState } from "../interfaces/RootState";

const Header: React.FC = () => {
  const currentUser: User = useSelector(
    (state: RootState) => state.auth.currentUser
  );

  const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);
  const open = Boolean(anchorEl);
  const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  return (
    <Box>
      <header className="w-full h-16 flex justify-between items-center">
        <img
          className="w-24"
          src="https://res.cloudinary.com/dduhlnft3/image/upload/v1696069111/frontend/logo-header-removebg-preview_dgsyuy.png"
          alt="logo-scoss"
        />
        {!currentUser.email ? (
          <Link to="/login">
            <Button variant="contained" disableElevation size="large">
              Đăng nhập
            </Button>
          </Link>
        ) : (
          <section className="flex items-center gap-2">
            <div className="max-sm:hidden text-right">
              <p className="font-semibold">
                {currentUser.lastName} {currentUser.firstName}
              </p>
              <p className="text-gray-600">{currentUser.email}</p>
            </div>
            <button
              id="user-choice"
              aria-controls={open ? "user-menu" : undefined}
              aria-haspopup="true"
              aria-expanded={open ? "true" : undefined}
              onClick={handleClick}
            >
              <Avatar
                className="hover:ring-2 ring-gray-200 cursor-pointer"
                src={currentUser.avatar}
                alt="avt"
                sx={{ width: "48px", height: "48px" }}
              />
            </button>

            {/* User menu */}
            <Menu
              id="user-menu"
              anchorEl={anchorEl}
              open={open}
              onClose={handleClose}
              MenuListProps={{
                "aria-labelledby": "user-choice",
              }}
            >
              <MenuItem onClick={handleClose}>Trang cá nhân</MenuItem>
              <MenuItem onClick={handleClose} sx={{ color: 'red'}}>Đăng xuất</MenuItem>
            </Menu>
          </section>
        )}
      </header>
      <Divider />
    </Box>
  );
};

export default Header;
