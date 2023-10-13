import React from "react";
import { Button, Paper } from "@mui/material";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";

import { RootState } from "../interfaces/RootState";

const paperStyle: object = {
  position: "relative",
  width: "100%",
  minHeight: "300px",
  backgroundImage:
    "url(https://res.cloudinary.com/dduhlnft3/image/upload/v1696045750/frontend/set-bright-school-stationery-orange-wall_y8ozka.jpg)",
  backgroundSize: "cover",
  backgroundPosition: "center",
  backgroundRepeat: "no-repeat",
  color: "black",
};

const MainIntro: React.FC = () => {
  const jwtToken = useSelector((state: RootState) => state.auth.jwtToken);

  return (
    <Paper elevation={1} sx={paperStyle}>
      <div className="absolute z-0 top-0 bottom-0 right-0 left-0 rounded-sm"></div>
      <div className="p-6 max-sm:w-full max-lg:w-3/4 lg:w-1/2 flex flex-col gap-6">
        <h1 className="text-4xl font-bold">
          Trắc nghiệm <br />
          định hướng nghề nghiệp
        </h1>
        <p className="text-xl">
          Làm bài khảo sát trắc nghiệm nghề nghiệp của tiến sĩ tâm lý học người
          Mỹ - John L.Holland để tìm ra ngành nghề phù hợp với bản thân.
        </p>
        <Link to={jwtToken === "" ? "/login" : "/home"}>
          <Button
            variant="contained"
            disableElevation
            sx={{
              width: "fit-content",
            }}
          >
            Làm khảo sát ngay!
          </Button>
        </Link>
      </div>
    </Paper>
  );
};

export default MainIntro;
