<template>
    <div>  
        this is user editor
        <input type="text" placeholder="username" v-model="newUser.name"/>
        <input type="text" placeholder="major" v-model="newUser.major"/>
        <input type="text" placeholder="university" v-model="newUser.university"/>
        <button @click="createUser(newUser)">create</button>
        <div v-for="(user, index) in allUsers" :key="index">
            <span>{{user.name}}</span>
        </div>
    </div>
</template>

<script>
import {mapGetters, mapActions} from 'vuex';
import {User} from '../models/user.js';
export default {
    data () {
        return {
            title: "user-editor",
            newUser: new User()
        }
    },
    computed: {
        ...mapGetters(
            'userModule', {
                allUsers: 'getAll'
            }
        )
    },
    methods: {
        ...mapActions('userModule', ['createUser', 'fetchAllUsers'])
    },
    mounted () {
        this.$nextTick(() => {
            this.fetchAllUsers()
        })
    }
}
</script>

