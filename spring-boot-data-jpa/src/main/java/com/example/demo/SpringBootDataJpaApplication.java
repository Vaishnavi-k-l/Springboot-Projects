package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Album;
import com.example.demo.entity.Image;

@SpringBootApplication
public class SpringBootDataJpaApplication 
{

	private AlbumRepository albumRepository;
	public SpringBootDataJpaApplication(AlbumRepository albumRepository, ImageRepository imageRepository) {
		super();
		this.albumRepository = albumRepository;
		this.imageRepository = imageRepository;
	}


	private ImageRepository imageRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Component
	class ImageCommand implements CommandLineRunner
	{
		@Override
		public void run(String... args) throws Exception 
		{
			List<Image> images = new ArrayList<Image>();
			
			Album tempalbum = new Album();
			Image tempimage = new Image();
			
			
			tempimage.setType("jpg");
			tempimage.setUrl("http://travels/img1.jpg");
			
			images.add(tempimage);
			
			tempalbum.setName("Mytravels");
			tempalbum.setImages(images);
			tempimage.setAlbum(tempalbum);
			
			albumRepository.save(tempalbum);
			imageRepository.save(tempimage);
			
		}
		
	}
	
}
