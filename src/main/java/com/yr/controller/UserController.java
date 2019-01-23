package com.yr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entity.User;
import com.yr.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/first")
	@ResponseBody
    public Object first() {  
        return "first controller";  
    }  
  
    @RequestMapping("/doError")  
    @ResponseBody
    public Object error() {  
        return 1 / 0;  
    }  
	
//	@RequestMapping("/inster")
//	public String insterUser(Map<String, Object> map){
//		String str = userService.insterUser("南城-有海有风", 25, "陈柏霖");
//		if (str.equals("succss")) {
//			map.put("over", "添加成功");
//			return "inster";
//		} else {
//			map.put("over", "添加失败");
//			return "inster";
//		}
//	}
	
//	@RequestMapping("/inster2")
//	public String insterUser2(Map<String, Object> map){
//		String str = userService.insterUser2("你的背包-千金不换", 35, "陈奕迅");
//		if (str.equals("succss")) {
//			map.put("over", "添加成功");
//			return "inster";
//		} else {
//			map.put("over", "添加失败");
//			return "inster";
//		}
//	}
	
//	@RequestMapping("/insterSql")
//	public String insterUserSql(Map<String, Object> map){
//		String str = userService.insterUserSql("防止sql注入", 9, "女");
//		if (str.equals("succss")) {
//			map.put("over", "防止SQL注入 添加成功");
//			return "insterSql";
//		} else {
//			map.put("over", "防止SQL注入 添加失败");
//			return "insterSql";
//		}
//	}
//	
//	@RequestMapping("/getOnlyUser")
//	public String getUserById(Map<String, Object> map){
//		User user = userService.getUserById(1);
//		if(user != null || !user.equals("")){
//			map.put("over", user);
//			return "getOnlyUser";
//		} else {
//			map.put("over", "User 中没有值");
//			return "getOnlyUser";
//		}
//	}
//	
//	
//	@SuppressWarnings("unused")
//	@RequestMapping("/userKey")
//	public String saveUserKey(User user, Map<String, Object> map){
//		user.setName("谢知非");
//		user.setAge(10);
//		user.setSex("女");
//		int res = userService.saveUserKey(user);
//		if(user != null || !user.equals("")){
//			map.put("over", res);
//			return "userKey";
//		} else {
//			map.put("over", res);
//			return "userKey";
//		}
//	}
//	
//	@RequestMapping("/deleteUser")
//	public String deleteUser(User user, Map<String, Object> map){
//		user.setId(10);
//		String res = userService.deleteUser(user);
//		if (res.equals("succss")) {
//			map.put("over", "删除成功");
//			return "deleteUser";
//		} else {
//			map.put("over", "删除失败");
//			return "deleteUser";
//		}
//	}
//	
//	@RequestMapping("/updateUser")
//	public String updateUser(User user, Map<String, Object> map){
//		user.setId(11);
//		user.setName("你猜我是谁啦~");
//		user.setAge(23);
//		user.setSex("男");
//		String res = userService.updateUser(user);
//		if (res.equals("succss")) {
//			map.put("over", "修改成功");
//			return "updateUser";
//		} else {
//			map.put("over", "修改失败");
//			return "updateUser";
//		}
//	}
	
//	@RequestMapping("/mybitsTest")
//    public String selMybits(Map<String, Object> map) {
//		List<User> listUser = userService.selMybits();
//		map.put("list", listUser);
//		return "mybits";
//    }
//	
//	@RequestMapping("/mybits2Test")
//    public String updMybits2(Map<String, Object> map) {
//		List<User> listUser = userService.selMybits2();
//		map.put("list", listUser);
//		return "mybits";
//    }
    
	@RequestMapping("/mybits3Test")
	public String updMybits2(Map<String, Object> map,User user) {
		user.setId(11);
		user.setName("看落日欧若拉才");
		user.setAge(111);
		user.setSex("未知");
		boolean aa = userService.ins(user);
		if(aa){
			map.put("over", "succss");
			return "inster";
		} else {
			map.put("over", "error");
			return "inster";
		}
	}
	
}
