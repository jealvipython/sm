package com.family.sweety.modules.novel.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/sys/novel")
public class NovelController {

	
	
	
	@RequestMapping(value="index.php")
	public String  index(){
		return "modules/novel/novel_index";
		
	}
}
