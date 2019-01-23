package com.yr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstTest3 {

	@RequestMapping("/index")
	public String index(ModelMap map){ // ModelMap转发值的作用
		map.addAttribute("name","降龙十八掌!");
		return "index";
	}
	
	/**
	 * freemarker:(跳转到 freemarker.ftl).
	 * @author zxy-un
	 * 
	 * @param map
	 * @return
	 * 
	 * 下午5:06:42
	 */
    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map){
        map.put("name", "Joe");
        map.put("sex", 1);    //sex:性别，1：男；0：女；  
        
        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
    }
    
    @RequestMapping("/testJsp")
	public String index() {
		return "testJsp";
	}
	
}
