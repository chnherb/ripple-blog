import {Notification as notify} from 'element-ui';
import fetchAPI from '../util/axiosutil.js'

export default function () {
  return {

    async getUserInfoData({state, commit, dispatch}, data) {
      let res = await fetchAPI({
        method: 'post',
        url: '/xxxx',
        params: data,
      });
      if (res.code == 200) {
        await dispatch("getxxxxx", params.imgIndex);
        return true;
      } else {
        notify.error({
          title: "获取数据失败",
          message: "获取统计数据失败",
        });
        await dispatch("getxxxxx", params.imgIndex);
        return false;
      }
    },

    async getUserInfo({commit}) {
      console.log("getUserInfo")
      let res = await fetchAPI({
        method: 'post',
        url: '/api/user/getAuthor',
      });
      if (res.code == 200) {
        commit("setUserInfoData", res);
        return true;
      } else {
        notify.error({
          title: "获取数据失败",
          message: "获取用户数据失败",
        });
        return false;
      }
    },
    async submitMdData({commit}, data) {
      console.log("mdData:")
      console.log(data)
      let res = await fetchAPI({
        method: 'post',
        url: '/api/md/insert',
        params: data
      });
      if (res.code == 200) {
        notify.success({
          title: "提交成功",
          message: res.msg,
        });
        return true;
      } else {
        notify.error({
          title: "提交失败",
          message: res.msg,
        });
        return false;
      }
    },
    async updateMdData({commit}, data) {
      console.log("updatedData:")
      console.log(data)
      let res = await fetchAPI({
        method: 'post',
        url: '/api/md/update',
        params: data
      });
      if (res.code == 200) {
        notify.success({
          title: "更新成功",
          message: res.msg,
        });
        return true;
      } else {
        notify.error({
          title: "更新失败",
          message: res.msg,
        });
        return false;
      }
    },

    async query({commit}, data) {
      let res = await fetchAPI({
        method: 'post',
        url: '/api/md/query',
        params: data
      });
      if (res.code == 200) {
        console.log(res)
        return res.data;
      } else {
        notify.error({
          title: "获取列表失败",
          message: res.msg,
        });
        return [];
      }
    },
    async findById({commit}, data) {
      let res = await fetchAPI({
        method: 'post',
        url: '/api/md/'+data.id,
      });
      if (res.code == 200) {
        console.log(res)
        return res.data;
      } else {
        notify.error({
          title: "获取列表失败",
          message: res.msg,
        });
        return [];
      }
    },

  };
}
