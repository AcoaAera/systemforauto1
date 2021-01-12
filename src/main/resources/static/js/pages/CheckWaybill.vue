<template>
    <div class="container" v-if="getRole === 3 || getRole === 0">
        <div v-if="waybills.length ==0">Путевых листов для вас нет</div>
        <div class="card mb-2" v-for="waybill in waybills" v-else>
            <div class="card-body">
                <h5 class="card-title">Путевой лист {{waybill.id}}</h5>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Марка машины</label>
                    <div class="col-sm-8">
                        <input disabled type="text" class="form-control" v-model="waybill.autos.name">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Водитель</label>
                    <div class="col-sm-8">
                        <input disabled type="text" class="form-control" v-model="waybill.driver.name">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Дата выезда из гаража</label>
                    <div class="col-sm-8">
                        <input disabled type="datetime-local" class="form-control" v-model="waybill.dateOfDeparture">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Количество топлива при выезде</label>
                    <div class="col-sm-8">
                        <input disabled type="number" min="0" class="form-control" v-model="waybill.countFuel">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Показатели одометра</label>
                    <div class="col-sm-8">
                        <input disabled type="number" min="0" class="form-control" v-model="waybill.odometr">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Маршрут</label>
                    <div class="col-sm-8">
                        <textarea disabled class="form-control" rows="3" v-model="waybill.route"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container" v-else>Страница не доступна для вас</div>
</template>

<script>
    import {mapGetters} from 'vuex';
    const axios = require('axios').default
    export default {
        name: "CheckWaybill",
        data() {
            return {
                waybills: []
            }
        },
        computed: {
            ...mapGetters(['getRole', 'getId'])
        },
        mounted() {
            axios.get("/waybill/getDriver/" + this.getId).then(res => {
                this.waybills = res.data
            })
        }
    }
</script>