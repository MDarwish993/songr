package com.mohammadDarwishLabs.songr.conroller;

import com.mohammadDarwishLabs.songr.modals.Album;
import com.mohammadDarwishLabs.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        return "RootPage.html";
    }

    @GetMapping("/capitalize/{myText}")
    public String renderCapitalizePage(Model viewModel,@PathVariable String myText){
        viewModel.addAttribute("capitalizedText",myText.toUpperCase());
        return "capitalizedWord.html";
    }

//    @GetMapping("/albums")
//    public String renderAlbumPage(Model viewModel){
//
//        List<Album> listOfAlbum=new ArrayList<>();
//        listOfAlbum.add(new Album("title1","artist1",1,100,"https://th.bing.com/th/id/OIP.JCqScGgwobf4_IhCRTMXHwHaHa?w=178&h=178&c=7&r=0&o=5&pid=1.7"));
//        listOfAlbum.add(new Album("title2","artist2",2,200,"https://th.bing.com/th/id/OIP.6GoJktj1SgdAPC2pGTGxhgHaJe?w=178&h=228&c=7&r=0&o=5&pid=1.7"));
//        listOfAlbum.add(new Album("title3","artist3",3,300,"https://th.bing.com/th/id/OIP.3E-aoTPxYaedOzYIR02pywHaHb?w=185&h=186&c=7&r=0&o=5&pid=1.7"));
//
//
//        viewModel.addAttribute("albumDetails",listOfAlbum);
//        return "albumPage.html";
//    }

    @Autowired
    AlbumRepository albumRepository;

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





}
