<template>
  <div class="login-modal" style="z-index: 1000;">
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <span>登录</span>
        </div>
      </template>
      <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
import { useRouter } from 'vue-router';
import { ref, reactive } from 'vue';
import { ElMessage } from 'element-plus';

export default {
  emits: ['close'], // 定义一个事件来关闭登录模态框
  setup(props, { emit }) {
    const form = reactive({
      username: '',
      password: ''
    });

    const rules = {
      username: [
        { required: true, message: '请输入用户名', trigger: 'blur' }
      ],
      password: [
        { required: true, message: '请输入密码', trigger: 'blur' }
      ]
    };

    const router = useRouter();

    const loginForm = ref(null);

    const onSubmit = async () => {
      try {
        await loginForm.value.validate();
        const response = await
            axios.post(`${process.env.VUE_APP_API_BASE_URL}/system/login`, {
          username: form.username,
          password: form.password
        });

        if (response.data) {
          localStorage.setItem('userToken', response.data.token); // 存储 token
          emit('close'); // 关闭登录模态框
          router.push('/home');
        } else {
          ElMessage.error('登录失败，请检查用户名和密码');
        }
      } catch (error) {
        ElMessage.error('登录失败，请检查网络连接');
      }
    };

    return {
      form,
      rules,
      loginForm,
      onSubmit
    };
  }
};
</script>

<style scoped>
.login-modal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 1000;
}


.box-card {
  width: 400px;
}

.card-header {
  text-align: center;
}
</style>