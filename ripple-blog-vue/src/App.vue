<template>
  <div id="app">
    <router-link to="/md">内容</router-link>
    <router-link to="/mdedit">编辑</router-link>
    <router-link to="/mavoneditor">mavon</router-link>
    <router-link to="/mdList">list</router-link>
    <div id="main">
      <router-view></router-view>

    </div>
    <!--<button @click="test">button</button>-->
    <!--<button @click="test2">button</button>-->
  </div>
</template>

<script>
  export default {
    name: 'app',
    components: {},
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        mode: 3,
        config: {
          print: false, // 隐藏掉打印功能
          exportmd: true,
          importmd: true,
        },
        placeholderValue: "请输入问题描述",//placeholder的内容
        initialValue: "",//，markdown默认值
        theme: 'OneDark',//主题
        content: "#hahah"
      }
    },
    methods: {
      saveMd() {
        console.log(this.$refs.handleSave)
        this.$refs.md.handleSave();

      },
      save(content) {
        console.log("原始内容:" + content.value);
        // console.log("转义后的内容:" + content.html);
        // console.log("主题theme:" + content.theme);
      },
      onChange() {

      },
      changeImg() {


      },
      test() {
        console.log("test")
        this.$store.dispatch('getUserInfo');

      },
      test2() {
        console.log("userInfo")
        console.log(this.$store.state.userInfoData);
      }
    },

  }
</script>

<style lang="scss">
  #main {
    width: 90%;
    height: 90%;
  }
</style>
