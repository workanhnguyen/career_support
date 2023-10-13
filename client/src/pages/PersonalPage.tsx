import { Avatar, Button, CircularProgress, Container, Paper } from "@mui/material";
import React, { useEffect } from "react";
import moment from "moment";
import "moment/locale/vi";
import { Footer, Header, Title } from "../components";
import { useSelector } from "react-redux";
import { RootState } from "../interfaces/RootState";
import { useSurveyHistories } from "../hooks";
import { SurveyHistory } from "../interfaces/SurveyHistory";

moment.locale("vi");

const PersonalPage: React.FC = () => {
  const currentUser = useSelector((state: RootState) => state.auth.currentUser);
  const { surveyHistories, isSurveyHistoryLoading } = useSurveyHistories();
  return (
    <>
        <Container className="mb-10">
          <Header />
          <div className="relative mt-5">
            <div className="max-sm:h-40 h-60 bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 rounded-md">
              <div className="absolute max-sm:top-24 top-44 w-full flex justify-center">
                <Avatar
                  sx={{ width: "120px", height: "120px" }}
                  src={currentUser.avatar}
                  className="ring-4 ring-gray-200"
                />
              </div>
            </div>
            <div className="w-full flex flex-col items-center mt-20 gap-1">
              <p className="text-2xl font-semibold">
                {currentUser.lastName} {currentUser.firstName}
              </p>
              <p className="text-gray-600">{currentUser.email}</p>
            </div>
          </div>
    
          <div className="mt-5">
            <Title text="Lịch sử khảo sát" />
            {isSurveyHistoryLoading ? (
              <div className="w-full flex justify-center">
                <CircularProgress />
              </div>
            ) : (
              <div className="flex flex-col gap-4">
                {surveyHistories.map((survey: SurveyHistory, index: number) => (
                  <Paper key={index} elevation={2} className="flex justify-between items-center p-4 gap-10">
                    <div className="flex max-md:flex-col max-md:gap-2 gap-5 truncate">
                        <p className="truncate font-semibold">{survey.surveyTitle}</p>
                        <p className="">{moment(survey.createdAt).fromNow()}</p>
                    </div>
                    <Button className="w-48" variant="contained" disableElevation>Chi tiết</Button>
                  </Paper>
                ))}
              </div>
            )}
          </div>
        </Container>
        <Footer />
    </>
  );
};

export default PersonalPage;
