package DAO;

import java.sql.SQLException;

import Model.Utilisateur;
import tools.DBInteraction;

public class DAOAdmin extends DAOUtilisateur{
	public int VerifieCompte(Utilisateur u) throws ClassNotFoundException, SQLException
	{
		DBInteraction.connect();
		int nb = DBInteraction.Maj("update utilisateur set etat = 1 where login='"+u.getLogin()+"' and password = '"+u.getPassword()+"'");
		DBInteraction.disconnect();
		return nb;
	}
	public int VerifieCompte(int idU) throws ClassNotFoundException, SQLException
	{
		DBInteraction.connect();
		int nb = DBInteraction.Maj("update utilisateur set etat = 1 where idU = "+idU);
		DBInteraction.disconnect();
		return nb;
	}
}
