package MarieTeam;

import junit.framework.TestCase;

/**
 * <b>La classe TestEquipement va permettre la r�alisation de tests unitaires sur la classe Equipement.</b>
 * <p>Il va �tre test� chaque m�thode une par une de la classe Equipement.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestEquipement extends TestCase {
	
	/**
	 * <b>La m�thode testToString() qui permet de r�aliser le test de la m�thode toString de la classe Equipement</b>
	 * <p>Cr�ation d'un �quipement afin de pouvoir r�cup�rer son libell� gr�ce � la m�thode</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la m�thode avec la chaine attendue.</p>
	 */
	public void testToString() {
		//Cr�ation d'un �quipement
		Equipement equip = new Equipement(1, "Acc�s handicap�");
		
		//Cr�ation chaine attendue et chaine obtenue
		String chaineObtenue = equip.toString();
		String chaineAttendue = "Acc�s handicap�";
		
		//Test de la m�thode toString
		assertEquals(chaineAttendue, chaineObtenue);
	}
}
