<template>
  <div>
    <ul v-for="item in this.markDownList" :key="item.id">
      <li><router-link :to="'/mavonshow/'+item.id">{{item.title}}</router-link></li>
    </ul>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        markDownList: [],
        skip: 0,
        limit: 100
      }
    },
    methods: {

    },
    async mounted() {
      console.log("mounted")
      this.markDownList = await this.$store.dispatch("query", {skip:this.skip, limit: this.limit});
      console.log("mdList");
      console.log(this.markDownList);
    }


  }
</script>
<style>

</style>
