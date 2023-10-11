import React from "react";
import { Survey } from "../interfaces/Survey";
import { Button, Paper } from "@mui/material";
import { Link } from "react-router-dom";

type SurveyItemProps = {
  survey: Survey;
};

const SurveyItem: React.FC<SurveyItemProps> = ({ survey }) => {
  return (
    <Paper className="h-fit flex flex-col justify-start p-4 gap-3" elevation={3}>
      <p className="text-md font-semibold">{survey.title}</p>
      <p className="text-base text-gray-400">{survey.author}</p>
      <Link to={`/surveys/${survey.id}`}>
        <Button className="w-fit" variant="contained" disableElevation>
          Bắt đầu
        </Button>
      </Link>
    </Paper>
  );
};

export default SurveyItem;
