package club.banyuan.role.contorller;

import club.banyuan.role.entity.UmsRole;
import club.banyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

  @Autowired
  private RoleService roleService;

  @RequestMapping("/role/listAll")
  @ResponseBody
  public List<UmsRole> getRoleList() {
    return roleService.getRoleList();
  }



}
