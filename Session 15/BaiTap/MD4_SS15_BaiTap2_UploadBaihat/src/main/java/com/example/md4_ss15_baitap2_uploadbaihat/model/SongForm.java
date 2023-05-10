package com.example.md4_ss15_baitap2_uploadbaihat.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    int id;
    String name;
    String artist;
    String category;
    MultipartFile url;

    public SongForm() {
    }

    public SongForm(int id, String name, String artist, String category, MultipartFile url) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SongForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", category='" + category + '\'' +
                ", url=" + url +
                '}';
    }
}
