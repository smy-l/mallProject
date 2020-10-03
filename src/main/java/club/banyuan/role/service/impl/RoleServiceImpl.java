package club.banyuan.role.service.impl;

import club.banyuan.role.dao.UmsRoleDao;
import club.banyuan.role.entity.UmsRole;
import club.banyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

  private static final SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Autowired
  private UmsRoleDao roleDao;

  @Override
  public List<UmsRole> getRoleList(String keyword, Integer pageSize, Integer pageNum) {
    return roleDao.getRoleList(keyword, pageSize, (pageNum - 1) * pageSize);
  }

  @Override
  public List<UmsRole> getRoleListAll() {
    return roleDao.getRoleListAll();
  }

  @Override
  public void updateRole(long id, UmsRole role) {
    UmsRole umsRole = roleDao.selectByPrimaryKey(id);
    umsRole.setAdminCount(role.getAdminCount());
    umsRole.setDescription(role.getDescription());
    umsRole.setName(role.getName());
    umsRole.setSort(role.getSort());
    umsRole.setStatus(role.getStatus());
    roleDao.updateByPrimaryKey(umsRole);
  }

  @Override
  public void updateRoleStatus(long id, Integer status) {
    UmsRole umsRole = roleDao.selectByPrimaryKey(id);
    umsRole.setStatus(status);
    roleDao.updateByPrimaryKey(umsRole);
  }

  @Override
  public void deleteRole(Long[] ids) {
    for (Long id : ids) {
      roleDao.deleteByPrimaryKey(id);
    }
  }

  @Override
  public void insertRole(UmsRole role) {
    role.setCreateTime(time.format(new Date()));
    roleDao.insert(role);
  }


}
