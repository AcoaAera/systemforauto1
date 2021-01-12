<template>
    <div class="mb-5">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#/">SystemForAuto</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <a v-if="getRole === 3 || getRole === 0" class="btn btn-link my-2 my-sm-0" href="#/checkWaybill">Смотреть путевые
                        листы</a>
                    <a v-if="getRole === 1 || getRole === 0" class="btn btn-link my-2 my-sm-0" href="#/createRequest">Создать запрос</a>
                    <a v-if="getRole === 2 || getRole === 0" class="btn btn-link my-2 my-sm-0" href="#/checkRequest">Смотреть запросы</a>
                    <div v-if="getRole == null">
                        <a class="btn btn-link my-2 my-sm-0" href="#/auth">Авторизация</a>
                    </div>
                    <div v-else>
                        <span>{{getName}}</span>
                        <button class="btn btn-link my-2 my-sm-0" @click="unauth">Выход</button>
                    </div>
                </form>
            </div>
        </nav>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex';

    export default {
        computed: {
            ...mapGetters(['getRole', 'getName'])
        },
        methods: {
            ...mapActions(['fetchUser']),
            unauth() {
                this.fetchUser({name: null, role: null})
                window.location.href = "#/"
            }
        }
    }

</script>