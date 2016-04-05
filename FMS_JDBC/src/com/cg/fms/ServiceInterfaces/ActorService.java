package com.cg.fms.ServiceInterfaces;

import java.util.HashSet;

import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Film;

public interface ActorService {
	boolean saveActor(Actor a) throws Exception;
	boolean changeActor(String name,Actor a) throws Exception;
	boolean deleteActor(String name) throws Exception;
	HashSet<Actor> findAllActor() throws Exception;
	HashSet<Film> findFilmByActor(String name) throws Exception;
}
