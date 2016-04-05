package com.cg.fms.RepoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

import com.cg.fms.RepoInterfaces.ActorRepo;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.ActorFilmVO;
import com.cg.fms.pojo.Film;

public class ActorRepoImpl implements ActorRepo {

	static HashSet<Actor> actors = new HashSet<Actor>();
	static HashSet<ActorFilmVO> actorfilm = new HashSet<ActorFilmVO>();
	ObjectMapper mapper = new ObjectMapper();
	ConnectionData connection = new ConnectionData();
	PreparedStatement st = null;
	Connection con=null;
	@Override
	public HashSet<Film> searchFilmByActor(String name) throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			st = con.prepareStatement("SELECT DISTINCT(film.film_id) FROM film JOIN film_actor JOIN actor ON(film.film_id=film_actor.film_id AND film_actor.actor_id = actor.actor_id) WHERE actor.first_name= ? AND film.delete_update=0");
			st.setString(1, name);
			ResultSet re = st.executeQuery();
			return mapper.resultMapper(re,con);
		}
		catch(Exception e){
			throw new Exception();
		}
		finally{
			con.close();
		}
	}

	@Override
	public boolean addActor(Actor a) {
		// TODO Auto-generated method stub
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
