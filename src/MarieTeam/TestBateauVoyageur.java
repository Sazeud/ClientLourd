package MarieTeam;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * <b>La classe TestBateau va permettre la r�alisation de tests unitaires sur la classe BateauVoyageur.</b>
 * <p>Il va �tre test� chaque m�thode une par une de la classe BateauVoyageur.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestBateauVoyageur extends TestCase {

	/**
	 * <b>La m�thode testToString() qui permet de r�aliser le test de la m�thode toString de la classe BateauVoyageur</b>
	 * <p>Cr�ation d'un bateau voyageur afin de pouvoir r�cup�rer ses attributs sous forme de chaine gr�ce � la m�thode</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la m�thode avec la chaine attendue.</p>
	 */
	public void testToString() {
		//Cr�ation d'une liste d'�quipements
		ArrayList<Equipement> listeEquip = new ArrayList<>();
		
		//Cr�ation d'objets �quipement
		Equipement e1 = new Equipement(1, "Bar");
		Equipement e2 = new Equipement(2, "Piscine");
		
		//Ajout des �quipement dans la liste des �quipements
		listeEquip.add(e1);
		listeEquip.add(e2);
		
		//Cr�ation d'un objet bateau voyageur
		BateauVoyageur batVoy = new BateauVoyageur(1, "BatTest", 36, 12, 16, "E:\bat.jpg", listeEquip);
		
		//Cr�ation des chaines attendue et obtenue avec la m�thode toString
		String chaineObtenue = batVoy.toString();
		String chaineAttendue = "Nom du bateau : BatTest\nLongueur : 36.0 m�tres\nLargeur : 12.0 m�tres\nVitesse : 16.0 noeuds\nListe des �quipements du bateau : \n-Bar\n-Piscine";
		
		//Test de la m�thode toString
		assertEquals(chaineAttendue, chaineObtenue);
	}
	
	/**
	 * <b>La m�thode testGetImageBatVoy() qui permet de r�aliser le test de la m�thode getImageBatVoy() de la classe BateauVoyageur</b>
	 * <p>Cr�ation d'un bateau voyageur afin de pouvoir r�cup�rer le chemin de son image gr�ce � la m�thode.</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la m�thode avec la chaine attendue.</p>
	 */
	public void testGetImageBatVoy() {
		ArrayList<Equipement> listeEquip = new ArrayList<>();
		
		//Cr�ation d'un objet Bateau Voyageur
		BateauVoyageur batVoy = new BateauVoyageur(1, "BatTest", 36, 12, 16, "E:\bat.jpg", listeEquip);
		
		//Cr�ation des chaines attendue et obtenue par la m�thode getImageBatVoy
		String chaineObtenue = batVoy.getImageBatVoy();
		String chaineAttendue = "E:\bat.jpg";
		
		//Test de la m�thode getImageBatVoy
		assertEquals(chaineAttendue, chaineObtenue);
	}
}
