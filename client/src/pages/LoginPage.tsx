import React from "react";
import { Link } from "react-router-dom";
import { useForm } from "react-hook-form";
import { z, ZodType } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";

import {
  Alert,
  Avatar,
  Box,
  Button,
  Container,
  CssBaseline,
  Grid,
  Snackbar,
  TextField,
  ThemeProvider,
  Typography,
  createTheme,
} from "@mui/material";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";

import useUserLogin from "../hooks/useUserLogin";
import { LoadingOverlay } from "../components";

const defaultTheme = createTheme();

type UserFormData = {
  email: string;
  password: string;
};

const LoginPage: React.FC = () => {
  const UserSchema: ZodType<UserFormData> = z.object({
    email: z.string().email({ message: "Email không hợp lệ" }),
    password: z.string().min(1, { message: "Không được bỏ trống" }),
  });

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<UserFormData>({ resolver: zodResolver(UserSchema) });
  const { loginUser, isLogging, loginErrorMessage } = useUserLogin();

  const onSubmit = (data: UserFormData) => {
    const loginData: UserFormData = {
      email: data.email,
      password: data.password,
    };

    loginUser(loginData);
  };
  return (
    <div className="relative">
      <ThemeProvider theme={defaultTheme}>
        <Container component="main" maxWidth="xs">
          <CssBaseline />
          <Box
            sx={{
              marginTop: 8,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Đăng nhập
            </Typography>
            <Box
              component="form"
              onSubmit={handleSubmit(onSubmit)}
              noValidate
              sx={{ mt: 1 }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Địa chỉ email"
                autoComplete="email"
                autoFocus
                {...register("email")}
                error={errors.email ? true : false}
                helperText={errors.email?.message}
              />
              <TextField
                margin="normal"
                required
                fullWidth
                label="Mật khẩu"
                type="password"
                id="password"
                autoComplete="current-password"
                {...register("password")}
                error={errors.password ? true : false}
                helperText={errors.password?.message}
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                disableElevation
                sx={{ mt: 3, mb: 2 }}
              >
                Đăng nhập
              </Button>
              <Grid container>
                <Grid
                  item
                  xs
                  sx={{ display: "flex", justifyContent: "center" }}
                >
                  <p>Chưa có tài khoản?</p>
                  <Link
                    to="/register"
                    className="hover:underline hover:text-primary"
                  >
                    &nbsp;Đăng ký
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
          <Copyright sx={{ mt: 8, mb: 4 }} />
        </Container>
      </ThemeProvider>

      {/* Snackbar alert */}
      <Snackbar
        anchorOrigin={{ vertical: "bottom", horizontal: "right" }}
        open={loginErrorMessage !== ""}
        autoHideDuration={2000}
      >
        <Alert severity="error" variant="filled">
          {loginErrorMessage as string}
        </Alert>
      </Snackbar>

      {/* Overlay logging */}
      {isLogging && <LoadingOverlay />}
    </div>
  );
};

export default LoginPage;

function Copyright(props: any) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"Copyright © " }
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}
