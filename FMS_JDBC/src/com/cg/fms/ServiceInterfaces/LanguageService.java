package com.cg.fms.ServiceInterfaces;

import java.util.HashSet;

import com.cg.fms.pojo.Film;

public interface LanguageService {
	HashSet<Film> findByLanguage(String language)throws Exception;
}
