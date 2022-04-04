package com.java.exercise48;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private SongList songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new SongList();
	}

	public boolean addSong(String title, double duration) {
		return songs.add(new Song(title, duration));
	}

	public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
		Song song = this.songs.findSong(trackNumber);
		if (song != null) {
			playlist.add(song);
			return true;
		}
		return false;
	}

	public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
		Song song = songs.findSong(songTitle);
		if (song != null) {
			playlist.add(song);
			return true;
		}
		return false;
	}

	public static class SongList {
		private ArrayList<Song> songs;

		private SongList() {
			this.songs = new ArrayList<Song>();
		}

		private boolean add(Song song) {
			if (!songs.contains(song)) {
				this.songs.add(song);
				return true;
			}
			return false;
		}

		private Song findSong(String title) {
			for (Song song : this.songs) {
				if (song.getTitle().equals(title))
					return song;
			}
			return null;
		}

		private Song findSong(int trackNumber) {
			if (trackNumber > 0 && trackNumber <= songs.size()) {
				return this.songs.get(trackNumber - 1);
			}
			return null;
		}
	}
}
