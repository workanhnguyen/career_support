import { createSlice } from "@reduxjs/toolkit"

const initialState = {
    jwtToken: '',
    currentUser: {}
}

export const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        saveJwtToken: (state, action) => {
            state.jwtToken = action.payload;
        },
        saveCurrentUser: (state, action) => {
            state.currentUser = action.payload;
        }
    }
});

export const { saveJwtToken, saveCurrentUser } = authSlice.actions;
export default authSlice.reducer;