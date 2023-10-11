import { Question } from "./Question";

export interface Survey {
    id: number;
    title: string;
    description: string;
    questions: Question[]
}