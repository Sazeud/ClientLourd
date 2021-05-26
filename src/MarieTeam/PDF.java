package MarieTeam;

import java.io.*;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/**
 * <b>PDF est la classe qui va permettre la cr�ation d'un document PDF ainsi que l'�criture sur ce dernier.</b>
 * <p>Un PDF va �tre d�fini par une valeur :</p>
 * <ul>
 * <li>Document pdf</li>
 * </ul>
 * 
 * @see Interface#brochurePDF()
 * 
 * @author Florian Petillon
 *
 */
public class PDF {
	
	/**
	 * Document pdf.
	 * 
	 * @see PDF#PDF(String)
	 */
	private Document doc;
	
	/**
	 * Constructeur PDF
	 * 
	 * <p>
	 * Lors de la construction d'un objet PDF, on cr�e un Document et on l'attribut � la valeur doc. On r�cup�re ensuite l'instance du document,
	 * pour pouvoir l'ouvrir.
	 * </p>
	 * 
	 * @param nomDoc
	 * Nom du document
	 * 
	 * @throws FileNotFoundException Si le fichier PDF n'est pas trouv�.
	 * @throws DocumentException En cas de probl�me rencontrer lors de la manipulation du pdf.
	 * 
	 * @see PDF#doc
	 * @see Interface#brochurePDF()
	 */
	public PDF(String nomDoc) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		this.doc = document;
		PdfWriter.getInstance(doc, new FileOutputStream(nomDoc));
		doc.open();
	}
	
	/**
	 * Va �crire sur le pdf la texte entr� en param�tre.
	 * 
	 * @param leTexte
	 * Texte a �crire sur le pdf
	 * @throws DocumentException En cas de probl�me rencontrer lors de la manipulation du pdf.
	 * 
	 * @see Interface#brochurePDF()
	 */
	public void ecrireTexte(String leTexte) throws DocumentException {
		doc.add(new Paragraph(leTexte + "\n"));
	}
	
	/**
	 * Permet de charger et placer une image sur le pdf.
	 * 
	 * @param chemin
	 * Chemin de l'image a charger.
	 * @throws IOException En cas de probl�me de r�cup�ration de l'image avec le chemin.
	 * @throws DocumentException En cas de probl�me rencontrer lors de la manipulation du pdf.
	 * 
	 * @see Interface#brochurePDF()
	 */
	public void chargerImage(String chemin) throws  DocumentException, IOException {
		Image image = Image.getInstance(chemin);
		image.setAlignment(Element.ALIGN_CENTER);
		image.scaleAbsolute(250, 120);
		doc.add(image);
	}
	
	/**
	 * Cela va permettre de cr�er une nouvelle page.
	 * 
	 * @see Interface#brochurePDF()
	 */
	public void changerPage() {
		doc.newPage();
	}
	
	/**
	 * Fermeture du document lorsque toutes les actions ont �t� r�alis�es. Actions impossibles suite � cela.
	 * 
	 * @see Interface#brochurePDF()
	 */
	public void fermerDoc() {
		doc.close();
	}
}
