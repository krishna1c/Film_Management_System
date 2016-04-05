package com.cg.fms.pojo;

import java.sql.Timestamp;
import java.util.HashSet;

public class Film {
	private int film_id;
	private String title;
	private String description;
	private int release_year;
	private double rental_date;
	private int length;
	private double replacement_cost;
	private Rating rating;
	private Timestamp last_update;
	private Timestamp delete_update;
	private Album album;
	private Category category;
	private Language languages;
	private HashSet<Actor> actors = new HashSet<Actor>();
	
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public double getRental_date() {
		return rental_date;
	}
	public void setRental_date(double rental_date) {
		this.rental_date = rental_date;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public Timestamp getDelete_update() {
		return delete_update;
	}
	public void setDelete_update(Timestamp delete_update) {
		this.delete_update = delete_update;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Language getLanguages() {
		return languages;
	}
	public void setLanguages(Language languages) {
		this.languages = languages;
	}
	public HashSet<Actor> getActors() {
		return actors;
	}
	public void setActors(HashSet<Actor> actors) {
		this.actors = actors;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + release_year;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (rating != other.rating)
			return false;
		if (release_year != other.release_year)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Film [title=" + title + ", release_year=" + release_year + ", rating=" + rating + ", last_update="
				+ last_update + ", delete_update=" + delete_update + ", category=" + category + ", languages="
				+ languages + ", actors=" + actors + "]";
	}
	
	
}
