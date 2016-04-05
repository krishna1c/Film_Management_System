package com.cg.fms.ServiceInterfaces;

import java.util.Set;

import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Film;

public interface ActorService {
	boolean saveActor(Actor a) throws Exception;
	boolean changeActor(String name,Actor a) throws Exception;
	boolean deleteActor(String name) throws Exception;
	Set<Actor> findAllActor() throws Exception;
	Set<Film> findFilmByActor(String name) throws Exception;
}
