const axios = require('axios').default

export default {
    actions: {
        fetchAutos(ctx) {
            axios
                .get('/requests')
                .then(res => {
                    ctx.commit('updateAutos', res.data)
                })
        }
    },
    mutations: {
        updateAutos(state, autos) {
            state.autos = autos
        }
    },
    state: {
        autos: []
    },
    getters: {
        allAutos(state) {
            return state.autos
        }
    },
}