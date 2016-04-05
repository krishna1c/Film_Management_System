package TestCases;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.fms.RepoImpl.FilmRepoImpl;
import com.cg.fms.ServiceExceptions.ActorNameCannotBeNull;
import com.cg.fms.ServiceExceptions.ActorShouldExistInFilm;
import com.cg.fms.ServiceExceptions.CategoryCannotBeNull;
import com.cg.fms.ServiceExceptions.FilmIsAlreadyExist;
import com.cg.fms.ServiceExceptions.FilmNotFound;
import com.cg.fms.ServiceExceptions.LanguageCannotBeNull;
import com.cg.fms.ServiceExceptions.RatingNotFound;
import com.cg.fms.ServiceExceptions.ReleaseYearNotCorrect;
import com.cg.fms.ServiceExceptions.TitleCannotBeNull;
import com.cg.fms.ServiceImpl.FilmServiceImpl;
import com.cg.fms.ServiceInterfaces.FilmService;
import com.cg.fms.pojo.*;

public class FilmTest {
	static FilmService service = new FilmServiceImpl(new FilmRepoImpl());
	@Test
	public void searchFilmByRating() throws Exception{
		assertTrue(service.findFilmByRating("G").size()>1);
	}
	@Test
	public void creatingFilmSuccess() throws Exception{
		Film f = new Film();
		f.setTitle("NewMOVE");
		Category c = new Category();
		c.setName("Animation");
		f.setCategory(c);
		f.setRating(Rating.PG);
		f.setRelease_year(2015);
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		assertTrue(s.saveFilm(f));
	}
	@Test
	public void modifyFilmSuccess() throws Exception{
		Film f = new Film();
		f.setTitle("KRISHH");
		Category c = new Category();
		c.setName("Animation");
		f.setCategory(c);
		f.setRating(Rating.G);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		Actor a = new Actor();
		a.setFirst_name("Praneeth");
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
		assertTrue(service.changeFilm("KRISHH",f));
	}
	@Test
	public void removeFilm() throws Exception{
		assertTrue(service.deleteFilm("ACADEMY DINOSAUR"));
	}
	@Test
	public void searchFilmByTitle() throws Exception{
		assertTrue(service.findFilmByName("ACE GOLDFINGER").size()>0);
	}
	@Test
	public void getAllFilms() throws Exception{
		assertTrue(service.findAllFilm().size()>1);
	}
	//SaveFilmWorstCases
	@Test(expected = TitleCannotBeNull.class)
	public void savingFilmTitleIsNull() throws Exception{
		Film f = new Film();
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected = CategoryCannotBeNull.class)
	public void savingFilmCategoryIsNull() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		f.setCategory(null);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected = ReleaseYearNotCorrect.class)
	public void savingFilmReleaseYearNotCorrect() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2019);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected = LanguageCannotBeNull.class)
	public void savingFilmLanguageIsNull() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName(null);
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected = ActorNameCannotBeNull.class)
	public void savingFilmActorFirstNameIsNull() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name(null);
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected = ActorNameCannotBeNull.class)
	public void savingFilmActorLastNameIsNull() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name(null);
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected = ActorShouldExistInFilm.class)
	public void savingFilmWithActorsNull() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected = ActorNameCannotBeNull.class)
	public void savingFilmActorPhotoUrlIsNull() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url(null);
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));;
		FilmService s = new FilmServiceImpl(new FilmRepoImpl());
		s.saveFilm(f);
	}
	@Test(expected=FilmIsAlreadyExist.class)
	public void savingFilmWhichisAlreadyExist() throws Exception{
		Film f = new Film();
		f.setTitle("KRISH");
		Category c = new Category();
		c.setName("Dude");
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
	}
	//ChangeFilm
	@Test(expected=FilmNotFound.class)
	public void modifyFilmTitleIsNotFound() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));
		service.changeFilm("Daruvu", f);
	}
	@Test(expected=FilmNotFound.class)
	public void modifyFilmTitleIsNull() throws Exception{
		Film f = new Film();
		f.setTitle("Krish");
		Category c = new Category();
		c.setName("Sci-Hi");
		f.setCategory(c);
		f.setRating(Rating.PG13);
		f.setRelease_year(2015);;
		HashSet<Actor> actors =  new HashSet<Actor>();
		Actor a = new Actor();
		Language l = new Language();
		l.setName("English");
		f.setLanguages(l);
		a.setFirst_name("Vamsi");
		a.setLast_name("Krishna");
		a.setPhoto_url("1.jpg");
		actors.add(a);
		Actor a1 = new Actor();
		a1.setFirst_name("Krishna");
		a1.setLast_name("Naidu");
		a1.setPhoto_url("2.jpg");
		actors.add(a1);
		f.setActors(actors);
		Date d = new Date();
		f.setLast_update(new Timestamp(d.getTime()));
		service.changeFilm(null, f);
	}
	//Delete Movie
	@Test(expected=FilmNotFound.class)
	public void deleteMovieTitleIsNull() throws Exception{
		service.deleteFilm(null);
	}
	@Test(expected=FilmNotFound.class)
	public void deleteMovieTitleIsNotFound()throws Exception{
		service.deleteFilm("New Year");
	}
	//SearchByName
	@Test(expected=FilmNotFound.class)
	public void searchByNameTitleIsNull() throws Exception{
		service.findFilmByName(null);
	}
	@Test(expected=FilmNotFound.class)
	public void searchByNameTitleIsNotExist() throws Exception{
		service.findFilmByName("Rama Krishna");
	}
	//SearchByRating
	@Test(expected=RatingNotFound.class)
	public void searchByNameRatingIsNull() throws Exception{
		service.findFilmByRating(null);
	}
	@Test(expected=RatingNotFound.class)
	public void searchByNameRatingIsNotExist() throws Exception{
		service.findFilmByRating("FAIL");
	}
}
