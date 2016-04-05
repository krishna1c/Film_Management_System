package com.cg.fms.RepoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;

public class ObjectMapper {
	ConnectionData connection = new ConnectionData();
	PreparedStatement st = null;
	public HashSet<Actor> actorMapper(int film_id,Connection con) throws SQLException, ClassNotFoundException{
		st = con.prepareStatement("SELECT * FROM actor JOIN film_actor USING(actor_id) WHERE film_actor.film_id = ?");
			st.setInt(1, film_id);
			ResultSet re =st.executeQuery();
			HashSet<Actor> actors = new HashSet<Actor>();
			while(re.next()){
				Actor a = new Actor();
				a.setFirst_name(re.getString("first_name"));
				actors.add(a);
			}
			return actors;		
	}
	public Category categoryMapper(int category_id,Connection con) throws SQLException, ClassNotFoundException{
		
			st = con.prepareStatement("SELECT NAME FROM category WHERE category_id = ?");
			st.setInt(1, category_id);
			ResultSet re =st.executeQuery();
			re.next();
			Category c = new Category();
			c.setName(re.getString("name"));
			return c;
	
	}
	public Language languageMapper(int language_id,Connection con) throws SQLException, ClassNotFoundException{
		
			st = con.prepareStatement("SELECT NAME FROM LANGUAGE WHERE language_id=?");
			st.setInt(1, language_id);
			ResultSet re =st.executeQuery();
			re.next();
			Language l = new Language();
			l.setName(re.getString("name"));
			return l;
		
	}
	public Film filmMapper(int film_id,Connection con) throws SQLException, ClassNotFoundException{
			st = con.prepareStatement("SELECT * FROM film WHERE film_id=?");
			st.setInt(1, film_id);
			ResultSet re =st.executeQuery();
			re.next();
			Film f = new Film();
			f.setTitle(re.getString("title"));
			f.setCategory(categoryMapper(re.getInt("category_id"),con));
			f.setLanguages(languageMapper(re.getInt("language_id"),con));
			f.setActors(actorMapper(re.getInt("film_id"),con));
			f.setDescription(re.getString("description"));
			f.setDelete_update(re.getTimestamp("delete_update"));
			return f;
	}
	public HashSet<Film> resultMapper(ResultSet re,Connection con) throws SQLException, ClassNotFoundException{
		HashSet<Film> f = new HashSet<Film>();
		while(re.next()){;
			f.add(filmMapper(re.getInt("film_id"),con));	
		}
		return f;
	}
}
