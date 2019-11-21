package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Image;


@Service
public class ImageServiceImpl implements ImageService
{
	private ImageRepository imageRepository;
	
	public ImageServiceImpl(ImageRepository imageRepository)
	{
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	@Transactional
	public List<Image> getAllImages()
	{
		
		return imageRepository.findAll();
	}

	@Override
	@Transactional
	public void createImage(Image image) 
	{
		
		imageRepository.save(image);
	}

	@Override
	@Transactional
	public Optional<Image> getImageById(int id)
	{
		Optional<Image> image = imageRepository.findById(id);
		return image;
	}

	@Override
	@Transactional
	public void deleteImage(int id) 
	{
		imageRepository.deleteById(id);
	}

}
