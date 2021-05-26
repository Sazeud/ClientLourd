package MarieTeam;

import java.util.ArrayList;
import java.sql.*;

/**
 * <b>La classe Passerrelle va permettre de charger les �quipements d'un bateau voyageur et les bateaux voyageurs dans des listes</b>
 * 
 * @see Equipement
 * @see BateauVoyageur
 * 
 * @author Florian Petillon
 *
 */
public class Passerrelle {
	
	/**
	 * Objet JeuEnregistrement qui contient le jeu de r�sultat de la requ�te pass�e en param�tre
	 * 
	 * @see JeuEnregistrement
	 * @see Passerrelle#chargerLesBateauxVoyageurs()
	 * @see Passerrelle#chargerLesEquipements(int)
	 * @see Passerrelle#chargerToutLesEquip()
	 */
	private static JeuEnregistrement jeu;
	
	/**
	 * Retourne une liste compos�e de tout les �quipements d'un bateau voyageur donn�.
	 * 
	 * @param unIdBateau
	 * Id du bateau voyageur dont les �quipements doivent �tre charg�s.
	 * @return Liste des �quipements du bateau voyageur donn�e.
	 * @throws SQLException En cas de probl�me de requ�te SQL.
	 */
	static ArrayList<Equipement> chargerLesEquipements(int unIdBateau) throws SQLException{
		ArrayList<Equipement> lesEquipements = new ArrayList<>();
		jeu = new JeuEnregistrement("SELECT id, lib FROM equipement as E, posseder as P, bateau as B WHERE P.idBat = " + unIdBateau + " AND B.idBateau = P.idBat AND P.idEquip = E.id;");
		while(jeu.suivant()) {
			int idEquip = jeu.getResult().getInt("id");
			String nomEquip = jeu.getResult().getString("lib");
			Equipement unEquip = new Equipement(idEquip, nomEquip);
			lesEquipements.add(unEquip);
		}
		return lesEquipements;
	}
	
	/**
	 * Retourne une liste de tout les �quipements disponible.
	 * 
	 * @return Liste de tout les �quipements possibles.
	 * @throws SQLException En cas de probl�me de requ�te SQL.
	 */
	static ArrayList<Equipement> chargerToutLesEquip() throws SQLException {
		ArrayList<Equipement> lesEquipements = new ArrayList<>();
		jeu = new JeuEnregistrement("SELECT * FROM equipement as E;");
		while(jeu.suivant()) {
			int idEquip = jeu.getResult().getInt("id");
			String nomEquip = jeu.getResult().getString("lib");
			Equipement unEquip = new Equipement(idEquip, nomEquip);
			lesEquipements.add(unEquip);
		}
		return lesEquipements;
	}
	
	/**
	 * Retourne une liste compos�e de tout les bateaux voyageurs.
	 * 
	 * @return Liste de tout les bateaux voyageurs.
	 * @throws SQLException En cas de probl�me de requ�te SQL
	 */
	static ArrayList<BateauVoyageur> chargerLesBateauxVoyageurs() throws SQLException{
		ArrayList<BateauVoyageur> lesBatVoy = new ArrayList<>();
		Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
		Statement stm = connexion.createStatement();
		ResultSet result = stm.executeQuery("SELECT idBateau, nom, longueur, largeur, vitesse, image FROM bateau WHERE type = 'v'");
		while(result.next()) {
			int idBat = result.getInt("idBateau");
			String nom = result.getString("nom");
			double longueur = result.getDouble("longueur");
			double largeur = result.getDouble("largeur");
			double vitesse = result.getDouble("vitesse");
			String image = result.getString("image");
			BateauVoyageur unBatVoy = new BateauVoyageur(idBat, nom, longueur, largeur, vitesse, image, chargerLesEquipements(idBat));
			lesBatVoy.add(unBatVoy);
		}
		return lesBatVoy;
	}
}
