package MarieTeam;

import java.sql.*;

/**
 * <b>La classe JeuEnregistrement va permettre d'obtenir un jeu d'enregistrement à partir d'une requête SQL donnée.</b>
 * <p>Un JeuEnregistrement est défini par :</p>
 * <ul>
 * <li>Un objet Connection</li>
 * <li>Un objet Statement</li>
 * <li>Un objet ResultSet</li>
 * </ul>
 * 
 * @author Florian Petillon
 *
 */
public class JeuEnregistrement {
	/**
	 * Objet Connection contenant la connexion établie à la base de données.
	 * 
	 * @see JeuEnregistrement#JeuEnregistrement(String)
	 */
	private Connection connexion;
	
	/**
	 * Objet Statement permettant d'éxecuter une requête SQL et de retourner un résultat.
	 * 
	 * @see JeuEnregistrement#JeuEnregistrement(String)
	 */
	private Statement stm;
	
	/**
	 * Objet ResultSet qui va contenir le résultat de la commande SQL.
	 * 
	 * @see JeuEnregistrement#JeuEnregistrement(String)
	 */
	private ResultSet result;
	
	/**
	 * Constructeur JeuEnregistrement
	 * 
	 * <p>Lors de la construction d'un objet JeuEnregistrement, on attributs à chacun la connexion, le statement ainsi que les resultats par rapport à la requête entrée en paramètre.
	 * 
	 * @param chaine 
	 * Requête SQL a réaliser.
	 * @throws SQLException En cas de problème de requête SQL.
	 */
	public JeuEnregistrement(String chaine) throws SQLException{
		this.connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
		this.stm = connexion.createStatement();
		this.result = stm.executeQuery(chaine);
	}
	
	/**
	 * Permet de déplacer le curseur et vérifier s'il y a encore des valeurs dans le ResultSet.
	 * 
	 * @return Si il y a encore des résultats ou non dans le ResultSet
	 * @throws SQLException En cas de problème de requête SQL.
	 */
	public boolean suivant() throws SQLException{
		boolean fin = true;
		if(!result.next()) {
			fin = false;
		}
		return fin;
	}
	
	/**
	 * Permet de récupérer le ResultSet pour pouvoir récupérer la valeur correspondant au curseur actuel.
	 * 
	 * @return ResultSet correspondant au positionnement du curseur.
	 */
	public ResultSet getResult() {
		return this.result;
	}
	
	/**
	 * Permet de fermer le ResultSet pour libérer de la mémoire lorsqu'on a récupéré toutes les valeurs.
	 * 
	 * @throws SQLException En cas de problème en rapport avec ResultSet.
	 */
	public void close() throws SQLException{
		result.close();
	}
}
