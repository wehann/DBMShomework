package edu.ntust.gallery;

import edu.ntust.gallery.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
