package com.cg.fms.ServiceInterfaces;

import java.util.Set;

import com.cg.fms.pojo.Film;

public interface FilmService {
	boolean saveFilm(Film f) throws Exception;
	boolean changeFilm(String title,Film f) throws Exception;
	boolean deleteFilm(String title) throws Exception;
	Set<Film> findFilmByName(String title) throws Exception;
	Set<Film> findFilmByRating(String rating) throws Exception;
	Set<Film> findAllFilm() throws Exception;
}
