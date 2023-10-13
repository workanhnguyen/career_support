import { Button, CircularProgress, Container } from "@mui/material";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { Header } from "../components";
import useSurveyDetail from "../hooks/useSurveyDetail";
import { PieChart } from "../charts";
import { HollandResult } from "../interfaces/HollandResult";

type ChartType = {
  labels: string[];
  datasets: {
    data: number[];
    backgroundColor: string[];
  }[];
};

const HollandResultDetailPage: React.FC = () => {
  const { responseId } = useParams();
  const { surveyDetail, isSurveyDetailLoading } = useSurveyDetail(
    parseInt(responseId!)
  );

  const [data, setData] = useState<ChartType>({
    labels: [],
    datasets: [
      {
        data: [],
        backgroundColor: [],
      },
    ],
  });

  useEffect(() => {
    if (surveyDetail.length > 0) {
      const labels = surveyDetail.map((data) =>
        data.holland.title.substring(0, data.holland.title.indexOf(" - "))
      );
      const percentages = surveyDetail.map(
        (data) => Math.round(data.percentage * 100) / 100
      );

      setData({
        labels: labels,
        datasets: [
          {
            data: percentages,
            backgroundColor: [
              "#fc4103",
              "#8606c2",
              "#06c219",
              "#fcc203",
              "#00ccff",
              "#067dc2",
            ],
          },
        ],
      });
    }
  }, [surveyDetail]);
  console.log(surveyDetail);
  return (
    <Container>
      <Header />
      {isSurveyDetailLoading ? (
        <CircularProgress />
      ) : (
        <div className="mt-10">
          <PieChart chartData={data} />
          <section className="mt-5">
            <table className="w-full border-collapse mb-5">
              <thead>
                <tr className="border-2">
                  <th className="border-2 p-3">Lĩnh vực</th>
                  <th className="border-2 p-3">Mô tả</th>
                </tr>
              </thead>
              <tbody>
                {surveyDetail.map((item: HollandResult, index: number) => (
                  <tr key={index} className="border-2">
                    <td className="border-2 p-3">
                      <p>{item.holland.title}</p>
                    </td>
                    <td className="p-3 flex flex-col gap-3">
                      <p className="text-justify">
                        <span className="font-bold">Diễn giải:</span>&nbsp;
                        {item.holland.description}
                      </p>
                      <p className="text-justify">
                        <span className="font-bold">Ngành nghề phù hợp:</span>
                        &nbsp;
                        {item.holland.suitableCareer}
                      </p>
                      <p className="text-justify">
                        <span className="font-bold">Điểm mạnh:</span>&nbsp;
                        {item.holland.strength}
                      </p>
                      <p className="text-justify">
                        <span className="font-bold">Điểm yếu:</span>&nbsp;
                        {item.holland.weakness}
                      </p>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
            <Link to="/profile">
              <Button variant="contained" color="warning" disableElevation>
                Trở lại
              </Button>
            </Link>
          </section>
        </div>
      )}
    </Container>
  );
};

export default HollandResultDetailPage;
