package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Album;
import com.example.demo.service.AlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController 
{
	private AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}
	
	@RequestMapping("/album")
	public List<Album> getAlbum()
	{
		return albumService.getAllAlbum();
	}
	
	@PostMapping("/album")
	public void createAlbum(@RequestBody Album album)
	{
		 albumService.createAlbum(album);
	}
	
	@GetMapping("/album/{id}")
	public Optional<Album> getAlbumbyId(@PathVariable int id)
	{
		Optional<Album> album = albumService.getAlbumById(id);
		return album;
	}
	
	@DeleteMapping("/album/{id}")
	public void deleteImage(@PathVariable int id)
	{
		albumService.deleteAlbum(id);
	}
	
}
