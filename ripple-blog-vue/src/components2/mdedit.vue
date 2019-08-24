<template>
  <div>
    <div>编辑</div>
    <!--<MarkDown theme="Dark" :mode="mode" :toolbars="config" ></MarkDown>-->
    <mark-down @on-save="save" ref="md" @on-change="changeImg"
               :theme="theme" :initialValue="initialValue"
               :placeholderValue="placeholderValue"
               v-model="content"
               on-change="onChange"
               changeImg="changeImg"
    >
    </mark-down>
    <button @click="saveMd()">保存</button>
  </div>
</template>

<script>
  import MarkDown from 'vue-meditor'

  export default {
    components: {
      MarkDown,
    },
    data() {
      return {//value的值是经过markdown解析后的文本，可使用`@change="changeData"`在控制台打印显示
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
      };
    },
    methods: {
      changeData(value, render) {
        console.log(render);
      },
      saveMd() {
        console.log(this.$refs.handleSave)
        this.$refs.md.handleSave();

      },
      save(content) {
        console.log("原始内容:" + content.value);
        var md =
        this.$store.dispatch('submitMdData', {title:"测试1", content: content.value});
        // console.log("转义后的内容:" + content.html);
        // console.log("主题theme:" + content.theme);
      },
      onChange() {

      },
      changeImg() {


      },
    }
  };
</script>
