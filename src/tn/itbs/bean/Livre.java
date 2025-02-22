package tn.itbs.bean;

public class Livre {
	private int id;
	private String titre;
	private double prix;
	private int idmagasin;
	private int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getIdmagasin() {
		return idmagasin;
	}
	public void setIdmagasin(int idmagasin) {
		this.idmagasin = idmagasin;
	}
	public Livre(int id, String titre, Double prix, int idmagasin) {
		super();
		this.id = id;
		this.titre = titre;
		this.prix = prix;
		this.idmagasin = idmagasin;
	}
	public Livre() {
		super();
	}
	

}
