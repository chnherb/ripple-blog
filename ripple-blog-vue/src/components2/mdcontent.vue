<template>
  <div>
    <div>内容</div>
    <VueMarkdown>{{value}}</VueMarkdown>
  </div>
</template>

<script>
  import VueMarkdown from 'vue-markdown'
  export default {
    components: {
      VueMarkdown,
    },
    data() {
      return {//value的值是经过markdown解析后的文本，可使用`@change="changeData"`在控制台打印显示
        value: `# 一级标题

# 链接

硬连接只能使用在文件上，不可以使用在文件夹上。至于文件前面的硬链接数字的含义如下：

如图标注区，为硬连接的数量，文件前的数字1表示没有硬链接。文件夹前面的数字至少是2，含义是这个文件夹是空文件夹，当数字大于2时，比如为n>2，则表示这个文件夹下面有个n-2个子文件和文件夹的和；因此从文件夹前面的这个数字可以知道文件夹下面到底有多少文件和文件夹(一个文件夹算做1，一个文件算作1)。至于文件夹的硬连接数为什么最小是2，有个解释是，每个文件夹下面都有两个默认的路径'.'和'..' ----- 其中一个点表示当前路径，两个点表示上个目录

## 相关命令

\`\`\`shell
# 创建软链接 将mysql执行文件的软链接放到环境目录/usr/bin中
sudo ln -s /usr/local/mysql-5.7.25-macos10.14-x86_64/bin/mysql /usr/bin

# 删除软链接 切换到目录下
rm -rf mysql
\`\`\`

`,
        defaultData: "preview"
      };
    },
    methods: {
      changeData(value, render) {
        console.log(render);
      }
    }
  };
</script>
