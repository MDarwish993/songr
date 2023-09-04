package com.mohammadDarwishLabs.songr.conroller;

import com.mohammadDarwishLabs.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/albums")
    public String renderAlbumPage(Model viewModel){

        ArrayList<Album> listOfAlbum=new ArrayList<>();
        listOfAlbum.add(new Album("title1","artist1",1,100,"image1"));
        listOfAlbum.add(new Album("title2","artist2",2,200,"image2"));
        listOfAlbum.add(new Album("title3","artist3",3,300,"image3"));


        viewModel.addAttribute("albumDetails",listOfAlbum.toString());
        return "albumPage.html";
    }





}
