package MarieTeam;

import java.awt.GridLayout;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.*;

import com.itextpdf.text.DocumentException;

/**
 * <b>La classe Interface va s'occuper du fonctionnement de l'interface graphique</b>
 * <p>C'est une classe fille de JFrame permettant d'utiliser toutes les fonctionnalit�s de cette derni�re pour r�aliser une interface graphique
 * mais il est aussi implement� la classe ActionListener pour g�rer les actions sur les boutons.</p>
 * 
 * @author Florian Petillon
 *
 */
public class Interface extends JFrame implements ActionListener{
	
	/**
	 * Bouton permettant d'acc�der � la page InsertPage.
	 * 
	 * @see Interface#Interface()
	 * @see Interface#actionPerformed(ActionEvent)
	 */
	private JButton insertButton;
	
	/**
	 * Bouton permettant d'acc�der � la page UpdatePage.
	 * 
	 * @see Interface#Interface()
	 * @see Interface#actionPerformed(ActionEvent)
	 */
	private JButton updateButton;
	
	/**
	 * Bouton permettant d'actualiser la brochure.
	 * 
	 * @see Interface#Interface()
	 * @see Interface#actionPerformed(ActionEvent)
	 */
	private JButton actualiserButton;
	
	/**
	 * JFrame correspondant � l'interface graphique.
	 * 
	 * @see Interface#Interface()
	 * @see Interface#actionPerformed(ActionEvent)
	 */
	private JFrame frame;
	
	/**
	 * Contructeur Interface.
	 * <p>Cr�ation de l'interface avec tout les �l�ments indiqu�s tel que les boutons et les labels.</p>
	 * 
	 * @see InsertPage#actionPerformed(ActionEvent)
	 * @see UpdatePage#actionPerformed(ActionEvent)
	 */
	public Interface() {
		frame = new JFrame("Gestion des brochures");
		
		JLabel label = new JLabel("Bienvenue sur l'�diteur de brochure pour les bateaux voyageurs : ", JLabel.CENTER);
		frame.add(label);
		
		JPanel panel = new JPanel();
		
		insertButton = new JButton("Ins�rer de nouvelles valeurs");
		updateButton = new JButton("Modifier des valeurs");
		actualiserButton = new JButton("Actualiser la brochure");
		
		
		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		actualiserButton.addActionListener(this);
		
		panel.add(insertButton);
		panel.add(updateButton);
		panel.add(actualiserButton);
		
		frame.setLayout(new GridLayout(2,1));
		frame.add(label);
		frame.add(panel);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	 /**
	  * <b>Gestion des actions sur les diff�rents boutons.</b>
	  * <p>En fonction du bouton activ�, ferme la page Interface afin d'ouvrir une des pages suivantes :</p>
	  * <ul>
	  * <li>InsertPage</li>
	  * <li>UpdatePage</li>
	  * </ul>
	  * <p>Si le bouton actualiserButton est activ�, alors la m�thode borchurePDF sera �xecut�e et l'application se fermera.</p>
	  */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertButton) {
			frame.dispose();
			InsertPage insertPage = new InsertPage();
		}
		else if(e.getSource() == updateButton) {
			frame.dispose();
			UpdatePage updatePage = new UpdatePage();
		}
		else if(e.getSource() == actualiserButton) {
			brochurePDF();
			System.out.println("Brochure mise � jour");
			System.exit(0);
		}
	}
	
	/**
	 * Permet la cr�ation du pdf BateauVoyageur gr�ce � la classe PDF et la classe Passerrelle.
	 * Le pdf sera rempli en fonction des valeurs de la base de donn�e avec 2 bateaux par page.
	 * 
	 * @see Interface#actionPerformed(ActionEvent)
	 */
	public static void brochurePDF() {
		int count = 0;
		try {
			PDF pdf = new PDF("BateauVoyageur.pdf");
			pdf.ecrireTexte("Brochure des bateaux voyageurs : \n");
            ArrayList<BateauVoyageur> lesBatVoy = new ArrayList<BateauVoyageur>();
            lesBatVoy = Passerrelle.chargerLesBateauxVoyageurs();
            for(BateauVoyageur unBat : lesBatVoy) {
            	pdf.chargerImage(unBat.getImageBatVoy());
            	pdf.ecrireTexte("\n" + unBat.toString() + "\n");
            	count += 1;
            	if((count % 2) == 0 && count != 0) {
            		pdf.changerPage();
            	}
            }
            
            pdf.fermerDoc();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
