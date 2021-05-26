package MarieTeam;

import junit.framework.TestCase;

/**
 * <b>La classe TestBateau va permettre la r�alisation de tests unitaires sur la classe Bateau.</b>
 * <p>Il va �tre test� chaque m�thode une par une de la classe Bateau.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestBateau extends TestCase {
	
	/**
	 * <b>La m�thode testToString() qui permet de r�aliser le test de la m�thode toString de la classe Bateau</b>
	 * <p>Cr�ation d'un bateau afin de pouvoir r�cup�rer ses attributs sous forme de chaine gr�ce � la m�thode</p>
	 * 
	 * <p>AssertEquals permet de comparer la chaine obtenue avec la m�thode avec la chaine attendue.</p>
	 */
	public void testToString() {
		Bateau bateau = new Bateau(1, "KorAnt", 24, 12);
		String chaineBat = bateau.toString();
		String chaineVoulu = "Nom du bateau : KorAnt\nLongueur : 24.0 m�tres\nLargeur : 12.0 m�tres";
		assertEquals(chaineVoulu, chaineBat);
	}
}
