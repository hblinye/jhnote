<template>
    <div>
        <h2>Home</h2>
        <router-link id='toUser' to='/user'>user</router-link>
        <router-link id='toCompany' to='/company'>company</router-link>
        <router-view></router-view>
    </div>
</template>

<script>
export default {

}
</script>
