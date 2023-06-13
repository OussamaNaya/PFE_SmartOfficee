package Model;

import java.util.Date;

public class Humidite extends Capteur
{	final String url = "112233/test/Humidite";
	
	public Humidite() {
		super();
	}
	public Humidite(float value, int idB, Date date) {
		super(value, idB, date);
	}
	public String getUrl() {
		return url;
	}
	@Override
	public float getValue() {
		float value = 0;
		if(value > super.getSssc().getBorneMaxHumidite() || value < super.getSssc().getBorneMinHumidite())
		{
			super.getSssc().getSurg().messageUtilisateurs();

		}
		return value;
	}
}
