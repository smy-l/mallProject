package club.banyuan.role.dao;

import club.banyuan.role.entity.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleDao {

    List<UmsRole> getRoleListAll();

    List<UmsRole> getRoleList(@Param("keyword") String keyword, @Param("pageSize") Integer pageSize, @Param("pageNum") Integer pageNum);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRole record);

    int insertSelective(UmsRole record);

    UmsRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsRole record);

    int updateByPrimaryKey(UmsRole record);
}