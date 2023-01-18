package org.studyeasy.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Scope {
	private int value=0;

	public Scope() {
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public void increaseValue() {
		value++;
	}

}
