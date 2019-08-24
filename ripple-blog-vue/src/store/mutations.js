export default function () {
  let $set = this.$set;
  return {
    setHeadPicData(state, data) {
      state.headPicData.dishList = data.dishList || [];
    },
    setUserInfoData(state, data) {
      state.userInfoData = data || {};
    },


  };
}
