package Model;

public  class SSecurite {
	final float borneMinHumidite = (float) 5;
	final float borneMaxHumidite = (float) 20;
	final float borneMinGaz = (float) 12.12;
	final float borneMaxGaz = (float) 12.12;
	final float borneMinFumee = (float) 12.12;
	final float borneMaxFumee = (float) 12.12;
    SUrgent surg;
	
	public SSecurite() {
		super();
		this.surg = new SUrgent();
	}
	public boolean humiditeIsValide(float humidite)
	{
		return humidite>this.borneMinHumidite & humidite<borneMaxHumidite;
	}
	public boolean gazIsValide(float gaz)
	{
		return gaz>this.borneMinGaz & gaz<borneMaxGaz;
	}
	public boolean fumeeIsValide(float fumee)
	{
		return fumee>this.borneMinFumee & fumee<this.borneMaxFumee;
	}
	public float getBorneMaxHumidite()
	{
		return borneMaxHumidite;
	}
	public float getBorneMinHumidite()
	{
		return borneMinHumidite;
	}
	public float getBorneMaxFumee()
	{
		return borneMaxFumee;
	}
	public float getBorneMinFumee()
	{
		return borneMinFumee;
	}
	public float getBorneMaxGaz()
	{
		return borneMaxGaz;
	}
	public float getBorneMinGaz()
	{
		return borneMinGaz;
	}
	public SUrgent getSurg() {
		return surg;
	}
	public void setSurg(SUrgent s) {
		this.surg = s;
	}
	@Override
	public String toString() {
		return "SSecurite [borneMinHumidite=" + borneMinHumidite + ", borneMaxHumidite=" + borneMaxHumidite
				+ ", borneMinGaz=" + borneMinGaz + ", borneMaxGaz=" + borneMaxGaz + ", borneMinFumee=" + borneMinFumee
				+ ", borneMaxFumee=" + borneMaxFumee + "]";
	}
}
