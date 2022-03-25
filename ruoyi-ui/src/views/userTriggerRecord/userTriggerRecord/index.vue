<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="记录号" prop="recordnumber">
        <el-input
          v-model="queryParams.recordnumber"
          placeholder="请输入记录号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="userid">
        <el-input
          v-model="queryParams.userid"
          placeholder="请输入用户id"
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
      <el-form-item label="公司ID" prop="companyid">
        <el-input
          v-model="queryParams.companyid"
          placeholder="请输入公司ID"
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
      <el-form-item label="推送方式" prop="pushway">
        <el-input
          v-model="queryParams.pushway"
          placeholder="请输入推送方式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="触发时间">
        <el-date-picker
          v-model="daterangeTriggertime"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
<!--      <el-form-item label="地址" prop="address">-->
<!--        <el-input-->
<!--          v-model="queryParams.address"-->
<!--          placeholder="请输入地址"-->
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

<!--    <el-row :gutter="10" class="mb8">-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['userTriggerRecord:userTriggerRecord:add']"-->
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
<!--          v-hasPermi="['userTriggerRecord:userTriggerRecord:edit']"-->
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
<!--          v-hasPermi="['userTriggerRecord:userTriggerRecord:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['userTriggerRecord:userTriggerRecord:export']"
        >导出</el-button>
      </el-col>
    <br>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
<!--    </el-row>-->

    <el-table v-loading="loading" :data="userTriggerRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录号" align="center" width="70" prop="recordnumber" />
      <el-table-column label="用户ID" align="center" prop="userid" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="公司ID" align="center" prop="companyid" />
      <el-table-column label="公司名" align="center" prop="companyname" />
      <el-table-column label="推送方式" align="center" prop="pushway" />
      <el-table-column label="触发时间" align="center" prop="triggertime" width="180">
      </el-table-column>
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['userTriggerRecord:userTriggerRecord:edit']"-->
<!--          >修改</el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['userTriggerRecord:userTriggerRecord:remove']"
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

    <!-- 添加或修改userTriggerRecord对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userid">
          <el-input v-model="form.userid" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="公司id" prop="companyid">
          <el-input v-model="form.companyid" placeholder="请输入公司id" />
        </el-form-item>
        <el-form-item label="公司名" prop="companyname">
          <el-input v-model="form.companyname" placeholder="请输入公司名" />
        </el-form-item>
        <el-form-item label="推送方式" prop="pushway">
          <el-input v-model="form.pushway" placeholder="请输入推送方式" />
        </el-form-item>
        <el-form-item label="触发时间" prop="triggertime">
          <el-date-picker clearable size="small"
                          v-model="form.triggertime"
                          type="datetime"
                          value-format="yyyy-MM-dd-hh-mm-ss"
                          placeholder="选择触发时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" />
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
import { listUserTriggerRecord, getUserTriggerRecord, delUserTriggerRecord, addUserTriggerRecord, updateUserTriggerRecord } from "@/api/userTriggerRecord/userTriggerRecord";

export default {
  name: "UserTriggerRecord",
  data() {
    return {
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
      // userTriggerRecord表格数据
      userTriggerRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 地址时间范围
      daterangeTriggertime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        recordnumber: null,
        userid: null,
        username: null,
        companyid: null,
        companyname: null,
        pushway: null,
        triggertime: null,
        address: null
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
    /** 查询userTriggerRecord列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeTriggertime && '' != this.daterangeTriggertime) {
        this.queryParams.params["beginTriggertime"] = this.daterangeTriggertime[0];
        this.queryParams.params["endTriggertime"] = this.daterangeTriggertime[1];
      }
      listUserTriggerRecord(this.queryParams).then(response => {
        console.log(response.rows)

        this.userTriggerRecordList = response.rows;
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
        recordnumber: null,
        userid: null,
        username: null,
        companyid: null,
        companyname: null,
        pushway: null,
        triggertime: null,
        address: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeTriggertime = [];
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
      this.title = "添加userTriggerRecord";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordnumber = row.recordnumber || this.ids
      getUserTriggerRecord(recordnumber).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改userTriggerRecord";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recordnumber != null) {
            updateUserTriggerRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserTriggerRecord(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除userTriggerRecord编号为"' + recordnumbers + '"的数据项？').then(function() {
        return delUserTriggerRecord(recordnumbers);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('userTriggerRecord/userTriggerRecord/export', {
        ...this.queryParams
      }, `userTriggerRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
