package com.cg.fms.RepoImpl;

import java.util.HashSet;

import com.cg.fms.RepoInterfaces.CategoryRepo;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;

public class CategoryRepoImpl implements CategoryRepo {
	static HashSet<Category> categories = new HashSet<Category>();
	@Override
	public HashSet<Film> searchByCategory(String category) {
		// TODO Auto-generated method stub
		HashSet<Film> f = new HashSet<Film>();
		for(Film film:FilmRepoImpl.films){
			if(film.getCategory().getName().equals(category) && film.getDelete_update()==null){
				f.add(film);
			}
		}
		return f;
	}

}
