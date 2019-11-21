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
import com.example.demo.entity.Image;
import com.example.demo.service.ImageService;

@RestController
@RequestMapping("/api")
public class ImageController 
{
	private ImageService imageService;

	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@RequestMapping("/image")
	public List<Image> getImage()
	{
		return imageService.getAllImages();
	}
	
	@PostMapping("/image")
	public void createImage(@RequestBody Image image)
	{
		imageService.createImage(image);
	}
	
	@GetMapping("/image/{id}")
	public Optional<Image> getImagebyId(@PathVariable int id)
	{
		Optional<Image> image =  imageService.getImageById(id);
		return image;
	}
	
	@DeleteMapping("/image/{id}")
	public void deleteImage(@PathVariable int id)
	{
		imageService.deleteImage(id);
	}
	
}
