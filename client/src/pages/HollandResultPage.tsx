import React, { useEffect, useState } from "react";
import { HollandResult } from "../interfaces/HollandResult";
import { PieChart } from "../charts";
import { Container } from "@mui/material";
import { Header } from "../components";

type ChartType = {
  labels: string[];
  datasets: {
    data: number[];
    backgroundColor: string[];
  }[];
};

const HollandResultPage: React.FC = () => {
  const [result, setResult] = useState<HollandResult[]>(
    JSON.parse(localStorage.getItem("holland_result")!) || []
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
    if (result.length > 0) {
      const labels = result.map((data) => data.holland.title.substring(0, data.holland.title.indexOf(" - ")));
      const percentages = result.map(
        (data) => Math.round(data.percentage * 100) / 100
      );

      setData({
        labels: labels,
        datasets: [
          {
            data: percentages,
            backgroundColor: ["#fc4103", "#8606c2", "#06c219", "#fcc203", "#00ccff", "#067dc2"], // Set your colors here
          },
        ],
      });
    }
  }, [result]);
  console.log(data);

  return (
    <Container>
      <Header />
      <div className="w-full p-8 flex flex-col items-center">
        {<PieChart chartData={data} />}
        hi
      </div>
    </Container>
  );
};

export default HollandResultPage;
