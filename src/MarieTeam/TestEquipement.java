package MarieTeam;

import junit.framework.TestCase;

/**
 * <b>La classe TestEquipement va permettre la réalisation de tests unitaires sur la classe Equipement.</b>
 * <p>Il va être testé chaque méthode une par une de la classe Equipement.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestEquipement extends TestCase {
	
	/**
	 * <b>La méthode testToString() qui permet de réaliser le test de la méthode toString de la classe Equipement</b>
	 * <p>Création d'un équipement afin de pouvoir récupérer son libellé grâce à la méthode</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la méthode avec la chaine attendue.</p>
	 */
	public void testToString() {
		//Création d'un équipement
		Equipement equip = new Equipement(1, "Accès handicapé");
		
		//Création chaine attendue et chaine obtenue
		String chaineObtenue = equip.toString();
		String chaineAttendue = "Accès handicapé";
		
		//Test de la méthode toString
		assertEquals(chaineAttendue, chaineObtenue);
	}
}
