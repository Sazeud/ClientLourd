package MarieTeam;

/**
 * <b>Equipement est la classe repr�sentant un �quipement</b>
 * <p>Un �quipement est d�fini par :</p>
 * <ul>
 * <li>Un id d'�quipement</li>
 * <li>Un libbel� d'�quipement</li>
 * </ul>
 * 
 * @see BateauVoyageur
 * @see Passerrelle#chargerLesEquipements(int)
 * @see Passerrelle#chargerToutLesEquip()
 * 
 * @author Florian Petillon
 *
 */
public class Equipement {
	
	/**
	 * Id de l'�quipement.
	 * 
	 * @see Equipement#Equipement(int, String)
	 */
	private int idEquip;
	
	/**
	 * Libell� de l'�quipement
	 * 
	 * @see Equipement#Equipement(int, String)
	 */
	private String libEquip;
	
	/**
	 * Contructeur Equipement.
	 * 
	 * <p>
	 * Lors de la construction d'un objet Equipement, un Id et un libell� est d�fini � partir d'unId et d'unLib.
	 * </p>
	 * 
	 * @param unId
	 * Id de l'�quipement
	 * @param unLib
	 * Libell� de l'�quipement
	 * 
	 * @see Equipement#idEquip
	 * @see Equipement#libEquip
	 */
	public Equipement(int unId, String unLib) {
		this.idEquip = unId;
		this.libEquip = unLib;
	}
	
	/**
	 * Retourne le libell� de l'�quipement
	 * 
	 * @return Libell� de l'�quipement
	 * 
	 * @see Equipement#libEquip
	 */
	public String toString() {
		return this.libEquip;	
	}
	
	@Override public boolean equals(Object unObjet) {
		if(!(unObjet instanceof Equipement)) {
			return false;
		}
		Equipement unEquipement = (Equipement) unObjet;
		return unEquipement.idEquip == this.idEquip && unEquipement.libEquip.equals(this.libEquip);
	}
}
