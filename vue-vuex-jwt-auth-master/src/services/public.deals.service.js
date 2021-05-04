import axios from 'axios';

const API_URL = 'http://localhost:9000/giveaways/';

class PublicDealsService {
    getDealById(id) {
        return axios.get(API_URL + 'id/' + id);
    }

    getDealBySearch(search_text){
        return axios.get(API_URL + 'search?text=' + search_text);

    }

    getDealsByPlatform(platform) {
        return axios.get(API_URL + 'platform/' + platform);
    }

    getDealsByType(type) {
        return axios.get(API_URL + 'type/' + type);
    }

    getTopDealsByType(type, sort_by, number) {
        return axios.get(API_URL + 'params' + `?type=${type}&sort_by=${sort_by}&number=${number}`);
    }

    getAllDeals() {
        return axios.get(API_URL + 'all');
    }

    getAllDealsWithParams(platform, type, sort_by) {
        return axios.get(API_URL + 'params' + `?platform=${platform}&type=${type}&sort_by=${sort_by}`);
    }

    getTopDeals(number){
        return axios.get(API_URL + 'top?' + `number=${number}`);
    }
}

export default new PublicDealsService();
