package TestCases;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.fms.RepoImpl.CategoryRepoImpl;
import com.cg.fms.RepoImpl.FilmRepoImpl;
import com.cg.fms.ServiceExceptions.CategoryNotFound;
import com.cg.fms.ServiceImpl.FilmServiceImpl;
import com.cg.fms.ServiceInterfaces.CategoryService;
import com.cg.fms.ServiceImpl.CategoryServiceImpl;
import com.cg.fms.ServiceInterfaces.FilmService;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;
import com.cg.fms.pojo.Rating;

public class CategoryTest {

	static CategoryService scategory = new CategoryServiceImpl(new CategoryRepoImpl());
	
	@Test
	public void searchByCategorySuccess() throws Exception{
		assertTrue(scategory.findByCategory("Action").size()==64);
	}
	@Test(expected = CategoryNotFound.class)
	public void searchByCategoryIfCategoryIsNull() throws Exception{
		scategory.findByCategory(null);
	}
	@Test(expected = CategoryNotFound.class)
	public void searchByCategoryIfCategoryIsNotFound() throws Exception{
		scategory.findByCategory("None");
	}
}
