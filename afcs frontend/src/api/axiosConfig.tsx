/* eslint-disable react-refresh/only-export-components */
import axios from "axios";


export default axios.create({
    baseURL: 'https://2faa-197-250-130-240.ngrok-free.app',
    headers: {"ngrok-skip-browser-warning": "true"}
})