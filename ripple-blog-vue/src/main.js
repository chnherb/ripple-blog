import Vue from 'vue'

import App from './App.vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import MavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'


import mdContent from './components2/mdcontent.vue'
import mdEdit from './components2/mdedit.vue'
import mavonEditor from './components/mavonEditor.vue'
import mavonShow from './components/mavonShow.vue'
import mdList from './components/mdList.vue'
import store from './store/index.js'

Vue.use(VueRouter)
Vue.use(VueResource)
Vue.use(ElementUI)
Vue.use(MavonEditor)

const router = new VueRouter({
  routes : [
    {path: "/md/:id?", component: mdContent},
    {path: "/mdedit/:id?", component: mdEdit},
    {path: "/mavoneditor/:id?", component: mavonEditor},
    {path: "/mavonshow/:id?", component: mavonShow},
    {path: "/mdList", component: mdList},
  ]
})

new Vue({
  el: '#app',
  render: h => h(App),
  router: router,
  store
})
