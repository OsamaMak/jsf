package org.studyeasy.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Novel {
	private String name;
	private String author;
	private String editor;
	private int edition;
	private float price;
	private String[] genre;
	private String description;
	private String releaseDate;
	private String origin;
	private String saleOutOfIndia;
	private String email;

	public Novel() {

	}
	public void validateEmail(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String email = value.toString();
		if(!email.endsWith("@studyeasy.org")) {
			throw new ValidatorException(new FacesMessage("Invalid email"));
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String[] getGenre() {
		return genre;
	}

	public void setGenre(String[] genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getSaleOutOfIndia() {
		return saleOutOfIndia;
	}

	public void setSaleOutOfIndia(String saleOutOfIndia) {
		this.saleOutOfIndia = saleOutOfIndia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
