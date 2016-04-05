package TestCases;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.fms.RepoImpl.ActorRepoImpl;
import com.cg.fms.RepoImpl.FilmRepoImpl;
import com.cg.fms.ServiceExceptions.ActorNotFound;
import com.cg.fms.ServiceImpl.FilmServiceImpl;
import com.cg.fms.ServiceInterfaces.ActorService;
import com.cg.fms.ServiceImpl.ActorServiceImpl;
import com.cg.fms.ServiceInterfaces.FilmService;
import com.cg.fms.pojo.Actor;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;
import com.cg.fms.pojo.Rating;

public class ActorTest {

	static FilmService service = new FilmServiceImpl(new FilmRepoImpl());
	static ActorService scategory = new ActorServiceImpl(new ActorRepoImpl());
	@Test
	public void searchByActorSuccess() throws Exception{
		System.out.println(scategory.findFilmByActor("ED").size());
		assertTrue(scategory.findFilmByActor("ED").size()>1);
	}
	@Test(expected = ActorNotFound.class)
	public void searchByActorIfActorIsNull() throws Exception{
		scategory.findFilmByActor(null);
	}
	@Test(expected = ActorNotFound.class)
	public void searchByActorIfActorIsNotFound() throws Exception{
		scategory.findFilmByActor("Animation");
	}
}
