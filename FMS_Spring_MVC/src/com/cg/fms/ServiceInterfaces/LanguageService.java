package com.cg.fms.ServiceInterfaces;

import java.util.Set;

import com.cg.fms.pojo.Film;

public interface LanguageService {
	Set<Film> findByLanguage(String language)throws Exception;
}
