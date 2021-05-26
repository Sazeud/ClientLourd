package MarieTeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

/**
 * <b>La classe TestJeuEnregistrement va permettre la réalisation de tests unitaires sur la classe JeuEnregistrement.</b>
 * <p>Il va être testé chaque méthode une par une de la classe JeuEnregistrement.</p>
 * 
 * @author Florian Petillon
 *
 */
public class TestJeuEnregistrement extends TestCase {

	/**
	 * <b>La méthode testSuivant va permettre de tester la méthode suivant de JeuEnregistrement.</b>
	 * <p>On crée un jeu d'enregistrement grâce au constructeur de JeuEnregistrement avec la requête SQL : SELECT nom FROM bateau</p>
	 * <p>Puis on crée nous meme un ResultSet en se connectant à la bdd, etc.</p>
	 * 
	 * <p>On utilise la fonction suivant() de JeuEnregistrement afin de déplacer le curseur sur la première ligne.
	 * De même avec la fonction next(). </p>
	 * 
	 * <p>Dans l'assertEquals on réutilise la méthode suivant() et next() et on compare si cela est identique.</p>
	 * 
	 * <p>On refait de même avec la commande SQL : SELECT nom FROM bateau WHERE idBateau = 1
	 * qui ne retourne qu'une ligne.</p>
	 */
	public void testSuivant() {
		try {
			//Test dans le cas d'une requête SQL qui retourne plusieurs lignes
			//Création d'un jeu d'enregistrement
			JeuEnregistrement jeuTest = new JeuEnregistrement("SELECT nom FROM bateau");
			
			//Création d'un resultset pour les tests
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
			Statement stm = connexion.createStatement();
			ResultSet result = stm.executeQuery("SELECT nom FROM bateau");
			
			//Test méthode suivant
			result.next();
			jeuTest.suivant();
			assertEquals(result.next(), jeuTest.suivant());
			
			//Test dans le cas d'une requête SQL qui ne retourne qu'une ligne
			//Création d'un deuxième jeu de test
			jeuTest = new JeuEnregistrement("SELECT nom FROM bateau WHERE idBateau = 1");
			
			//Création d'un autre resultset pour les tests
			result = stm.executeQuery("SELECT nom FROM bateau WHERE idBateau = 1");
			
			//Test méthode suivant
			result.next();
			jeuTest.suivant();
			assertEquals(result.next(), jeuTest.suivant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>La méthode testGetResult va tester la méthode getResult de la classe JeuEnregistrement.</b>
	 * <p>On crée deux resultset et on compare avec les méthode de JeuEnregistrement et JUnit.</p>
	 * 
	 * <p>L'assertEquals permet de savoir si le résultat retourné est le même.</p>
	 */
	public void testGetResult() {
		try {
			//Création d'un jeu d'enregistrement
			JeuEnregistrement jeuTest = new JeuEnregistrement("SELECT nom FROM bateau WHERE idBateau = 3");
			
			//Création d'un resultset pour les tests
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
			Statement stm = connexion.createStatement();
			ResultSet result = stm.executeQuery("SELECT nom FROM bateau WHERE idBateau = 3");
			
			jeuTest.suivant();
			result.next();
			
			//Test de résultat
			assertEquals(result.getString("nom"), jeuTest.getResult().getString("nom"));
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
