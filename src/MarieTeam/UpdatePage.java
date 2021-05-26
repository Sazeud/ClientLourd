package MarieTeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 * <b>La classe UpdatePage va permettre la création d'une interface graphique pour mettre à jour des données dans la base de données.</b>
 * <p>C'est une classe fille de JFrame permettant d'utiliser toutes les fonctionnalités de cette dernière pour réaliser une interface graphique
 * mais il est aussi implementé la classe ActionListener pour gérer les actions sur les boutons.</p>
 *
 * @see Interface#actionPerformed(ActionEvent)
 * 
 * @author Florian Petillon
 *
 */
public class UpdatePage extends JFrame implements ActionListener{
	
	/**
	 * Jframe correspondant à l'interface graphique.
	 * 
	 * @see UpdatePage#UpdatePage()
	 * @see UpdatePage#UpdatePage(string)
	 * @see UpdatePage#actionPerformed(ActionEvent)
	 */
	private JFrame frame;
	
	/**
	 * Bouton de validation du choix.
	 * 
	 * @see UpdatePage#UpdatePage()
	 */
	private JButton validerButt;
	
	/**
	 * Bouton qui permet de mettre à jour les données des équipements.
	 * 
	 * @see UpdatePage#UpdatePage(string)
	 */
	private JButton updateDonneesEquip;
	
	/**
	 * Bouton qui permet de mettre à jour les données d'un bateau.
	 * 
	 * @see UpdatePage#UpdatePage(string)
	 */
	private JButton updateDonneesBateau;
	 
	/**
	 * Bouton qui permet de mettre à jour les données des équipements d'un bateau.
	 * 
	 * @see UpdatePage#UpdatePage(string)
	 */
	private JButton updateDonneesBateauEquip;
	
	/**
	 * Bouton permettant d'afficher les équipements d'un bateau donné.
	 * 
	 * @see UpdatePage#UpdatePage(string)
	 */
	private JButton afficherBateauEquip;
	
	/**
	 * Liste permettant de faire un choix entre insérer un bateau ou seulement un équipement.
	 * 
	 * @see UpdatePage#UpdatePage()
	 */
	private JList liste;
	
	/**
	 * Liste contenant tout les équipements.
	 * 
	 * @see InsertPage#InsertPage(string)
	 */
	private ArrayList<Equipement> lesEquip;
	
	/**
	 * Champ de Texte de la colonne a modif pour un bateau.
	 * 
	 * @see InsertPage#InsertPage(String)
	 */
	private JTextField editColonne;
	
	/**
	 * Champ de texte de la nouvelle valeur a affecter.
	 * 
	 * @see InsertPage#InsertPage(String)
	 */
	private JTextField editNewVal;
	
	/**
	 * Champ de texte de l'id du bateau a modifier.
	 * 
	 * @see InsertPage#InsertPage(String)
	 */
	private JTextField editIdBat;
	
	/**
	 * Champ de texte de l'id de l'équipement à modifier.
	 * 
	 * @see InsertPage#InsertPage(String)
	 */
	private JTextField editIdEquip;
	
	/**
	 * <b>Contructeur UpdatePage.</b>
	 * <p>Création de l'interface avec tout les éléments indiqués tel que les boutons, labels, tableaux... Permettant de choisir le type de modification à réaliser.</p>
	 * 
	 * @see Interface#actionPerformed(ActionEvent)
	 * @see InsertPage#actionPerformed(ActionEvent)
	 */
	public UpdatePage() {
		frame = new JFrame("Modification de données");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel contentLab = new JPanel(new GridLayout(2,1));
		
		JLabel label1 = new JLabel("Sur cette page vous pourrez modifier des valeurs dans la bdd ! ", JLabel.CENTER);
		label1.setPreferredSize(new Dimension(0,50));
		contentLab.add(label1);
		
		JLabel label2 = new JLabel("Renseignez ici si vous voulez modifier un bateau, les équipements d'un bateau ou un équipement : ", JLabel.CENTER);
		label2.setPreferredSize(new Dimension(0,50));
		contentLab.add(label2);
		
		contentPane.add(contentLab, BorderLayout.NORTH);
		
		JPanel contentList = new JPanel(new FlowLayout());
		
		String choix[] = {"Bateau", "Equipement d'un bateau", "Equipement"};
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
	 * <b>Constructeur UpdatePage.</b>
	 * <p>L'affiche de l'interface dépend du choix si c'est bateau la modification sera sur un bateau, si c'est équipement la modification se fera sur un équipement 
	 * et si c'est bateauEquipement alors il sera réaliser une modification sur un équipement d'un bateau.</p>
	 * <p>Lorsqu'on rentre un id de bateau dans Bateau Equipement, on arrive sur une page où il y a la la liste des équipements de ce bateau, on choisit ensuite la modifs.</p>
	 * 
	 * @param choix 
	 * Choix entre bateau, équipement et bateau équipement afin de réaliser une insertion.
	 */
	public UpdatePage(String choix) {
		if(choix == "bateau") {
			frame = new JFrame("Modification de bateaux");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800, 700);
			frame.setLocationRelativeTo(null);
			
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.setLayout(new BorderLayout());
			
			JPanel contentLab = new JPanel(new GridLayout(4,1));
			
			JLabel label2 = new JLabel("Renseignez l’id du bateau à modifier ainsi que la colonne et la nouvelle valeur à modifier :", JLabel.CENTER);
			label2.setPreferredSize(new Dimension(0,50));
			contentLab.add(label2);
			
			int row = 0;
			try {
				JeuEnregistrement jeu = new JeuEnregistrement("SELECT * FROM bateau");
				while(jeu.suivant()) {
					row += 1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			String[] columns = {"ID","Nom","Longueur","Largeur","Vitesse","Image","PoidsMax","Type"};
			String data[][] = new String[row][8];
			
			int count = 0;
			try {
				JeuEnregistrement jeu = new JeuEnregistrement("SELECT * FROM bateau");
				while(jeu.suivant()) {
					Integer id = jeu.getResult().getInt("idBateau");
					String nom = jeu.getResult().getString("nom");
					Double longueur = jeu.getResult().getDouble("longueur");
					Double largeur = jeu.getResult().getDouble("largeur");
					Double vitesse =jeu.getResult().getDouble("vitesse");
					String image = jeu.getResult().getString("image");
					Double poidsMax = jeu.getResult().getDouble("poidsMax");
					String type = jeu.getResult().getString("type");
					data[count][0] = id.toString();
					data[count][1] = nom;
					data[count][2] = longueur.toString();
					data[count][3] = largeur.toString();
					data[count][4] = vitesse.toString();
					data[count][5] = image;
					data[count][6] = poidsMax.toString();
					data[count][7] = type;
					count += 1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			JTable table = new JTable(data, columns);
			table.setShowGrid(true);
			table.setShowVerticalLines(true);
			
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	        rightRenderer.setHorizontalAlignment(JLabel.CENTER);

	        TableModel tableModel = table.getModel();

	        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
	        {
	            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
	        }
			
			contentLab.add(table.getTableHeader());
			contentLab.add(table);
			
			contentPane.add(contentLab, BorderLayout.NORTH);
			
			JPanel donneesPane = new JPanel(new FlowLayout());
			
			JLabel idBat = new JLabel("Id Bateau: ");
			donneesPane.add(idBat);
			
			editIdBat = new JTextField();
			editIdBat.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editIdBat);
			
			JLabel colonne = new JLabel("Nom colonne : ");
			donneesPane.add(colonne);
			
			editColonne = new JTextField();
			editColonne.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editColonne);
			
			JLabel newVal = new JLabel("Nouvelle valeur : ");
			donneesPane.add(newVal);
			
			editNewVal = new JTextField();
			editNewVal.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editNewVal);
			
			contentPane.add(donneesPane);
			
			JPanel contentButt = new JPanel(new FlowLayout());
			
			updateDonneesBateau = new JButton("Envoyer");
			updateDonneesBateau.addActionListener(this);
			contentButt.add(updateDonneesBateau);
			
			contentPane.add(contentButt, BorderLayout.SOUTH);

			frame.setVisible(true);
		}
		else if(choix == "equipement") {
			frame = new JFrame("Modification d'équipements");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800, 700);
			frame.setLocationRelativeTo(null);
			
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.setLayout(new BorderLayout());
			
			JPanel contentLab = new JPanel(new GridLayout(4,1));
			
			JLabel label1 = new JLabel("Renseignez ici les données à modifier sur l'équipement voulu : ", JLabel.CENTER);
			label1.setPreferredSize(new Dimension(0,50));
			contentLab.add(label1);
			
			JLabel label2 = new JLabel("Vous devez l'id de l'équipement sur lequel vous voulez modifier le libellé et la nouvelle valeur", JLabel.CENTER);
			label2.setPreferredSize(new Dimension(0,50));
			contentLab.add(label2);
			
			try {
				lesEquip = Passerrelle.chargerToutLesEquip();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			String[] columns = {"ID","Libellé"};
			String data[][] = new String[lesEquip.size()][2];
			
			int count = 0;
			for(Equipement unEquip : lesEquip) {
				Integer id = count + 1;
				data[count][0] = id.toString();
				data[count][1] = unEquip.toString();
				count++;
			}
			
			JTable table = new JTable(data, columns);
			table.setShowGrid(true);
			table.setShowVerticalLines(true);
			
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	        rightRenderer.setHorizontalAlignment(JLabel.CENTER);

	        TableModel tableModel = table.getModel();

	        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
	        {
	            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
	        }
			
			contentLab.add(table.getTableHeader());
			contentLab.add(table);
			
			contentPane.add(contentLab, BorderLayout.NORTH);
			
			JPanel donneesPane = new JPanel(new FlowLayout());
			
			JLabel id = new JLabel("Id Equipement : ");
			donneesPane.add(id);
			
			editIdEquip = new JTextField();
			editIdEquip.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editIdEquip);
			
			JLabel newVal = new JLabel("Nouveau libellé : ");
			donneesPane.add(newVal);
			
			editNewVal = new JTextField();
			editNewVal.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editNewVal);
			
			contentPane.add(donneesPane);
			
			JPanel contentButt = new JPanel(new FlowLayout());
			
			updateDonneesEquip = new JButton("Envoyer");
			updateDonneesEquip.addActionListener(this);
			contentButt.add(updateDonneesEquip);
			
			contentPane.add(contentButt, BorderLayout.SOUTH);

			frame.setVisible(true);
		}
		else if(choix == "bateauEquip") {
			frame = new JFrame("Modification d'équipements de bateaux");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800, 600);
			frame.setLocationRelativeTo(null);
			
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.setLayout(new BorderLayout());
			
			JPanel contentLab = new JPanel(new GridLayout(4,1));
			
			JLabel label2 = new JLabel("Veuillez renseigner l'id du bateau dont vous voulez modifier l'équipement", JLabel.CENTER);
			label2.setPreferredSize(new Dimension(0,50));
			contentLab.add(label2);
			
			contentPane.add(contentLab, BorderLayout.NORTH);
			
			int row = 0;
			try {
				JeuEnregistrement jeu = new JeuEnregistrement("SELECT * FROM bateau");
				while(jeu.suivant()) {
					row += 1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			String[] columns = {"ID","Nom","Longueur","Largeur","Vitesse","Image","PoidsMax","Type"};
			String data[][] = new String[row][8];
			
			int count = 0;
			try {
				JeuEnregistrement jeu = new JeuEnregistrement("SELECT * FROM bateau");
				while(jeu.suivant()) {
					Integer id = jeu.getResult().getInt("idBateau");
					String nom = jeu.getResult().getString("nom");
					Double longueur = jeu.getResult().getDouble("longueur");
					Double largeur = jeu.getResult().getDouble("largeur");
					Double vitesse =jeu.getResult().getDouble("vitesse");
					String image = jeu.getResult().getString("image");
					Double poidsMax = jeu.getResult().getDouble("poidsMax");
					String type = jeu.getResult().getString("type");
					data[count][0] = id.toString();
					data[count][1] = nom;
					data[count][2] = longueur.toString();
					data[count][3] = largeur.toString();
					data[count][4] = vitesse.toString();
					data[count][5] = image;
					data[count][6] = poidsMax.toString();
					data[count][7] = type;
					count += 1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			JTable table = new JTable(data, columns);
			table.setShowGrid(true);
			table.setShowVerticalLines(true);
			
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	        rightRenderer.setHorizontalAlignment(JLabel.CENTER);

	        TableModel tableModel = table.getModel();

	        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
	        {
	            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
	        }
			
			contentLab.add(table.getTableHeader());
			contentLab.add(table);
			
			contentPane.add(contentLab, BorderLayout.NORTH);
			
			JPanel donneesPane = new JPanel(new FlowLayout());
			
			JLabel id = new JLabel("Id Bateau: ");
			donneesPane.add(id);
			
			editIdBat = new JTextField();
			editIdBat.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editIdBat);
			
			contentPane.add(donneesPane);
			
			JPanel contentButt = new JPanel(new FlowLayout());
			
			afficherBateauEquip = new JButton("Afficher");
			afficherBateauEquip.addActionListener(this);
			contentButt.add(afficherBateauEquip);
			
			contentPane.add(contentButt, BorderLayout.SOUTH);

			frame.setVisible(true);
		}
		else {
			frame = new JFrame("Modification d'équipements de bateau");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800, 650);
			frame.setLocationRelativeTo(null);
			
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.setLayout(new BorderLayout());
			
			JPanel contentLab = new JPanel(new GridLayout(4,1));
			
			JLabel label1 = new JLabel("Renseignez ici l'id de l'équipement liés au bateau à modifier ainsi que l'id du nouvel équipement", JLabel.CENTER);
			label1.setPreferredSize(new Dimension(0,50));
			contentLab.add(label1);
			
			int row = 0;
			try {
				JeuEnregistrement jeu = new JeuEnregistrement("SELECT E.id, E.lib FROM equipement as E, posseder as P WHERE idBat = " + choix + " AND P.idEquip = E.id");
				while(jeu.suivant()) {
					row += 1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			String[] columns = {"ID","Libellé"};
			String data[][] = new String[row][2];
			
			int count = 0;
			try {
				JeuEnregistrement jeu = new JeuEnregistrement("SELECT E.id, E.lib FROM equipement as E, posseder as P WHERE idBat = " + choix + " AND P.idEquip = E.id");
				while(jeu.suivant()) {
					Integer id = jeu.getResult().getInt(1);
					String lib = jeu.getResult().getString(2);
					data[count][0] = id.toString();
					data[count][1] = lib.toString();
					count += 1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			JTable table = new JTable(data, columns);
			table.setShowGrid(true);
			table.setShowVerticalLines(true);
			
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	        rightRenderer.setHorizontalAlignment(JLabel.CENTER);

	        TableModel tableModel = table.getModel();

	        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
	        {
	            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
	        }
			
			contentLab.add(table.getTableHeader());
			contentLab.add(table);
			
			contentPane.add(contentLab, BorderLayout.NORTH);
			
			JPanel donneesPane = new JPanel(new FlowLayout());
			
			JLabel idBat = new JLabel("Id Bateau : ");
			donneesPane.add(idBat);
			
			editIdBat = new JTextField(choix);
			editIdBat.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editIdBat);
			
			JLabel idEquip = new JLabel("Id Equipement : ");
			donneesPane.add(idEquip);
			
			editIdEquip = new JTextField();
			editIdEquip.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editIdEquip);
			
			JLabel newVal = new JLabel("Nouvelle Valeur : ");
			donneesPane.add(newVal);
			
			editNewVal = new JTextField();
			editNewVal.setPreferredSize(new Dimension(80, 25));
			donneesPane.add(editNewVal);
			
			contentPane.add(donneesPane);
			
			JPanel contentButt = new JPanel(new FlowLayout());
			
			updateDonneesBateauEquip = new JButton("Envoyer");
			updateDonneesBateauEquip.addActionListener(this);
			contentButt.add(updateDonneesBateauEquip);
			
			contentPane.add(contentButt, BorderLayout.SOUTH);

			frame.setVisible(true);
		}
	}

	/**
	  * <b>Gestion des actions sur les différents boutons.</b>
	  * <p>En fonction du bouton activé, ferme la page UpdatePage afin d'ouvrir une des pages suivantes :</p>
	  * <ul>
	  * <li>UpdatePage -> Bateau</li>
	  * <li>UpdatePage -> Equipement</li>
	  * <li>UpdatePage -> Bateau Equipement</li>
	  * </ul>
	  * <p>Sur la page Bateau Equipement, il y a un bouton permettant d'afficher la liste des équipements liés à l'id du bateau donnée,
	  *  il est ensuite possible de modifier un des libellés des équipements en appuyant sur le bouton avec la valeur renseignée.</p>
	  * <p>Sur les autres pages les boutons lorsqu'ils sont activés, modifie les valeurs dans la base de données avec les valeurs fournis.</p>
	  */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == validerButt) {
			String retour = (String) liste.getSelectedValue();
			if(retour == "Bateau") {
				frame.dispose();
				UpdatePage updateBateau = new UpdatePage("bateau");
			}
			else if(retour == "Equipement d'un bateau") {
				frame.dispose();
				UpdatePage updateBateau = new UpdatePage("bateauEquip");
			}
			else if(retour == "Equipement") {
				frame.dispose();
				UpdatePage updateBateau = new UpdatePage("equipement");
			}
		}
		else if(e.getSource() == updateDonneesBateau) {
			try {
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
				Statement stm = connexion.createStatement();
				stm.executeUpdate("UPDATE bateau SET " + editColonne.getText() + " = '" + editNewVal.getText() + "' WHERE idBateau = " + editIdBat.getText());
				System.out.println("Modification effectuée");
				connexion.close();
				frame.dispose();
				Interface gestionBrochure = new Interface();
			}catch (SQLException a) {
				a.printStackTrace();
			}
		}
		else if(e.getSource() == updateDonneesEquip) {
			try {
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
				Statement stm = connexion.createStatement();
				stm.executeUpdate("UPDATE equipement SET lib = '" + editNewVal.getText() + "' WHERE id = '" + editIdEquip.getText() + "'");
				System.out.println("Modification effectuée");
				connexion.close();
				frame.dispose();
				Interface gestionBrochure = new Interface();
			}catch (SQLException a) {
				a.printStackTrace();
			}
		}
		else if(e.getSource() == updateDonneesBateauEquip) {
			try {
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/marieteam","root","");
				Statement stm = connexion.createStatement();
				stm.executeUpdate("UPDATE posseder SET idEquip = " + editNewVal.getText() + " WHERE idBat = " + editIdBat.getText() + " AND idEquip = " + editIdEquip.getText());
				System.out.println("Modification effectuée");
				connexion.close();
				frame.dispose();
				Interface gestionBrochure = new Interface();
			}catch (SQLException a) {
				a.printStackTrace();
			}
		}
		else if(e.getSource() == afficherBateauEquip) {
			frame.dispose();
			UpdatePage updatePage = new UpdatePage(editIdBat.getText());
		}
	}
}