package com.family.sweety.modules.programmer_url.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.family.sweety.common.utils.MailSendUtil;
import com.family.sweety.common.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.family.sweety.modules.programmer_url.entity.ProgrammerUrlCategoryEntity;
import com.family.sweety.modules.programmer_url.entity.SummerizeCategoryEntity;
import com.family.sweety.modules.programmer_url.service.ProgrammerUrlService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import sun.applet.Main;

@Controller
@RequestMapping(value="/programmer")
public class ProgrammerUrlController {
	
	@Autowired
	private ProgrammerUrlService programmerUrlService;

	@RequestMapping(value="good_url.php")
	public String goodUrl(HttpServletRequest request ,Model model ){
	List<SummerizeCategoryEntity> list = programmerUrlService.findProgrammerUrlList();
		model.addAttribute("list", list);
		return "modules/programmer_url/url_index";
	}
	
	@RequestMapping(value="findCategoryBySummrizeId.php")
	public @ResponseBody List<ProgrammerUrlCategoryEntity>findCategoryBySummrizeId(Integer summerizeId,Model model){
		
		 
				
				List<ProgrammerUrlCategoryEntity> list = programmerUrlService.findCategoryBySummrizeId(summerizeId);
			
				JsonConfig config = new JsonConfig();
				config.setExcludes(new String[]{"categoryEntity"});
				
				
				return JSONArray.fromObject(list,config);
		
	}


}
