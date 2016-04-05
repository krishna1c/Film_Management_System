package com.cg.fms.RepoInterfaces;

import java.util.Set;

import com.cg.fms.pojo.Film;

public interface CategoryRepo {
	Set<Film> searchByCategory(String category) throws Exception;
}
