package Model;

public class Utilisateur {
	int idU,idAdmin;
	String login,password;
	Bureau b;
	String role;
	String email;
	String tele;
	boolean etat;

	public Utilisateur(int idU, int idAdmin, int idBureau,String email, String login, String password,boolean etat,String role,String tele) {
		super();
		this.idU = idU;
		this.idAdmin = idAdmin;
		b = new Bureau();
		b.setIdB(idBureau);
		this.login = login;
		this.password = password;
		this.etat = etat;
		this.role = role;
		this.email = email;
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Utilisateur(int idU, int idAdmin, int idBureau, String login, String password,boolean etat,String role,String tele) {
		super();
		this.idU = idU;
		this.idAdmin = idAdmin;
		b = new Bureau();
		b.setIdB(idBureau);
		this.login = login;
		this.password = password;
		this.etat = etat;
		this.role = role;
		this.tele = tele;
	}
	public Utilisateur(int idU, int idAdmin,String login, String password,Bureau b, boolean etat,String role,String tele) {
		super();
		this.idU = idU;
		this.idAdmin = idAdmin;
        this.b = b;
		this.login = login;
		this.password = password;
		this.etat = etat;
		this.role = role;
		this.tele = tele;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Utilisateur(int idU, int idAdmin,int idB,String login, String password, String role, String tele) {
		super();
		this.idU = idU;
		this.idAdmin = idAdmin;
		this.login = login;
		this.password = password;
		b = new Bureau();
		this.b.setIdB(idB);;
		this.role = role;
		this.tele = tele;
	}
	public Utilisateur(String login, String password,String tele) {
		super();
		b = new Bureau();
		this.login = login;
		this.password = password;
		this.tele = tele;
	}
	public Utilisateur() {
		super();
		this.b = new Bureau();
	}
	public Utilisateur(Utilisateur u)
	{
		this.idU = u.idU;
		this.idAdmin = u.idAdmin;
		this.login = u.login;
		this.password = u.password;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int id) {
		this.idU = id;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdB()
	{
		return b.getIdB();
	}
	public void setIdB(int idB)
	{
		this.b.setIdB(idB);
	}
	public Bureau getB() {
		return b;
	}
	public void setB(Bureau b) {
		this.b.setCapteurFumee(b.getCapteurFumee());;
		this.b.setCapteurGaz(b.getCapteurGaz());
		this.b.setCapteurHumidite(b.getCapteurHumidite());
		this.b.setIdB(b.getIdB());
		this.b.setLoc(b.getLoc());
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTele() {
		return tele;
	}  
	public void setTele(String tele) {
		this.tele = tele;
	}
	@Override
	public String toString() {
		return "Utilisateur [idU=" + idU + ", idAdmin=" + idAdmin + ", login=" + login + ", password=" + password
				+ ", b=" + b + ", role=" + role + ", tele=" + tele + ", etat=" + etat + "]";
	}
	
    
	
	
}
