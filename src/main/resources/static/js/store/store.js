import Vue from 'vue'
import Vuex from 'vuex'
import user from 'store/modules/user.js'
import auto from 'store/modules/auto.js'

Vue.use(Vuex)

export default new Vuex.Store({
    modules:{
        user, auto
    }
})