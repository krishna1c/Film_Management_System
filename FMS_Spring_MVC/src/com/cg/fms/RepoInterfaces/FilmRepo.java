package com.cg.fms.RepoInterfaces;
import java.sql.SQLException;
import java.util.Set;
import com.cg.fms.pojo.*;

public interface FilmRepo {
	boolean addFilm(Film f) throws Exception;
	boolean modifyFilm(String title,Film f) throws ClassNotFoundException, SQLException;
	boolean removeFilm(String title) throws Exception;
	Set<Film> searchFilmByName(String title) throws Exception;
	Set<Film> searchFilmByRating(String rating) throws Exception;
	Set<Film> getAllFilm() throws Exception;
}
