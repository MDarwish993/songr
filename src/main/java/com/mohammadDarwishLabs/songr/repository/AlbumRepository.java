package com.mohammadDarwishLabs.songr.repository;

import com.mohammadDarwishLabs.songr.modals.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {
}
