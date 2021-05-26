package MarieTeam;

import java.sql.*;

/**
 * <b>La classe JeuEnregistrement va permettre d'obtenir un jeu d'enregistrement � partir d'une requ�te SQL donn�e.</b>
 * <p>Un JeuEnregistrement est d�fini par :</p>
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
	 * Objet Connection contenant la connexion �tablie � la base de donn�es.
	 * 
	 * @see JeuEnregistrement#JeuEnregistrement(String)
	 */
	private Connection connexion;
	
	/**
	 * Objet Statement permettant d'�xecuter une requ�te SQL et de retourner un r�sultat.
	 * 
	 * @see JeuEnregistrement#JeuEnregistrement(String)
	 */
	private Statement stm;
	
	/**
	 * Objet ResultSet qui va contenir le r�sultat de la commande SQL.
	 * 
	 * @see JeuEnregistrement#JeuEnregistrement(String)
	 */
	private ResultSet result;
	
	/**
	 * Constructeur JeuEnregistrement
	 * 
	 * <p>Lors de la construction d'un objet JeuEnregistrement, on attributs � chacun la connexion, le statement ainsi que les resultats par rapport � la requ�te entr�e en param�tre.
	 * 
	 * @param chaine 
	 * Requ�te SQL a r�aliser.
	 * @throws SQLException En cas de probl�me de requ�te SQL.
	 */
	public JeuEnregistrement(String chaine) throws SQLException{
		this.connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
		this.stm = connexion.createStatement();
		this.result = stm.executeQuery(chaine);
	}
	
	/**
	 * Permet de d�placer le curseur et v�rifier s'il y a encore des valeurs dans le ResultSet.
	 * 
	 * @return Si il y a encore des r�sultats ou non dans le ResultSet
	 * @throws SQLException En cas de probl�me de requ�te SQL.
	 */
	public boolean suivant() throws SQLException{
		boolean fin = true;
		if(!result.next()) {
			fin = false;
		}
		return fin;
	}
	
	/**
	 * Permet de r�cup�rer le ResultSet pour pouvoir r�cup�rer la valeur correspondant au curseur actuel.
	 * 
	 * @return ResultSet correspondant au positionnement du curseur.
	 */
	public ResultSet getResult() {
		return this.result;
	}
	
	/**
	 * Permet de fermer le ResultSet pour lib�rer de la m�moire lorsqu'on a r�cup�r� toutes les valeurs.
	 * 
	 * @throws SQLException En cas de probl�me en rapport avec ResultSet.
	 */
	public void close() throws SQLException{
		result.close();
	}
}
