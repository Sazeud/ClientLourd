package MarieTeam;

import static org.junit.Assert.*;
import java.lang.Object;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * <b>La classe TestPasserrelle va permettre la r�alisation de tests unitaires sur la classe Passerrelle.</b>
 * <p>Il va �tre test� chaque m�thode une par une de la classe Passerrelle.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestPasserrelle extends TestCase {
	
	/**
	 * <b>La m�thode testChargerLesEquipements va permettre de tester la m�thode chargerLesEquipements() de Passerrelle.</b>
	 * <p>On cr�e une liste des �quipements d'un bateau gr�ce � la m�thode</p>
	 * 
	 * <p>L'assertEquals permet de comparer la liste obtenu avec la m�thode avec la liste attendue.</p>
	 */
	public void testChargerLesEquipements() {
		try {
			//Cr�ation des listes d'�quipements
			ArrayList<Equipement> lesEquipTest = Passerrelle.chargerLesEquipements(2);
			ArrayList<Equipement> lesEquipAttendue = new ArrayList<>();
			
			//Cr�ation des �quipements pour la liste attendue
			Equipement e1 = new Equipement(1,"Acc�s Handicap�");
			Equipement e2 = new Equipement(2,"Bar");
			Equipement e3 = new Equipement(4,"Salon Video");
			Equipement e4 = new Equipement(5,"Piscine");
			Equipement e5 = new Equipement(6,"Spa");
			
			//Chargement de la liste attendue
			lesEquipAttendue.add(e1);
			lesEquipAttendue.add(e2);
			lesEquipAttendue.add(e3);
			lesEquipAttendue.add(e4);
			lesEquipAttendue.add(e5);
			
			//Test de la classe chargerLesEquipements
			assertEquals(lesEquipAttendue, lesEquipTest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>La m�thode testChargerToutLesEquipements va permettre de tester la m�thode chargerToutLesEquipements() de Passerrelle.</b>
	 * <p>On cr�e une liste de tout les �quipements gr�ce � la m�thode.</p>
	 * 
	 * <p>L'assertEquals permet de comparer la liste obtenu avec la m�thode ainsi que la liste attendue.</p>
	 */
	public void testChargerToutLesEquip() {
		try {
			//Cr�ation des listes d'�quipements
			ArrayList<Equipement> lesEquipTest = Passerrelle.chargerToutLesEquip();
			ArrayList<Equipement> lesEquipAttendue = new ArrayList<>();
			
			//Cr�ation des �quipements pour la liste attendue
			Equipement e1 = new Equipement(1, "Acc�s Handicap�");
			Equipement e2 = new Equipement(2, "Bar");
			Equipement e3 = new Equipement(3, "Pont promenade");
			Equipement e4 = new Equipement(4, "Salon Video");
			Equipement e5 = new Equipement(5, "Piscine");
			Equipement e6 = new Equipement(6, "Spa");
			Equipement e7 = new Equipement(7, "Salle de cin�ma");
			
			//Chargement de la liste attendue
			lesEquipAttendue.add(e1);
			lesEquipAttendue.add(e2);
			lesEquipAttendue.add(e3);
			lesEquipAttendue.add(e4);
			lesEquipAttendue.add(e5);
			lesEquipAttendue.add(e6);
			lesEquipAttendue.add(e7);
			
			//Test de la classe chargerLesEquipements
			assertEquals(lesEquipAttendue, lesEquipTest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>La m�thode testChargerLesBateauxVoyageur va permettre de tester la m�thode chargerLesBateauxVoyageur() de Passerrelle.</b>
	 * <p>On cr�e une liste de tous les bateaux voyageurs gr�ce � la m�thode.</p>
	 * 
	 * <p>L'assertEquals permet de comparer la liste obtenu avec la m�thode ainsi que la liste attendue.</p>
	 */
	public void testChargerLesBateauxVoyageur() {
		try {
			//Cr�ation des listes d'�quipements
			ArrayList<BateauVoyageur> lesBatVoyTest = Passerrelle.chargerLesBateauxVoyageurs();
			ArrayList<BateauVoyageur> lesBatVoyAttendue = new ArrayList<>();
			
			//Cr�ation des �quipements pour les bateaux voyageurs
			Equipement e1 = new Equipement(1, "Acc�s Handicap�");
			Equipement e2 = new Equipement(2, "Bar");
			Equipement e3 = new Equipement(3, "Pont promenade");
			Equipement e4 = new Equipement(4, "Salon Video");
			Equipement e5 = new Equipement(5, "Piscine");
			Equipement e6 = new Equipement(6, "Spa");
			Equipement e7 = new Equipement(7, "Salle de cin�ma");
			
			//Cr�ation collections �quipements
			ArrayList<Equipement> equipB1 = new ArrayList<>();
			ArrayList<Equipement> equipB2 = new ArrayList<>();
			ArrayList<Equipement> equipB3 = new ArrayList<>();
			ArrayList<Equipement> equipB4 = new ArrayList<>();
			ArrayList<Equipement> equipB5 = new ArrayList<>();
			
			equipB1.add(e1);
			equipB1.add(e2);
			equipB1.add(e3);
			
			equipB2.add(e1);
			equipB2.add(e2);
			equipB2.add(e4);
			equipB2.add(e5);
			equipB2.add(e6);
			
			equipB3.add(e1);
			equipB3.add(e3);
			equipB3.add(e5);
			equipB3.add(e6);
			
			equipB4.add(e1);
			equipB4.add(e2);
			equipB4.add(e3);
			equipB4.add(e4);
			
			equipB5.add(e1);
			equipB5.add(e3);
			equipB5.add(e5);
			equipB5.add(e7);
			
			//Cr�ation des bateaux voyageurs
			BateauVoyageur b1 = new BateauVoyageur(1, "Kor' Ant", 31.8, 9.4, 22, "E:\\Eclipse\\PPE-Marieteam\\KorAnt.jpg", equipB1);
			BateauVoyageur b2 = new BateauVoyageur(2, "Ar Solen", 34.8, 16, 16, "E:\\Eclipse\\PPE-Marieteam\\ArSolen.jpg", equipB2);
			BateauVoyageur b3 = new BateauVoyageur(3, "Al'xi", 25, 7, 16, "E:\\Eclipse\\PPE-Marieteam\\Alxi.jpg", equipB3);
			BateauVoyageur b4 = new BateauVoyageur(4, "Luce isle", 37.2, 8.6, 26, "E:\\Eclipse\\PPE-Marieteam\\LuceIsle.jpg", equipB4);
			BateauVoyageur b5 = new BateauVoyageur(5, "Ma�llys", 38, 10, 28, "E:\\Eclipse\\PPE-Marieteam\\Maellys.jpg", equipB5);
			
			//Chargement de la liste attendue
			lesBatVoyAttendue.add(b1);
			lesBatVoyAttendue.add(b2);
			lesBatVoyAttendue.add(b3);
			lesBatVoyAttendue.add(b4);
			lesBatVoyAttendue.add(b5);
			
			//Test de la classe chargerLesEquipements
			assertEquals(lesBatVoyAttendue, lesBatVoyTest);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
