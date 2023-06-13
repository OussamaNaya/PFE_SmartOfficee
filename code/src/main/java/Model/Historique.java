package Model;

public class Historique {
      float valeurHumidite;
      float valeurGaz;
      float valeurFumee;
      int idB;
      String date;
      String statuHumidite;
      String statuGaz;
      String statuFumee;

	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Historique(float valeurHumidite, float valeurGaz, float valeurFumee, int idB, String date,
			String statuHumidite, String statuGaz, String statuFumee) {
		super();
		this.valeurHumidite = valeurHumidite;
		this.valeurGaz = valeurGaz;
		this.valeurFumee = valeurFumee;
		this.idB = idB;
		this.date = date;
		this.statuHumidite = statuHumidite;
		this.statuGaz = statuGaz;
		this.statuFumee = statuFumee;
	}
	public float getValeurHumidite() {
		return valeurHumidite;
	}
	public void setValeurHumidite(float valeurHumidite) {
		this.valeurHumidite = valeurHumidite;
	}
	public float getValeurGaz() {
		return valeurGaz;
	}
	public void setValeurGaz(float valeurGaz) {
		this.valeurGaz = valeurGaz;
	}
	public float getValeurFumee() {
		return valeurFumee;
	}
	public void setValeurFumee(float valeurFumee) {
		this.valeurFumee = valeurFumee;
	}
	public int getIdB() {
		return idB;
	}
	public void setIdB(int idB) {
		this.idB = idB;
	}    
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatuHumidite() {
		return statuHumidite;
	}
	public void setStatuHumidite(String statuHumidite) {
		this.statuHumidite = statuHumidite;
	}
	public String getStatuGaz() {
		return statuGaz;
	}
	public void setStatuGaz(String statuGaz) {
		this.statuGaz = statuGaz;
	}
	public String getStatuFumee() {
		return statuFumee;
	}
	public void setStatuFumee(String statuFumee) {
		this.statuFumee = statuFumee;
	}
	@Override
	public String toString() {
		return "Historique [valeurHumidite=" + valeurHumidite + ", valeurGaz=" + valeurGaz + ", valeurFumee="
				+ valeurFumee + ", idB=" + idB + ", date=" + date + "]";
	}
      
      
}
