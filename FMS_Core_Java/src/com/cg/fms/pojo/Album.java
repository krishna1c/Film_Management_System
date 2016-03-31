package com.cg.fms.pojo;

import java.security.Timestamp;
import java.util.HashSet;

public class Album {
	private int album_id;
	private String album_name;
	private Timestamp last_update;
	private Timestamp delete_update;
	private HashSet<PhotoCollection> photocollection = new HashSet<PhotoCollection>();
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getAlbum_name() {
		return album_name;
	}
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
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
	public HashSet<PhotoCollection> getPhotocollection() {
		return photocollection;
	}
	public void setPhotocollection(HashSet<PhotoCollection> photocollection) {
		this.photocollection = photocollection;
	}
	
}