package com.cg.fms.RepoInterfaces;

import java.util.HashSet;

import com.cg.fms.pojo.Film;

public interface CategoryRepo {
	HashSet<Film> searchByCategory(String category);
}
