package club.banyuan.admin.service.impl;

import club.banyuan.admin.dao.UmsAdminDao;
import club.banyuan.admin.entity.UmsAdmin;
import club.banyuan.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

  private static final SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Autowired
  private UmsAdminDao umsAdminDao;

  @Override
  public UmsAdmin login(UmsAdmin admin) {
    return umsAdminDao.login(admin.getUsername(), admin.getPassword());
  }

  @Override
  public void deleteAdmin(Long id) {
    umsAdminDao.deleteByPrimaryKey(id);
  }

  @Override
  public List<UmsAdmin> getAdminList(String keyword, Integer pageSize, Integer pageNum) {
    return umsAdminDao.getAdminList(keyword, pageSize, (pageNum - 1) * pageSize);
  }

  @Override
  public List<UmsAdmin> getList() {
    return umsAdminDao.getList();
  }

  @Override
  public void registerAdmin(UmsAdmin umsAdmin) {
    umsAdmin.setCreateTime(time.format(new Date()));
    umsAdminDao.insert(umsAdmin);
  }

  @Override
  public void updateAdmin(long id, UmsAdmin umsAdmin) {
    UmsAdmin admin = umsAdminDao.selectByPrimaryKey(id);
    admin.setPassword(umsAdmin.getPassword());
    admin.setEmail(umsAdmin.getEmail());
    admin.setIcon(umsAdmin.getIcon());
    admin.setNickName(umsAdmin.getNickName());
    admin.setNote(umsAdmin.getNote());
    admin.setStatus(umsAdmin.getStatus());
    admin.setUsername(umsAdmin.getUsername());
    umsAdminDao.updateByPrimaryKey(admin);
  }

  @Override
  public UmsAdmin getAdmin(long id) {
    UmsAdmin umsAdmin = umsAdminDao.selectByPrimaryKey(id);
    return umsAdmin;
  }

  @Override
  public void updateAdminLoginTime(UmsAdmin admin) {
    admin.setLoginTime(time.format(new Date()));
    umsAdminDao.updateByPrimaryKey(admin);
  }
}
