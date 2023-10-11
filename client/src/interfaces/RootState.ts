import { AuthState } from "./AuthState";
import { Survey } from "./Survey";
import { SurveyState } from "./SurveyState";

export interface RootState {
    auth: AuthState;
    survey: SurveyState;
    response: Response
}