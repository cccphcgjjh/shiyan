<template>
  <el-aside width="200px">
    <el-menu default-active="1" router>
      <el-menu-item index="/">
        <i class="el-icon-house"></i>
        <span>首页</span>
      </el-menu-item>
      <el-menu-item index="/studentList">
        <i class="el-icon-info"></i>
        <span>学生管理</span>
      </el-menu-item>
      <el-menu-item index="/courseList">
        <i class="el-icon-info"></i>
        <span>课程管理</span>
      </el-menu-item>
      <el-menu-item index="/bookList">
        <i class="el-icon-info"></i>
        <span>图书管理</span>
      </el-menu-item>
      <el-menu-item index="/customerList">
        <i class="el-icon-info"></i>
        <span>客户管理</span>
      </el-menu-item>
      <el-menu-item index="/about">
        <i class="el-icon-info"></i>
        <span>关于我们</span>
      </el-menu-item>
      <el-menu-item index="/contact">
        <i class="el-icon-phone"></i>
        <span>联系我们</span>
      </el-menu-item>
    </el-menu>
  </el-aside>
</template>

<script>
export default {
  name: 'MyAside'
};
</script>

<style scoped>
.el-aside {
  background-color: #fffff0; /* 更改 aside 背景色 */
  height: 100%; /* 继承父容器的高度 */
  //overflow-y: auto; /* 如果树形结构内容过多，允许滚动 */
}
</style>