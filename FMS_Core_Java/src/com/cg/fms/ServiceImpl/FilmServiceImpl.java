package com.cg.fms.ServiceImpl;

import java.util.Calendar;
import java.util.HashSet;

import com.cg.fms.RepoImpl.FilmRepoImpl;
import com.cg.fms.RepoInterfaces.FilmRepo;
import com.cg.fms.ServiceExceptions.ActorNameCannotBeNull;
import com.cg.fms.ServiceExceptions.ActorShouldExistInFilm;
import com.cg.fms.ServiceExceptions.CategoryCannotBeNull;
import com.cg.fms.ServiceExceptions.FilmIsAlreadyExist;
import com.cg.fms.ServiceExceptions.FilmNotFound;
import com.cg.fms.ServiceExceptions.LanguageCannotBeNull;
import com.cg.fms.ServiceExceptions.RatingNotFound;
import com.cg.fms.ServiceExceptions.ReleaseYearNotCorrect;
import com.cg.fms.ServiceExceptions.TitleCannotBeNull;
import com.cg.fms.ServiceInterfaces.FilmService;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Album;
import com.cg.fms.pojo.Film;

public class FilmServiceImpl implements FilmService {
	FilmRepo repo;
	public FilmServiceImpl(FilmRepoImpl repo){
		this.repo=repo;
	}
	public void checkFilm(Film f)throws Exception{
		if(f.getTitle()==null)
			throw new TitleCannotBeNull();
		if(f.getRelease_year()<1950 || f.getRelease_year()>Calendar.getInstance().get(Calendar.YEAR))
			throw new ReleaseYearNotCorrect();
		if(f.getCategory()==null || f.getCategory().getName()==null)
			throw new CategoryCannotBeNull();
		if(f.getLanguages()==null || f.getLanguages().getName()==null)
			throw new LanguageCannotBeNull();
		if(f.getAlbum()==null)
			f.setAlbum(new Album());
		if(f.getAlbum().getAlbum_name()==null)
			f.getAlbum().setAlbum_name(f.getTitle());
		if(f.getActors()==null || f.getActors().size()==0)
			throw new ActorShouldExistInFilm();
		for(Actor a:f.getActors())
			if(a.getFirst_name()== null || a.getLast_name()==null || a.getPhoto_url()==null)
				throw new ActorNameCannotBeNull();
	}
	@Override
	public boolean saveFilm(Film f) throws Exception{
		// TODO Auto-generated method stub
		checkFilm(f);
		if(!repo.addFilm(f))
			throw new FilmIsAlreadyExist();
		return true;
	}

	@Override
	public boolean changeFilm(String title, Film f) throws Exception {
		// TODO Auto-generated method stub
		checkFilm(f);
		if(title==null || !repo.modifyFilm(title, f))
			throw new FilmNotFound();
		return true;
	}

	@Override
	public boolean deleteFilm(String title) throws Exception{
		// TODO Auto-generated method stub
		if(title==null || !repo.removeFilm(title))
			throw new FilmNotFound();
		return true;
	}

	@Override
	public HashSet<Film> findFilmByName(String title)throws Exception {
		// TODO Auto-generated method stub
		HashSet<Film> f = repo.searchFilmByName(title);
		if(title==null || f.size()==0)
			throw new FilmNotFound();
		return f;
	}

	@Override
	public HashSet<Film> findFilmByRating(String rating) throws Exception{
		// TODO Auto-generated method stub
		HashSet<Film> f = repo.searchFilmByRating(rating);
		if(rating==null || f.size()==0)
			throw new RatingNotFound();
		return f;
	}

	@Override
	public HashSet<Film> findAllFilm() {
		// TODO Auto-generated method stub
		return repo.getAllFilm();
	}
	
}
