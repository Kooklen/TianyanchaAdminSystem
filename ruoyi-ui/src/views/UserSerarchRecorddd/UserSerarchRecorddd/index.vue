<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户ID" prop="userid">
        <el-input
          v-model="queryParams.userid"
          placeholder="请输入用户ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入用户名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="daterangeStarttime"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
<!--      <el-form-item label="到期时间" prop="endtime">-->
<!--        <el-date-picker clearable size="small"-->
<!--                        v-model="queryParams.endtime"-->
<!--                        type="date"-->
<!--                        value-format="yyyy-MM-dd"-->
<!--                        placeholder="选择到期时间"-->
<!--        >-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->

      <!--      <el-form-item label="监控功能" prop="monitorf">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.monitorf"-->
      <!--          placeholder="请输入监控功能"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="密码" prop="password">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.password"-->
      <!--          placeholder="请输入密码"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['UserSerarchRecorddd:UserSerarchRecorddd:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['UserSerarchRecorddd:UserSerarchRecorddd:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['UserSerarchRecorddd:UserSerarchRecorddd:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['UserSerarchRecorddd:UserSerarchRecorddd:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="UserSerarchRecordddList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="用户ID" align="center" prop="userid"/>
      <el-table-column label="用户名" align="center" prop="username"/>
      <el-table-column label="密码" align="center" prop="password"/>
      <el-table-column label="创建时间" align="center" prop="starttime" width="180">
      </el-table-column>
      <el-table-column label="到期时间" align="center" prop="endtime" width="180">
      </el-table-column>
      <el-table-column label="搜索功能" align="center" prop="searchfunction"/>
      <el-table-column label="监控功能" align="center" prop="monitorf"/>
      <!--      <el-table-column label="${comment}" align="center" prop="id" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['UserSerarchRecorddd:UserSerarchRecorddd:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['UserSerarchRecorddd:UserSerarchRecorddd:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改UserSerarchRecorddd对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userid">
          <el-input v-model="form.userid" placeholder="请输入用户id"/>
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名"/>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入密码"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="starttime">
          <el-date-picker clearable size="small"
                          v-model="form.starttime"
                          type="datetime"
                          placeholder="选择创建时间"
                          value-format="yyyy-MM-dd-mm-ss"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="到期时间" prop="endtime">
          <el-date-picker clearable size="small"
                          v-model="form.endtime"
                          type="datetime"
                          placeholder="选择到期时间"
                          value-format="yyyy-MM-dd-mm-ss"

          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="搜索功能" prop="searchfunction">
          <!--          <el-input v-model="form.searchfunction" placeholder="请输入搜索功能" />-->
          <el-radio v-model="form.searchfunction" :label="0">关闭</el-radio>
          <el-radio v-model="form.searchfunction" :label="1">开启</el-radio>
        </el-form-item>
        <el-form-item label="监控功能" prop="monitorf">
          <!--          <el-input v-model="form.monitorf" placeholder="请输入监控功能" />-->
          <el-radio v-model="form.monitorf" :label="0">关闭</el-radio>
          <el-radio v-model="form.monitorf" :label="1">开启</el-radio>
        </el-form-item>


      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listUserSerarchRecorddd,
  getUserSerarchRecorddd,
  delUserSerarchRecorddd,
  addUserSerarchRecorddd,
  updateUserSerarchRecorddd
} from '@/api/UserSerarchRecorddd/UserSerarchRecorddd'
import { listUserSearchRecord } from '@/api/userSearchRecord/userSearchRecord'

export default {
  name: 'UserSerarchRecorddd',
  data() {
    return {
      daterangeStarttime: [],
      starttime: '',
      endtime: '',
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // UserSerarchRecorddd表格数据
      UserSerarchRecordddList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userid: null,
        username: null,
        starttime: "",
        searchfunction: null,
        endtime: "",
        monitorf: null,
        password: null
      },
      // 表单参数
      form: {
        userid:''
      },
      // 表单校验
      rules: {
        userid: [
          {
            required:true,
            // type: 'number',
            min: 8,
            max: 8,
            message: 'ID必须为8位数字值',
            trigger: 'blur'

          }
        ]}
      }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询UserSerarchRecorddd列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeStarttime && '' != this.daterangeStarttime) {
        this.queryParams.params["beginStarttime"] = this.daterangeStarttime[0];
        this.queryParams.params["endStarttime"] = this.daterangeStarttime[1];
      }
      listUserSerarchRecorddd(this.queryParams).then(response => {
        this.UserSerarchRecordddList = response.rows;
        for (let i = 0; i < response.rows.length; i++) {
          console.log(response.rows)
          if (response.rows[i].monitorf == 0) {
            response.rows[i].monitorf = '未开通'
          } else {
            response.rows[i].monitorf = '已开通'

          }
          if (response.rows[i].searchfunction == 0) {
            response.rows[i].searchfunction = '未开通'
          } else {
            response.rows[i].searchfunction = '已开通'

          }
        }
        console.log(response.rows)
        this.total = response.total;
        this.loading = false;
      });
      // this.loading = true
      // console.log("查询中")
      // listUserSerarchRecorddd(this.queryParams).then(response => {
      //   for (let i = 0; i < response.rows.length; i++) {
      //     console.log(response.rows)
      //     if (response.rows[i].monitorf == 0) {
      //       response.rows[i].monitorf = '未开通'
      //     } else {
      //       response.rows[i].monitorf = '已开通'
      //
      //     }
      //     if (response.rows[i].searchfunction == 0) {
      //       response.rows[i].searchfunction = '未开通'
      //     } else {
      //       response.rows[i].searchfunction = '已开通'
      //
      //     }
      //   }
      //   this.UserSerarchRecordddList = response.rows
      //   this.total = response.total
      //   this.loading = false
      // })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        userid: null,
        username: null,
        starttime: null,
        searchfunction: null,
        endtime: null,
        monitorf: null,
        id: null,
        password: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      console.log(this.queryParams)
      this.queryParams.pageNum = 1
      this.getList(this.queryParams)
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加账户'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getUserSerarchRecorddd(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户账户的信息'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        console.log(this.form)
        if (valid) {
          if (this.form.id != null) {
            updateUserSerarchRecorddd(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addUserSerarchRecorddd(this.form).then(response => {
              this.$modal.msgSuccess('新增成功')
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除UserSerarchRecorddd编号为"' + ids + '"的数据项？').then(function() {
        return delUserSerarchRecorddd(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('UserSerarchRecorddd/UserSerarchRecorddd/export', {
        ...this.queryParams
      }, `UserSerarchRecorddd_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
