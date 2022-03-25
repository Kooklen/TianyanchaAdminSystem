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
      <el-form-item label="记录号" prop="recordnumber">
        <el-input
          v-model="queryParams.recordnumber"
          placeholder="请输入记录号"
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
      <el-form-item label="企业ID" prop="companyid">
        <el-input
          v-model="queryParams.companyid"
          placeholder="请输入企业ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司名" prop="companyname">
        <el-input
          v-model="queryParams.companyname"
          placeholder="请输入公司名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下载时间时间">
        <el-date-picker
          v-model="daterangeSearchtime"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['userSearchRecord:userSearchRecord:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['userSearchRecord:userSearchRecord:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          plain-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['userSearchRecord:userSearchRecord:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['userSearchRecord:userSearchRecord:export']"
        >导出</el-button>
      <br>
<!--      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userSearchRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录号" align="center" width="60" prop="recordnumber" />
      <el-table-column label="用户ID" align="center" prop="userid" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="下载企业ID" align="center" prop="companyid" />
      <el-table-column label="下载企业" align="center" prop="companyname" />
      <el-table-column label="下载时间" align="center" prop="searchtime" width="180">
      </el-table-column>
      <el-table-column label="状态" align="center" prop="state" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['userSearchRecord:userSearchRecord:edit']"-->
<!--          >修改</el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['userSearchRecord:userSearchRecord:remove']"
          >删除</el-button>
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

    <!-- 添加或修改用户搜索记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="userid">
          <el-input v-model="form.userid" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="企业ID" prop="companyid">
          <el-input v-model="form.companyid" placeholder="请输入企业ID" />
        </el-form-item>
        <el-form-item label="企业名" prop="companyname">
          <el-input v-model="form.companyname" placeholder="请输入企业名" />
        </el-form-item>
        <el-form-item label="搜索时间" prop="searchtime">
          <el-date-picker clearable size="small"
            v-model="form.searchtime"
            type="datetime"
            value-format="yyyy-MM-dd-mm-ss"
            placeholder="选择下载时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态" />
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
import { listUserSearchRecord, getUserSearchRecord, delUserSearchRecord, addUserSearchRecord, updateUserSearchRecord } from "@/api/userSearchRecord/userSearchRecord";

export default {
  name: "UserSearchRecord",
  data() {
    return {
      daterangeSearchtime: [],
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
      // 用户搜索记录表格数据
      userSearchRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userid: null,
        recordnumber: null,
        username: null,
        companyid: null,
        companyname: null,
        searchtime: null,
        state: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户搜索记录列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeSearchtime && '' != this.daterangeSearchtime) {
        this.queryParams.params["beginSearchtime"] = this.daterangeSearchtime[0];
        this.queryParams.params["endSearchtime"] = this.daterangeSearchtime[1];
      }
      listUserSearchRecord(this.queryParams).then(response => {
        for(let i=0 ; i<response.rows.length; i++){
          if(response.rows[i].state==0){
            response.rows[i].state="失败"
          }else {
            response.rows[i].state="成功"
          }
        }
        this.userSearchRecordList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        userid: null,
        recordnumber: null,
        username: null,
        companyid: null,
        companyname: null,
        searchtime: null,
        state: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      console.log(this.queryParams)
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.recordnumber)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户搜索记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordnumber = row.recordnumber || this.ids
      getUserSearchRecord(recordnumber).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户搜索记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recordnumber != null) {
            updateUserSearchRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserSearchRecord(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const recordnumbers = row.recordnumber || this.ids;
      this.$modal.confirm('是否确认删除用户搜索记录编号为"' + recordnumbers + '"的数据项？').then(function() {
        return delUserSearchRecord(recordnumbers);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('userSearchRecord/userSearchRecord/export', {
        ...this.queryParams
      }, `userSearchRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
