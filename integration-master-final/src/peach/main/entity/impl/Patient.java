/**
 * 
 */
package peach.main.entity.impl;

import peach.main.entity.IEHR;
import peach.main.entity.IPatient;
import peach.main.entity.IPerson;

/**
 * @author Shruti Sinha
 *
 */
public class Patient implements IPatient{

	IPerson person;
	IEHR ehr;
	 
	public Patient(IPerson person,IEHR ehr){
		this.person = person;
		this.ehr = ehr;
	}
	
	public IPerson getPerson() {
		return person;
	}
	void setPerson(IPerson person) {
		this.person = person;
	}
	public IEHR getEhr() {
		return ehr;
	}
	void setEhr(IEHR ehr) {
		this.ehr = ehr;
	}
}
