package club.banyuan.role.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ums_role
 * @author 
 */
public class UmsRole implements Serializable {
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 后台用户数量
     */
    private Integer admin_count;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdmin_count() {
        return admin_count;
    }

    public void setAdmin_count(Integer admin_count) {
        this.admin_count = admin_count;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}