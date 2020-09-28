package club.banyuan.admin.dao;

import club.banyuan.admin.entity.UmsAdmin;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);

    UmsAdmin login(@Param("username") String name, @Param("password") String pwd);
}