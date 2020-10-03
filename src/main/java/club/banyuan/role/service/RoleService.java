package club.banyuan.role.service;

import club.banyuan.role.entity.UmsRole;

import java.util.List;

public interface RoleService {

  List<UmsRole> getRoleList(String keyword, Integer pageSize, Integer pageNum);

  List<UmsRole> getRoleListAll();

  void updateRole(long id, UmsRole role);

  void updateRoleStatus(long id, Integer status);

  void deleteRole(Long[] ids);

  void insertRole(UmsRole role);

}
