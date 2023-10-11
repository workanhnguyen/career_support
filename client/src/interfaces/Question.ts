import { Option } from "./Option";

export interface Question {
    id: number;
    content: string;
    options: Option[];
}