<template>
  <div>
    <el-form :inline="true" :model="searchForm" width="30%">
      <el-form-item label="客户姓名">
        <el-input v-model="searchForm.customerName" placeholder="请输入客户姓名"></el-input>
      </el-form-item>
      <el-form-item label="客户电话">
        <el-input v-model="searchForm.customerPhone" placeholder="请输入客户电话"></el-input>
      </el-form-item>
      <el-form-item label="客户邮箱">
        <el-input v-model="searchForm.customerEmail" placeholder="请输入客户邮箱"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>

    <el-button type="info" @click="refreshCustomers">刷新</el-button>
    <el-button type="success" @click="showAddDialog">新增</el-button>
    <el-button type="danger" @click="deleteCustomers">批量删除</el-button>
    <el-table :data="customers" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="customerId" label="ID" width="100"></el-table-column>
      <el-table-column prop="customerName" label="客户姓名"></el-table-column>
      <el-table-column prop="customerGender" label="客户性别"></el-table-column>
      <el-table-column prop="customerAge" label="客户年龄"></el-table-column>
      <el-table-column prop="customerPhone" label="客户电话"></el-table-column>
      <el-table-column prop="customerEmail" label="客户邮箱"></el-table-column>
      <el-table-column prop="customerAddress" label="客户地址"></el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button size="mini" @click="showEditDialog(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="confirmDeleteCustomer(scope.row.customerId, scope.row.customerName)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加客户" v-model="addVisible" width="30%">
      <el-form :model="addForm">
        <el-form-item label="客户姓名" label-width="100px">
          <el-input v-model="addForm.customerName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户性别" label-width="100px">
          <el-select v-model="addForm.customerGender" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户年龄" label-width="100px">
          <el-input v-model.number="addForm.customerAge" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户电话" label-width="100px">
          <el-input v-model="addForm.customerPhone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户邮箱" label-width="100px">
          <el-input v-model="addForm.customerEmail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户地址" label-width="100px">
          <el-input v-model="addForm.customerAddress" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="addVisible = false">取 消</el-button>
          <el-button type="primary" @click="addCustomer">确 定</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog title="编辑客户" v-model="editVisible" width="30%">
      <el-form :model="editForm">
        <el-form-item label="客户姓名" label-width="100px">
          <el-input v-model="editForm.customerName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户性别" label-width="100px">
          <el-select v-model="editForm.customerGender" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户年龄" label-width="100px">
          <el-input v-model.number="editForm.customerAge" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户电话" label-width="100px">
          <el-input v-model="editForm.customerPhone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户邮箱" label-width="100px">
          <el-input v-model="editForm.customerEmail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="客户地址" label-width="100px">
          <el-input v-model="editForm.customerAddress" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="editVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateCustomer">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';
import { ElMessageBox } from 'element-plus';

export default {
  name: 'CustomerList',
  data() {
    return {
      customers: [],
      searchForm: {
        customerName: '',
        customerPhone: '',
        customerEmail: ''
      },
      addVisible: false,
      editVisible: false,
      addForm: {
        customerName: '',
        customerGender: '',
        customerAge: null,
        customerPhone: '',
        customerEmail: '',
        customerAddress: ''
      },
      editForm: {
        customerId: null,
        customerName: '',
        customerGender: '',
        customerAge: null,
        customerPhone: '',
        customerEmail: '',
        customerAddress: ''
      },
      selectedCustomers: [] // 用于存储选中的客户
    };
  },
  methods: {
    async fetchCustomers(params) {
      try {
        const response = await axios.get(`${process.env.VUE_APP_API_BASE_URL}/customers/list`, { params });
        this.customers = response.data; // 假设返回的是一个对象数组
      } catch (error) {
        console.error('Failed to fetch customers:', error);
      }
    },
    onSearch() {
      const params = {
        customerName: this.searchForm.customerName,
        customerPhone: this.searchForm.customerPhone,
        customerEmail: this.searchForm.customerEmail
      };
      this.fetchCustomers(params);
    },
    showAddDialog() {
      this.addVisible = true;
    },
    async addCustomer() {
      // 发送 POST 请求来添加新客户
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/customers/add`, this.addForm);
        this.customers.push(response.data); // 假设返回的新客户对象
        this.addVisible = false;
        this.resetAddForm();
        this.refreshCustomers();
      } catch (error) {
        console.error('Failed to add customer:', error);
      }
    },
    resetAddForm() {
      this.addForm.customerName = '';
      this.addForm.customerGender = '';
      this.addForm.customerAge = null;
      this.addForm.customerPhone = '';
      this.addForm.customerEmail = '';
      this.addForm.customerAddress = '';
    },
    showEditDialog(row) {
      this.editForm = { ...row };
      this.editVisible = true;
    },
    async updateCustomer() {
      // 发送 PUT/PATCH 请求来更新客户
      try {
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/customers/update`, this.editForm);
        const index = this.customers.findIndex(customer => customer.customerId === this.editForm.customerId);
        if (index !== -1) {
          this.customers[index] = { ...response.data }; // 假设返回更新后的客户对象
        }
        this.editVisible = false;
        this.refreshCustomers();
      } catch (error) {
        console.error('Failed to update customer:', error);
      }
    },
    confirmDeleteCustomer(id, name) {
      ElMessageBox.confirm(
          `确定要删除客户 "${name}" 吗？`,
          '警告',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
      ).then(() => {
        this.deleteCustomer(id);
      }).catch(() => {
        // 用户取消删除
      });
    },
    async deleteCustomer(id) {
      // 发送 DELETE 请求来删除客户
      try {
        await axios.delete(`${process.env.VUE_APP_API_BASE_URL}/customers/delete/${id}`);
        this.customers = this.customers.filter(customer => customer.customerId !== id);
        this.refreshCustomers();
      } catch (error) {
        console.error('Failed to delete customer:', error);
      }
    },
    async deleteCustomers() {
      if (this.selectedCustomers.length === 0) {
        this.$message({
          message: '请选择要删除的客户',
          type: 'warning'
        });
        return;
      }
      // 构建提示信息
      const names = this.selectedCustomers.map(customer => customer.customerName).join(', ');
      const message = `确定要删除以下客户吗？\n${names}`;

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
          const ids = this.selectedCustomers.map(customer => customer.customerId);
          await axios.post(`${process.env.VUE_APP_API_BASE_URL}/customers/deleteByIds`, ids);
          this.customers = this.customers.filter(customer => !ids.includes(customer.customerId));
          this.refreshCustomers();
          this.$message({
            message: '删除成功',
            type: 'success'
          });
        } catch (error) {
          console.error('Failed to delete customers:', error);
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
      this.selectedCustomers = selection;
    },
    refreshCustomers() {
      this.fetchCustomers();
    },
    resetForm() {
      this.searchForm.customerName = '';
      this.searchForm.customerPhone = '';
      this.searchForm.customerEmail = '';
      this.refreshCustomers();
    }
  },
  mounted() {
    this.fetchCustomers(); // 页面加载时立即获取客户列表
  }
};
</script>

<style scoped>
.el-select {
  width: 100%; /* 确保下拉框宽度足够 */
}
</style>
