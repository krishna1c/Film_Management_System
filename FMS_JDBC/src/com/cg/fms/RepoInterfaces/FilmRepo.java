package com.cg.fms.RepoInterfaces;
import java.sql.SQLException;
import java.util.HashSet;
import com.cg.fms.pojo.*;

public interface FilmRepo {
	boolean addFilm(Film f) throws Exception;
	boolean modifyFilm(String title,Film f) throws ClassNotFoundException, SQLException;
	boolean removeFilm(String title) throws Exception;
	HashSet<Film> searchFilmByName(String title) throws Exception;
	HashSet<Film> searchFilmByRating(String rating) throws Exception;
	HashSet<Film> getAllFilm() throws Exception;
}
