<template>
    <div>
        <my-header></my-header>
        <router-view></router-view>
    </div>
</template>

<script>
    const myHeader = require('components/myHeader.vue').default

    export default {
        components: {
            myHeader
        },
    }
</script>

<style></style>