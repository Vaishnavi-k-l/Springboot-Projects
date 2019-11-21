package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.entity.Album;


@Service
public class AlbumServiceImpl implements AlbumService
{
	private AlbumRepository albumRepository;
	
	public AlbumServiceImpl(AlbumRepository albumRepository) {
		super();
		this.albumRepository = albumRepository;
	}

	@Override
	@Transactional
	public void createAlbum(Album album) 
	{
		albumRepository.save(album);
	}

	@Override
	@Transactional
	public List<Album> getAllAlbum() 
	{
		return albumRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Album> getAlbumById(int id) 
	{
			Optional<Album> album =  albumRepository.findById(id);
			return album;
	}

	@Override
	@Transactional
	public void deleteAlbum(int id) 
	{
		albumRepository.deleteById(id);	
	}

	
	
	
		
	
}
