import React from "react";
import { Bar, Line, Pie } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

type PieChartProps = {
  chartData: any;
};

export const options = {
  responsive: true,
  plugins: {
    legend: {
      position: 'top' as const,
      display: false
    },
    title: {
      display: true,
      position: 'bottom' as const,
      text: 'Kết quả khảo sát Holland (%)',
    },
  },
};

const PieChart: React.FC<PieChartProps> = ({ chartData }) => {
  return <Bar data={chartData} options={options} />;
};

export default PieChart;
