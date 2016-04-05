package com.cg.fms.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.ServiceInterfaces.ActorService;
import com.cg.fms.ServiceInterfaces.CategoryService;
import com.cg.fms.ServiceInterfaces.FilmService;
import com.cg.fms.ServiceInterfaces.LanguageService;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class SearchController {
	@Autowired
	private LanguageService lservice;
	@Autowired
	private CategoryService cservice;
	@Autowired
	private FilmService fservice;
	@Autowired
	private ActorService aservice;
	HttpSession session;
	ArrayList<String> st = new ArrayList<String>();
	@RequestMapping("/slanguage")
	public Set<Film> findByLanguage(Language l,HttpServletRequest request) throws Exception{
		session=request.getSession(true);
		st.add(l.getName());
	
			System.out.println(session.getAttribute("success"));
		return lservice.findByLanguage(l.getName());
	}
	@RequestMapping("/scategory")
	public Set<Film> findByCategory(Category c) throws Exception{
		
		System.out.println(st);
		return cservice.findByCategory(c.getName());
	}
	
	@RequestMapping("/srating")
	public Set<Film> findByRating(String name) throws Exception{
		return fservice.findFilmByRating(name);
	}
	
	@RequestMapping("/stitle")
	public Set<Film> findByTitle(String name) throws Exception{
		return fservice.findFilmByName(name);
	}
	
	@RequestMapping("/sactor")
	public Set<Film> findByActor(String name) throws Exception{
		return aservice.findFilmByActor(name);
	}
	@RequestMapping("/ss/{name}")
	public Category findByActorr(@PathVariable String name) throws Exception{
		Category c=new Category();
		c.setName(name);
		return c;
	}
	@RequestMapping("/gfilm")
	public Set<Film> getAll() throws Exception{
		return fservice.findAllFilm();
	}
	@RequestMapping("/rfilm")
	public boolean removeFilm(String name) throws Exception{
		return fservice.deleteFilm(name);
	}
	@RequestMapping
	(value="sfilm", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@JsonCreator
	public  @ResponseBody boolean addFilm(@RequestBody String s) throws Exception{
		System.out.println(s);
		ObjectMapper mapper = new ObjectMapper();
		Film s1 = mapper.readValue(s, Film.class);
		return fservice.saveFilm(s1);
	}
	@RequestMapping
	(value="mfilm", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@JsonCreator
	public  @ResponseBody boolean modifyFilm(@RequestBody String s,String tit) throws Exception{
		
		System.out.println(tit);
		ImageSave is=new ImageSave();
		ObjectMapper mapper = new ObjectMapper();
		Film s1 = mapper.readValue(s, Film.class);
		
		return fservice.changeFilm(tit,s1);
	}
	@RequestMapping
	(value="nn", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Category newFilm(@RequestBody List<Category> c) throws Exception{
		System.out.println(c.get(0));
		return c.get(0);
	}
	
	
}
