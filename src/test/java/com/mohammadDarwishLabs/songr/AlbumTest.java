package com.mohammadDarwishLabs.songr;

import com.mohammadDarwishLabs.songr.modals.Album;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlbumTest {

    @Test
    public void testAlbumConstructor() {
        Album album = new Album("Title", "Artist", 10, 3600, "image.jpg");

        assertEquals("Title", album.getTitle());
        assertEquals("Artist", album.getArtist());
        assertEquals(10, album.getSongCount());
        assertEquals(3600, album.getLengthInSecond());
        assertEquals("image.jpg", album.getImageUrl());
    }

    @Test
    public void testSetTitle() {
        Album album = new Album("Title", "Artist", 10, 3600, "image.jpg");
        album.setTitle("New Title");
        assertEquals("New Title", album.getTitle());
    }

    @Test
    public void testSetArtist() {
        Album album = new Album("Title", "Artist", 10, 3600, "image.jpg");
        album.setArtist("New Artist");
        assertEquals("New Artist", album.getArtist());
    }

    @Test
    public void testSetSongCount() {
        Album album = new Album("Title", "Artist", 10, 3600, "image.jpg");
        album.setSongCount(15);
        assertEquals(15, album.getSongCount());
    }

    @Test
    public void testSetLengthInSecond() {
        Album album = new Album("Title", "Artist", 10, 3600, "image.jpg");
        album.setLengthInSecond(4200);
        assertEquals(4200, album.getLengthInSecond());
    }

    @Test
    public void testSetImageUrl() {
        Album album = new Album("Title", "Artist", 10, 3600, "image.jpg");
        album.setImageUrl("new_image.jpg");
        assertEquals("new_image.jpg", album.getImageUrl());
    }
}
