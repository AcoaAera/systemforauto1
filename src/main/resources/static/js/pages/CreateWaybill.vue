<template>
    <div class="container" v-if="getRole === 2 || getRole === 0">

        <div class="card mb-2">
            <div class="card-body">
                <h5 class="card-title">Заявка {{request.id}}</h5>
                <p>Статус: {{request.statuses.name}}</p>
                <p>Запросивший: {{request.user.name}}</p>
                <p class="card-text">{{request.comment}}</p>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Марка машины</label>
            <div class="col-sm-8">
                <select class="form-control" v-model="waybill.autos">
                    <option v-for="auto in allAutos"
                            v-bind:key="auto.id"
                            v-bind:value="auto">
                        {{ auto.name }}
                    </option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Водитель</label>
            <div class="col-sm-8">
                <select class="form-control" v-model="waybill.driver">
                    <option v-for="driver in getDrivers"
                            v-bind:key="driver.id"
                            v-bind:value="driver">
                        {{driver.name}}
                    </option>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Дата выезда из гаража</label>
            <div class="col-sm-8">
                <input type="datetime-local" class="form-control" v-model="waybill.dateOfDeparture">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Количество топлива при выезде</label>
            <div class="col-sm-8">
                <input type="number" min="0" class="form-control" v-model="waybill.countFuel">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Показатели одометра</label>
            <div class="col-sm-8">
                <input type="number" min="0" class="form-control" v-model="waybill.odometr">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Маршрут</label>
            <div class="col-sm-8">
                <textarea class="form-control" rows="3" v-model="waybill.route"></textarea>
            </div>
        </div>
        <button type="button" class="btn btn-primary" @click="postWaybill">Отправить</button>
    </div>
    <div class="container" v-else>Страница не доступна для вас</div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex'

    const axios = require('axios').default

    export default {
        name: "CreateWaybill",
        data() {
            return {
                waybill: {
                    autos: null,
                    driver: null,
                    dateOfDeparture: null,
                    countFuel: 50,
                    odometr: 100000,
                    route: "Путь",
                    request: null
                },
                request: {}
            }
        },
        computed: mapGetters(['getDrivers', 'allAutos', 'getRole']),
        methods: {
            ...mapActions(['fetchAutos', 'fetchDrivers']),
            postWaybill() {
                let reqId = this.$route.params.id
                this.waybill.request = reqId
                axios
                    .post("/waybill", this.waybill).then(res => {
                    axios.get('/statuses/1').then(res => {
                        this.request.statuses = res.data
                        axios.put("/requests/" + reqId, this.request).then(res => {
                            window.location.href = '#/checkRequest'
                        })
                    })
                })
            }
        },
        mounted() {
            this.fetchAutos();
            this.fetchDrivers();
            axios.get("/requests/" + this.$route.params.id).then(res => {
                this.request = res.data
            })
        },
    }
</script>

<style scoped>

</style>



