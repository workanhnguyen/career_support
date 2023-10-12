import React, { useEffect, useState } from "react";
import { HollandResult } from "../interfaces/HollandResult";
import { PieChart } from "../charts";

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
      const labels = result.map((data) => data.holland.title);
      const percentages = result.map(
        (data) => Math.round(data.percentage * 100) / 100
      );

      setData({
        labels: labels,
        datasets: [
          {
            data: percentages,
            backgroundColor: [], // Set your colors here
          },
        ],
      });
    }
  }, [result]);
  console.log(data);

  return <div className="w-96">{<PieChart chartData={data} />}</div>;
};

export default HollandResultPage;
