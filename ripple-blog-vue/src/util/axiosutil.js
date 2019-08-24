import axios from 'axios'
// import qs from 'qs'

// const base_url = ""
const base_url = "http://localhost:8080"

// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_API, //
  timeout: 5000,
  // headers: {
  //   "Content-Type": "application/x-www-form-urlencoded"
  // },
  withCredentials: true // 允许携带cookie
})

// service.defaults.headers.post['Content-Type'] = 'application/json';

// 发送请求前处理request的数据
axios.defaults.transformRequest = [function (data) {
  let newData = '';
  for (let k in data) {
    newData += encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) + '&'
  }
  return data;
}]

// request拦截器
service.interceptors.request.use(
  config => {
    // 发送请求之前，要做的业务
    config.url = base_url + config.url;
    return config;
  },
  error => {
    return Promise.reject(error);
  }
)

// response拦截器
service.interceptors.response.use(
  response => {
    // 数据响应之后，要做的业务
    return response
  },
  error => {
    return Promise.reject(error);
  }
)

// export default service

export default function (obj) {
  // var state = obj.state;
  var url = obj.url;
  var method = obj.method || 'post';
  if (method == 'post') {
    var data = obj.params;
  } else {
    var params = obj.params;
  }
  return new Promise((resolve, reject) => {
    service({
      method,
      url,
      // data: qs.stringfy(data),
      data,
      params,
    }).then(res => {
      resolve(res.data);
    }).catch(res => {
      reject(res);
    })
  })
}
