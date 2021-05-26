package MarieTeam;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

/**
 * <b>La classe Program correspond � la classe Main et va permettre l'�xecution du programme.</b>
 * 
 * @see Interface
 * @author Florian Petillon
 *
 */
public class Program {
	
	/**
	 * Lancement de l'interface graphique permettant de faire les diff�rentes manipulations du programme.
	 * @param args R�alisation du main
	 */
	public static void main(String[] args) {
		Interface gestionBrochure = new Interface();
	}
}