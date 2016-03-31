package com.cg.fms.RepoInterfaces;

import java.util.HashSet;

import com.cg.fms.pojo.Film;

public interface LanguageRepo {
	HashSet<Film> searchByLanguage(String language);
}
