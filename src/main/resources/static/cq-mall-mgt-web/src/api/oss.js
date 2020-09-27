
export function uploadUrl() {
  return process.env.BASE_API + "/file/image/upload";
}

export function policy() {
  return request({
    url:'/aliyun/oss/policy',
    method:'get',
  })
}
