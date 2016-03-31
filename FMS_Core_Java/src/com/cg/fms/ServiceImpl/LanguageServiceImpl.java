package com.cg.fms.ServiceImpl;

import java.util.HashSet;

import com.cg.fms.RepoImpl.LanguageRepoImpl;
import com.cg.fms.RepoInterfaces.LanguageRepo;
import com.cg.fms.ServiceExceptions.LanguageNotFound;
import com.cg.fms.ServiceInterfaces.LanguageService;
import com.cg.fms.pojo.Film;

public class LanguageServiceImpl implements LanguageService {
	LanguageRepo repo;
	public LanguageServiceImpl(LanguageRepoImpl repo) {
		this.repo = repo;
	}

	@Override
	public HashSet<Film> findByLanguage(String language) throws Exception{
		// TODO Auto-generated method stub
		HashSet<Film> f = repo.searchByLanguage(language);
		if(language == null || f.size()==0)
			throw new LanguageNotFound();
		return f;
	}

}
