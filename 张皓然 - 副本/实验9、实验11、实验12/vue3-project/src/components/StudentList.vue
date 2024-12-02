<template>
  <div>
    <el-form :inline="true" :model="searchForm" width="30%">
      <el-form-item label="姓名">
        <el-input v-model="searchForm.name" placeholder="请输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="searchForm.sex" placeholder="请选择性别" style="width:
         150px">
          <el-option label="请选择" value=""></el-option>
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>

    <el-button type="info" @click="refreshStudents">刷新</el-button>
    <el-button type="success" @click="showAddDialog">新增</el-button>
    <el-button type="danger" @click="deleteStudents">批量删除</el-button>
    <el-table :data="students" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="100"></el-table-column>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="remark" label="备注"></el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button size="mini" @click="showEditDialog(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="confirmDeleteStudent(scope.row.id, scope.row.name)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加学生" v-model="addVisible" width="30%">
      <el-form :model="addForm">
        <el-form-item label="姓名" label-width="100px">
          <el-input v-model="addForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" label-width="100px">
          <el-select v-model="addForm.sex" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
            <el-option label="未知" value="未知"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" label-width="100px">
          <el-input v-model="addForm.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" label-width="100px">
          <el-input v-model="addForm.remark" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="addVisible = false">取 消</el-button>
          <el-button type="primary" @click="addStudent">确 定</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog title="编辑学生" v-model="editVisible" width="30%">
      <el-form :model="editForm">
        <el-form-item label="姓名" label-width="100px">
          <el-input v-model="editForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" label-width="100px">
          <el-select v-model="editForm.sex" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" label-width="100px">
          <el-input v-model="editForm.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" label-width="100px">
          <el-input v-model="editForm.remark" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="editVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateStudent">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';
import { ElMessageBox } from 'element-plus';

export default {
  name: 'StudentList',
  data() {
    return {
      students: [],
      searchForm: {
        name: '',
        sex: ''
      },
      addVisible: false,
      editVisible: false,
      addForm: {
        name: '',
        sex: '男',
        age: '',
        remark: ''
      },
      editForm: {
        id: null,
        name: '',
        sex: '',
        age: '',
        remark: ''
      },
      selectedStudents: [] // 用于存储选中的学生
    };
  },
  methods: {
    async fetchStudents(params) {
      try {
        const response = await
            axios.get(`${process.env.VUE_APP_API_BASE_URL}/students/list`, { params });
        this.students = response.data; // 假设返回的是一个对象数组
      } catch (error) {
        console.error('Failed to fetch students:', error);
      }
    },
    onSearch() {
      const params = {
        name: this.searchForm.name,
        sex: this.searchForm.sex
      };
      this.fetchStudents(params);
    },
    showAddDialog() {
      this.addVisible = true;
    },
    async addStudent() {
      // 发送 POST 请求来添加新学生
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/students/add`, this.addForm);
        this.students.push(response.data); // 假设返回的新学生对象
        this.addVisible = false;
        this.resetAddForm();
        this.refreshStudents();
      } catch (error) {
        console.error('Failed to add student:', error);
      }
    },
    resetAddForm() {
      this.addForm.name = '';
      this.addForm.sex = '男';
      this.addForm.age = '';
      this.addForm.remark = '';
    },
    showEditDialog(row) {
      this.editForm = { ...row };
      this.editVisible = true;
    },
    async updateStudent() {
      // 发送 PUT/PATCH 请求来更新学生
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/students/update`, this.editForm);
        const index = this.students.findIndex(student => student.id === this.editForm.id);
        if (index !== -1) {
          this.students[index] = { ...response.data }; // 假设返回更新后的学生对象
        }
        this.editVisible = false;
        this.refreshStudents();
      } catch (error) {
        console.error('Failed to update student:', error);
      }
    },
    confirmDeleteStudent(id, name) {
      ElMessageBox.confirm(
          `确定要删除学生 "${name}" 吗？`,
          '警告',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
      ).then(() => {
        this.deleteStudent(id);
      }).catch(() => {
        // 用户取消删除
      });
    },
    async deleteStudent(id) {
      // 发送 DELETE 请求来删除学生
      try {
        await axios.delete(`${process.env.VUE_APP_API_BASE_URL}/students/delete/${id}`);
        this.students = this.students.filter(student => student.id !== id);
        this.refreshStudents();
      } catch (error) {
        console.error('Failed to delete student:', error);
      }
    },
    async deleteStudents() {
      if (this.selectedStudents.length === 0) {
        this.$message({
          message: '请选择要删除的学生',
          type: 'warning'
        });
        return;
      }
      // 构建提示信息
      const names = this.selectedStudents.map(student => student.name).join(', ');
      const message = `确定要删除以下学生吗？\n${names}`;

      ElMessageBox.confirm(
          message,
          '警告',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
      ).then(async () => {
        try {
          const ids = this.selectedStudents.map(student => student.id);
          await axios.post(`${process.env.VUE_APP_API_BASE_URL}/students/deleteByIds`, ids);
          this.students = this.students.filter(student => !ids.includes(student.id));
          this.refreshStudents();
          this.$message({
            message: '删除成功',
            type: 'success'
          });
        } catch (error) {
          console.error('Failed to delete students:', error);
          this.$message({
            message: '删除失败',
            type: 'error'
          });
        }
      }).catch(() => {
        // 用户取消删除
      });
    },
    handleSelectionChange(selection) {
      this.selectedStudents = selection;
    },
    refreshStudents() {
      this.fetchStudents();
    },
    resetForm() {
      this.searchForm.name = '';
      this.searchForm.sex = '';
      this.refreshStudents();
    }
  },
  mounted() {
    this.fetchStudents(); // 页面加载时立即获取学生列表
  }
};
</script>

<style scoped>
.el-select {
  width: 100%; /* 确保下拉框宽度足够 */
}
</style>