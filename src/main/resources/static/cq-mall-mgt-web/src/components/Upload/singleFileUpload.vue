<template> 
  <div>
    <el-upload
      :action="uploadUrlAction()"
      :data="useOss?dataObj:null"
      :headers="authToken()"
      list-type="picture"
      :multiple="false" :show-file-list="showFileList"
      :file-list="fileList"
      :before-upload="beforeUpload"
      :on-remove="handleRemove"
      :on-success="handleUploadSuccess"
      :on-preview="handlePreview">
      <el-button size="small" type="primary">点击上传</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过10MB</div>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="fileList[0].url" alt="">
    </el-dialog>
  </div>
</template>
<script>
  import {uploadUrl} from "@/api/oss";
  import {getToken} from '@/utils/auth';
  import store from '@/store';
  import {Message, MessageBox} from "element-ui";

  export default {
    name: 'singleFileUpload',
    props: {
      value: String
    },
    computed: {
      imageUrl() {
        return this.value;
      },
      imageName() {
        if (this.value != null && this.value !== '') {
          return this.value.substr(this.value.lastIndexOf("/") + 1);
        } else {
          return null;
        }
      },
      fileList() {
        return [{
          name: this.imageName,
          url: this.imageUrl
        }]
      },
      showFileList: {
        get: function () {
          return this.value !== null && this.value !== '' && this.value !== undefined;
        },
        set: function (newValue) {
        }
      }
    },
    data() {
      return {
        dataObj: {
          policy: '',
          signature: '',
          key: '',
          ossaccessKeyId: '',
          dir: '',
          host: '',
          // callback:'',
        },
        dialogVisible: false,
        useOss: false, //使用oss->true;使用MinIO->false
        ossUploadUrl: 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com',
        minioUploadUrl: '/minio/upload',
      };
    },
    methods: {
      emitInput(val) {
        this.$emit('input', val)
      },
      uploadUrlAction() {
        return uploadUrl();
      },
      handleRemove(file, fileList) {
        this.emitInput('');
      },
      handlePreview(file) {
        this.dialogVisible = true;
      },
      authToken() {
        if (store.getters.token) {
          let token = getToken();
          return {Authorization: token};
        }
      },
      beforeUpload(file) {
        let _self = this;
        if (!this.useOss) {
          //不使用oss不需要获取策略
          return true;
        }
      },
      handleUploadSuccess(res, file) {
        if (res.code !== 200) {
          Message({
            message: res.message,
            type: 'error',
            duration: 3 * 1000
          })
          return;
        }
        // 401:未登录;
        if (res.code === 401) {
          MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
            confirmButtonText: '重新登录',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            store.dispatch('FedLogOut').then(() => {
              location.reload()// 为了重新实例化vue-router对象 避免bug
            })
          })
          return;
        }

        this.showFileList = true;
        this.fileList.pop();
        let url = this.dataObj.host + '/' + this.dataObj.dir + '/' + file.name;

        if (!this.useOss) {
          //不使用oss直接获取图片路径
          url = res.data.url;
        }
        this.fileList.push({name: file.name, url: url});
        this.emitInput(this.fileList[0].url);
      }
    }
  }
</script>
<style>

</style>


