/**
 * 
 */
package peach.main.entity.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import peach.main.entity.IPerson;

/**
 * @author Shruti Sinha
 *
 */
@XmlRootElement
public class Person implements IPerson{

	private String personId;
	private String dateCreated;
	private String dateChanged;	
	private String givenName;	 
	private String familyName;	 
	private String familyName2;	 
	private String middlename;	 
	private String motherName;	 
	private String fatherName;	 
	private String prefix;	 
	private String suffix;	 
	private String dateOfBirth;	 
	private String birthPlace;	 
	private String multipleBirthIndicator;	 
	private String birthOrder;	 
	private String motherMaidenName;	
	private String deathTime;	 
	private String deathIndicator;	 
	private String phoneCountryCode;	 
	private String areaCode;	 
	private String phoneNo;	 
	private String phoneExt;	 
	private String address1;	 
	private String address2;	 
	private String city;	 
	private String state;	 
	private String postcode;	 
	private String country;	 
	private String countryCode;	 
	private String email;	 	 
	private String maritalStatusCode;	 
	private String ethnicity;	 
	private String nationality;	 
	private String language;	 
	private String religion;	 
	private String degree;


	@XmlElement
	public String getPersonId() {
		return personId;
	}

	void setPersonId(String personId) {
		this.personId = personId;
	}

	@XmlElement
	public String getDateCreated() {
		return dateCreated;
	}

	void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@XmlElement
	public String getDateChanged() {
		return dateChanged;
	}

	void setDateChanged(String dateChanged) {
		this.dateChanged = dateChanged;
	}

	@XmlElement
	public String getGivenName() {
		return givenName;
	}

	void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	@XmlElement
	public String getFamilyName() {
		return familyName;
	}
	void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@XmlElement
	public String getFamilyName2() {
		return familyName2;
	}
	void setFamilyName2(String familyName2) {
		this.familyName2 = familyName2;
	}

	@XmlElement
	public String getMiddlename() {
		return middlename;
	}
	void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@XmlElement
	public String getMotherName() {
		return motherName;
	}
	void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@XmlElement
	public String getFatherName() {
		return fatherName;
	}
	void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@XmlElement
	public String getPrefix() {
		return prefix;
	}
	void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@XmlElement
	public String getSuffix() {
		return suffix;
	}
	void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@XmlElement
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@XmlElement
	public String getBirthPlace() {
		return birthPlace;
	}
	void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@XmlElement
	public String getMultipleBirthIndicator() {
		return multipleBirthIndicator;
	}
	void setMultipleBirthIndicator(String multipleBirthIndicator) {
		this.multipleBirthIndicator = multipleBirthIndicator;
	}

	@XmlElement
	public String getBirthOrder() {
		return birthOrder;
	}
	void setBirthOrder(String birthOrder) {
		this.birthOrder = birthOrder;
	}

	@XmlElement
	public String getMotherMaidenName() {
		return motherMaidenName;
	}
	void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}

	@XmlElement
	public String getDeathTime() {
		return deathTime;
	}
	void setDeathTime(String deathTime) {
		this.deathTime = deathTime;
	}

	@XmlElement
	public String getDeathIndicator() {
		return deathIndicator;
	}
	void setDeathIndicator(String deathIndicator) {
		this.deathIndicator = deathIndicator;
	}

	@XmlElement
	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}
	void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	@XmlElement
	public String getAreaCode() {
		return areaCode;
	}
	void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@XmlElement
	public String getPhoneNo() {
		return phoneNo;
	}
	void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@XmlElement
	public String getPhoneExt() {
		return phoneExt;
	}
	void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}

	@XmlElement
	public String getAddress1() {
		return address1;
	}
	void setAddress1(String address1) {
		this.address1 = address1;
	}

	@XmlElement
	public String getAddress2() {
		return address2;
	}
	void setAddress2(String address2) {
		this.address2 = address2;
	}

	@XmlElement
	public String getCity() {
		return city;
	}
	void setCity(String city) {
		this.city = city;
	}

	@XmlElement
	public String getState() {
		return state;
	}
	void setState(String state) {
		this.state = state;
	}

	@XmlElement
	public String getPostcode() {
		return postcode;
	}
	void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@XmlElement
	public String getCountry() {
		return country;
	}
	void setCountry(String country) {
		this.country = country;
	}

	@XmlElement
	public String getCountryCode() {
		return countryCode;
	}
	void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getMaritalStatusCode() {
		return maritalStatusCode;
	}
	void setMaritalStatusCode(String maritalStatusCode) {
		this.maritalStatusCode = maritalStatusCode;
	}

	@XmlElement
	public String getEthnicity() {
		return ethnicity;
	}
	void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	@XmlElement
	public String getNationality() {
		return nationality;
	}
	void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@XmlElement
	public String getLanguage() {
		return language;
	}
	void setLanguage(String language) {
		this.language = language;
	}

	@XmlElement
	public String getReligion() {
		return religion;
	}
	void setReligion(String religion) {
		this.religion = religion;
	}

	@XmlElement
	public String getDegree() {
		return degree;
	}
	void setDegree(String degree) {
		this.degree = degree;
	}	

	private Person.Genders genders;

	public Person.Genders getGenders() {
		return genders;
	}

	@XmlElement(name="gender")
	public void setGenders(Person.Genders value) {
		this.genders=value;
	}

	public static class Genders implements IGender{

		String genderCd;
		String genderDescription;
		String genderName;

		@XmlElement
		public String getGenderCd() {
			return genderCd;
		}
		public void setGenderCd(String genderCd) {
			this.genderCd = genderCd;
		}

		@XmlElement
		public String getGenderDescription() {
			return genderDescription;
		}
		public void setGenderDescription(String genderDescription) {
			this.genderDescription = genderDescription;
		}

		@XmlElement
		public String getGenderName() {
			return genderName;
		}
		public void setGenderName(String genderName) {
			this.genderName = genderName;
		}  	
	}

	private Person.Race race;

	public Person.Race getRace() {
		return race;
	}

	@XmlElement(name="race")
	public void setRace(Person.Race value) {
		this.race=value;
	}

	public static class Race implements IPerson.IRace{

		String raceCd;
		String raceCode;
		String raceDescription;
		String raceName;

		@XmlElement
		public String getRaceCd() {
			return raceCd;
		}
		public void setRaceCd(String raceCd) {
			this.raceCd = raceCd;
		}

		@XmlElement
		public String getRaceCode() {
			return raceCode;
		}
		public void setRaceCode(String raceCode) {
			this.raceCode = raceCode;
		}

		@XmlElement
		public String getRaceDescription() {
			return raceDescription;
		}
		public void setRaceDescription(String raceDescription) {
			this.raceDescription = raceDescription;
		}

		@XmlElement
		public String getRaceName() {
			return raceName;
		}
		public void setRaceName(String raceName) {
			this.raceName = raceName;
		}  	
	}

	@XmlElement(name="personIdentifiers")
	private List<Person.PersonIdentifiers> personIdentifiers;

	public List<Person.PersonIdentifiers> getPersonIdentifiers() {
		return personIdentifiers;
	}
	
	public static class PersonIdentifiers {
		String identifier;

		@XmlElement
		public String getIdentifier() {
			return this.identifier;
		}

		public void setIdentifier(String identifier){
			this.identifier = identifier;
		}
	}
}
