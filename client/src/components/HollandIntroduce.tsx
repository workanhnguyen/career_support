import { memo } from "react";

import { Box } from "@mui/material";
import React from "react";
import { Title } from "../components";

const HollandIntroduce: React.FC = () => {
  return (
    <Box>
      <Title text="Trắc nghiệm Holland là gì?" />
      <div className="w-full flex max-sm:flex-col justify-between">
        <p className="max-sm:mb-5 text-justify sm:pr-10">
          John L.Holland (1919 – 2008) là tiến sỹ tâm lý học người Mỹ. John
          Holland nổi tiếng nhất và biết đến rộng rãi nhất qua nghiên cứu Lý
          thuyết lựa chọn nghề nghiệp. <br />
          <br />
          Mô hình lý thuyết nghề nghiệp của ông đã được sử dụng trong thực tiễn
          hướng nghiệp tại nhiều nước trên thế giới và được đánh giá rất cao về
          tính chính xác trong việc khám phá, lựa chọn ngành, nghề phù hợp tính
          cách, sở thích của bản thân.
          <br />
          <br />
          Học thuyết của John Holland đã lập luận rằng: “Thiên hướng nghề nghiệp
          chính là sự biểu hiện cá tính của mỗi con người” và nó được phân loại
          thành 6 nhóm và được diễn tả ở hai phương diện: tính cách con người và
          môi truờng làm việc.
          <br />
          <br />
          Lý thuyết Lựa chọn nghề nghiệp chia con người ra 6 loại cá tính và
          thường được viết tắt là RIASEC và được gọi là mật mã Holland (Holland
          codes).
        </p>
        <img
          className="max-sm:w-full max-md:w-1/2 md:w-52 rounded-lg"
          src="https://res.cloudinary.com/dduhlnft3/image/upload/v1696048879/frontend/John-Holland_bbe5se.jpg"
          alt="holland"
        />
      </div>
    </Box>
  );
};

export default memo(HollandIntroduce);
