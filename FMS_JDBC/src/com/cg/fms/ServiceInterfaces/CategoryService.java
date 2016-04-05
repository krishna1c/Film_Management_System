package com.cg.fms.ServiceInterfaces;

import java.util.HashSet;

import com.cg.fms.pojo.Film;

public interface CategoryService {
	HashSet<Film> findByCategory(String category)throws Exception;
}
