package com.cg.fms.RepoImpl;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.fms.RepoInterfaces.LanguageRepo;
import com.cg.fms.pojo.Film;
@Repository
public class LanguageRepoImpl implements LanguageRepo {
	@Autowired
	private DataSource datasoruce;
	private JdbcTemplate jdbcTemplate;
	ResultMap mapper = new ResultMap();
	@Override
	public Set<Film> searchByLanguage(String language) throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql  = "SELECT film_id FROM film JOIN LANGUAGE USING(language_id) WHERE language.name = ? AND film.delete_update=0";
		Set<Integer> id = new HashSet<Integer>(jdbcTemplate.queryForList(sql,new Object[] { language }, Integer.class));
		return mapper.resultMapper(id,jdbcTemplate);
	}

}
