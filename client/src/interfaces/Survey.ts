import { Question } from "./Question";

export interface Survey {
    id: number;
    title: string;
    description: string;
    author: string;
    image: string;
    questions: Question[]
}