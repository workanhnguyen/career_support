import { createSlice } from "@reduxjs/toolkit"
import { Cookies } from "react-cookie";

const cookies = new Cookies();

export const authState = {
    jwtToken: '',
    currentUser: {}
}

export const authSlice = createSlice({
    name: 'auth',
    initialState: authState,
    reducers: {
        saveJwtToken: (state, action) => {
            cookies.set('jwt_token', action.payload);
            state.jwtToken = action.payload || cookies.get('jwt_token');
        },
        saveCurrentUser: (state, action) => {
            cookies.set('current_user', action.payload);
            state.currentUser = action.payload;
        }
    }
});

export const { saveJwtToken, saveCurrentUser } = authSlice.actions;
export default authSlice.reducer;