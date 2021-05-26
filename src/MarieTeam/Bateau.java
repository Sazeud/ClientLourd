package MarieTeam;

/**
 * <b>Bateau est la classe m�re repr�sentant tout les bateaux de l'application Marieteam</b>
 * <p>Un bateau va �tre caract�ris� avec :</p>
 * <ul>
 * <li>Un id unique attribu� au bateau</li>
 * <li>Un nom</li>
 * <li>Une longueur</li>
 * <li>Une largeur</li>
 * </ul>
 * De plus, un bateau peut-�tre d�fini avec d'autres informations en fonction de son type.
 * 
 * @see BateauVoyageur
 * @see BateauFret
 * 
 * @author Florian Petillon
 *
 */
public class Bateau {
	/**
	 * L'id du bateau, Unique et non modifiable.
	 * 
	 * @see Bateau#Bateau(int, String, double, double)
	 *
	 */
	private int idBat;
	
	/**
	 * Le nom du bateau.
	 * 
	 * @see Bateau#Bateau(int, String, double, double)
	 * @see Bateau#toString()
	 */
	private String nomBat;
	
	/**
	 * La longueur du Bateau.
	 * 
	 * @see Bateau#Bateau(int, String, double, double)
	 * @see Bateau#toString()
	 */
	private double longueurBat;
	
	/**
	 * La largeur du Bateau.
	 * 
	 * @see Bateau#Bateau(int, String, double, double)
	 * @see Bateau#toString()
	 */
	private double largeurBat;
	
	/**
	 * Constructeur Bateau.
	 * <p>
	 * A la construction d'un objet Bateau, tout ses param�tres sont fix�s soit l'id -> unId, le nom -> unNom, la longueur -> uneLongueur et la largeur -> uneLargeur
	 * </p>
	 * @param unId
	 * Identifiant unique du bateau
	 * @param unNom
	 * Nom du bateau
	 * @param uneLongueur
	 * Longueur du bateau
	 * @param uneLargeur
	 * Largeur du bateau
	 * 
	 * @see Bateau#idBat
	 * @see Bateau#nomBat
	 * @see Bateau#longueurBat
	 * @see Bateau#largeurBat
	 */
	public Bateau(int unId, String unNom, double uneLongueur, double uneLargeur) {
		this.idBat = unId;
		this.nomBat = unNom;
		this.longueurBat = uneLongueur;
		this.largeurBat = uneLargeur;
	}
	
	/**
	 * Retourne une chaine qui va �tre compos� de tout les attributs d'un bateau sauf l'id.
	 * 
	 * @return Retourne les caract�ristiques d'un bateau sauf l'id sous forme d'une chaine
	 * 
	 * @see Bateau#nomBat
	 * @see Bateau#longueurBat
	 * @see Bateau#largeurBat
	 */
	public String toString(){
		String chaine = "";
		chaine = "Nom du bateau : " + this.nomBat + "\nLongueur : " + this.longueurBat + " m�tres\nLargeur : " + this.largeurBat + " m�tres";
		return chaine;
	}
	
	public int getId() {
		return this.idBat;
	}
	
	public String getNom() {
		return this.nomBat;
	}
	
	public double getLongueur(){
		return this.longueurBat;
	}
	
	public double getLargeur() {
		return this.largeurBat;
	}
}
