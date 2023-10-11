import React, { useEffect } from "react";

import { SurveyItem, SurveySkeleton, Title } from "../components";
import { useSurveys } from "../hooks";
import { Grid } from "@mui/material";
import { useSelector } from "react-redux";
import { RootState } from "../interfaces/RootState";

const SurveyList: React.FC = () => {
  const { isSurveysLoading } = useSurveys();
  
  const surveys = useSelector((state: RootState) => state.survey.surveys);
  return (
    <div>
      <Title text="Danh sách bài khảo sát" />
      {isSurveysLoading ? (
        <SurveySkeleton />
      ) : (
        <Grid container spacing={3}>
          {surveys.map((survey, index) => (
            <Grid item xs={12} sm={6} md={4} key={index}>
              <SurveyItem survey={survey} />
            </Grid>
          ))}
        </Grid>
      )}
    </div>
  );
};

export default SurveyList;
