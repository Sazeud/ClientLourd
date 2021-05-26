package MarieTeam;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

/**
 * <b>La classe Program correspond à la classe Main et va permettre l'éxecution du programme.</b>
 * 
 * @see Interface
 * @author Florian Petillon
 *
 */
public class Program {
	
	/**
	 * Lancement de l'interface graphique permettant de faire les différentes manipulations du programme.
	 * @param args Réalisation du main
	 */
	public static void main(String[] args) {
		Interface gestionBrochure = new Interface();
	}
}