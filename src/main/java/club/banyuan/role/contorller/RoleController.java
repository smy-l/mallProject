package club.banyuan.role.contorller;

import club.banyuan.mall.mgt.dto.Message;
import club.banyuan.role.entity.UmsRole;
import club.banyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @RequestMapping("/list")
  @ResponseBody
  public Message getRoleList(String keyword, Integer pageSize, Integer pageNum) {
    System.out.println(keyword);
    System.out.println(pageSize);
    System.out.println(pageNum);
    int total = roleService.getRoleListAll().size();
    List<UmsRole> roleList = roleService.getRoleList(keyword, pageSize, pageNum);
    Map<String, Object> data = new HashMap<>();
    data.put("list", roleList);
    data.put("pageNum", pageNum);
    data.put("pageSize", pageSize);
    data.put("total", total);
    data.put("totalPage", (roleList.size() / pageSize) + 1);
    Message message = new Message();
    message.setCode(200);
    message.setData(data);
    message.setMessage("操作成功");
    return message;
  }

  @RequestMapping("/listAll")
  @ResponseBody
  public Message getRoleListAll() {
    List<UmsRole> data = roleService.getRoleListAll();
    Message message = new Message();
    message.setCode(200);
    message.setData(data);
    message.setMessage("操作成功");
    return message;
  }

  @RequestMapping("/update/{id}")
  @ResponseBody
  public Message updateRole(@PathVariable("id") long id, @RequestBody UmsRole role) {
    System.out.println(id);
    System.out.println(role);
    roleService.updateRole(id, role);
    Message message = new Message();
    message.setCode(200);
    message.setMessage("操作成功");
    return message;
  }

  @RequestMapping("/updateStatus/{id}")
  @ResponseBody
  public Message updateRoleStatus(@PathVariable("id") long id, Integer status) {
    System.out.println(id);
    System.out.println(status);
    roleService.updateRoleStatus(id, status);
    Message message = new Message();
    message.setCode(200);
    message.setMessage("操作成功");
    return message;
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Message deleteRole(Long[] ids) {
    roleService.deleteRole(ids);
    Message message = new Message();
    message.setCode(200);
    message.setMessage("操作成功");
    return message;
  }

  @RequestMapping("/create")
  @ResponseBody
  public Message createRole(@RequestBody UmsRole role) {
    roleService.insertRole(role);
    Message message = new Message();
    message.setCode(200);
    message.setMessage("添加成功");
    return message;
  }
}

