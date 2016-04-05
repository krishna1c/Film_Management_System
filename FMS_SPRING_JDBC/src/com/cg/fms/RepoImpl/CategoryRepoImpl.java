package com.cg.fms.RepoImpl;


import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.fms.RepoInterfaces.CategoryRepo;
import com.cg.fms.pojo.Film;
@Repository
public class CategoryRepoImpl implements CategoryRepo {
	@Autowired
	private DataSource datasoruce;
	private JdbcTemplate jdbcTemplate;
	ResultMap mapper = new ResultMap();
	@Override
	public Set<Film> searchByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql = "SELECT film_id FROM film JOIN category USING(category_id) WHERE category.name=? AND delete_update=0";
		Set<Integer> id = new HashSet<Integer>(jdbcTemplate.queryForList(sql,new Object[] { category }, Integer.class));
		return mapper.resultMapper(id,jdbcTemplate);
	}

}
