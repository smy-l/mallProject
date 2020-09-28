package club.banyuan.role.dao;

import club.banyuan.role.entity.UmsRole;

import java.util.List;

public interface UmsRoleDao {

    List<UmsRole> getRoleList();

    int deleteByPrimaryKey(Long id);

    int insert(UmsRole record);

    int insertSelective(UmsRole record);

    UmsRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsRole record);

    int updateByPrimaryKey(UmsRole record);
}