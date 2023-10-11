export interface Response {
    userId: number;
    surveyId: number;
    questions: {
        id: number;
        options: {
            id: number;
            checked: boolean;
        }[]
    }[]
}