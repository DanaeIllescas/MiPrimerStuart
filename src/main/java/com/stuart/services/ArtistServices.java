package com.stuart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuart.model.Artist;
import com.stuart.repositories.ArtistRepository;

@Service
public class ArtistServices {
	@Autowired
	private ArtistRepository artistRepository;

	public List<Artist> findAllArtist(){
		return artistRepository.findAll();
	}

	public Optional<Artist> findArtistById(Long id) {
		return artistRepository.findById(id);
	}

	public Artist saveArtist(Artist artist) {
		return artistRepository.save(artist);
	}

	public void deleteArtistById(Long id) {
		artistRepository.deleteById(id);
	}
}
