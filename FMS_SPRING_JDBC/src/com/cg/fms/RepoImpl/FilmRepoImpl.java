package com.cg.fms.RepoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.fms.RepoInterfaces.*;
import com.cg.fms.pojo.*;
@Repository
public class FilmRepoImpl implements FilmRepo {
	ConnectionData connection = new ConnectionData();
	PreparedStatement st = null;
	Connection con=null;
	@Autowired
	private DataSource datasoruce;
	private JdbcTemplate jdbcTemplate;
	ResultMap mapper = new ResultMap();
	@Override 
	public boolean addFilm(Film f) throws Exception {
		// TODO Auto-generated method stub
		String sql;
		jdbcTemplate = new JdbcTemplate(datasoruce);
		if(searchFilmByName(f.getTitle()).size()!=0)
			return false;
		int laguage_id;
		try{
			sql = "SELECT language_id FROM language WHERE NAME = ?";
			laguage_id = jdbcTemplate.queryForObject(sql, new Object[] { f.getLanguages().getName() }, Integer.class);
		}
		catch(EmptyResultDataAccessException  e){
			sql = "INSERT INTO language(NAME) VALUES (?)";
			jdbcTemplate.update(sql, f.getLanguages().getName());
			sql = "SELECT language_id FROM language WHERE NAME = ?";
			laguage_id = jdbcTemplate.queryForObject(sql, new Object[] { f.getLanguages().getName() }, Integer.class);
		}

		int category_id;
		try{
			sql = "SELECT category_id FROM category WHERE NAME = ?";
			category_id = jdbcTemplate.queryForObject(sql, new Object[] { f.getCategory().getName() }, Integer.class);
		}
		catch(EmptyResultDataAccessException  e){
			sql = "INSERT INTO category(NAME) VALUES (?)";
			jdbcTemplate.update(sql, f.getCategory().getName());
			sql = "SELECT category_id FROM category WHERE NAME = ?";
			category_id = jdbcTemplate.queryForObject(sql, new Object[] { f.getCategory().getName() }, Integer.class);
		}

		int album_id;
		sql = "INSERT INTO album(album_name) VALUES(?)";
		jdbcTemplate.update(sql, f.getTitle());
		sql = "SELECT album_id FROM album WHERE album_name = ?";
		album_id = jdbcTemplate.queryForObject(sql, new Object[] { f.getTitle() }, Integer.class);
		sql = "INSERT INTO photocollection(album_id,photo_url) VALUES(?,?)";
		for(PhotoCollection pc : f.getAlbum().getPhotocollection()){
			jdbcTemplate.update(sql,album_id,pc.getPhoto_url());
		}

		sql = "insert into film(title,description,release_year,language_id,rating,category_id,album_id,length) values (?,?,?,?,?,?,?,?)";
		try{
			jdbcTemplate.update(sql, f.getTitle(), f.getDescription(), f.getRelease_year(),laguage_id,  f.getRating().toString(),category_id,album_id,f.getLength());
		}
		catch(DataAccessException e){
			return false;
		}
		int film_id,actor_id;
		sql = "SELECT film_id FROM film where title = ?";
		film_id = jdbcTemplate.queryForObject(sql, new Object[] { f.getTitle() }, Integer.class);
		for(Actor a:f.getActors()){
			try{
				sql = "SELECT actor_id FROM actor WHERE first_name = ? AND last_name = ?";
				actor_id = jdbcTemplate.queryForObject(sql, new Object[] { a.getFirst_name(), a.getLast_name() }, Integer.class);
				sql = "INSERT INTO film_actor(film_id,actor_id) values (?,?)";
				jdbcTemplate.update(sql, film_id,actor_id);
			}
			catch(EmptyResultDataAccessException  e){
				sql = "INSERT INTO actor(first_name,last_name) values (?,?)";
				jdbcTemplate.update(sql, a.getFirst_name(),a.getLast_name());
				sql = "SELECT actor_id FROM actor WHERE first_name = ? AND last_name = ?";
				actor_id = jdbcTemplate.queryForObject(sql, new Object[] { a.getFirst_name(), a.getLast_name() }, Integer.class);
				sql = "INSERT INTO film_actor(film_id,actor_id) values (?,?)";
				jdbcTemplate.update(sql, film_id,actor_id);
			}
		}
		return true;

	}

	@Override
	public boolean modifyFilm(String title,Film f) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql  = "SELECT COUNT(*) FROM film WHERE title = ?";
		sql = "update film SET title = ?,description = ?,release_year = ?,length = ?,rating = ? where title = ?";
		try{
			jdbcTemplate.update(sql, f.getTitle(), f.getDescription(), f.getRelease_year(), f.getLength(), f.getRating().toString(),title);
		}
		catch(DataAccessException e){
			return false;
		}
		return true;
	}

	@Override
	public boolean removeFilm(String title) throws Exception {
		// TODO Auto-generated method stub
		if(searchFilmByName(title).size()==0)
			return false;
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql  ="UPDATE film SET delete_update =  NOW() WHERE title = ?";
		try{
			jdbcTemplate.update(sql,title);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public Set<Film> searchFilmByName(String title) throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql  = "SELECT film_id FROM film  WHERE title = ? AND delete_update=0";
		Set<Integer> id = new HashSet<Integer>(jdbcTemplate.queryForList(sql,new Object[] { title }, Integer.class));
		return mapper.resultMapper(id,jdbcTemplate);

	}

	@Override
	public Set<Film> searchFilmByRating(String rating) throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql  =  "SELECT film_id FROM film  WHERE rating = ? AND delete_update=0";
		Set<Integer> id = new HashSet<Integer>(jdbcTemplate.queryForList(sql,new Object[] { rating }, Integer.class));
		return mapper.resultMapper(id,jdbcTemplate);

	}

	@Override
	public Set<Film> getAllFilm() throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasoruce);
		String sql  = "SELECT film_id FROM film WHERE delete_update=0";
		Set<Integer> id = new HashSet<Integer>(jdbcTemplate.queryForList(sql, Integer.class));
		return mapper.resultMapper(id,jdbcTemplate);

	}

}
