package com.java.exercise46;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		songs = new ArrayList<Song>();
	}

	public boolean addSong(String title, double duration) {
		Song song = findSong(title);
		if (song == null) {
			songs.add(new Song(title, duration));
			return true;
		}
		return false;
	}
	
	private Song findSong(String title) {
		for (Song song : songs) {
			if (song.getTitle().equals(title)) return song;
		}
		return null;
	}
	
	public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
		if (trackNumber > 0 && trackNumber <= songs.size()) {
			playlist.add(songs.get(trackNumber - 1));
			return true;
		}
		return false;
	}
	
	public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
		Song song = findSong(songTitle);
		if (song != null) {
			playlist.add(song);
			return true;
		}
		return false;
	}
}
