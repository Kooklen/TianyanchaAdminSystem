import request from '@/utils/request'

// 查询用户搜索记录列表
export function listUserSearchRecord(query) {
  return request({
    url: '/userSearchRecord/userSearchRecord/list',
    method: 'get',
    params: query
  })
}

// 查询用户搜索记录详细
export function getUserSearchRecord(recordnumber) {
  return request({
    url: '/userSearchRecord/userSearchRecord/' + recordnumber,
    method: 'get'
  })
}

// 新增用户搜索记录
export function addUserSearchRecord(data) {
  return request({
    url: '/userSearchRecord/userSearchRecord',
    method: 'post',
    data: data
  })
}

// 修改用户搜索记录
export function updateUserSearchRecord(data) {
  return request({
    url: '/userSearchRecord/userSearchRecord',
    method: 'put',
    data: data
  })
}

// 删除用户搜索记录
export function delUserSearchRecord(recordnumber) {
  return request({
    url: '/userSearchRecord/userSearchRecord/' + recordnumber,
    method: 'delete'
  })
}
