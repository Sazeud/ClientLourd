package MarieTeam;

import junit.framework.TestCase;

/**
 * <b>La classe TestBateau va permettre la réalisation de tests unitaires sur la classe Bateau.</b>
 * <p>Il va être testé chaque méthode une par une de la classe Bateau.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestBateau extends TestCase {
	
	/**
	 * <b>La méthode testToString() qui permet de réaliser le test de la méthode toString de la classe Bateau</b>
	 * <p>Création d'un bateau afin de pouvoir récupérer ses attributs sous forme de chaine grâce à la méthode</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la méthode avec la chaine attendue.</p>
	 */
	public void testToString() {
		Bateau bateau = new Bateau(1, "KorAnt", 24, 12);
		String chaineBat = bateau.toString();
		String chaineVoulu = "Nom du bateau : KorAnt\nLongueur : 24.0 mètres\nLargeur : 12.0 mètres";
		assertEquals(chaineVoulu, chaineBat);
	}
}
