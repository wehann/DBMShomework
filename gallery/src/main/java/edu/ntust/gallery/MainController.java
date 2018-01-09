package  edu.ntust.gallery;
import  edu.ntust.gallery.Artist;
import  edu.ntust.gallery.ArtistRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.http.HttpStatus; import  org.springframework.http.ResponseEntity; 
import  org.springframework.stereotype.Controller; import  
org.springframework.web.bind.annotation.*;

import  javax.persistence.EntityNotFoundException;
@Controller
public  class  MainController  {
	private  ArtistRepository  artistRepository;

	@Autowired
	public  MainController(ArtistRepository  artistRepository)  {
		this.artistRepository  =  artistRepository;
	}

	@PostMapping(path  =  "/artist")
	public  @ResponseBody
	ResponseEntity<Artist>  addUserBy(@RequestParam  Long  artistId,
		@RequestParam  String  lastName,
		@RequestParam  String  firstName,
		@RequestParam  String  nationality,
		@RequestParam  double  dateOfBirth,
		@RequestParam  double  dateDeceased)  {
		HttpStatus  status  =  HttpStatus.OK; if  (!artistRepository.exists(artistId))  { status  =  
			HttpStatus.CREATED;
		}
		Artist  saved  =  artistRepository.save(new  Artist()
			.setArtistId(artistId)

			.setLastName(lastName)
			.setFirstName(firstName)
			.setNationality(nationality)
			.setDateOfBirth(dateOfBirth)
			.setDateDeceased(dateDeceased));
		return  new  ResponseEntity<>(saved,  status);
	}

	@GetMapping(path  =  "/artists") public  @ResponseBody Iterable<Artist>  getAllUsers()  {
		return  artistRepository.findAll();
	}

	@GetMapping(path  =  "/artist/{id}")
	public  @ResponseBody
	Artist  getUserBy(@RequestParam  Long  id)  {
		return  artistRepository.findOne(id);
	}

	@PutMapping(path  =  "/artist/{id}")
	public  @ResponseBody
	ResponseEntity<Artist>  updateUserBy(@PathVariable  long  id,
		@RequestParam  String  lastName,
		@RequestParam  String  firstName,
		@RequestParam  String  nationality,
		@RequestParam  double  dateOfBirth,
		@RequestParam  double  dateDeceased)  throws  EntityNotFoundException  {
		if  (!artistRepository.exists(id))  {
			throw  new  EntityNotFoundException("Artist  "  +  id  +  "  cannot  be  found");

		}
		Artist  saved  =  artistRepository.save(new  Artist()
			.setArtistId(id)
			.setLastName(lastName)
			.setFirstName(firstName)
			.setNationality(nationality)
			.setDateOfBirth(dateOfBirth)

			.setDateDeceased(dateDeceased));
		return  new  ResponseEntity<>(saved,  HttpStatus.CREATED);
	}

	@DeleteMapping(path  =  "/artist/{id}")
	public  @ResponseBody
	ResponseEntity<Artist>  deleteUserBy(@PathVariable  Long  id)  throws  EntityNotFoundException  {
		if  (!artistRepository.exists(id))  {
			throw  new  EntityNotFoundException("Artist  "  +  id  +  "  cannot  be  found");
		}
		artistRepository.delete(id);
		return  new  ResponseEntity<>(HttpStatus.OK);
	}
}
