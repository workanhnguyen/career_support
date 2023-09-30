import { useEffect, useState } from "react";
import { Holland } from "../interfaces/Holland";
import { getAllHollands } from "../apis/HollandApi";

function useHollands() {
  const [hollands, setHollands] = useState<Holland[]>([]);
  const [isHollandLoading, setIsHollandLoading] = useState<boolean>(false);

  useEffect(() => {
    const fetch = async () => {
      setIsHollandLoading(true);

      try {
        let response = await getAllHollands();
        response.status === 200 && setHollands(response.data);
      } catch (error) {
        console.log(error);
      } finally {
        setIsHollandLoading(false);
      }
    };

    fetch();
  }, []);
  return { hollands, isHollandLoading };
}

export default useHollands;
