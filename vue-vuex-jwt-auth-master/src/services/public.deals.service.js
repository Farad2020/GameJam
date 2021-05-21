import axios from 'axios';
import authHeader from "@/services/auth-header";

const API_URL = 'http://localhost:9000/giveaways/';
const API_TEST_URL = 'http://localhost:9000/api/test/';

class PublicDealsService {
    getDealById(id) {
        return axios.get(API_URL + 'id/' + id);
    }

    getDealBySearch(search_text){
        return axios.get(API_URL + 'search?text=' + search_text);
    }

    getDealBySearchWithParams(search_text, type, platform){
        return axios.get(API_URL + 'search?text=' + search_text + `&platform=${platform}&type=${type}`);
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

    getTopDealsByPlatform(platform, sort_by, number) {
        return axios.get(API_URL + 'params' + `?platform=${platform}&number=${number}&sort_by=${sort_by}`);
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

    linkUserAndDeal(giveawayId){
        return axios.get(API_TEST_URL + 'linkGiveaway?' + `giveawayId=${giveawayId}`, { headers: authHeader() });
    }

    checkUserDeal(giveawayId){
        return axios.get(API_TEST_URL + 'checkUserDeal?' + `giveawayId=${giveawayId}`, { headers: authHeader() });
    }

    getUserDeals(){
        return axios.get(API_TEST_URL + 'userDeals', { headers: authHeader() });
    }
}

export default new PublicDealsService();
