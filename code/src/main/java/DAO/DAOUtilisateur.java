package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.*;
import tools.DBInteraction;

public class DAOUtilisateur {
        public boolean CreeCompte(Utilisateur u) throws ClassNotFoundException, SQLException
        {
        	DBInteraction.connect();
        	int nb = DBInteraction.Maj("insert into utilisateur values(null,"+u.getIdAdmin()+","+u.getIdB()+",'"+u.getLogin()+"','"+u.getPassword()+"',"+u.isEtat()+",'"+u.getRole()+"','"+u.getTele()+"','"+u.getEmail()+"')");
        	//DBInteraction.Maj("update utilisateur set etat = 0 where idU = "+u.getIdU());
        	if(nb != 0)
        	{
        		return true;
        	}
        	DBInteraction.disconnect();
        	return false;
        }
        public Utilisateur authentifie(Utilisateur u) throws SQLException, ClassNotFoundException
        {
        	Utilisateur u1 = null;
        	DBInteraction.connect();
        	ResultSet rs = DBInteraction.Select("select * from utilisateur where login = '"+u.getLogin()+"' and password = '"+u.getPassword()+"'");
        	if(rs.next())
        	{
        		
        		int idU = rs.getInt(1);
        		int idA = rs.getInt(2);
        		int idB = rs.getInt(3);
        		String log = rs.getString(4);
        		String pass = rs.getString(5);
        		boolean etata = rs.getBoolean(6);
        		String rol = rs.getString(7);
        		String tele = rs.getString(8);
        		ResultSet r = DBInteraction.Select("select * from bureau where idB = "+u1.getIdB());
        		String loc;
        		Bureau b = null;
        		if(r.next())
        		{
        			loc = r.getString("loc");
        			b = new Bureau(idB,loc);
        		}
        		u1 = new Utilisateur(idU, idA, log, pass, b, etata, rol, tele);
//        		u1 = new Utilisateur();
//        		u1.setIdU(rs.getInt(1));
//        		u1.setIdAdmin(rs.getInt(2));
//        		u1.setIdB(rs.getInt(3));
//        		u1.setLogin(rs.getString(4));
//        		u1.setPassword(rs.getString(5));
//        		u1.setEtat(rs.getBoolean(6));
//        		u1.setRole(rs.getString(7));
//        		u1.setTele(rs.getString(8));
//        		rs = DBInteraction.Select("select * from bureau where idB = "+u1.getIdB());
//        		Bureau b = new Bureau();
//        		b.setIdB(rs.getInt(1));
//        		b.setLoc(rs.getString(2));
//        		u1.setB(b);;
        	}
        	DBInteraction.disconnect();
        	return u1;
         }
        public Utilisateur authentifie(String login,String password) throws SQLException, ClassNotFoundException
        {
        	Utilisateur u1 = null;
        	DBInteraction.connect();
        	ResultSet rs = DBInteraction.Select("select * from utilisateur where login = '"+login+"' and password = '"+password+"'");
        	if(rs.next())
        	{
        		u1 = new Utilisateur();
        		u1.setIdU(rs.getInt(1));
        		u1.setIdAdmin(rs.getInt(2));
        		u1.setIdB(rs.getInt(3));
        		u1.setLogin(rs.getString(4));
        		u1.setPassword(rs.getString(5));
        		u1.setEtat(rs.getBoolean(6));
        		u1.setRole(rs.getString(7));
        		u1.setTele(rs.getString(8));
        		u1.setEmail(rs.getString(9));
        	}
        	DBInteraction.disconnect();
        	return u1;
         }
        public Map InfoCompte(Utilisateur u) throws ClassNotFoundException, SQLException
        {
        	Map<String,Object> m = new HashMap<>();        	
        	DBInteraction.connect();
        	ResultSet rs = DBInteraction.Select("select * from utilisateur where idu = "+u.getIdU());
        	int idB = 0;
        	if(rs.next())
        	{
        	    idB = rs.getInt("idB");
        		m.put("idU", rs.getInt("idU"));
				m.put("idA", rs.getInt("idA"));
				m.put("idB", rs.getInt("idB"));
				m.put("login", rs.getString("login"));
				m.put("password", rs.getString("password"));
				m.put("role", rs.getString("role"));
				m.put("tele", rs.getString("tele"));
        	}
        	rs = DBInteraction.Select("select * from bureau where idB = "+idB);
        	if(rs.next())
        	{
        		m.put("loc", rs.getString("loc"));
        	}
        	DBInteraction.disconnect();
        	return m;
        }
        public float ConsulteGaz() throws ClassNotFoundException, SQLException
        {
        	float value = (float) 0.0;
        	Gaz gaz = new Gaz();
        	value = gaz.getValue();
        	return value;
        }
        public float ConsulteHumidite() throws ClassNotFoundException, SQLException
        {
        	float value = (float) 0.0;
        	Humidite h = new Humidite();
        	value = h.getValue();
        	return value;
        }
        public float ConsulteFumee() throws ClassNotFoundException, SQLException
        {
        	float value = (float) 0.0;
        	Fumee f = new Fumee();
        	value = f.getValue();
        	return value;
        }
        public List<Historique> Historique(Utilisateur u,String d1,String d2) throws ClassNotFoundException, SQLException
        {
        	List<Historique> l = new ArrayList<>();
        	DBInteraction.connect();
        	//to_char("+d2+",'yyyy-mm-dd') )
        	//order by date asc
        	//+"and ( date between "+d1+" and "+d2+" ) "
        	//select * from capteur where idB = 12 and date BETWEEN '2002-07-29 00:00:00' AND '2023-07-29 00:00:00'; valide
        	//select * from capteur where idB = "+u.getIdB()+" and date BETWEEN DATE_FORMAT('"+d1+"', '%Y-%m-%d 00:00:00') AND DATE_FORMAT('"+d2+"', '%Y-%m-%d 00:00:00') non valide
        	//select * from capteur where idB = 12 and date BETWEEN date_format('2002/07/29', '%Y-%m-%d 00:00:00') AND '2024-07-29 00:00:00' 
        	ResultSet rs = DBInteraction.Select("select * from historique where idB = "+u.getIdB()+" and date BETWEEN date_format('"+d1+"', '%Y-%m-%d 00:00:00') AND date_format('"+d2+"', '%Y-%m-%d 00:00:00')");
        	while(rs.next())
        	{
        	    float valeurHumidite = (float)rs.getFloat(1);
        	    float valeurGaz = (float)rs.getFloat(2);
        	    float valeurFumee = (float)rs.getFloat(3);
        	    int idB = rs.getInt(4);
        	    String date = rs.getString(5);
        	    SSecurite ssec = new SSecurite();
        	    String statuHumidite;
            	boolean bHumidite = ssec.humiditeIsValide(valeurHumidite);
            	if(bHumidite)
            	{
            		statuHumidite = "Etata de Humidite Normal";
            	}
            	else
            	{
            		statuHumidite = "Etata de Humidite Anormale";
            	}
        	    String statuGaz;
        	    boolean bGAz = ssec.gazIsValide(valeurGaz);
            	if(bGAz)
            	{
            		statuGaz = "Etata de Gaz Normal";
            	}
            	else
            	{
            		statuGaz = "Etata de Gaz Anormale";
            	}
        	    String statuFumee;
        	    boolean bFumee = ssec.fumeeIsValide(valeurFumee);
            	if(bFumee)
            	{
            		statuFumee = "Etata de Fumee Normal";
            	}
            	else
            	{
            		statuFumee = "Etata de Fumee Anormale";
            	}
        	    Historique h = new Historique(valeurHumidite, valeurGaz, valeurFumee, idB, date,statuHumidite,statuGaz,statuFumee);
        		l.add(h);
        	}
        	DBInteraction.disconnect();
        	return l;
        }
        public List<Historique> AllHistorique(Utilisateur u) throws ClassNotFoundException, SQLException
        {
        	List<Historique> l = new ArrayList<>();
        	DBInteraction.connect();
        	//to_char("+d2+",'yyyy-mm-dd') )
        	//order by date asc
        	//+"and ( date between "+d1+" and "+d2+" ) "
        	ResultSet rs = DBInteraction.Select("select * from historique where idB = "+u.getIdB()+" order by 5 desc");
        	while(rs.next())
        	{
        	    float valeurHumidite = (float)rs.getFloat(1);
        	    float valeurGaz = (float)rs.getFloat(2);
        	    float valeurFumee = (float)rs.getFloat(3);
        	    int idB = rs.getInt(4);
        	    String date = rs.getString(5);
        	    SSecurite ssec = new SSecurite();
        	    String statuHumidite;
            	boolean bHumidite = ssec.humiditeIsValide(valeurHumidite);
            	if(bHumidite)
            	{
            		statuHumidite = "Etata de Humidite Normal";
            	}
            	else
            	{
            		statuHumidite = "Etata de Humidite Anormale";
            	}
        	    String statuGaz;
        	    boolean bGAz = ssec.gazIsValide(valeurGaz);
            	if(bGAz)
            	{
            		statuGaz = "Etata de Gaz Normal";
            	}
            	else
            	{
            		statuGaz = "Etata de Gaz Anormale";
            	}
        	    String statuFumee;
        	    boolean bFumee = ssec.fumeeIsValide(valeurFumee);
            	if(bFumee)
            	{
            		statuFumee = "Etata de Fumee Normal";
            	}
            	else
            	{
            		statuFumee = "Etata de Fumee Anormale";
            	}
        	    Historique h = new Historique(valeurHumidite, valeurGaz, valeurFumee, idB, date,statuHumidite,statuGaz,statuFumee);
        		l.add(h);
        	}
        	DBInteraction.disconnect();
        	return l;
        }
        public int ModifierCompte(int idU,Utilisateur u) throws ClassNotFoundException, SQLException
        {
        	DBInteraction.connect();
        	int nbr = DBInteraction.Maj("Update utilisateur set idA="+u.getIdAdmin()+",idB="+u.getIdB()+",login='"+u.getLogin()+"',password='"+u.getPassword()+"',etat="+u.isEtat()+",role='"+u.getRole()+"',tele='"+u.getTele()+"',email='"+u.getEmail()+"' where idU = "+idU);
        	DBInteraction.disconnect();
        	return nbr;
        }
        public int supprime(int idU) throws ClassNotFoundException, SQLException
        {
        	int nb;
        	DBInteraction.connect();
        	nb = DBInteraction.Maj("delete from utilisateur where idU = "+idU);
        	DBInteraction.disconnect();
        	return nb;
        }
        public List<Utilisateur> AllUtilisateur(Utilisateur u) throws ClassNotFoundException, SQLException
        {
        	List l = new ArrayList<>();
        	DBInteraction.connect();
        	ResultSet rs = DBInteraction.Select("select * from utilisateur where idA = "+u.getIdU());
        	while(rs.next())
        	{
        		Utilisateur u1 = new Utilisateur();
        		u1.setIdU(rs.getInt(1));
        		u1.setIdAdmin(rs.getInt(2));
        		u1.setIdB(rs.getInt(3));
        		u1.setLogin(rs.getString(4));
        		u1.setPassword(rs.getString(5));
        		u1.setEtat(rs.getBoolean(6));
        		u1.setRole(rs.getString(7));
        		u1.setTele(rs.getString(8));
        		u1.setEmail(rs.getString(9));
        		l.add(u1);  
        	}
        	DBInteraction.disconnect();
        	return l;
        }
        public Utilisateur getAdmin(Utilisateur u) throws ClassNotFoundException, SQLException
        {
        	Utilisateur ut = null;
        	DBInteraction.connect();
        	ResultSet rs = DBInteraction.Select("select * from utilisateur where idU = "+u.getIdAdmin());
        	while(rs.next())
        	{
        	    ut = new Utilisateur();
        		ut.setIdU(rs.getInt(1));
        		ut.setIdAdmin(rs.getInt(2));
        		ut.setIdB(rs.getInt(3));
        		ut.setLogin(rs.getString(4));
        		ut.setPassword(rs.getString(5));
        		ut.setEtat(rs.getBoolean(6));
        		ut.setRole(rs.getString(7));
        		ut.setTele(rs.getString(8)); 
        	}
        	DBInteraction.disconnect();
        	return ut;
        }
}
