package club.banyuan.admin.dao;

import club.banyuan.admin.entity.UmsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminDao {
    List<UmsAdmin> getAdminList(@Param("keyword") String keyword, @Param("pageSize") Integer pageSize, @Param("pageNum") Integer pageNum);

    List<UmsAdmin> getList();

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);

    UmsAdmin login(@Param("username") String name, @Param("password") String pwd);
}