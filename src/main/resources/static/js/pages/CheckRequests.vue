<template>
    <div class="container" v-if="getRole === 2 || getRole === 0">
        <div class="card mb-2" v-for="req in requests" v-bind:key="req.id">
            <div class="card-body">
                <h5 class="card-title">Заявка {{req.id}}</h5>
                <p>Статус: {{req.statuses.name}}</p>
                <p>Запросивший: {{req.user.name}}</p>
                <p class="card-text">{{req.comment}}</p>
                <a @click="gud(req)" class="btn btn-primary">Отработать</a>
                <a @click="stop(req)" class="btn btn-danger">Отклонить</a>
            </div>
        </div>
    </div>
    <div class="container" v-else>Страница не доступна для вас</div>
</template>

<script>
    import {mapGetters} from 'vuex'

    const axios = require('axios').default
    export default {
        name: "CheckRequests",
        data() {
            return {
                requests: []
            }
        },
        mounted() {
            axios.get('/requests').then(res => {
                this.requests = res.data
                console.log(this.requests)
                console.log(this.requests[0].user.name)
            })
        },
        computed: {
            ...mapGetters(['getRole'])
        },
        methods: {
            gud(req) {
                window.location.href = "#/createWaybill/" + req.id
            },
            stop(req) {
                req.statuses = 2
                axios.put('/requests/' + req.id, req).then(res =>
                    window.location.href = '#/checkRequest')
            }
        }
    }
</script>