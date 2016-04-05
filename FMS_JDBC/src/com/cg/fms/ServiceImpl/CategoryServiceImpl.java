package com.cg.fms.ServiceImpl;

import java.util.HashSet;

import com.cg.fms.RepoImpl.CategoryRepoImpl;
import com.cg.fms.RepoInterfaces.CategoryRepo;
import com.cg.fms.ServiceExceptions.CategoryNotFound;
import com.cg.fms.ServiceInterfaces.CategoryService;
import com.cg.fms.pojo.Film;

public class CategoryServiceImpl implements CategoryService {
	CategoryRepo repo;
	
	public CategoryServiceImpl(CategoryRepoImpl repo) {
		this.repo = repo;
	}

	@Override
	public HashSet<Film> findByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		HashSet<Film> f = repo.searchByCategory(category);
		if(category == null || f.size()==0 )
			throw new CategoryNotFound();
		return f;
	}

}
