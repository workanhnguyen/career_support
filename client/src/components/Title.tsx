import React from "react";

type TitleProps = {
  text: string;
};

const Title: React.FC<TitleProps> = ({ text }) => {
  return <p className="text-2xl font-bold text-primary mb-5">{text}</p>;
};

export default Title;
