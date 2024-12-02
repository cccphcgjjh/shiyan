<template>
  <div>
    <el-form :inline="true" :model="searchForm" width="30%">
      <el-form-item label="书名">
        <el-input v-model="searchForm.title" placeholder="请输入书名"></el-input>
      </el-form-item>
      <el-form-item label="作者">
        <el-input v-model="searchForm.author" placeholder="请输入作者"></el-input>
      </el-form-item>
      <el-form-item label="出版社">
        <el-input v-model="searchForm.publisher" placeholder="请输入出版社"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>

    <el-button type="info" @click="refreshBooks">刷新</el-button>
    <el-button type="success" @click="showAddDialog">新增</el-button>
    <el-button type="danger" @click="deleteBooks">批量删除</el-button>
    <el-table :data="books" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="100"></el-table-column>
      <el-table-column prop="title" label="书名"></el-table-column>
      <el-table-column prop="author" label="作者"></el-table-column>
      <el-table-column prop="publisher" label="出版社"></el-table-column>
      <el-table-column prop="publishDate" label="出版时间" width="150"></el-table-column>
      <el-table-column prop="remarks" label="备注"></el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button size="mini" @click="showEditDialog(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="confirmDeleteBook(scope.row.id, scope.row.title)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加图书" v-model="addVisible" width="30%">
      <el-form :model="addForm">
        <el-form-item label="书名" label-width="100px">
          <el-input v-model="addForm.title" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="作者" label-width="100px">
          <el-input v-model="addForm.author" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版社" label-width="100px">
          <el-input v-model="addForm.publisher" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版时间" label-width="100px">
          <el-date-picker v-model="addForm.publishDate" type="date" placeholder="选择日期" style="width: 100%"></el-date-picker>
        </el-form-item>
        <el-form-item label="备注" label-width="100px">
          <el-input v-model="addForm.remarks" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="addVisible = false">取 消</el-button>
          <el-button type="primary" @click="addBook">确 定</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog title="编辑图书" v-model="editVisible" width="30%">
      <el-form :model="editForm">
        <el-form-item label="书名" label-width="100px">
          <el-input v-model="editForm.title" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="作者" label-width="100px">
          <el-input v-model="editForm.author" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版社" label-width="100px">
          <el-input v-model="editForm.publisher" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版时间" label-width="100px">
          <el-date-picker v-model="editForm.publishDate" type="date" placeholder="选择日期" style="width: 100%"></el-date-picker>
        </el-form-item>
        <el-form-item label="备注" label-width="100px">
          <el-input v-model="editForm.remarks" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="editVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateBook">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';
import { ElMessageBox } from 'element-plus';

export default {
  name: 'BookList',
  data() {
    return {
      books: [],
      searchForm: {
        title: '',
        author: '',
        publisher: ''
      },
      addVisible: false,
      editVisible: false,
      addForm: {
        title: '',
        author: '',
        publisher: '',
        publishDate: '',
        remarks: ''
      },
      editForm: {
        id: null,
        title: '',
        author: '',
        publisher: '',
        publishDate: '',
        remarks: ''
      },
      selectedBooks: [] // 用于存储选中的图书
    };
  },
  methods: {
    async fetchBooks(params) {
      try {
        const response = await axios.get(`${process.env.VUE_APP_API_BASE_URL}/books/list`, { params });
        this.books = response.data; // 假设返回的是一个对象数组
      } catch (error) {
        console.error('Failed to fetch books:', error);
      }
    },
    onSearch() {
      const params = {
        title: this.searchForm.title,
        author: this.searchForm.author,
        publisher: this.searchForm.publisher
      };
      this.fetchBooks(params);
    },
    showAddDialog() {
      this.addVisible = true;
    },
    async addBook() {
      // 发送 POST 请求来添加新图书
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/books/add`, this.addForm);
        this.books.push(response.data); // 假设返回的新图书对象
        this.addVisible = false;
        this.resetAddForm();
        this.refreshBooks();
      } catch (error) {
        console.error('Failed to add book:', error);
      }
    },
    resetAddForm() {
      this.addForm.title = '';
      this.addForm.author = '';
      this.addForm.publisher = '';
      this.addForm.publishDate = '';
      this.addForm.remarks = '';
    },
    showEditDialog(row) {
      this.editForm = { ...row };
      this.editVisible = true;
    },
    async updateBook() {
      // 发送 PUT/PATCH 请求来更新图书
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/books/update`, this.editForm);
        const index = this.books.findIndex(book => book.id === this.editForm.id);
        if (index !== -1) {
          this.books[index] = { ...response.data }; // 假设返回更新后的图书对象
        }
        this.editVisible = false;
        this.refreshBooks();
      } catch (error) {
        console.error('Failed to update book:', error);
      }
    },
    confirmDeleteBook(id, title) {
      ElMessageBox.confirm(
          `确定要删除图书 "${title}" 吗？`,
          '警告',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
      ).then(() => {
        this.deleteBook(id);
      }).catch(() => {
        // 用户取消删除
      });
    },
    async deleteBook(id) {
      // 发送 DELETE 请求来删除图书
      try {
        await axios.delete(`${process.env.VUE_APP_API_BASE_URL}/books/delete/${id}`);
        this.books = this.books.filter(book => book.id !== id);
        this.refreshBooks();
      } catch (error) {
        console.error('Failed to delete book:', error);
      }
    },
    async deleteBooks() {
      if (this.selectedBooks.length === 0) {
        this.$message({
          message: '请选择要删除的图书',
          type: 'warning'
        });
        return;
      }
      // 构建提示信息
      const titles = this.selectedBooks.map(book => book.title).join(', ');
      const message = `确定要删除以下图书吗？\n${titles}`;

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
          const ids = this.selectedBooks.map(book => book.id);
          await axios.post(`${process.env.VUE_APP_API_BASE_URL}/books/deleteByIds`, ids);
          this.books = this.books.filter(book => !ids.includes(book.id));
          this.refreshBooks();
          this.$message({
            message: '删除成功',
            type: 'success'
          });
        } catch (error) {
          console.error('Failed to delete books:', error);
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
      this.selectedBooks = selection;
    },
    refreshBooks() {
      this.fetchBooks();
    },
    resetForm() {
      this.searchForm.title = '';
      this.searchForm.author = '';
      this.searchForm.publisher = '';
      this.refreshBooks();
    }
  },
  mounted() {
    this.fetchBooks(); // 页面加载时立即获取图书列表
  }
};
</script>

<style scoped>
.el-select {
  width: 100%; /* 确保下拉框宽度足够 */
}
</style>
