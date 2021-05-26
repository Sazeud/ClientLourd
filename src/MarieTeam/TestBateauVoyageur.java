package MarieTeam;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * <b>La classe TestBateau va permettre la réalisation de tests unitaires sur la classe BateauVoyageur.</b>
 * <p>Il va être testé chaque méthode une par une de la classe BateauVoyageur.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestBateauVoyageur extends TestCase {

	/**
	 * <b>La méthode testToString() qui permet de réaliser le test de la méthode toString de la classe BateauVoyageur</b>
	 * <p>Création d'un bateau voyageur afin de pouvoir récupérer ses attributs sous forme de chaine grâce à la méthode</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la méthode avec la chaine attendue.</p>
	 */
	public void testToString() {
		//Création d'une liste d'équipements
		ArrayList<Equipement> listeEquip = new ArrayList<>();
		
		//Création d'objets équipement
		Equipement e1 = new Equipement(1, "Bar");
		Equipement e2 = new Equipement(2, "Piscine");
		
		//Ajout des équipement dans la liste des équipements
		listeEquip.add(e1);
		listeEquip.add(e2);
		
		//Création d'un objet bateau voyageur
		BateauVoyageur batVoy = new BateauVoyageur(1, "BatTest", 36, 12, 16, "E:\bat.jpg", listeEquip);
		
		//Création des chaines attendue et obtenue avec la méthode toString
		String chaineObtenue = batVoy.toString();
		String chaineAttendue = "Nom du bateau : BatTest\nLongueur : 36.0 mètres\nLargeur : 12.0 mètres\nVitesse : 16.0 noeuds\nListe des équipements du bateau : \n-Bar\n-Piscine";
		
		//Test de la méthode toString
		assertEquals(chaineAttendue, chaineObtenue);
	}
	
	/**
	 * <b>La méthode testGetImageBatVoy() qui permet de réaliser le test de la méthode getImageBatVoy() de la classe BateauVoyageur</b>
	 * <p>Création d'un bateau voyageur afin de pouvoir récupérer le chemin de son image grâce à la méthode.</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la méthode avec la chaine attendue.</p>
	 */
	public void testGetImageBatVoy() {
		ArrayList<Equipement> listeEquip = new ArrayList<>();
		
		//Création d'un objet Bateau Voyageur
		BateauVoyageur batVoy = new BateauVoyageur(1, "BatTest", 36, 12, 16, "E:\bat.jpg", listeEquip);
		
		//Création des chaines attendue et obtenue par la méthode getImageBatVoy
		String chaineObtenue = batVoy.getImageBatVoy();
		String chaineAttendue = "E:\bat.jpg";
		
		//Test de la méthode getImageBatVoy
		assertEquals(chaineAttendue, chaineObtenue);
	}
}
