package com.cg.fms.ServiceInterfaces;

import java.util.Set;
import com.cg.fms.pojo.Film;

public interface CategoryService {
	Set<Film> findByCategory(String category)throws Exception;
}
