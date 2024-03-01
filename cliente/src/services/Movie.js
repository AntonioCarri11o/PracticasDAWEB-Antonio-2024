import axios from 'axios';

import { API_URL } from '../config';

const listGenre = async () => {
    try {
        const response = await axios.get(`${API_URL}/genre`);
        return response.data;
    } catch (err) {
        throw(err);
    }
};

const saveMovie = async (movie) => {
    try {
        const response = await axios.post(`${API_URL}/movie/`, movie);
        return response.data;
    } catch(err) {
        throw (err);
    }
}

const updateMovie = async (id, movie) => {
    try {
        const response = await axios.put(`${API_URL}/movie/${id}`, movie);
        return response.data;
    } catch(err) {
        throw(err);
    }
}
const listMovies = async (params = null) => {
    try {
        const response = await axios.get(`${API_URL}/movie/${(params.param != null  && params.value != null)? params.param + '?' + params?.param + '=' + params?.value : ''}`);
        return response.data;
    } catch(err) {
        throw(err);
    }
}

const getMovieById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/movie/${id}`);
        return response.data;
    } catch(err) {
        throw(err);
    }
}
const deleteMovie = async (id) => {
    try {
        await axios.delete(`${API_URL}/movie/${id}`);
        window.location.reload();
    } catch(err) {
        throw(err);
    }
}
export default {
    listMovies,
    getMovieById,
    saveMovie,
    updateMovie,
    deleteMovie,
    listGenre,
}