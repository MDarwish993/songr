package com.mohammadDarwishLabs.songr.modals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String artist;
    private int songCount;
    private int lengthInSecond;
    private String imageUrl;

    public Album(String title, String artist, int songCount, int lengthInSecond, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.lengthInSecond = lengthInSecond;
        this.imageUrl = imageUrl;
    }

    public Album(){

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLengthInSecond() {
        return lengthInSecond;
    }

    public void setLengthInSecond(int lengthInSecond) {
        this.lengthInSecond = lengthInSecond;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", lengthInSecond=" + lengthInSecond +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
