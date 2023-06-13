package Model;
import java.sql.SQLException;
import java.util.Date;

public abstract class Capteur {
	float value;
	int idB; // je ponse il faut declare un objet de type bureau
	Date date;
	SSecurite sssc;
	
	
	public Capteur() {
		super();
		this.sssc = new SSecurite();
		//instantiation de l'objet Bureau
	}
	public Capteur(float value, int idB, Date date) {
		super();
		this.sssc = new SSecurite();
		this.value = value;
		this.idB = idB;
		this.date = date;
	}
	public int getIdB() {
		return idB;
	}
	public void setIdB(int idB) {
		this.idB = idB;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public SSecurite getSssc() {
		return sssc;
	}
	public void setSssc(SSecurite sssc) {
		this.sssc = sssc;
	}
	public abstract float getValue() throws ClassNotFoundException, SQLException;	
}
