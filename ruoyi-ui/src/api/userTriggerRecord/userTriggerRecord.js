import request from '@/utils/request'

// 查询userTriggerRecord列表
export function listUserTriggerRecord(query) {
  return request({
    url: '/userTriggerRecord/userTriggerRecord/list',
    method: 'get',
    params: query
  })
}

// 查询userTriggerRecord详细
export function getUserTriggerRecord(recordnumber) {
  return request({
    url: '/userTriggerRecord/userTriggerRecord/' + recordnumber,
    method: 'get'
  })
}

// 新增userTriggerRecord
export function addUserTriggerRecord(data) {
  return request({
    url: '/userTriggerRecord/userTriggerRecord',
    method: 'post',
    data: data
  })
}

// 修改userTriggerRecord
export function updateUserTriggerRecord(data) {
  return request({
    url: '/userTriggerRecord/userTriggerRecord',
    method: 'put',
    data: data
  })
}

// 删除userTriggerRecord
export function delUserTriggerRecord(recordnumber) {
  return request({
    url: '/userTriggerRecord/userTriggerRecord/' + recordnumber,
    method: 'delete'
  })
}
