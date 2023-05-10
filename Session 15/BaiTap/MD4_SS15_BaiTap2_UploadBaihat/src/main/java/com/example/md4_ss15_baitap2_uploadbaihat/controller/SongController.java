package com.example.md4_ss15_baitap2_uploadbaihat.controller;

import com.example.md4_ss15_baitap2_uploadbaihat.model.Song;
import com.example.md4_ss15_baitap2_uploadbaihat.model.SongForm;
import com.example.md4_ss15_baitap2_uploadbaihat.service.ISongService;
import com.example.md4_ss15_baitap2_uploadbaihat.service.SongServiceIMPL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = {"/","/song"})
public class SongController {
    ISongService songService = new SongServiceIMPL();
    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping
    public String home(Model model) {
        model.addAttribute("listSongs", songService.findAll());
        return "/home";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveSong(@ModelAttribute ("songForm") SongForm songForm) {
//        System.out.println("songForm ---------> "+songForm);
        MultipartFile multipartFile = songForm.getUrl();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getUrl().getBytes(), new File(fileUpload, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getArtist(), songForm.getCategory(), fileName);
//        System.out.println("song ----------> "+song);
        songService.create(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
