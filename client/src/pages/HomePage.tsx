import React from "react";

import { Container } from "@mui/material";

import { Footer, Header, MainContent } from "../components";

const HomePage: React.FC = () => {
  return (
    <>
      <Container>
        <div className="flex flex-col justify-between gap-8 mb-5">
          <Header />
          <MainContent />
        </div>
      </Container>
      <Footer />
    </>
  );
};

export default HomePage;
