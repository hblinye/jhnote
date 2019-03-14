import Vue from 'vue';
import VueRouter from 'vue-router';
import store from './store/index.js';
import routers from './routers.js';
import App from './App.vue';

Vue.use(VueRouter)
const router = new VueRouter({
    mode: 'history',
    routes: routers
})

new Vue({
    el: '#app',
    store,
    router,
    components: {
        App
    }
})
