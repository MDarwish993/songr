package com.mohammadDarwishLabs.songr.conroller;

import com.mohammadDarwishLabs.songr.exceptions.AlbumNotFoundException;
import com.mohammadDarwishLabs.songr.modals.Album;
import com.mohammadDarwishLabs.songr.modals.Song;
import com.mohammadDarwishLabs.songr.repository.AlbumRepository;
import com.mohammadDarwishLabs.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("add-song")
    public RedirectView addSong(String title, int length, int trackNumber, Long albumId){
        Album album=albumRepository
                .findById(albumId)
                .orElseThrow(()->new AlbumNotFoundException("could not found Album"));

        Song song=new Song(title,length,trackNumber,album);
            songRepository.save(song);
        return new RedirectView("/albums");
    }

    @GetMapping("/songs")
    public String getAllSongs(Model viewModel){
        List<Song> listOfSong=songRepository.findAll();

        viewModel.addAttribute("listOfSong",listOfSong);
        return "/songs.html";
    }

//    @DeleteMapping("/delete/{songId}")
//    public RedirectView deleteSong(@PathVariable Long songId){
//        songRepository.deleteById(songId);
//
//        return new RedirectView("/");
//    }
//
//
//    @PutMapping("/update/{songId}")
//    public RedirectView updateSong(@PathVariable Long songId,String title, int length, int trackNumber, Long albumId){
//        Song song=songRepository
//                .findById(songId)
//                .orElseThrow(() -> new RuntimeException());
//        song.setTitle(title);
//        song.setLength(length);
//        song.setTrackNumber(trackNumber);
//        Album album=albumRepository
//                .findById(albumId)
//                .orElseThrow(()->new AlbumNotFoundException("could not find Album"));
//        song.setAlbum(album);
//        songRepository.save(song);
//        return new RedirectView("/");
//    }



}
