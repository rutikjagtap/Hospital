package com.accio.SpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringProjectApplication {
	@GetMapping("/song")
	public String getsongs(@RequestParam(name = "title") String title) {
		return title +" is good in DSA.";
	}
	@GetMapping("/playlist/{id}/song/{songId}")
	public String getsong(@PathVariable String id, @PathVariable String songId) {
		return "PlayList: "+ id + ",Song: " +songId;
	}
	@GetMapping("/song-detail")
	public Song getsongDetail(@RequestParam String title, @RequestParam double duration) {
		Song song = new Song(title,duration);
		return song;
	}
	@GetMapping("song-index")
	public List<Song> getsongIndex() {
		List<Song> songs = new ArrayList<Song>();
		songs.add(new Song("rutik",0));
		songs.add(new Song("Pratik",1));
		songs.add(new Song("Ankit",2));
		songs.add(new Song("Prashil",3));
		return songs;
	}
	public static void main(String[] args) {

		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
