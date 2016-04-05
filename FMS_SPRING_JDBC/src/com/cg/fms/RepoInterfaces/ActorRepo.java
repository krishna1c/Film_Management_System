package com.cg.fms.RepoInterfaces;

import java.util.Set;

import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Film;

public interface ActorRepo {
	Set<Film> searchFilmByActor(String name) throws Exception;
	boolean addActor(Actor a);
	boolean modifyActor(String name,Actor a);
	boolean removeActor(String name);
	Set<Actor> getAllActor();
}
