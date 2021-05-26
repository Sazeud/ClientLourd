package MarieTeam;

import java.util.ArrayList;

/**
 * <b>Bateau Fret est une classe fille de Bateau, elle gère les bateaux de type fret</b>
 * <p>Un bateau fret va être caractérisé par :</p>
 * <ul>
 * <li>Un id unique attribué au bateau</li>
 * <li>Un nom</li>
 * <li>Une longueur</li>
 * <li>Une largeur</li>
 * <li>Un poids maximal</li>
 * </ul>
 * 
 * @see Bateau
 * 
 * @author Florian Petillon
 */
public class BateauFret extends Bateau{
	
	/**
	 * Le poids maximal du bateau fret
	 * 
	 * @see BateauFret#BateauFret(int, String, double, double, double)
	 */
	private double poidsMaxBatFret;
	
	/**
	 * Constructeur BateauFret
	 * 
	 * <p>
	 * Lors de la construction d'un objet BateauFret, le mot clef super est utilisé afin d'utiliser le constructeur de la classe mère Bateau afin de définir les paramètres
	 * unId, unNom, uneLongueur, uneLargeur. L'autre attribut est fixé grâce à unPoidsMax.
	 * </p>
	 * 
	 * @param unId
	 * Identifiant du bateau fret
	 * @param unNom
	 * Nom du bateau fret
	 * @param uneLongueur
	 * Longueur du bateau fret
	 * @param uneLargeur
	 * Largeur du bateau fret
	 * @param unPoidsMax
	 * Poids maximal que le bateau fret peut supporter
	 * 
	 * @see BateauFret#poidsMaxBatFret
	 * @see Bateau#Bateau(int, String, double, double)
	 */
	public BateauFret(int unId, String unNom, double uneLongueur, double uneLargeur, double unPoidsMax) {
		super(unId, unNom, uneLongueur, uneLargeur);
		this.poidsMaxBatFret = unPoidsMax;
	}
}
