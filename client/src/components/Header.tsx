import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";

import { Avatar, Box, Button, Divider, Menu, MenuItem } from "@mui/material";

import { User } from "../interfaces/User";
import { RootState } from "../interfaces/RootState";
import { persistor } from "../app/store";
import { logout } from "../apis/AuthApi";
import { clearAuthInfo } from "../slices/authSlice";

const Header: React.FC = () => {

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const currentUser: User | null = useSelector(
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

  const handleLogout = async () => {
    try {
      let res = await logout();
      if (res.status === 200) {
        setAnchorEl(null);
        dispatch(clearAuthInfo(null));
        persistor.purge();

        navigate('/', { replace: true });
      }
    } catch (error) {}
  };

  return (
    <Box>
      <header className="w-full h-16 flex justify-between items-center">
        <Link to="/">
          <img
            className="w-24"
            src="https://res.cloudinary.com/dduhlnft3/image/upload/v1696069111/frontend/logo-header-removebg-preview_dgsyuy.png"
            alt="logo-scoss"
          />
        </Link>
        {!currentUser?.email ? (
          <Link to="/login">
            <Button variant="contained" disableElevation size="large">
              Đăng nhập
            </Button>
          </Link>
        ) : (
          <section className="flex items-center gap-2">
            <div className="max-sm:hidden text-right">
              <p className="font-semibold">
                {currentUser?.lastName} {currentUser?.firstName}
              </p>
              <p className="text-gray-600">{currentUser?.email}</p>
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
              <MenuItem onClick={handleClose}>
                <Link to="/profile">Trang cá nhân</Link>
              </MenuItem>
              <MenuItem onClick={handleLogout} sx={{ color: "red" }}>
                Đăng xuất
              </MenuItem>
            </Menu>
          </section>
        )}
      </header>
      <Divider />
    </Box>
  );
};

export default Header;
