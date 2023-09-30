import React, { memo } from "react";

const Footer: React.FC = () => {
  return (
    <footer className="w-full h-64 flex flex-col justify-center items-center text-center text-white bg-blue-950 gap-10">
      <div className="flex flex-col gap-4 items-center">
        <img
          className="w-32"
          src="https://res.cloudinary.com/dduhlnft3/image/upload/v1696069111/frontend/logo-header-removebg-preview_dgsyuy.png"
          alt="main-logo"
        />
        <p className="uppercase text-3xl font-bold">
          Hệ thống hỗ trợ hướng nghiệp cho học sinh
        </p>
      </div>
      <div>
        <p>Ho Chi Minh City Open University</p>
        <p>@2023 - Power by Nguyen Van Anh</p>
      </div>
    </footer>
  );
};

export default memo(Footer);
