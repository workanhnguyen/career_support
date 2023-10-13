import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import { z, ZodType } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider } from "@mui/material/styles";

import { PASSWORD_REGEX } from "../constants/regexes";
import { UserRegisterForm } from "../interfaces/UserRegisterForm";
import { useUserRegistration } from "../hooks";
import { Alert, Snackbar } from "@mui/material";
import { LoadingOverlay } from "../components";
import authCheckHOC from "../hocs/authCheckHOC";

const defaultTheme = createTheme();

type UserFormData = {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  confirmPassword: string;
};

const RegisterPage: React.FC = () => {
  const UserSchema: ZodType<UserFormData> = z
    .object({
      firstName: z
        .string()
        .min(1, { message: "Không được bỏ trống" })
        .max(20, { message: "Tên không vượt quá 20 ký tự" }),
      lastName: z
        .string()
        .min(1, { message: "Không được bỏ trống" })
        .max(40, { message: "Họ và tên đệm không vượt quá 40 ký tự" }),
      email: z
        .string()
        .email({ message: "Email không hợp lệ" })
        .max(40, { message: "Email quá dài" }),
      password: z
        .string()
        .min(5, { message: "Mật khẩu phải có ít nhất 5 ký tự" })
        .max(20, { message: "Mật khẩu không vượt quá 20 ký tự" })
        .regex(PASSWORD_REGEX, {
          message:
            "Mật khẩu không được chứa khoảng trắng, phải chứa ít nhất 1 ký tự viết thường, 1 ký tự viết hoa, 1 chữ số, 1 ký tự đặc biệt",
        }),
      confirmPassword: z.string(),
    })
    .refine((data) => data.password === data.confirmPassword, {
      message: "Mật khẩu không trùng khớp",
      path: ["confirmPassword"],
    });
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm<UserFormData>({ resolver: zodResolver(UserSchema) });

  const { isRegistering, registrationMessage, registerUser, registrationType } =
    useUserRegistration();

  const onSubmit = (data: UserFormData) => {
    const registerData: UserRegisterForm = {
      firstName: data.firstName,
      lastName: data.lastName,
      email: data.email,
      password: data.password,
    };

    registerUser(registerData);
  };

  useEffect(() => {
    registrationType && reset();
  }, [registrationType]);

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
              Đăng ký
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={handleSubmit(onSubmit)}
              sx={{ mt: 3 }}
            >
              <Grid container spacing={2}>
                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    id="lastName"
                    label="Họ và tên đệm"
                    autoComplete="family-name"
                    {...register("lastName")}
                    error={errors.lastName ? true : false}
                    helperText={errors.lastName?.message}
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    autoComplete="given-name"
                    required
                    fullWidth
                    id="firstName"
                    label="Tên"
                    {...register("firstName")}
                    error={errors.firstName ? true : false}
                    helperText={errors.firstName?.message}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    id="email"
                    label="Địa chỉ email"
                    autoComplete="email"
                    type="email"
                    {...register("email")}
                    error={errors.email ? true : false}
                    helperText={errors.email?.message}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    label="Mật khẩu"
                    type="password"
                    id="password"
                    autoComplete="new-password"
                    {...register("password")}
                    error={errors.password ? true : false}
                    helperText={errors.password?.message}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    label="Nhập lại mật khẩu"
                    type="password"
                    id="confirm-password"
                    autoComplete="confirm-password"
                    {...register("confirmPassword")}
                    error={errors.confirmPassword ? true : false}
                    helperText={errors.confirmPassword?.message}
                  />
                </Grid>
              </Grid>
              <Button
                type="submit"
                fullWidth
                variant="contained"
                disableElevation
                sx={{ mt: 3, mb: 2 }}
              >
                Đăng ký
              </Button>
              <Grid container>
                <Grid
                  item
                  xs
                  sx={{ display: "flex", justifyContent: "center" }}
                >
                  <p>Đã có tài khoản?</p>
                  <Link
                    to="/login"
                    className="hover:underline hover:text-primary"
                  >
                    &nbsp;Đăng nhập
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
          <Copyright sx={{ mt: 5 }} />
        </Container>
      </ThemeProvider>

      {/* Overlay registering */}
      {isRegistering && <LoadingOverlay />}

      {/* Snackbar alert */}
      <Snackbar
        anchorOrigin={{ vertical: "bottom", horizontal: "right" }}
        open={registrationMessage !== ""}
        autoHideDuration={2000}
      >
        {registrationType ? (
          <Alert severity="success" variant="filled">
            {registrationMessage as string}
          </Alert>
        ) : (
          <Alert severity="error" variant="filled">
            {registrationMessage as string}
          </Alert>
        )}
      </Snackbar>
    </div>
  );
};

export default authCheckHOC(RegisterPage);

function Copyright(props: any) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"Copyright © "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}
