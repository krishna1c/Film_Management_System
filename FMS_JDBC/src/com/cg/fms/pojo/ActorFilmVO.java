package com.cg.fms.pojo;

import java.util.HashSet;

public class ActorFilmVO {
	private Actor actor;
	private HashSet<Film> actor_films = new HashSet<Film>();
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public HashSet<Film> getActor_films() {
		return actor_films;
	}
	public void setActor_films(HashSet<Film> actor_films) {
		this.actor_films = actor_films;
	}
	@Override
	public String toString() {
		return "ActorFilmVO [actor=" + actor + ", actor_films=" + actor_films + "]";
	}
	
}
