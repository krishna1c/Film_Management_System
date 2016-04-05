package com.cg.fms.ServiceImpl;

import java.util.HashSet;

import com.cg.fms.RepoImpl.ActorRepoImpl;
import com.cg.fms.RepoInterfaces.ActorRepo;
import com.cg.fms.ServiceExceptions.ActorNotFound;
import com.cg.fms.ServiceInterfaces.ActorService;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Film;

public class ActorServiceImpl implements ActorService {
	ActorRepo repo;
	public ActorServiceImpl(ActorRepoImpl repo) {
		this.repo = repo;
	}

	@Override
	public HashSet<Film> findFilmByActor(String name)throws Exception {
		// TODO Auto-generated method stub
		HashSet<Film> f = repo.searchFilmByActor(name);
		if(name==null || f.size()==0)
			throw new ActorNotFound();
		return f;
	}

	@Override
	public boolean saveActor(Actor a) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeActor(String name, Actor a) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteActor(String name) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashSet<Actor> findAllActor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
