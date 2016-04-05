package com.cg.fms.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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
	private int category_id;
	private int album_id;
	private int language_id;
	private Album album;
	private Category category;
	private Language languages;
	private Set<Actor> actors;
	public Film() {
		super();
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
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
	public Set<Actor> getActors() {
		return actors;
	}
	public void setActors(Set<Actor> set) {
		this.actors = set;
	}
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", album="
				+ album + "]";
	}
	

	
}
