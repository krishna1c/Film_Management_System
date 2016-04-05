package TestCases;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.fms.RepoImpl.LanguageRepoImpl;
import com.cg.fms.RepoImpl.FilmRepoImpl;
import com.cg.fms.ServiceExceptions.LanguageNotFound;
import com.cg.fms.ServiceImpl.FilmServiceImpl;
import com.cg.fms.ServiceInterfaces.LanguageService;
import com.cg.fms.ServiceImpl.LanguageServiceImpl;
import com.cg.fms.ServiceInterfaces.FilmService;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;
import com.cg.fms.pojo.Rating;

public class LanguageTest {
	static LanguageService scategory = new LanguageServiceImpl(new LanguageRepoImpl());
	
	@Test
	public void searchByLanguageSuccess() throws Exception{
		assertTrue(scategory.findByLanguage("English").size()>1);
	}
	@Test(expected = LanguageNotFound.class)
	public void searchByLanguageIfLanguageIsNull() throws Exception{
		scategory.findByLanguage(null);
	}
	@Test(expected = LanguageNotFound.class)
	public void searchByLanguageIfLanguageIsNotFound() throws Exception{
		scategory.findByLanguage("Animation");
	}
}
