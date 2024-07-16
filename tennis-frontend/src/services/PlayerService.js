import axios from 'axios';

const API_URL = 'http://localhost:8080/api/players';

class PlayerService {
    getAllPlayers() {
        return axios.get(API_URL);
    }

    searchPlayersBySuffix(suffix) {
        return axios.get(`${API_URL}/search?suffix=${suffix}`);
    }
}

export default new PlayerService();
