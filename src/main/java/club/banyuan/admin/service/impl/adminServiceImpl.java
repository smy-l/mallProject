package club.banyuan.admin.service.impl;

import club.banyuan.admin.dao.UmsAdminDao;
import club.banyuan.admin.entity.UmsAdmin;
import club.banyuan.admin.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceImpl implements adminService {

  @Autowired
  private UmsAdminDao adminDao;

  @Override
  public UmsAdmin Login(UmsAdmin admin) {
    return adminDao.login(admin.getUsername(), admin.getPassword());
  }
}
