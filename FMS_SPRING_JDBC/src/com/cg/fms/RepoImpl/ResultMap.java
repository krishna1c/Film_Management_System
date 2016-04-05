package com.cg.fms.RepoImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Album;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;
import com.cg.fms.pojo.PhotoCollection;

public class ResultMap {
	String sql;
	public Set<Actor> actorMapper(int film_id,JdbcTemplate jdbcTemplate){
		sql = "SELECT * FROM actor JOIN film_actor USING(actor_id) WHERE film_actor.film_id = ?";
		return new HashSet<Actor>(jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Actor.class),film_id));		
	}
	public Set<PhotoCollection> photoCollectionMapper(int album_id,JdbcTemplate jdbcTemplate){
		sql = "SELECT * FROM photocollection WHERE album_id = ?";
		return new HashSet<PhotoCollection>(jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PhotoCollection.class),album_id));
	}
	public Album albumMapper(int album_id,JdbcTemplate jdbcTemplate){
		sql = "SELECT * FROM album WHERE album_id = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Album.class),album_id);
	}
	public Category categoryMapper(int category_id,JdbcTemplate jdbcTemplate){
		sql = "SELECT NAME FROM category WHERE category_id = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Category.class),category_id);		

	}
	public Language languageMapper(int language_id,JdbcTemplate jdbcTemplate){
		sql = "SELECT NAME FROM LANGUAGE WHERE language_id=?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Language.class),language_id);		
	}
	
	public Film filmMapper(int film_id,JdbcTemplate jdbcTemplate){
		sql = "SELECT * FROM film WHERE film_id=?";
		Film f = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Film.class),film_id);		
		f.setCategory(categoryMapper(f.getCategory_id(),jdbcTemplate));
		f.setLanguages(languageMapper(f.getLanguage_id(),jdbcTemplate));
		f.setActors(actorMapper(f.getFilm_id(),jdbcTemplate));
		f.setAlbum(albumMapper(f.getAlbum_id(),jdbcTemplate));
		f.getAlbum().setPhotocollection(photoCollectionMapper(f.getAlbum_id(), jdbcTemplate));
		return f;
	}
	public Set<Film> resultMapper(Set<Integer> ids,JdbcTemplate jdbcTemplate){
		Set<Film> f = new HashSet<Film>();
		for(int i:ids){
			f.add(filmMapper(i,jdbcTemplate));	
		}
		return f;
	}
}
