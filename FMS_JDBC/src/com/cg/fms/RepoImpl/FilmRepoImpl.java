package com.cg.fms.RepoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import com.cg.fms.RepoInterfaces.*;
import com.cg.fms.pojo.*;

public class FilmRepoImpl implements FilmRepo {
	ObjectMapper mapper = new ObjectMapper();
	ConnectionData connection = new ConnectionData();
	PreparedStatement st = null;
	Connection con=null;
	@Override 
	public boolean addFilm(Film f) throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			PreparedStatement sta = con.prepareStatement("SELECT COUNT(*) FROM film WHERE title = ?");
			sta.setString(1,f.getTitle());
			ResultSet res = sta.executeQuery();
			res.next();
			if(res.getInt(1)!=0)
				return false;
			st = con.prepareStatement("insert into film(title,description,release_year,language_id,rating,last_update,category_id,album_id) values (?,?,?,?,?,?,?,?)");
			st.setString(1, f.getTitle());
			st.setString(2, f.getDescription());
			st.setInt(3, f.getRelease_year());
			sta = con.prepareStatement("SELECT language_id FROM language WHERE NAME = ?");
			sta.setString(1,f.getLanguages().getName());
			res = sta.executeQuery();
			res.next();
			st.setInt(4, res.getInt(1));
			st.setString(5, f.getRating().toString());
			Date date = new Date();
			st.setTimestamp(6, new Timestamp(date.getTime()));
			PreparedStatement stat = con.prepareStatement("SELECT category_id FROM category WHERE NAME = ?");
			stat.setString(1,f.getCategory().getName());
			ResultSet resu = stat.executeQuery();
			resu.next();
			st.setInt(7, resu.getInt(1));
			ResultSet resul = con.createStatement().executeQuery("SELECT COUNT(*) FROM film");
			resul.next();
			st.setInt(8,resul.getInt(1));
			System.out.println(resu.getInt(1));
			System.out.println(1);
			System.out.println(st);
			int re = st.executeUpdate();
			System.out.println(""+5 + re);
			
			if(re==0)
				return false;
			
			for(Actor a:f.getActors()){
				st = con.prepareStatement("insert into actor(first_name,last_name) values (?,?)");
			}
			return true;
		}
		finally{
			con.close();
		}
	}

	@Override
	public boolean modifyFilm(String title,Film f) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			PreparedStatement sta = con.prepareStatement("SELECT COUNT(*) FROM film WHERE title = ?");
			sta.setString(1,title);
			ResultSet res = sta.executeQuery();
			res.next();
			if(res.getInt(1)==0)
				return false;
			st = con.prepareStatement("update film SET title = ?,description = ?,release_year = ? ,language_id = ?,rating = ?,last_update=?,category_id=? where title = ?");
			st.setString(1, f.getTitle());
			st.setString(2, f.getDescription());
			st.setInt(3, f.getRelease_year());
			sta = con.prepareStatement("SELECT language_id FROM language WHERE NAME = ?");
			sta.setString(1,f.getLanguages().getName());
			res = sta.executeQuery();
			res.next();
			st.setInt(4, res.getInt(1));
			st.setString(5, f.getRating().toString());
			Date date = new Date();
			st.setTimestamp(6, new Timestamp(date.getTime()));
			PreparedStatement stat = con.prepareStatement("SELECT category_id FROM category WHERE NAME = ?");
			stat.setString(1,f.getCategory().getName());
			ResultSet resu = stat.executeQuery();
			resu.next();
			st.setInt(7, resu.getInt(1));
			st.setString(8, title);
			System.out.println(1);
			int re = st.executeUpdate();
			System.out.println(""+5 + re);
			return true;
		}
		finally{
			con.close();
		}
	}

	@Override
	public boolean removeFilm(String title) throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			st = con.prepareStatement("UPDATE film SET delete_update = ? WHERE title = ?");
			Date date = new Date();
			st.setTimestamp(1, new Timestamp(date.getTime()));
			st.setString(2, title);
			int re = st.executeUpdate();
			if(re==0)
				return false;
			return true;
		}
		finally{
			con.close();
		}
	}

	@Override
	public HashSet<Film> searchFilmByName(String title) throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			st = con.prepareStatement("SELECT film_id FROM film  WHERE title = ? AND delete_update=0");
			st.setString(1, title);
			ResultSet re = st.executeQuery();
			return mapper.resultMapper(re,con);
		}
		finally{
			connection.closeConnection();
			con.close();
		}
	}

	@Override
	public HashSet<Film> searchFilmByRating(String rating) throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			st = con.prepareStatement("SELECT film_id FROM film  WHERE rating = ? AND delete_update=0");
			st.setString(1, rating);
			ResultSet re = st.executeQuery();
			return mapper.resultMapper(re,con);
		}
		finally{
			connection.closeConnection();
			con.close();
		}
	}

	@Override
	public HashSet<Film> getAllFilm() throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			st = con.prepareStatement("SELECT film_id FROM film WHERE delete_update=0");
			ResultSet re = st.executeQuery();
			return mapper.resultMapper(re,con);
		}
		finally{
			connection.closeConnection();
			con.close();
		}
	}

}
