package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Album;

public interface AlbumService 
{
	public void createAlbum(Album album);
	public List<Album> getAllAlbum();
	
	public Optional<Album> getAlbumById(int id) ;
	
	public void deleteAlbum(int id);
	//public void updateAlbum(int id);
}
