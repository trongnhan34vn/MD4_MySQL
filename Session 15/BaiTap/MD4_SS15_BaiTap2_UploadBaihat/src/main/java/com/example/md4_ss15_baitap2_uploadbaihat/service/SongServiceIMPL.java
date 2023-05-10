package com.example.md4_ss15_baitap2_uploadbaihat.service;

import com.example.md4_ss15_baitap2_uploadbaihat.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongServiceIMPL implements ISongService{
    List<Song> songs = new ArrayList<>();
    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void create(Song song) {
        songs.add(song);
    }
}
