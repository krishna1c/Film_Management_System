package com.cg.fms.ServiceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.RepoImpl.LanguageRepoImpl;
import com.cg.fms.RepoInterfaces.LanguageRepo;
import com.cg.fms.ServiceExceptions.LanguageNotFound;
import com.cg.fms.ServiceInterfaces.LanguageService;
import com.cg.fms.pojo.Film;
@Service(value="lservice")
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	LanguageRepo repo;
	

	@Override
	public Set<Film> findByLanguage(String language) throws Exception{
		// TODO Auto-generated method stub
		Set<Film> f = repo.searchByLanguage(language);
		if(language == null || f.size()==0)
			throw new LanguageNotFound();
		return f;
	}

}
