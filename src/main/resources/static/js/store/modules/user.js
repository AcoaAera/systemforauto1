const axios = require('axios').default

export default {
    actions: {
        fetchUser(ctx, user) {
            console.log(user)
            ctx.commit('updateName', user)
            ctx.commit('updateRole', user)
            ctx.commit('updateId', user)
            ctx.commit('updateUser', user)
        },
        fetchDrivers(ctx) {
            axios
                .get('/user/drivers')
                .then(res => {
                    ctx.commit('updateDrivers', res.data)
                })
        }
    },
    mutations: {
        updateName(state, user) {
            state.name = user.name
        },
        updateRole(state, user) {
            state.role = user.role
        },
        updateId(state, user) {
            state.id = user.id
        },
        updateUser(state, user) {
            state.user = user
        },
        updateDrivers(state, drivers) {
            state.drivers = drivers
        }
    },
    state: {
        user:null,
        name: null,
        role: null,
        id: null,
        drivers: [],
    },
    getters: {
        getName(state) {
            return state.name
        },
        getRole(state) {
            return state.role
        },
        getId(state) {
            return state.id
        },
        getUser(state){
            return state.user
        },
        getDrivers(state) {
            return state.drivers
        }
    },
}