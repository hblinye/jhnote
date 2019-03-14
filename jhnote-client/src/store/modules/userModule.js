import 'axios';

const state = {
    allUsers: []
}

const getters = {
    getAll (state) {
        return allUsers
    }
}

const mutations = {
    updateAllUser (state) {
        state.allUsers = []
    }
}

const actions = {
    updateAllUser (context) {
        context.commit('updateAllUser')
    }
}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
}