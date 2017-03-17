/**
 * 
 */
package peach.main.entity.impl;

import peach.main.entity.IEHR;

/**
 * @author Shruti Sinha
 *
 */
public class EHR implements IEHR{

	private String ehrId;
	private String subjectId;
	private String namespace;
	
	public EHR(String ehrId, String subjectId, String namespace){
		this.ehrId = ehrId;
		this.subjectId = subjectId;
		this.namespace = namespace;
	}

	public String getehrId() {
		return ehrId;
	}

	public void setehrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	
}
