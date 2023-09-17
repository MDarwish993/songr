package com.mohammadDarwishLabs.songr.modals;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "album",cascade = CascadeType.ALL)
    private List<Song> songList;

    public Album(String title, String artist, int songCount, int lengthInSecond, String imageUrl) {
       setTitle(title);
        setArtist(artist);
        setSongCount(songCount);
        setLengthInSecond(lengthInSecond);
        setImageUrl(imageUrl);
    }

    public Album(){
        this.title = "unkown title";
        this.artist = "unkown artist";
        this.songCount = 0;
        this.lengthInSecond = 0;
        this.imageUrl = "unkown imageUrl";
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
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
