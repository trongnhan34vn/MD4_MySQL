package com.example.md4_ss15_baitap2_uploadbaihat.service;

import com.example.md4_ss15_baitap2_uploadbaihat.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void create(Song song);
}
