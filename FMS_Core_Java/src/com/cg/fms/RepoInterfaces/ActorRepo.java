package com.cg.fms.RepoInterfaces;

import java.util.HashSet;

import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Film;

public interface ActorRepo {
	HashSet<Film> searchFilmByActor(String name);
	boolean addActor(Actor a);
	boolean modifyActor(String name,Actor a);
	boolean removeActor(String name);
	HashSet<Actor> getAllActor();
}
