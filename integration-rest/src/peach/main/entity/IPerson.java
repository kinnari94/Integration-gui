/**
 * 
 */
package peach.main.entity;

/**
 * @author Shruti Sinha
 *
 */
public interface IPerson {


	//public String getPersonId();
	public String getDateCreated();
	public String getDateChanged();
	public String getGivenName();
	public String getFamilyName() ;
	public String getFamilyName2();
	public String getMiddlename();
	public String getMotherName();
	public String getFatherName();
	public String getPrefix();
	public String getSuffix();
	public String getDateOfBirth();
	public String getBirthPlace();
	public String getMultipleBirthIndicator();
	public String getBirthOrder();
	public String getMotherMaidenName();
	public String getDeathTime();
	public String getDeathIndicator();
	public String getPhoneCountryCode();
	public String getAreaCode();
	public String getPhoneNo();
	public String getPhoneExt();
	public String getAddress1();
	public String getAddress2();
	public String getCity();
	public String getState();
	public String getPostcode();
	public String getCountry();
	public String getCountryCode();
	public String getEmail();
	public String getMaritalStatusCode();
	public String getEthnicity();
	public String getNationality();
	public String getLanguage();
	public String getReligion();
	public String getDegree();
	public IGender getGenders();
	public IRace getRace();

	public interface IGender{
		public String getGenderCd();
		public String getGenderDescription();
		public String getGenderName();
	}
	
	public interface IRace{
		public String getRaceCd();
		public String getRaceCode();
		public String getRaceDescription();
		public String getRaceName();
	}

}
