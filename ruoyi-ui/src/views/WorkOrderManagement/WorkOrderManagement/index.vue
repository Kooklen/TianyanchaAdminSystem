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
      <el-form-item label="公司名" prop="companyname">
        <el-input
          v-model="queryParams.companyname"
          placeholder="请输入公司名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createtime">
        <el-date-picker clearable size="small"
          v-model="queryParams.createtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择创建时间">
        </el-date-picker>
      </el-form-item>
<!--      <el-form-item label="状态" prop="state">-->
<!--        <el-input-->
<!--          v-model="queryParams.state"-->
<!--          placeholder="请输入状态"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="法人名" prop="legalpeople">
        <el-input
          v-model="queryParams.legalpeople"
          placeholder="请输入法人名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省份" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入省份"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="城市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入城市"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="统一社会信用代码" prop="code">-->
<!--        <el-input-->
<!--          v-model="queryParams.code"-->
<!--          placeholder="请输入统一社会信用代码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="联系方式" prop="contactphone">
        <el-input
          v-model="queryParams.contactphone"
          placeholder="请输入联系方式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="备注" prop="note">-->
<!--        <el-input-->
<!--          v-model="queryParams.note"-->
<!--          placeholder="请输入备注"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="工单号" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入工单号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="处理时间" prop="finaltime">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.finaltime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择处理时间">-->
<!--        </el-date-picker>-->
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
          v-hasPermi="['WorkOrderManagement:WorkOrderManagement:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['WorkOrderManagement:WorkOrderManagement:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['WorkOrderManagement:WorkOrderManagement:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['WorkOrderManagement:WorkOrderManagement:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="WorkOrderManagementList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工单号" align="center" prop="id" />
      <el-table-column label="用户ID" align="center" prop="userid" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="公司名" align="center" prop="companyname" />
      <el-table-column label="创建时间" align="center" prop="createtime" width="180">
      </el-table-column>
      <el-table-column label="状态" align="center" prop="state" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['WorkOrderManagement:WorkOrderManagement:edit']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['WorkOrderManagement:WorkOrderManagement:remove']"
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

    <!-- 添加或修改WorkOrderManagement对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工单号" prop="id">
          <el-input v-model="form.id" placeholder="请输入工单号" :disabled="true"/>
        </el-form-item>
        <el-form-item label="用户ID" prop="userid">
          <el-input v-model="form.userid" placeholder="请输入用户ID" :disabled="true"/>
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" :disabled="true"/>
        </el-form-item>
        <el-form-item label="公司名" prop="companyname">
          <el-input v-model="form.companyname" placeholder="请输入公司名" :disabled="true"/>
        </el-form-item>

        <el-form-item label="法人名" prop="legalpeople" >
          <el-input v-model="form.legalpeople" placeholder="请输入法人名" :disabled="true"/>
        </el-form-item>
        <el-form-item label="省份" prop="province">
          <el-input v-model="form.province" placeholder="请输入省份" :disabled="true"/>
        </el-form-item>
        <el-form-item label="城市" prop="city">
          <el-input v-model="form.city" placeholder="请输入城市" :disabled="true"/>
        </el-form-item>
        <el-form-item label="统一社会信用代码" prop="code">
          <el-input v-model="form.code" placeholder="" :disabled="true"/>
        </el-form-item>
        <el-form-item label="联系方式" prop="contactphone">
          <el-input v-model="form.contactphone" placeholder="请输入联系方式" :disabled="true"/>
        </el-form-item>

        <el-form-item label="创建时间" prop="createtime">
          <el-date-picker clearable size="small"
                          v-model="form.createtime"
                          type="datetime"
                          value-format="yyyy-MM-dd-mm-ss"
                          placeholder="选择创建时间"
                          :disabled="true"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态" prop="state" >
          <el-radio v-model="form.state" :label="0">待处理</el-radio>
          <el-radio v-model="form.state" :label="1">已解决</el-radio>
          <el-radio v-model="form.state" :label="2">无法处理</el-radio>
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
import { listWorkOrderManagement, getWorkOrderManagement, delWorkOrderManagement, addWorkOrderManagement, updateWorkOrderManagement } from "@/api/WorkOrderManagement/WorkOrderManagement";

export default {
  name: "WorkOrderManagement",
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
      // WorkOrderManagement表格数据
      WorkOrderManagementList: [],
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
        companyname: null,
        createtime: null,
        state: 0,
        legalpeople: null,
        province: null,
        city: null,
        code: null,
        contactphone: null,
        note: null,
        orderid: null,
        finaltime: null
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
    /** 查询WorkOrderManagement列表 */
    getList() {
      this.loading = true;
      listWorkOrderManagement(this.queryParams).then(response => {
        for (let i = 0; i < response.rows.length; i++) {
          console.log(response.rows)
          if (response.rows[i].state == 0) {
            response.rows[i].state = '待处理'
          }}
        // console.log(response.rows)
        this.WorkOrderManagementList = response.rows;
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
        id: null,
        userid: null,
        username: null,
        companyname: null,
        createtime: null,
        state: null,
        legalpeople: null,
        province: null,
        city: null,
        code: null,
        contactphone: null,
        note: null,
        orderid: null,
        finaltime: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加WorkOrderManagement";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getWorkOrderManagement(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工单";
      });
    },
    writenote() {
      this.$prompt('请输入无法解决的原因', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        console.log(value)
        this.form.note = value;
        this.form.finaltime = //时间还没搞
        console.log(this.form.note)
        // console.log(this.form.note)
        this.submit()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    },
    /** 提交按钮 */
    submitForm() {
      if(this.form.state==2){
        this.writenote()
      }else{
        this.submit()
      }},
    submit(){
      var _this = this;
      let yy = new Date().getFullYear();
      let mm = new Date().getMonth() + 1;
      let dd = new Date().getDate() < 10 ? '0' + new Date().getDate() : new Date().getDate();;
      let hh = new Date().getHours() < 10 ? '0' + new Date().getHours() : new Date().getHours();;
      let mf = new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes();
      let ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds();
      _this.gettime = yy + '-' + mm + '-' + dd + '-' + hh + '-' + mf + '-' + ss;
      this.form.finaltime = _this.gettime;
      // console.log(this.form)
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWorkOrderManagement(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWorkOrderManagement(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    }
    ,
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除WorkOrderManagement编号为"' + ids + '"的数据项？').then(function() {
        return delWorkOrderManagement(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('WorkOrderManagement/WorkOrderManagement/export', {
        ...this.queryParams
      }, `WorkOrderManagement_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
