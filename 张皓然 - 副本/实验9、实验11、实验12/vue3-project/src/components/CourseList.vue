<template>
  <div>
    <el-form :inline="true" :model="searchForm" width="30%">
      <el-form-item label="课程名称">
        <el-input v-model="searchForm.name" placeholder="请输入课程名称"></el-input>
      </el-form-item>
      <el-form-item label="课程类别">
        <el-select v-model="searchForm.courseCategory" placeholder="请选择类别" style="width: 150px">
          <el-option label="请选择" value=""></el-option>
          <el-option label="考试课" value="考试课"></el-option>
          <el-option label="考查课" value="考查课"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>

    <el-button type="info" @click="refreshCourses">刷新</el-button>
    <el-button type="success" @click="showAddDialog">新增</el-button>
    <el-button type="danger" @click="deleteCourses">批量删除</el-button>
    <el-table :data="courses" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="100"></el-table-column>
      <el-table-column prop="name" label="课程名称"></el-table-column>
      <el-table-column prop="courseCategory" label="类别"></el-table-column>
      <el-table-column prop="coursePeriod" label="课程周期"></el-table-column>
      <el-table-column prop="remark" label="备注"></el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button size="mini" @click="showEditDialog(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="confirmDeleteCourse(scope.row.id, scope.row.name)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加课程" v-model="addVisible" width="30%">
      <el-form :model="addForm">
        <el-form-item label="课程名称" label-width="100px">
          <el-input v-model="addForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程类别" label-width="100px">
          <el-select v-model="addForm.courseCategory" placeholder="请选择类别">
            <el-option label="考试课" value="考试课"></el-option>
            <el-option label="考查课" value="考查课"></el-option>
            <el-option label="未知" value="未知"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="课程周期" label-width="100px">
          <el-input v-model="addForm.coursePeriod" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" label-width="100px">
          <el-input v-model="addForm.remark" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="addVisible = false">取 消</el-button>
          <el-button type="primary" @click="addCourse">确 定</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog title="编辑课程" v-model="editVisible" width="30%">
      <el-form :model="editForm">
        <el-form-item label="课程名称" label-width="100px">
          <el-input v-model="editForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="类别" label-width="100px">
          <el-select v-model="editForm.courseCategory" placeholder="请选择类别">
            <el-option label="考试课" value="考试课"></el-option>
            <el-option label="考查课" value="考查课"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="课程周期" label-width="100px">
          <el-input v-model="editForm.coursePeriod" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" label-width="100px">
          <el-input v-model="editForm.remark" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="editVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateCourse">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';
import { ElMessageBox } from 'element-plus';

export default {
  name: 'CourseList',
  data() {
    return {
      courses: [],
      searchForm: {
        name: '',
        courseCategory: ''
      },
      addVisible: false,
      editVisible: false,
      addForm: {
        name: '',
        courseCategory: '考查课',
        coursePeriod: '',
        remark: ''
      },
      editForm: {
        id: null,
        name: '',
        courseCategory: '',
        coursePeriod: '',
        remark: ''
      },
      selectedCourses: [] // 用于存储选中的课程
    };
  },
  methods: {
    async fetchCourses(params) {
      try {
        const response = await
            axios.get(`${process.env.VUE_APP_API_BASE_URL}/courses/list`, {
              params });
        this.courses = response.data; // 假设返回的是一个对象数组
      } catch (error) {
        console.error('Failed to fetch courses:', error);
      }
    },
    onSearch() {
      const params = {
        name: this.searchForm.name,
        courseCategory: this.searchForm.courseCategory
      };
      this.fetchCourses(params);
    },
    showAddDialog() {
      this.addVisible = true;
    },
    async addCourse() {
      // 发送 POST 请求来添加新课程
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/courses/add`, this.addForm);
        this.courses.push(response.data); // 假设返回的新课程对象
        this.addVisible = false;
        this.resetAddForm();
        this.refreshCourses();
      } catch (error) {
        console.error('Failed to add course:', error);
      }
    },
    resetAddForm() {
      this.addForm.name = '';
      this.addForm.courseCategory = '考查课';
      this.addForm.coursePeriod = '';
      this.addForm.remark = '';
    },
    showEditDialog(row) {
      this.editForm = { ...row };
      this.editVisible = true;
    },
    async updateCourse() {
      // 发送 PUT/PATCH 请求来更新课程
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/courses/update`, this.editForm);
        const index = this.courses.findIndex(course => course.id === this.editForm.id);
        if (index !== -1) {
          this.courses[index] = { ...response.data }; // 假设返回更新后的课程对象
        }
        this.editVisible = false;
        this.refreshCourses();
      } catch (error) {
        console.error('Failed to update course:', error);
      }
    },
    confirmDeleteCourse(id, name) {
      ElMessageBox.confirm(
          `确定要删除课程 "${name}" 吗？`,
          '警告',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
      ).then(() => {
        this.deleteCourse(id);
      }).catch(() => {
        // 用户取消删除
      });
    },
    async deleteCourse(id) {
      // 发送 DELETE 请求来删除课程
      try {
        await axios.delete(`${process.env.VUE_APP_API_BASE_URL}/courses/delete/${id}`);
        this.courses = this.courses.filter(course => course.id !== id);
        this.refreshCourses();
      } catch (error) {
        console.error('Failed to delete course:', error);
      }
    },
    async deleteCourses() {
      if (this.selectedCourses.length === 0) {
        this.$message({
          message: '请选择要删除的课程',
          type: 'warning'
        });
        return;
      }
      // 构建提示信息
      const names = this.selectedCourses.map(course => course.name).join(', ');
      const message = `确定要删除以下课程吗？\n${names}`;

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
          const ids = this.selectedCourses.map(course => course.id);
          await axios.post(`${process.env.VUE_APP_API_BASE_URL}/courses/deleteByIds`, ids);
          this.courses = this.courses.filter(course => !ids.includes(course.id));
          this.refreshCourses();
          this.$message({
            message: '删除成功',
            type: 'success'
          });
        } catch (error) {
          console.error('Failed to delete courses:', error);
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
      this.selectedCourses = selection;
    },
    refreshCourses() {
      this.fetchCourses();
    },
    resetForm() {
      this.searchForm.name = '';
      this.searchForm.courseCategory = '';
      this.refreshCourses();
    }
  },
  mounted() {

    this.fetchCourses(); // 页面加载时立即获取课程列表
  }
};
</script>

<style scoped>
.el-select {
  width: 100%; /* 确保下拉框宽度足够 */
}
</style>