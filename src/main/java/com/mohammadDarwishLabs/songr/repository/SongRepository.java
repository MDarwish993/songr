package com.mohammadDarwishLabs.songr.repository;

import com.mohammadDarwishLabs.songr.modals.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {
}
