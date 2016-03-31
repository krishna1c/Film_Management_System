package com.cg.fms.ServiceInterfaces;

import java.util.HashSet;

import com.cg.fms.pojo.Film;

public interface FilmService {
	boolean saveFilm(Film f) throws Exception;
	boolean changeFilm(String title,Film f) throws Exception;
	boolean deleteFilm(String title) throws Exception;
	HashSet<Film> findFilmByName(String title) throws Exception;
	HashSet<Film> findFilmByRating(String rating) throws Exception;
	HashSet<Film> findAllFilm() throws Exception;
}
