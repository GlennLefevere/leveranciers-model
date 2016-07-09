package be.provikmo.leveranciers.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adres {

	private String landNaam;
	private String provincieNaam;
	private String gemeenteNaam;
	private int postcode;
	private String straat;
	
	public String getLandNaam() {
		return landNaam;
	}
	
	public void setLandNaam(String landNaam) {
		this.landNaam = landNaam;
	}
	
	public String getProvincieNaam() {
		return provincieNaam;
	}
	
	public void setProvincieNaam(String provincieNaam) {
		this.provincieNaam = provincieNaam;
	}
	
	public String getGemeenteNaam() {
		return gemeenteNaam;
	}
	
	public void setGemeenteNaam(String gemeenteNaam) {
		this.gemeenteNaam = gemeenteNaam;
	}
	
	public int getPostcode() {
		return postcode;
	}
	
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	public String getStraat() {
		return straat;
	}
	
	public void setStraat(String straat) {
		this.straat = straat;
	}
	
}
