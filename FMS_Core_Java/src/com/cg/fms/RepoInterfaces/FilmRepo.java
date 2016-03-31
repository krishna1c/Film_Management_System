package com.cg.fms.RepoInterfaces;
import java.util.HashSet;
import com.cg.fms.pojo.*;

public interface FilmRepo {
	boolean addFilm(Film f);
	boolean modifyFilm(String title,Film f);
	boolean removeFilm(String title);
	HashSet<Film> searchFilmByName(String title);
	HashSet<Film> searchFilmByRating(String rating);
	HashSet<Film> getAllFilm();
}
