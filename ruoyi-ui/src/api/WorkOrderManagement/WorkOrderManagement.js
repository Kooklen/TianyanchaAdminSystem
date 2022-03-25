import request from '@/utils/request'

// 查询WorkOrderManagement列表
export function listWorkOrderManagement(query) {
  return request({
    url: '/WorkOrderManagement/WorkOrderManagement/list',
    method: 'get',
    params: query
  })
}

// 查询WorkOrderManagement详细
export function getWorkOrderManagement(id) {
  return request({
    url: '/WorkOrderManagement/WorkOrderManagement/' + id,
    method: 'get'
  })
}

// 新增WorkOrderManagement
export function addWorkOrderManagement(data) {
  return request({
    url: '/WorkOrderManagement/WorkOrderManagement',
    method: 'post',
    data: data
  })
}

// 修改WorkOrderManagement
export function updateWorkOrderManagement(data) {
  return request({
    url: '/WorkOrderManagement/WorkOrderManagement',
    method: 'put',
    data: data
  })
}

// 删除WorkOrderManagement
export function delWorkOrderManagement(id) {
  return request({
    url: '/WorkOrderManagement/WorkOrderManagement/' + id,
    method: 'delete'
  })
}
