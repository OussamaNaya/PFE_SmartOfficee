package Model;

import java.util.ArrayList;
import java.util.List;

public class Bureau {	
	int idB;
	List<Utilisateur> list;
	String loc;
	Humidite capteurHumidite;
	Fumee capteurFumee;
	Gaz capteurGaz;

	public Bureau() {
		super();
		list = new ArrayList<>();
		this.capteurHumidite = new Humidite();
		this.capteurFumee = new Fumee();
		this.capteurGaz = new Gaz();
	}
	public Bureau(int idB,String loc) {
		super();
		list = new ArrayList<>();
		this.capteurHumidite = new Humidite();
		this.capteurFumee = new Fumee();
		this.capteurGaz = new Gaz();
		this.idB = idB;
		this.loc = loc;
	}
	public Bureau(int idB, List<Utilisateur> list, String loc, Humidite capteurHumidite, Fumee capteurFumee,Gaz capteurGaz) {
		super();
		this.capteurHumidite = new Humidite();
		this.capteurFumee = new Fumee();
		this.capteurGaz = new Gaz();
		this.idB = idB;
		this.list = list;
		this.loc = loc;
		this.capteurHumidite = capteurHumidite;
		this.capteurFumee = capteurFumee;
		this.capteurGaz = capteurGaz;
	}
	public List<Utilisateur> getList() {
		return list;
	}
	public void setList(List<Utilisateur> list) {
		this.list = list;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getIdB() {
		return idB;
	}
	public void setIdB(int idB)
	{
		this.idB = idB;
	}
	public Humidite getCapteurHumidite() {
		return capteurHumidite;
	}
	public void setCapteurHumidite(Humidite capteurHumidite) {
		this.capteurHumidite = capteurHumidite;
	}
	public Fumee getCapteurFumee() {
		return capteurFumee;
	}
	public void setCapteurFumee(Fumee capteurFumee) {
		this.capteurFumee = capteurFumee;
	}
	public Gaz getCapteurGaz() {
		return capteurGaz;
	}
	public void setCapteurGaz(Gaz capteurGaz) {
		this.capteurGaz = capteurGaz;
	}
	@Override
	public String toString() {
		return "Bureau [idB=" + idB + ", list=" + list + ", loc=" + loc + "]";
	}
	
}
