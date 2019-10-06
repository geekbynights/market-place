import VueRouter from 'vue-router'
import Ads from "../page/Ads.vue";
import Ad from "../page/Ad.vue";

const routes = [
    {
        path: '/ad/:adId',
        component: Ad,
        meta: {
            name: 'Ad'
        }
    },
    {
        path: '/*',
        component: Ads,
        meta: {
            name: 'Ads'
        }
    }
];

const router = new VueRouter({routes})

export {router}