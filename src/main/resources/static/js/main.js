import Vue from 'vue'
import App from 'pages/App.vue'
import store from 'store/store.js'

import VueRouter from "vue-router";

import started from "pages/Started.vue"
import auth from "pages/auth.vue"
import createWaybill from "pages/CreateWaybill.vue"
import createRequest from "pages/CreateRequest.vue"
import checkRequest from "pages/CheckRequests.vue"
import checkWaybill from "pages/CheckWaybill.vue"

Vue.use(VueRouter)

let router = new VueRouter({
    routes: [
        {path: '/', component: started},
        {path: '/auth', component: auth},
        {path: '/createWaybill/:id', component: createWaybill},
        {path: '/createRequest', component: createRequest},
        {path: '/checkRequest', component: checkRequest},
        {path: '/checkWaybill', component: checkWaybill},
    ]
})

new Vue({
    el: '#app',
    store: store,
    router: router,
    render: a => a(App)
})