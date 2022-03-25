<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="企业状态" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入企业状态（0为正常,1为异常)"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="状态" prop="ismonitor">
        <el-input
          v-model="queryParams.ismonitor"
          placeholder="请输入状态（0为没有监控,1为正在监控)"
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
      <el-form-item label="公司id" prop="companyid">
        <el-input
          v-model="queryParams.companyid"
          placeholder="请输入公司id"
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
      <el-form-item label="公司名" prop="companyname">
        <el-input
          v-model="queryParams.companyname"
          placeholder="请输入公司名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="监控时间">
        <el-date-picker
          v-model="daterangeMonitortime"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['userMonitorCompany:userMonitorCompany:export']"
        >导出</el-button>
    <br>
<!--      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
<!--    </el-row>-->

    <el-table v-loading="loading" :data="userMonitorCompanyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column width="70" label="记录号" align="center" prop="recordnumber" />
      <el-table-column label="企业状态" align="center">
        <template slot-scope="scope">
          <div v-if="scope.row.state==0">正常</div>
          <div v-if="scope.row.state==1">异常</div>
        </template>
      </el-table-column>

      <el-table-column label="是否在监控" align="center">
        <template slot-scope="scope">
          <div v-if="scope.row.ismonitor==0">没有监控</div>
          <div v-if="scope.row.ismonitor==1">正在监控</div>
        </template>
      </el-table-column>
      <el-table-column label="用户id" align="center" prop="userid" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="公司id" align="center" prop="companyid" />
      <el-table-column label="公司名" align="center" prop="companyname" />
      <el-table-column label="监控时间" align="center" prop="monitortime" width="180">
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.monitortime, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['userMonitorCompany:userMonitorCompany:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['userMonitorCompany:userMonitorCompany:remove']"
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

    <!-- 添加或修改userMonitorCompany对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="企业状态（0为正常,1为异常)" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态（0为正常,1为异常)" />
        </el-form-item>
        <el-form-item label="监控状态（0为没有监控,1为正在监控)" prop="state">
          <el-input v-model="form.ismonitor" placeholder="请输入状态（0为正常,1为异常)" />
        </el-form-item>
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
        <el-form-item label="监控时间" prop="monitortime">
          <el-date-picker clearable size="small"
            v-model="form.monitortime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择监控时间">
          </el-date-picker>
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
import { listUserMonitorCompany, getUserMonitorCompany, delUserMonitorCompany, addUserMonitorCompany, updateUserMonitorCompany } from "@/api/userMonitorCompany/userMonitorCompany";

export default {
  name: "UserMonitorCompany",
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
      // userMonitorCompany表格数据
      userMonitorCompanyList: [],
      // 监控时间时间范围
      daterangeMonitortime: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userid: null,
        username: null,
        companyid: null,
        recordnumber: null,
        companyname: null,
        monitortime: null
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
    /** 查询userMonitorCompany列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeMonitortime && '' != this.daterangeMonitortime) {
        this.queryParams.params["beginMonitortime"] = this.daterangeMonitortime[0];
        this.queryParams.params["endMonitortime"] = this.daterangeMonitortime[1];
      }
      listUserMonitorCompany(this.queryParams).then(response => {
        console.log(response)
        this.userMonitorCompanyList = response.rows;
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
        username: null,
        companyid: null,
        recordnumber: null,
        companyname: null,
        monitortime: null
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
      this.title = "添加userMonitorCompany";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordnumber = row.recordnumber || this.ids
      getUserMonitorCompany(recordnumber).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改userMonitorCompany";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recordnumber != null) {
            updateUserMonitorCompany(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserMonitorCompany(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除userMonitorCompany编号为"' + recordnumbers + '"的数据项？').then(function() {
        return delUserMonitorCompany(recordnumbers);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('userMonitorCompany/userMonitorCompany/export', {
        ...this.queryParams
      }, `userMonitorCompany_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
