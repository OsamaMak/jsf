package org.studyeasy.jsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;



@ApplicationScoped
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
