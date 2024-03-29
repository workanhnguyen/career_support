import React from "react";

import { Paper, Skeleton } from "@mui/material";

const SurveySkeleton: React.FC = () => {
  return (
    <Paper className="w-96 flex flex-col justify-center p-4">
      <Skeleton />
      <Skeleton width={90} height={64} />
    </Paper>
  );
};

export default SurveySkeleton;
