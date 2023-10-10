import { User } from "./User";

export interface AuthState {
    jwtToken: string;
    currentUser: User;
}