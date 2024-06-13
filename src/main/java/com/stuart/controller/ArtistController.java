package com.stuart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stuart.model.Artist;
import com.stuart.services.ArtistServices;

@RestController
	@RequestMapping("/api/artist/")
	public class ArtistController {
	
	  @Autowired
	  private ArtistServices artistServices;
//GET
	  @GetMapping
	  public List<Artist> getAllArtist() {
	    return artistServices.findAllArtist();
	  }
	  
	  @GetMapping("{id}")
	  public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
	    return artistServices.findArtistById(id)
	    .map(ResponseEntity::ok)
	    .orElse(ResponseEntity.notFound().build());
	  }
//POST

	  @PostMapping
	  public Artist createArtist(@RequestBody Artist artist) {
	    return artistServices.saveArtist(artist);
	  }
//DELETE
	  @DeleteMapping("{id}")
	  public ResponseEntity<Void> deleteArtist(@PathVariable("id")Long id) {
	    return artistServices.findArtistById(id)
	    .map(artist -> {
	      artistServices.deleteArtistById(id);
	      return ResponseEntity.ok().<Void>build();
	    })
	    .orElse(ResponseEntity.notFound().build());
	  }
	}

