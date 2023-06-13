package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import DAO.DAOAdmin;
import DAO.DAOUtilisateur;
import Model.Admin;
import Model.Bureau;
import Model.Historique;
import Model.Utilisateur;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------------- test Classe Utilisateur -------------------------");
        Utilisateur u = new Utilisateur(11, 12, 13, "oussama", "123", "dd", "cc");
        System.out.println(u.toString());
        Admin a = new Admin(1, 2, 3, "ousss", "nayaya", 5, false, "admin", "0988", null);
        System.out.println(a);
        System.out.println(a.getIdU());
        System.out.println(a.toString());
        System.out.println(a.getList());
        Bureau bureau = new Bureau(1122,"casa blanca");
        System.out.println("Bureau = "+bureau);
        Utilisateur uttt = new Utilisateur(22, 3, "othman", "123", bureau, false, "admin","0666554410");
        System.out.println("->"+uttt);
        System.out.println("Localisation du bureau de "+uttt.getLogin()+" est : "+uttt.getB().getLoc());
        System.out.println("  ------------------ test methode Authentified ------------------- ");
        DAOUtilisateur dao = new DAOUtilisateur(); 

        Utilisateur u1 = null;
        try {
			u1 = dao.authentifie("oussama","naya");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("->"+u1+" | "+u1.getB());
       
        Utilisateur ut = new Utilisateur(4,22,153,"hakitch","jaja", "ff", "rrt");
        System.out.println(ut);
//        try {
//			boolean b = dao.CreeCompte(ut);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        System.out.println("----------------------- test creeCompte ----------------");
        DAOUtilisateur daoU0 = new DAOUtilisateur();
        Utilisateur ut1 = new Utilisateur(0,1122,12,"uu     nnnnnnnnnnnnnnnuuuu","1234ae",false,"ut","887799");
        boolean b = false;
        try {
			b = daoU0.CreeCompte(ut1);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println(b);
        System.out.println("-------------test VerifiCompte Admin --------------");
        DAOAdmin a1 = new DAOAdmin();
        Utilisateur ut2 = new Utilisateur(0,88,22,"uu     nnnnnnnnnnnnnnnuuuu","1234ae",false,"ut","887799");

        int b1 = 0;
        try {
			b1 = a1.VerifieCompte(ut1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        System.out.println(b1);
//        try {
//			boolean b =  dao.CreeCompte(ut);
//			System.out.println(b);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        DAOAdmin a1 = new DAOAdmin();
//        try {
//			a1.VerifieCompte(ut);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        System.out.println("  ----------------test InfoPage--------------------");
        DAOUtilisateur daoU1 = new DAOUtilisateur();
        Utilisateur u11 = new Utilisateur(1122, 1, 2, "ok", "bb", "ll", "jjj");
        try {
			Map map = daoU1.InfoCompte(u11);
			Set ke = map.keySet();
			Collection c = map.values();
			System.out.println("keys => "+ke);
			System.out.println("value => "+c);
			
			for(Object  key : map.keySet())
			{
				System.out.println("=> "+key+" = "+map.get(key));
				//System.out.println(map.get("loc"));
			}
//			for(String s : ke)
//			{
//				
//			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("--------------------- test Historique -----------------");
        DAOUtilisateur daoU2 = new DAOUtilisateur();
        Utilisateur u12 = new Utilisateur(1122, 1, 12, "ok", "bb", "k", "n");
        //System.out.println(u12.getIdB());
        List<Historique> l;
        System.out.println("-->Historique(d1,d2)");
        try {
			// List<String> l = daoU2.Historique(u12, new Date(2023-05-10),new Date(2002-01-03) );
			//List<String> l = daoU2.AllHistorique(u12.getIdB());
        	//Attention : new Date(2024, 7, 29) cette appel est fausse (parfois une seule parametre est valide sera implique l'execution de le programme;
        	l = daoU2.Historique(u12,"2002/7/29","2023/5/12");
        	for(Historique h : l)
			 {
				 System.out.println(h);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("-->AllHistorique()");
               try {
				l = daoU2.AllHistorique(u12);
		        	for(Historique h : l)
					 {
						 System.out.println(h);
					 }
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

        System.out.println("--------------------------- test ModifierCompte -------------------------------");
        DAOUtilisateur daoU3 = new DAOUtilisateur();
        Utilisateur u13 = new Utilisateur("haha","tata","0555657088");
        try {
			int nb = daoU3.ModifierCompte(1126, u13);
			System.out.println("le nombre de lignes modifie est : "+nb);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("------------------------ test SupprimeCompte ----------------------");
//        DAOUtilisateur daoU4 = new DAOUtilisateur();
//        Utilisateur u14 = new Utilisateur(1137,1122,12,"uuuuuu","1234ae",false,"ut","887799");
//        try {
//			int nb = daoU4.supprime(u14);
//			System.out.println("le nombre de lignes supprime est : "+nb);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        System.out.println("------------------------- test getAdmin ");
        DAOUtilisateur daoU4 = new DAOUtilisateur();
        Bureau bureau2 = new Bureau(1122,"casa blanca");
        System.out.println("Bureau = "+bureau);
        Utilisateur u14 = new Utilisateur(1144, 1122, "othman", "123", bureau, false, "admin","0666554410");
        try {
			System.out.println("-->"+daoU4.getAdmin(u14));
			System.out.println("Login de l'admin : "+daoU4.getAdmin(u14).getLogin());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("------------ test CreeCompte Admin -----------");
        Utilisateur u15 = new Utilisateur(1144, 1122,556, "adam", "123",true, "utilisateur","0666554410");
        DAOUtilisateur daoU5 = new DAOUtilisateur();
        boolean nb = false ;
        try {
			nb = daoU5.CreeCompte(u15);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("la modification est : "+nb);
	 }
}
