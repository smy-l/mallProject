package club.banyuan.role.service.impl;

import club.banyuan.role.dao.UmsRoleDao;
import club.banyuan.role.entity.UmsRole;
import club.banyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private UmsRoleDao roleDao;

  @Override
  public List<UmsRole> getRoleList() {
    return roleDao.getRoleList();
  }
}
