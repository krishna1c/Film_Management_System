package com.cg.fms.RepoImpl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import com.cg.fms.RepoInterfaces.*;
import com.cg.fms.pojo.*;

public class FilmRepoImpl implements FilmRepo {
	static HashSet<Film> films = new HashSet<Film>();
	@Override 
	public boolean addFilm(Film f) {
		// TODO Auto-generated method stub
		for(Actor a:f.getActors()){
			if(!ActorRepoImpl.actors.add(a)){
				for(Actor aa:ActorRepoImpl.actors){
					if(a.equals(aa)){
						a=aa;
					}
				}
			}
		}
		for(Actor a:f.getActors()){
			int c=0;
			for(ActorFilmVO vo:ActorRepoImpl.actorfilm){
				if(vo.getActor().equals(a)){
					vo.getActor_films().add(f);
					c++;
				}
			}
			if(c==0){
				ActorFilmVO avo = new ActorFilmVO();
				avo.setActor(a);
				avo.getActor_films().add(f);
				ActorRepoImpl.actorfilm.add(avo);
			}
		}
		if(!LanguageRepoImpl.languages.add(f.getLanguages())){
			for(Language l:LanguageRepoImpl.languages){
				if(l.equals(f.getLanguages()))
					f.setLanguages(l);
			}
		}
		if(!CategoryRepoImpl.categories.add(f.getCategory())){
			for(Category c:CategoryRepoImpl.categories){
				if(c.equals(f.getCategory()))
					f.setCategory(c);;
			}
		}
		if(films.add(f))
			return true;
		return false;
		
	}

	@Override
	public boolean modifyFilm(String title,Film f) {
		// TODO Auto-generated method stub
		for(Film film:films){
			if(film.getTitle().equals(title) && film.getDelete_update()==null){
				film=f;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeFilm(String title) {
		// TODO Auto-generated method stub
		for(Film film:films){
			if(film.getTitle().equals(title)){
				Date date = new Date();
				film.setDelete_update(new Timestamp(date.getTime()));
				return true;
			}
		}
		return false;
	}

	@Override
	public HashSet<Film> searchFilmByName(String title) {
		// TODO Auto-generated method stub
		HashSet<Film> f = new HashSet<Film>();
		for(Film film:films){
			if(film.getTitle().equals(title) && film.getDelete_update()==null){
				f.add(film);
			}
		}
		return f;
	}

	@Override
	public HashSet<Film> searchFilmByRating(String rating) {
		// TODO Auto-generated method stub
		HashSet<Film> f = new HashSet<Film>();
		for(Film film:films){
			if(film.getRating().toString().equals(rating) && film.getDelete_update()==null){
				f.add(film);
			}
		}
		return f;
	}

	@Override
	public HashSet<Film> getAllFilm() {
		// TODO Auto-generated method stub
		return films;
	}

}
