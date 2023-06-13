package Model;

import java.util.Date;

public class Fumee extends Capteur
{   final String url = "112233/test/Fumee";

	public Fumee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fumee(float value, int idB, Date date) {
		super(value, idB, date);
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	@Override
	public float getValue() {
		// TODO Auto-generated method stub
		float value = 0;
		if(value > super.getSssc().getBorneMaxFumee() || value < super.getSssc().getBorneMinFumee())
		{
			super.getSssc().getSurg().appelPompier();
			super.getSssc().getSurg().messageUtilisateurs();

		}
		return value;
	}

}
