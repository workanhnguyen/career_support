import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import { HollandResult } from "../interfaces/HollandResult";
import { BarChart } from "../charts";
import { Button, Container } from "@mui/material";
import { Header } from "../components";
import { getAllHollands } from "../apis/HollandApi";
import { Holland } from "../interfaces/Holland";

type ChartType = {
  labels: string[];
  datasets: {
    data: number[];
    backgroundColor: string[];
  }[];
};

const HollandResultPage: React.FC = () => {
  const [result, _] = useState<HollandResult[]>(
    JSON.parse(localStorage.getItem("holland_result")!) || []
  );
  const [hollands, setHollands] = useState<Holland[]>([]);
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
    const fetchHolland = async () => {
      try {
        let res = await getAllHollands();
        res.status === 200 && setHollands(res.data);
      } catch (error) {}
    };

    fetchHolland();
  }, []);

  useEffect(() => {
    if (result.length > 0) {
      const labels = result.map((data) =>
        data.holland.title.substring(0, data.holland.title.indexOf(" - "))
      );
      const percentages = result.map(
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
  }, [result]);

  return (
    <Container>
      <Header />
      <div className="w-full p-8 flex flex-col">
        {<BarChart chartData={data} />}
        <section className="mt-5">
          <table className="w-full border-collapse">
            <thead>
              <tr className="border-2">
                <th className="border-2 p-3">Lĩnh vực</th>
                <th className="border-2 p-3">Mô tả</th>
              </tr>
            </thead>
            <tbody>
              {hollands.map((holland: Holland, index: number) => (
                <tr key={index} className="border-2">
                  <td className="border-2 p-3">
                    <p>{holland.title}</p>
                  </td>
                  <td className="p-3 flex flex-col gap-3">
                    <p className="text-justify">
                      <span className="font-bold">Diễn giải:</span>&nbsp;
                      {holland.description}
                    </p>
                    <p className="text-justify">
                      <span className="font-bold">Ngành nghề phù hợp:</span>
                      &nbsp;
                      {holland.suitableCareer}
                    </p>
                    <p className="text-justify">
                      <span className="font-bold">Điểm mạnh:</span>&nbsp;
                      {holland.strength}
                    </p>
                    <p className="text-justify">
                      <span className="font-bold">Điểm yếu:</span>&nbsp;
                      {holland.weakness}
                    </p>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </section>
        <Link to="/home" className="mt-5">
          <Button variant="contained" color="warning" disableElevation>
            Trở lại
          </Button>
        </Link>
      </div>
    </Container>
  );
};

export default HollandResultPage;
