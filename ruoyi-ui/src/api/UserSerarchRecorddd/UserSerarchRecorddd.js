import request from '@/utils/request'

// 查询UserSerarchRecorddd列表
export function listUserSerarchRecorddd(query) {
  return request({
    url: '/UserSerarchRecorddd/UserSerarchRecorddd/list',
    method: 'get',
    params: query
  })
}

// 查询UserSerarchRecorddd详细
export function getUserSerarchRecorddd(id) {
  return request({
    url: '/UserSerarchRecorddd/UserSerarchRecorddd/' + id,
    method: 'get'
  })
}

// 新增UserSerarchRecorddd
export function addUserSerarchRecorddd(data) {
  return request({
    url: '/UserSerarchRecorddd/UserSerarchRecorddd',
    method: 'post',
    data: data
  })
}

// 修改UserSerarchRecorddd
export function updateUserSerarchRecorddd(data) {
  return request({
    url: '/UserSerarchRecorddd/UserSerarchRecorddd',
    method: 'put',
    data: data
  })
}

// 删除UserSerarchRecorddd
export function delUserSerarchRecorddd(id) {
  return request({
    url: '/UserSerarchRecorddd/UserSerarchRecorddd/' + id,
    method: 'delete'
  })
}
