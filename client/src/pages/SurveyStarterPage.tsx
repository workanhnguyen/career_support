import React from "react";

import { Button, Container } from "@mui/material";
import { Link, useParams } from "react-router-dom";

import { Header } from "../components";
import useSurveyById from "../hooks/useSurveyById";
import { useInitResponse } from "../hooks";
import { useSelector } from "react-redux";
import { RootState } from "../interfaces/RootState";

const SurveyStarterPage: React.FC = () => {
  const { surveyId } = useParams();

  const {} = useSurveyById(Number(surveyId));
  const {} = useInitResponse();

  const survey = useSelector((state: RootState) => state.survey.currentSurvey);

  return (
    <main className="w-full flex justify-center">
      <Container maxWidth="md">
        <Header />
        <section className="w-full min-h-screen flex max-sm:flex-col max-sm:items-center justify-center items-center max-sm:mt-6 sm:-mt-20 gap-8">
          <img className="w-72" src={survey?.image} alt="img" />
          <div className="flex-1 flex flex-col gap-10">
            <p className="text-xl max-sm:text-center uppercase font-semibold">
              {survey?.title}
            </p>
            <div className="w-full flex flex-col gap-4">
              <p className="text-justify">{survey?.description}</p>
              <Link to={`/surveys/${surveyId}/quiz`}>
                <Button
                  variant="contained"
                  disableElevation
                  className="max-sm:w-full w-fit"
                >
                  Thực hiện khảo sát
                </Button>
              </Link>
            </div>
          </div>
        </section>
      </Container>
    </main>
  );
};

export default SurveyStarterPage;
