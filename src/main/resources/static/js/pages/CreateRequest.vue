<template>
    <div class="container" v-if="getRole === 1 || getRole === 0">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Заявка</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="3" v-model="request.comment"></textarea>
            </div>
        </div>
        <button type="button" class="btn btn-primary" @click="postRequests">Отправить заявку</button>
    </div>
    <div class="container" v-else>Страница не доступна для вас</div>
</template>

<script>
    import {mapGetters} from 'vuex';

    const axios = require('axios').default
    export default {
        name: "CreateRequest",
        data() {
            return {
                request: {
                    user: null,
                    comment: "Требование к заявке",
                    statuses: {id: 0, name: "Новая"}
                }
            }
        },
        computed: {
            ...mapGetters(['getRole', 'getId', 'getUser'])
        },
        methods: {
            postRequests() {
                this.request.user = this.getUser
                axios
                    .post("/requests", this.request).then(res=>{
                    console.log(res.data)
                })
            }
        }
    }
</script>

<style scoped>

</style>