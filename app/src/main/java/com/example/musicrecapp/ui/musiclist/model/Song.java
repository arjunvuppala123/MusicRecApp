package com.example.musicrecapp.ui.musiclist.model;

public class Song {
    private long id;
    private long genreId;
    private String songName;
    private String artistName;
    private String Genre;

    /*public Song(long id,long genreId,String songName, String artistName, String Genre) {
        this.id = id;
        this.genreId = genreId;
        this.songName = songName;
        this.artistName = artistName;
        this.Genre = Genre;
    }
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getsongName() {
        return songName;
    }

    public void setsongName(String songName) {
        this.songName = songName;
    }
    public String getartistName() {
        return artistName;
    }

    public void setartistName(String artistName) {
        this.artistName = artistName;
    }
    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }
}
