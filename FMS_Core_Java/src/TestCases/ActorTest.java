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
	@BeforeClass
	public static void saveData() throws Exception{
		Film f = new Film();
		f.setTitle("Vamsi");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		Actor a = new Actor();
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Rama");
		a1.setLast_name("Rao");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));
		service.saveFilm(f);
		
		Film f1 = new Film();
		f1.setTitle("Krishna");
		Category c1 = new Category();
		c1.setName("Horror");
		f1.setCategory(c1);
		f1.setRating(Rating.G);
		f1.setRelease_year(2014);;
		HashSet<Actor> actors1 =  new HashSet<Actor>();
		Language l1 = new Language();
		l1.setName("English");
		f1.setLanguages(l1);
		Actor a2 = new Actor();
		a2.setFirst_name("Praneeth");
		a2.setLast_name("Paidi");
		a2.setPhoto_url("3.jpg");
		actors1.add(a2);
		Actor a3 = new Actor();
		a3.setFirst_name("Udaya");
		a3.setLast_name("Tanelanka");
		a3.setPhoto_url("4.jpg");
		actors1.add(a3);
		f1.setActors(actors1);
		Date d1 = new Date();
		f1.setLast_update(new Timestamp(d1.getTime()));
		service.saveFilm(f1);
	}
	@Test
	public void searchByActorSuccess() throws Exception{
		assertTrue(scategory.findFilmByActor("Udaya").size()==1);
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
