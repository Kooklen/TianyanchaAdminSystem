import request from '@/utils/request'

// 查询userAccountManagement列表
export function listUserAccountManagement(query) {
  return request({
    url: '/userAccountManagement/userAccountManagement/list',
    method: 'get',
    params: query
  })
}

// 查询userAccountManagement详细
export function getUserAccountManagement(userid) {
  return request({
    url: '/userAccountManagement/userAccountManagement/' + userid,
    method: 'get'
  })
}

// 新增userAccountManagement
export function addUserAccountManagement(data) {
  return request({
    url: '/userAccountManagement/userAccountManagement',
    method: 'post',
    data: data
  })
}

// 修改userAccountManagement
export function updateUserAccountManagement(data) {
  return request({
    url: '/userAccountManagement/userAccountManagement',
    method: 'put',
    data: data
  })
}

// 删除userAccountManagement
export function delUserAccountManagement(userid) {
  return request({
    url: '/userAccountManagement/userAccountManagement/' + userid,
    method: 'delete'
  })
}
