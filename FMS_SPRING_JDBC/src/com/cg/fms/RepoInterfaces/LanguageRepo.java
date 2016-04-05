package com.cg.fms.RepoInterfaces;

import java.util.Set;

import com.cg.fms.pojo.Film;

public interface LanguageRepo {
	Set<Film> searchByLanguage(String language) throws Exception;
}
