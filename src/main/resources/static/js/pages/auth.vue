<template>
    <div class="container" v-if="getRole == null">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal">
                    <span>АВТОРИЗАЦИЯ</span>
                    <div class="form-group">
                        <input type="text" class="form-control" v-model="user.login" placeholder="Логин">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" v-model="user.pass" placeholder="Пароль">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" @click="checkUser">ВХОД</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</template>

<script>

    import {mapGetters, mapActions} from 'vuex'

    const axios = require('axios').default
    export default {
        data() {
            return {
                user: {
                    login: '1',
                    pass: 'user'
                }
            }
        },
        computed: {
            ...mapGetters(['getRole'])
        },
        methods: {
            ...mapActions(['fetchUser']),
            checkUser() {
                axios
                    .post("/user/checkUser", this.user)
                    .then(res => {
                        this.fetchUser(res.data)
                        window.location.href = '#/'
                    })
            }
        }
    }
</script>

<style>

</style>