<template>
  <div>
    <div id="md-title">
      <input id="md-title-input" aria-placeholder="请输入标题"
             v-model="title"></input>
    </div>
    <div id="md-editor">
      <mavon-editor v-model="content"
                    ref="md"
                    :ishljs=true
                    :toolbars="toolbarsValue"
                    @save="submit"/>
    </div>
  </div>
</template>
<script>
  import {mavonEditor} from 'mavon-editor'
  import 'mavon-editor/dist/css/index.css'

  export default {
    components: {
      'mavon-editor': mavonEditor
    },
    data() {
      return {
        toolbarsValue: {
          bold: true, // 粗体
          italic: true, // 斜体
          header: true, // 标题
          underline: true, // 下划线
          strikethrough: true, // 中划线
          mark: true, // 标记
          superscript: true, // 上角标
          subscript: true, // 下角标
          quote: true, // 引用
          ol: true, // 有序列表
          ul: true, // 无序列表
          link: true, // 链接
          imagelink: true, // 图片链接
          code: true, // code
          table: true, // 表格
          fullscreen: true, // 全屏编辑
          readmodel: true, // 沉浸式阅读
          htmlcode: true, // 展示html源码
          help: true, // 帮助
          /* 1.3.5 */
          undo: true, // 上一步
          redo: true, // 下一步
          trash: true, // 清空
          save: true, // 保存（触发events中的save事件）
          /* 1.4.2 */
          navigation: true, // 导航目录
          /* 2.1.8 */
          alignleft: true, // 左对齐
          aligncenter: true, // 居中
          alignright: true, // 右对齐
          /* 2.2.1 */
          subfield: true, // 单双栏模式
          preview: true, // 预览
        },
        title: "biaoti111",
        content: "# 一级标题",
      }
    },
    methods: {
      async submit(value, render) {
        // console.log("原始标题:" + this.title);
        // console.log("原始内容:" + this.content);
        // console.log("this is render"+render); // html
        // console.log("this is value"+value);
        this.$store.dispatch('submitMdData', {title:this.title, content: this.content});
      }
    }
  }
</script>
<style>
  #md-title {
    height: 60px;
    text-align: center;
  }

  #md-title-input {
    margin-top: 10px;
    margin-bottom: 10px;
    text-align: center;
    height: 25px;
    width: 50%
  }

  #md-editor {
    margin: auto;
    width: 100%;
    height: 100%;
  }
</style>
