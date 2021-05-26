package MarieTeam;

import java.util.ArrayList;

/**
 * <b>Bateau Voyageur est une classe fille de Bateau, elle g�re les bateaux de type voyageur</b>
 * <p>Un bateau voyageur va �tre caract�ris� par :</p>
 * <ul>
 * <li>Un id unique attribu� au bateau</li>
 * <li>Un nom</li>
 * <li>Une longueur</li>
 * <li>Une largeur</li>
 * <li>Une vitesse</li>
 * <li>Une image</li>
 * </ul>
 * <p>De plus, un bateau voyageur a une liste d'�quipements.</p>
 * 
 * @see Bateau
 * @see Equipement
 * @see Passerrelle#chargerLesBateauxVoyageurs()
 * 
 * @author Florian Petillon
 *
 */
public class BateauVoyageur extends Bateau{
	
	/**
	 * La vitesse du bateau voyageur.
	 * 
	 * @see BateauVoyageur#BateauVoyageur(int, String, double, double, double, String, ArrayList)
	 * @see BateauVoyageur#toString()
	 */
	private double vitesseBatVoy;
	
	/**
	 * Le chemin de l'image du bateau voyageur.
	 * 
	 * @see BateauVoyageur#BateauVoyageur(int, String, double, double, double, String, ArrayList)
	 * @see BateauVoyageur#toString()
	 * @see BateauVoyageur#getImageBatVoy()
	 */
	private String imageBatVoy;
	
	/**
	 * Liste des �quipements du bateau voyageur.
	 * 
	 * @see BateauVoyageur#BateauVoyageur(int, String, double, double, double, String, ArrayList)
	 * @see BateauVoyageur#toString()
	 */
	private ArrayList<Equipement> lesEquipements;
	
	/**
	 * Constructeur BateauVoyageur.
	 * 
	 * <p>
	 * Lors de la construction d'un objet BateauVoyageur, il est utilis� le mot clef super() afin d'utiliser le constructeur de la classe m�re Bateau avec les
	 * param�tres unId, unNom, uneLongueur, uneLargeur. Les autres attributs sont fix�s gr�ce � uneVitesse, uneImage, uneCollEquip.
	 * </p>
	 * 
	 * @param unId
	 * Identifiant du bateau voyageur
	 * @param unNom
	 * Nom du bateau voyageur
	 * @param uneLongueur
	 * Longueur du bateau voyageur
	 * @param uneLargeur
	 * Largeur du bateau voyageur
	 * @param uneVitesse
	 * Vitesse du bateau voyageur
	 * @param uneImage
	 * Chemin de l'image du bateau voyageur
	 * @param uneCollEquip
	 * Collection des �quipements du bateau voyageur
	 * 
	 * @see Bateau#Bateau(int, String, double, double)
	 * @see BateauVoyageur#vitesseBatVoy
	 * @see BateauVoyageur#imageBatVoy
	 * @see BateauVoyageur#lesEquipements
	 */
	public BateauVoyageur(int unId, String unNom, double uneLongueur, double uneLargeur, double uneVitesse, String uneImage, ArrayList<Equipement> uneCollEquip) {
		super(unId, unNom, uneLongueur, uneLargeur);
		this.vitesseBatVoy = uneVitesse;
		this.imageBatVoy = uneImage;
		this.lesEquipements = uneCollEquip;
	}
	
	/**
	 * Retourne une chaine qui va �tre compos� de tout les attributs d'un bateau voyageur sauf son id en utilisant la m�thode toString de la classe Bateau.
	 * 
	 * @return Retourne les caract�ristiques d'un bateau voyageur sauf l'id sous forme d'une chaine
	 * 
	 * @see BateauVoyageur#vitesseBatVoy
	 * @see BateauVoyageur#imageBatVoy
	 * @see BateauVoyageur#lesEquipements
	 * @see Bateau#toString()
	 */
	public String toString() {
		String chaine = super.toString();
		chaine += "\nVitesse : " + this.vitesseBatVoy + " noeuds\nListe des �quipements du bateau : ";
		for(Equipement unEquip : this.lesEquipements) {
			chaine += "\n-" + unEquip.toString();
		}
		return chaine;
	}
	
	/**
	 * Retourne l'image du bateau voyageur.
	 * 
	 * @return Retourne le chemin de l'image correspondant au bateau voyageur.
	 * 
	 * @see BateauVoyageur#imageBatVoy
	 */
	public String getImageBatVoy() {
		return this.imageBatVoy;
	}
	
	@Override public boolean equals(Object unObjet) {
		if(!(unObjet instanceof BateauVoyageur)) {
			return false;
		}
		BateauVoyageur unBV = (BateauVoyageur) unObjet;
		return this.getId() == unBV.getId() && this.getNom().equals(unBV.getNom()) && this.getLargeur() == unBV.getLargeur() && this.getLongueur() == unBV.getLongueur() 
				&& this.imageBatVoy.equals(unBV.imageBatVoy) && this.vitesseBatVoy == unBV.vitesseBatVoy; //&& this.lesEquipements.equals(unBV.lesEquipements)
	}
	
	public void display() {
		System.out.println(this.imageBatVoy);
	}
}
