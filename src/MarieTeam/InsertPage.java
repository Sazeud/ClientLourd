package MarieTeam;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 * <b>La classe InsertPage va permettre la cr�ation d'une interface graphique pour ins�rer des donn�es dans la base de donn�es.</b>
 * <p>C'est une classe fille de JFrame permettant d'utiliser toutes les fonctionnalit�s de cette derni�re pour r�aliser une interface graphique
 * mais il est aussi implement� la classe ActionListener pour g�rer les actions sur les boutons.</p>
 *
 * @see Interface#actionPerformed(ActionEvent)
 * 
 * @author Florian Petillon
 *
 */
public class InsertPage extends JFrame implements ActionListener{
	
	/**
	 * Bouton de validation du choix entre bateau et �quipement pour l'ajout de donn�es.
	 * 
	 * @see InsertPage#InsertPage()
	 * @see InsertPage#InsertPage(string)
	 */
	private JButton validerButt;
	
	/**
	 * Bouton pour ins�rer les donn�es entr�s dans la base de donn�es, pour un bateau voyageur.
	 * @see InsertPage#InsertPage(string)
	 */
	private JButton insertDonneesBateauV;
	
	/**
	 * Bouton pour ins�rer les donn�es entr�s dans la base de donn�es, pour un bateau fret.
	 * @see InsertPage#InsertPage(string)
	 */
	private JButton insertDonneesBateauF;
	
	/**
	 * Bouton pour ins�rer les donn�es entr�s dans la base de donn�es, pour un �quipement.
	 * @see InsertPage#InsertPage(string)
	 */
	private JButton insertDonneesEquip;
	
	/**
	 * Bouton du choix entre bateau voyageur et bateau fret.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JButton choixInsert;
	
	/**
	 * Liste permettant de faire un choix entre ins�rer un bateau ou seulement un �quipement.
	 * 
	 * @see InsertPage#InsertPage()
	 * @see InsertPage#InsertPage(String)
	 */
	private JList liste;
	
	/**
	 * Champ de texte pour ins�rer le nom du bateau.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertNom;
	
	/**
	 * Champ de texte pour ins�rer la longueur du bateau
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertLongueur;
	
	/**
	 * Champ de texte pour ins�rer la largeur du bateau
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertLargeur;
	
	/**
	 * Champ de texte pour ins�rer la vitesse du bateau
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertVitesse;
	
	/**
	 * Champ de texte pour ins�rer le chemin de l'image du bateau.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertImage;
	
	/**
	 * Champ de texte pour ins�rer le poidsMax que peut supporter le bateau.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertPoids;
	
	/**
	 * Champ de texte pour ins�rer le type de bateau.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertType;
	
	/**
	 * Champ de texte pour ins�rer le libell� de l'�quipement.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private JTextField insertLib;
	
	/**
	 * Liste contenant tout les �quipements.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private ArrayList<Equipement> lesEquip;
	
	/**
	 * Liste de check box afin de pouvoir choisir les diff�rents �quipements qu'un bateau poss�de lors de l'insertion d'un bateau.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private ArrayList<JCheckBox> lesCheckBox;
	
	/**
	 * Jframe correspondant � l'interface graphique.
	 * 
	 * @see InsertPage#InsertPage()
	 * @see InsertPage#InsertPage(string)
	 * @see InsertPage#actionPerformed(ActionEvent)
	 */
	private JFrame frame;
	
	/**
	 * <b>Contructeur InsertPage.</b>
	 * <p>Cr�ation de l'interface avec tout les �l�ments indiqu�s tel que les boutons, labels, tableaux... Permettant de choisir le type d'insertion � r�aliser.</p>
	 * 
	 * @see Interface#actionPerformed(ActionEvent)
	 * @see UpdatePage#actionPerformed(ActionEvent)
	 */
	public InsertPage() {
		frame = new JFrame("Insertion de donn�es");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel contentLab = new JPanel(new GridLayout(2,1));
		
		JLabel label1 = new JLabel("Sur cette page vous pourrez ins�rer de nouvelles donn�es dans la bdd ! ", JLabel.CENTER);
		label1.setPreferredSize(new Dimension(0,50));
		contentLab.add(label1);
		
		JLabel label2 = new JLabel("Renseignez ici si vous voulez ins�rer un bateau ou un �quipement : ", JLabel.CENTER);
		label2.setPreferredSize(new Dimension(0,50));
		contentLab.add(label2);
		
		contentPane.add(contentLab, BorderLayout.NORTH);
		
		JPanel contentList = new JPanel(new FlowLayout());
		
		String choix[] = {"Bateau", "Equipement"};
		liste = new JList(choix);
		contentList.add(liste);
		
		contentPane.add(contentList);
		
		JPanel contentButt = new JPanel(new FlowLayout());
		
		validerButt = new JButton("Valider");
		validerButt.addActionListener(this);
		contentButt.add(validerButt);
		
		contentPane.add(contentButt, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
	
	/**
	 * <b>Constructeur InsertPage.</b>
	 * <p>L'affiche de l'interface d�pend du choix si c'est bateau il pourra �tre ins�r� un bateau, si c'est �quipement il pourra �tre ins�r� un �quipement.</p>
	 * 
	 * @param choix 
	 * Choix entre bateau et �quipement afin de r�aliser une insertion.
	 */
	public InsertPage(String choix) {
		if(choix == "bateau") {
			frame = new JFrame("Insertion de bateaux");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(600, 500);
			frame.setLocationRelativeTo(null);
			
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.setLayout(new BorderLayout());
			
			JPanel contentLab = new JPanel(new GridLayout(2,1));
			
			JLabel label1 = new JLabel("Renseignez ici si vous voulez ajouter un bateau voyageur ou un bateau fret : ", JLabel.CENTER);
			label1.setPreferredSize(new Dimension(0,50));
			contentLab.add(label1);
			
			contentPane.add(contentLab, BorderLayout.NORTH);
			
			JPanel contentList = new JPanel(new FlowLayout());
			
			String type[] = {"Voyageur", "Fret"};
			liste = new JList(type);
			contentList.add(liste);
			
			contentPane.add(contentList);
			
			JPanel contentButt = new JPanel(new FlowLayout());
			
			choixInsert = new JButton("Envoyer");
			choixInsert.addActionListener(this);
			contentButt.add(choixInsert);
			
			contentPane.add(contentButt, BorderLayout.SOUTH);

			frame.setVisible(true);
		}
		else if(choix == "equipement") {
			frame = new JFrame("Insertion d'�quipements");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(600, 500);
			frame.setLocationRelativeTo(null);
			
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.setLayout(new BorderLayout());
			
			JPanel contentLab = new JPanel(new GridLayout(4,1));
			
			JLabel label1 = new JLabel("Renseignez ici toutes les donn�es en rapport avec l'�quipement � ajouter : ", JLabel.CENTER);
			label1.setPreferredSize(new Dimension(0,50));
			contentLab.add(label1);
			
			JLabel label2 = new JLabel("Toutes autres informations doivent �tre renseign�es pour l'ajout d'un nouvel �quipement", JLabel.CENTER);
			label2.setPreferredSize(new Dimension(0,50));
			contentLab.add(label2);
			
			contentPane.add(contentLab, BorderLayout.NORTH);
			
			JPanel donneesPane = new JPanel(new FlowLayout());
			
			JLabel libelle = new JLabel("Libell� �quipement : ");
			donneesPane.add(libelle);
			
			insertLib = new JTextField();
			insertLib.setPreferredSize(new Dimension(160, 25));
			donneesPane.add(insertLib);
			
			contentPane.add(donneesPane);
			
			JPanel contentButt = new JPanel(new FlowLayout());
			
			insertDonneesEquip = new JButton("Envoyer");
			insertDonneesEquip.addActionListener(this);
			contentButt.add(insertDonneesEquip);
			
			contentPane.add(contentButt, BorderLayout.SOUTH);

			frame.setVisible(true);
		}
		else {
			if(choix == "Voyageur") {
				frame = new JFrame("Insertion de bateaux");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(800, 600);
				frame.setLocationRelativeTo(null);
				
				JPanel contentPane = (JPanel) frame.getContentPane();
				contentPane.setLayout(new BorderLayout());
				
				JPanel contentLab = new JPanel(new GridLayout(3,1));
				
				JLabel label1 = new JLabel("Renseignez ici toutes les donn�es en rapport avec le bateau voyageur � ajouter : ", JLabel.CENTER);
				label1.setPreferredSize(new Dimension(0,50));
				contentLab.add(label1);
				
				contentPane.add(contentLab, BorderLayout.NORTH);
				
				JPanel donneesPane = new JPanel(new FlowLayout());
				
				JLabel nom = new JLabel("Nom : ");
				donneesPane.add(nom);
				
				insertNom = new JTextField();
				insertNom.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertNom);
				
				JLabel longueur = new JLabel("Longueur : ");
				donneesPane.add(longueur);
				
				insertLongueur = new JTextField();
				insertLongueur.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertLongueur);
				
				JLabel largeur = new JLabel("Largeur : ");
				donneesPane.add(largeur);
				
				insertLargeur = new JTextField();
				insertLargeur.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertLargeur);
				
				JLabel vitesse = new JLabel("Vitesse : ");
				donneesPane.add(vitesse);
				
				insertVitesse = new JTextField();
				insertVitesse.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertVitesse);
				
				JLabel image = new JLabel("Chemin image : ");
				donneesPane.add(image);
				
				insertImage = new JTextField();
				insertImage.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertImage);
				
				try {
					lesEquip = Passerrelle.chargerToutLesEquip();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				lesCheckBox = new ArrayList<>();
				int count=0;
				for(Equipement unEquip : lesEquip) {
					lesCheckBox.add(new JCheckBox(unEquip.toString()));
					donneesPane.add(lesCheckBox.get(count));
					count += 1;
				}
				
				contentPane.add(donneesPane);
				
				JPanel contentButt = new JPanel(new FlowLayout());
				
				insertDonneesBateauV = new JButton("Envoyer");
				insertDonneesBateauV.addActionListener(this);
				contentButt.add(insertDonneesBateauV);
				
				contentPane.add(contentButt, BorderLayout.SOUTH);

				frame.setVisible(true);
			}
			else if(choix == "Fret") {
				frame = new JFrame("Insertion de bateaux");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(600, 500);
				frame.setLocationRelativeTo(null);
				
				JPanel contentPane = (JPanel) frame.getContentPane();
				contentPane.setLayout(new BorderLayout());
				
				JPanel contentLab = new JPanel(new GridLayout(3,1));
				
				JLabel label1 = new JLabel("Renseignez ici toutes les donn�es en rapport avec le bateau fret � ajouter : ", JLabel.CENTER);
				label1.setPreferredSize(new Dimension(0,50));
				contentLab.add(label1);
				
				contentPane.add(contentLab, BorderLayout.NORTH);
				
				JPanel donneesPane = new JPanel(new FlowLayout());
				
				JLabel nom = new JLabel("Nom : ");
				donneesPane.add(nom);
				
				insertNom = new JTextField();
				insertNom.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertNom);
				
				JLabel longueur = new JLabel("Longueur : ");
				donneesPane.add(longueur);
				
				insertLongueur = new JTextField();
				insertLongueur.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertLongueur);
				
				JLabel largeur = new JLabel("Largeur : ");
				donneesPane.add(largeur);
				
				insertLargeur = new JTextField();
				insertLargeur.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertLargeur);
				
				JLabel poidsMax = new JLabel("Poids Max : ");
				donneesPane.add(poidsMax);
				
				insertPoids = new JTextField();
				insertPoids.setPreferredSize(new Dimension(80, 25));
				donneesPane.add(insertPoids);
				
				contentPane.add(donneesPane);
				
				JPanel contentButt = new JPanel(new FlowLayout());
				
				insertDonneesBateauF = new JButton("Envoyer");
				insertDonneesBateauF.addActionListener(this);
				contentButt.add(insertDonneesBateauF);
				
				contentPane.add(contentButt, BorderLayout.SOUTH);

				frame.setVisible(true);
			}
		}
	}
	
	/**
	  * <b>Gestion des actions sur les diff�rents boutons.</b>
	  * <p>En fonction du bouton activ�, ferme la page InsertPage afin d'ouvrir une des pages suivantes :</p>
	  * <ul>
	  * <li>InsertPage -> Bateau</li>
	  * <li>InsertPage -> Equipement</li>
	  * </ul>
	  * <p>Sur ces 2 pages il y a aussi des boutons qui permettent, lorsqu'ils sont activ�s, l'insertion de donn�es bateau ou �quipement en fonction de la page.</p>
	  */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == validerButt) {
			String retour = (String) liste.getSelectedValue();
			if(retour == "Bateau") {
				frame.dispose();
				InsertPage insertBateau = new InsertPage("bateau");
			}
			else if(retour == "Equipement") {
				frame.dispose();
				InsertPage insertEquipement = new InsertPage("equipement");
			}
		}
		else if(e.getSource() == insertDonneesBateauV) {
				try {
					int nbEquip = lesCheckBox.size();
					ArrayList<Integer> lesIdEquip = new ArrayList<Integer>();
					for(int i = 0; i < nbEquip; i++) {
						if(lesCheckBox.get(i).isSelected()) {
							lesIdEquip.add(i+1);
						}
					}
					Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
					Statement stm = connexion.createStatement();
					stm.executeUpdate("INSERT INTO bateau (nom, longueur, largeur, vitesse, image, type) VALUES ('" + insertNom.getText() + "'," + insertLongueur.getText() + "," + insertLargeur.getText() +
							"," + insertVitesse.getText() + ",'" + insertImage.getText() + "','v')");
					System.out.println("Bateau bien ajout�");
					ResultSet result = stm.executeQuery("SELECT idBateau FROM bateau WHERE nom = '" + insertNom.getText() + "';");
					result.next();
					int id = result.getInt(1);
					for(int unId : lesIdEquip) {
						stm.executeUpdate("INSERT INTO posseder VALUES (" + id + "," + unId + ")");
					}
					connexion.close();
					frame.dispose();
					Interface gestionBrochure = new Interface();
				}catch (SQLException a) {
					a.printStackTrace();
				}
			}
		else if(e.getSource() == insertDonneesBateauF) {
			try {
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
				Statement stm = connexion.createStatement();
				stm.executeUpdate("INSERT INTO bateau (nom, longueur, largeur, poidsMax, type) VALUES ('" + insertNom.getText() + "'," + insertLongueur.getText() + "," + insertLargeur.getText() +
						"," + insertPoids.getText() + ",'f');");
				System.out.println("Bateau bien ajout�");
				connexion.close();
				frame.dispose();
				Interface gestionBrochure = new Interface();
			}catch (SQLException a) {
				a.printStackTrace();
			}
		}
		else if(e.getSource() == insertDonneesEquip){
			try {
				ArrayList<Equipement> lesEquip = Passerrelle.chargerToutLesEquip();
				int id = lesEquip.size() + 1;
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
				Statement stm = connexion.createStatement();
				stm.executeUpdate("INSERT INTO equipement (id, lib) VALUES (" + id + ",'" + insertLib.getText() + "');");
				System.out.println("Equipement bien ajout�");
				connexion.close();
				frame.dispose();
				Interface gestionBrochure = new Interface();
			}catch (SQLException a) {
				a.printStackTrace();
			}
		}
		else if(e.getSource() == choixInsert) {
			frame.dispose();
			InsertPage insertPage = new InsertPage((String) liste.getSelectedValue());
		}
	}
}
