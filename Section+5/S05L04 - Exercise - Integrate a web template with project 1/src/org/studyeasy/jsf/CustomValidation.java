package org.studyeasy.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class CustomValidation {

	public CustomValidation() {
		
	}
	
	public void validateRefCode(FacesContext context, UIComponent component, Object value)
			throws ValidatorException{
		String refCode = value.toString();
		if(!(refCode.startsWith("ref"))) {
			throw new ValidatorException(new FacesMessage("Ref code should start with 'ref'"));
		}
	}
}
