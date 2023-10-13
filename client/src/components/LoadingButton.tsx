import React, { memo } from "react";

import { Button } from "@mui/material";
import CircularProgress from "@mui/material/CircularProgress";

type LoadingButtonProps = {
  size: "small" | "medium" | "large";
  fullWidth: boolean;
  sx: {};
};

const LoadingButton: React.FC<LoadingButtonProps> = ({
  size = "medium",
  fullWidth,
  sx,
}) => {
  return (
    <Button variant="outlined" size={size} fullWidth={fullWidth} sx={sx}>
      <CircularProgress size={24} />
    </Button>
  );
};

export default memo(LoadingButton);
