import axios from 'axios';
import {GET_URLS, POST_URLS} from '../../util/urls.js';

const state = {
    allUsers: []
}

const getters = {
    getAll (state) {
        return state.allUsers
    }
}

const mutations = {
    updateAllUsers (state, allUsers) {
        state.allUsers = allUsers
    }
}

const actions = {
    fetchAllUsers (context) {
        let options = {}
        axios.get(GET_URLS.allUserApi, options)
        .then((data) => {
            context.commit('updateAllUsers', data.data)
        })
    },
    createUser (context, user) {
        let options = {}
        let params = user
        axios.post(
            POST_URLS.createUserApi,
            params,
            options
        )
        .then(() => {
            context.dispatch('fetchAllUsers')
        })
    }
}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
}