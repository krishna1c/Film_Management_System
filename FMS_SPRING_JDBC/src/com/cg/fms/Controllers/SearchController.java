package com.cg.fms.Controllers;

import java.nio.channels.FileChannel.MapMode;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.ServiceInterfaces.ActorService;
import com.cg.fms.ServiceInterfaces.LanguageService;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;


@RestController
public class SearchController {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("Config.xml");
	private LanguageService lservice = ctx.getBean("lservice",LanguageService.class);;
	@RequestMapping("/hello")
	public Set<Film> findByLanguage() throws Exception{
		return lservice.findByLanguage("English");
	}
}
