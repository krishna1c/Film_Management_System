package com.cg.fms.RepoImpl;

import java.util.HashSet;

import com.cg.fms.RepoInterfaces.ActorRepo;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.ActorFilmVO;
import com.cg.fms.pojo.Film;

public class ActorRepoImpl implements ActorRepo {

	static HashSet<Actor> actors = new HashSet<Actor>();
	static HashSet<ActorFilmVO> actorfilm = new HashSet<ActorFilmVO>();
	
	@Override
	public HashSet<Film> searchFilmByActor(String name) {
		// TODO Auto-generated method stub
		HashSet<Film> f = new HashSet<Film>();
		for(ActorFilmVO a:actorfilm){
			if(a.getActor().getFirst_name().equals(name)){
				for(Film film : a.getActor_films()){
					if(film.getLast_update()!=null)
						f.add(film);
				}
			}
		}
		return f;
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
