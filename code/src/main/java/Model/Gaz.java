package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import tools.DBInteraction;

public class Gaz extends Capteur
{   final String url = "112233/test/Gaz";

	public Gaz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gaz(float value, int idB, Date date) {
		super(value, idB, date);
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	@Override
	public float getValue() throws ClassNotFoundException, SQLException {
		float value = 0;
		if(value > super.getSssc().getBorneMaxGaz() || value < super.getSssc().getBorneMinGaz())
		{
			super.getSssc().getSurg().messageUtilisateurs();

		}
		return value;
	}

}
