package com.cg.fms.RepoImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.fms.RepoInterfaces.ActorRepo;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Film;
@Repository
public class ActorRepoImpl implements ActorRepo {
	@Autowired
	private DataSource datasoruce;
	private JdbcTemplate jdbcTemplate;
	ResultMap mapper = new ResultMap();
	@Override
	public Set<Film> searchFilmByActor(String name) throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql = "SELECT DISTINCT(film.film_id) FROM film JOIN film_actor JOIN actor ON(film.film_id=film_actor.film_id AND film_actor.actor_id = actor.actor_id) WHERE actor.first_name= ? AND film.delete_update=0";
		Set<Integer> id = new HashSet<Integer>(jdbcTemplate.queryForList(sql,new Object[] { name }, Integer.class));
//		ObjectWriter mapperr = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		List<Film> l =new ArrayList<Film>(mapper.resultMapper(id,jdbcTemplate));
//        String json = mapperr.writeValueAsString(l);
//        System.out.println(json);
		return mapper.resultMapper(id,jdbcTemplate);
	}

	@Override
	public boolean addActor(Actor a) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO actor(first_name,last_name) values (?,?)";
		jdbcTemplate.update(sql, a.getFirst_name(),a.getLast_name());
		return false;
	}

	@Override
	public boolean modifyActor(String name, Actor a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeActor(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashSet<Actor> getAllActor() {
		// TODO Auto-generated method stub
		return null;
	}

}
