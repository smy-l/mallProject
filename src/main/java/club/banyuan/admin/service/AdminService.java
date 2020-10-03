package club.banyuan.admin.service;

import club.banyuan.admin.entity.UmsAdmin;

import java.util.List;

public interface AdminService {

  UmsAdmin login(UmsAdmin admin);

  void deleteAdmin (Long id);

  List<UmsAdmin> getAdminList(String keyword, Integer pageSize, Integer pagePum);

  List<UmsAdmin> getList();

  void registerAdmin(UmsAdmin umsAdmin);

  void updateAdmin(long id, UmsAdmin umsAdmin);

  UmsAdmin getAdmin(long id);

  void updateAdminLoginTime(UmsAdmin admin);

}
