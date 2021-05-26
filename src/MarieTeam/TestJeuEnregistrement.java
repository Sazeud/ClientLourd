package MarieTeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

/**
 * <b>La classe TestJeuEnregistrement va permettre la r�alisation de tests unitaires sur la classe JeuEnregistrement.</b>
 * <p>Il va �tre test� chaque m�thode une par une de la classe JeuEnregistrement.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestJeuEnregistrement extends TestCase {

	/**
	 * <b>La m�thode testSuivant va permettre de tester la m�thode suivant de JeuEnregistrement.</b>
	 * <p>On cr�e un jeu d'enregistrement gr�ce au constructeur de JeuEnregistrement avec la requ�te SQL : SELECT nom FROM bateau</p>
	 * <p>Puis on cr�e nous meme un ResultSet en se connectant � la bdd, etc.</p>
	 * 
	 * <p>On utilise la fonction suivant() de JeuEnregistrement afin de d�placer le curseur sur la premi�re ligne.
	 * De m�me avec la fonction next(). </p>
	 * 
	 * <p>Dans l'assertEquals on r�utilise la m�thode suivant() et next() et on compare si cela est identique.</p>
	 * 
	 * <p>On refait de m�me avec la commande SQL : SELECT nom FROM bateau WHERE idBateau = 1
	 * qui ne retourne qu'une ligne.</p>
	 */
	public void testSuivant() {
		try {
			//Test dans le cas d'une requ�te SQL qui retourne plusieurs lignes
			//Cr�ation d'un jeu d'enregistrement
			JeuEnregistrement jeuTest = new JeuEnregistrement("SELECT nom FROM bateau");
			
			//Cr�ation d'un resultset pour les tests
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
			Statement stm = connexion.createStatement();
			ResultSet result = stm.executeQuery("SELECT nom FROM bateau");
			
			//Test m�thode suivant
			result.next();
			jeuTest.suivant();
			assertEquals(result.next(), jeuTest.suivant());
			
			//Test dans le cas d'une requ�te SQL qui ne retourne qu'une ligne
			//Cr�ation d'un deuxi�me jeu de test
			jeuTest = new JeuEnregistrement("SELECT nom FROM bateau WHERE idBateau = 1");
			
			//Cr�ation d'un autre resultset pour les tests
			result = stm.executeQuery("SELECT nom FROM bateau WHERE idBateau = 1");
			
			//Test m�thode suivant
			result.next();
			jeuTest.suivant();
			assertEquals(result.next(), jeuTest.suivant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>La m�thode testGetResult va tester la m�thode getResult de la classe JeuEnregistrement.</b>
	 * <p>On cr�e deux resultset et on compare avec les m�thode de JeuEnregistrement et JUnit.</p>
	 * 
	 * <p>L'assertEquals permet de savoir si le r�sultat retourn� est le m�me.</p>
	 */
	public void testGetResult() {
		try {
			//Cr�ation d'un jeu d'enregistrement
			JeuEnregistrement jeuTest = new JeuEnregistrement("SELECT nom FROM bateau WHERE idBateau = 3");
			
			//Cr�ation d'un resultset pour les tests
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
			Statement stm = connexion.createStatement();
			ResultSet result = stm.executeQuery("SELECT nom FROM bateau WHERE idBateau = 3");
			
			jeuTest.suivant();
			result.next();
			
			//Test de r�sultat
			assertEquals(result.getString("nom"), jeuTest.getResult().getString("nom"));
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
