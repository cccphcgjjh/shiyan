<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <div class="header-content">
          <span>这里是系统名称：哈信息代码系统</span>
          <el-button type="text" @click="logout" class="logout-button">退出</el-button>
        </div>
      </el-header>
      <el-container>
        <MyAside />
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import MyAside from './components/MyAside.vue';

export default {
  components: {
    MyAside
  },
  methods: {
    logout() {
      // 清除用户的登录状态
      localStorage.removeItem('userToken');
      // 重定向到登录页面
      this.$router.push('/login');
    }
  }
};
</script>

<style scoped>
.common-layout {
  height: 100vh; /* 设置高度为视口高度的 100% */
  overflow-y: hidden; /* 去掉纵向滚动条 */
  display: flex;
  flex-direction: column;
}

.el-container {
  height: calc(100% - 60px); /* 减去 header 的高度 */
  width: 100%;
  background-color: #f0faff; /* 更改背景色 */
  display: flex;
  flex-direction: row;
}

.el-header {
  background-color: #4c73ff; /* 更改 header 背景色 */
  height: 60px; /* 固定高度，可以根据需要调整 */
  color: white;
  line-height: 60px; /* 文字垂直居中 */
  padding-left: 20px; /* 左侧内边距 */
  position: relative; /* 使绝对定位的子元素相对于 header 定位 */
}

.header-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}

.logout-button {
  position: absolute;
  right: 20px; /* 右侧内边距 */
  top: 50%;
  transform: translateY(-50%); /* 垂直居中 */
  color: white; /* 按钮文字颜色 */
}

.el-main {
  background-color: #ffffff; /* 更改 main 区域的颜色 */
  flex-grow: 1; /* 让主内容区域占满剩余空间 */
}
</style>