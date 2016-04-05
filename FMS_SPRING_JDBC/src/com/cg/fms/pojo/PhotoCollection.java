package com.cg.fms.pojo;

import java.sql.Timestamp;

public class PhotoCollection {
	private int photo_id;
	private int album_id;
	private String photo_url;
	private Timestamp last_update;
	private Timestamp delete_update;
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
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
	@Override
	public String toString() {
		return "PhotoCollection [photo_id=" + photo_id + ", album_id="
				+ album_id + ", photo_url=" + photo_url + ", last_update="
				+ last_update + ", delete_update=" + delete_update + "]";
	}
	
}