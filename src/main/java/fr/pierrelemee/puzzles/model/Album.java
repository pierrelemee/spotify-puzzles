package fr.pierrelemee.puzzles.model;

import java.util.*;

/**
 * Represents an album
 */
public class Album {

    private Set<Song> songs = new TreeSet<Song>(new Comparator<Song>() {
        public int compare(Song o1, Song o2) {
            return o1.higherQualityThan(o2) ? -1 : 1;
        }
    });

    private void addSong(Song song) {
        this.songs.add(song);
    }

    public List<Song> getSongs() {
        return Arrays.asList(this.songs.toArray(new Song[]{}));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<Song> songs = new LinkedList<Song>();

        public Builder addSong(String title, int nbListenings) {
            this.songs.add(new Song(this.songs.size() + 1, title, nbListenings));
            return this;
        }

        public Album build() {
            Album album = new Album();
            for (Song song: this.songs) {
                album.addSong(song);
            }
            return album;
        }
    }

    public static final class Song {
        private int rank;
        private String title;
        private int nbListenings;

        Song(int rank, String title, int nbListenings) {
            this.rank = rank;
            this.title = title;
            this.nbListenings = nbListenings;
        }

        int getZipf() {
            return this.rank * this.nbListenings;
        }

        public String getTitle() {
            return title;
        }

        public boolean higherQualityThan(Song song) {
            if (this.getZipf() == song.getZipf()) {
                return this.rank > song.rank;
            }
            return this.getZipf() > song.getZipf();
        }
    }
}
