import request from '@/utils/request'

// 查询userMonitorCompany列表
export function listUserMonitorCompany(query) {
  return request({
    url: '/userMonitorCompany/userMonitorCompany/list',
    method: 'get',
    params: query
  })
}

// 查询userMonitorCompany详细
export function getUserMonitorCompany(recordnumber) {
  return request({
    url: '/userMonitorCompany/userMonitorCompany/' + recordnumber,
    method: 'get'
  })
}

// 新增userMonitorCompany
export function addUserMonitorCompany(data) {
  return request({
    url: '/userMonitorCompany/userMonitorCompany',
    method: 'post',
    data: data
  })
}

// 修改userMonitorCompany
export function updateUserMonitorCompany(data) {
  return request({
    url: '/userMonitorCompany/userMonitorCompany',
    method: 'put',
    data: data
  })
}

// 删除userMonitorCompany
export function delUserMonitorCompany(recordnumber) {
  return request({
    url: '/userMonitorCompany/userMonitorCompany/' + recordnumber,
    method: 'delete'
  })
}
