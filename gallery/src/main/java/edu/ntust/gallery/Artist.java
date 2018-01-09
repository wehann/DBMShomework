package edu.ntust.gallery;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long artistId; private String lastName; private String firstName; private String 
	nationality; private double dateOfBirth;
	private double dateDeceased;

	public long getArtistId() {
		return artistId;
	}
	public Artist setArtistId(long artistId) {
		this.artistId = artistId;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public Artist setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getFirstName() {

		return firstName;
	}
	public Artist setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getNationality() {
		return nationality;
	}
	public Artist setNationality(String nationality) {
		this.nationality = nationality;
		return this;
	}
	public double getDateOfBirth() {
		return dateOfBirth;
	}
	public Artist setDateOfBirth(double dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}
	public double getDateDeceased() {
		return dateDeceased;
	}
	public Artist setDateDeceased(double dateDeceased) {
		this.dateDeceased = dateDeceased;
		return this;
	}
}
