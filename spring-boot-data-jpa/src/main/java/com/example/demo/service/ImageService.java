package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Image;

public interface ImageService 
{
	public List<Image> getAllImages();
	public void createImage(Image image);
	public Optional<Image> getImageById(int theId);
	public void deleteImage(int id);
	//public void updateImage(int id);
}
