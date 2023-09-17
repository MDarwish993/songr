package com.mohammadDarwishLabs.songr.conroller;

import com.mohammadDarwishLabs.songr.exceptions.AlbumNotFoundException;
import com.mohammadDarwishLabs.songr.modals.Album;
import com.mohammadDarwishLabs.songr.repository.AlbumRepository;
import com.mohammadDarwishLabs.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class RoutesController {

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/")
    public String renderRootPage(Model viewModel){
        viewModel.addAttribute("welcomePage","Welcome Page");
        return "rootPage.html";
    }

    @GetMapping("/capitalize/{myText}")
    public String renderCapitalizePage(Model viewModel,@PathVariable String myText){
        viewModel.addAttribute("capitalizedText",myText.toUpperCase());
        return "capitalizedWord.html";
    }

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/createAlbum")
    public RedirectView createAlbumController(String title, String artist, int songCount, int lengthInSecond, String imageUrl){
        Album newAlbum =new Album(title,artist,songCount,lengthInSecond,imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }
    @GetMapping("/albums")
    public String getAllAlbums(Model viewModel){
        List<Album> listOfAlbum=albumRepository.findAll();

        viewModel.addAttribute("albumDetails",listOfAlbum);
        return "albumPage.html";
    }

    @GetMapping("/albums/{albumId}")
    public String getAlbumWithItsSongs(@PathVariable Long albumId,Model model ){
        Album albumById=albumRepository
                .findById(albumId)
                .orElseThrow(()->new AlbumNotFoundException("the album not found"));
        model.addAttribute("album",albumById);
        model.addAttribute("abumWithSongs",albumById.getSongList());

        return "albumPage.html";
    }

    @DeleteMapping("/delete/{albumId}")
    public RedirectView deleteAlbum(@PathVariable Long albumId){
        songRepository.deleteByalbum(albumId);
        albumRepository.deleteById(albumId);

        return new RedirectView("/albums");
    }

//    @PutMapping("/update/{albumId}")
//    public RedirectView updateAlbum(@PathVariable Long albumId,String title, String artist, int songCount, int lengthInSecond, String imageUrl){
//        Album album=albumRepository
//                .findById(albumId)
//                .orElseThrow(()->new AlbumNotFoundException("could not found Album"));
//        album.setTitle(title);
//        album.setArtist(artist);
//        album.setSongCount(songCount);
//        album.setLengthInSecond(lengthInSecond);
//        album.setImageUrl(imageUrl);
//        albumRepository.save(album);
//        return new RedirectView("/albums");
//    }




}
