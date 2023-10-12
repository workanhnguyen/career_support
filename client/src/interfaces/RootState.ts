import { AuthState } from "./AuthState";
import { Response } from "./Response";
import { Survey } from "./Survey";
import { SurveyState } from "./SurveyState";

export interface RootState {
    auth: AuthState;
    survey: SurveyState;
    response: Response
}