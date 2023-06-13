package Model;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Utilisateur{
     List<Utilisateur> list;

	public Admin() {
		list = new ArrayList<Utilisateur>();
	}
	public Admin(int idU, int idAdmin, int idBureau, String login, String password, int idA,boolean etat,String role,String tele, List<Utilisateur> list) {
		super(idU, idAdmin, idBureau, login, password, etat, password, password);
		this.list = list;
	}
	public Admin(String login, String password,String tele,List<Utilisateur> list) {
		super(login, password,tele);
		this.list = list;
	}
	public Admin(String login, String password,String tele) {
		super(login, password,tele);
	}
    public Admin(Admin a)
    {
    	super(a);
    	list = a.list;
    }
	public List<Utilisateur> getList() {
		return list;
	}
	public void setList(List<Utilisateur> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Admin [ list=" + list + ", idU=" + idU + ", idAdmin=" + idAdmin + ", idBureau="
				+ b.getIdB() + ", login=" + login + ", password=" + password + "]";
	}
	
	
     
     
}
