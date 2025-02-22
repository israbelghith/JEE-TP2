package tn.itbs.bean;

public class Magasin {
	private int id;
	private String nom;
	private String adresse;
	private int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public Magasin(int id, String nom, String adresse) {
	super();
	this.id = id;
	this.nom = nom;
	this.adresse = adresse;
}
public Magasin() {
	super();
}

}
