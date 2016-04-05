package com.cg.fms.ServiceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.RepoImpl.CategoryRepoImpl;
import com.cg.fms.RepoInterfaces.CategoryRepo;
import com.cg.fms.ServiceExceptions.CategoryNotFound;
import com.cg.fms.ServiceInterfaces.CategoryService;
import com.cg.fms.pojo.Film;
@Service(value="cservice")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepo repo;

	

	@Override
	public Set<Film> findByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		Set<Film> f = repo.searchByCategory(category);
		if(category == null || f.size()==0 )
			throw new CategoryNotFound();
		return f;
	}

}
