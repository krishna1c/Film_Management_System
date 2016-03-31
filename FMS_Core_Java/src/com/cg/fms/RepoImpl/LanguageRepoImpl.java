package com.cg.fms.RepoImpl;

import java.util.HashSet;

import com.cg.fms.RepoInterfaces.LanguageRepo;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;

public class LanguageRepoImpl implements LanguageRepo {
	static HashSet<Language> languages = new HashSet<Language>();
	@Override
	public HashSet<Film> searchByLanguage(String language) {
		// TODO Auto-generated method stub
		HashSet<Film> f = new HashSet<Film>();
		for(Film film:FilmRepoImpl.films){
			if(film.getLanguages().getName().equals(language) && film.getDelete_update()==null){
				f.add(film);
			}
		}
		return f;
	}

}
