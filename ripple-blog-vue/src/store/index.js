import Vue from 'vue';
import Vuex from 'vuex';
import actionsWrap from './actions'
import mutationsWrap from './mutations'
import gettersWrap from './getters'

Vue.use(Vuex);

let vue = new Vue();

export default new Vuex.Store({
  state: {
    userInfoData: {},
    headPicData: {}
  },

  actions: actionsWrap.call(vue),
  mutations: mutationsWrap.call(vue),
  getters: gettersWrap.call(vue),
})
