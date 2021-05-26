package MarieTeam;

/**
 * <b>Equipement est la classe représentant un équipement</b>
 * <p>Un équipement est défini par :</p>
 * <ul>
 * <li>Un id d'équipement</li>
 * <li>Un libbelé d'équipement</li>
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
	 * Id de l'équipement.
	 * 
	 * @see Equipement#Equipement(int, String)
	 */
	private int idEquip;
	
	/**
	 * Libellé de l'équipement
	 * 
	 * @see Equipement#Equipement(int, String)
	 */
	private String libEquip;
	
	/**
	 * Contructeur Equipement.
	 * 
	 * <p>
	 * Lors de la construction d'un objet Equipement, un Id et un libellé est défini à partir d'unId et d'unLib.
	 * </p>
	 * 
	 * @param unId
	 * Id de l'équipement
	 * @param unLib
	 * Libellé de l'équipement
	 * 
	 * @see Equipement#idEquip
	 * @see Equipement#libEquip
	 */
	public Equipement(int unId, String unLib) {
		this.idEquip = unId;
		this.libEquip = unLib;
	}
	
	/**
	 * Retourne le libellé de l'équipement
	 * 
	 * @return Libellé de l'équipement
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
