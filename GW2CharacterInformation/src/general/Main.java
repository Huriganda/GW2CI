package general;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import java.awt.Toolkit;

public class Main extends JFrame {

	private static final long serialVersionUID = -997898219508751946L;
	public static JPanel contentPane;
	static JTextField tF_APIToken;
	static JComboBox<String> cB_CharNames = new JComboBox<String>();
	static JLabel lbl_KlasseIcon = new JLabel("");
	static JTextPane textPane = new JTextPane();
	static JTextPane tP_ItemInfo = new JTextPane();

	// Icons für die einzelnen Items
	static JLabel lbl_KopfIcon = new JLabel(" ");
	static JLabel lbl_SchulterIcon = new JLabel(" ");
	static JLabel lbl_HandschuhIcon = new JLabel(" ");
	static JLabel lbl_BrustIcon = new JLabel(" ");
	static JLabel lbl_SchuhIcon = new JLabel(" ");
	static JLabel lbl_Waffe1AIcon = new JLabel(" ");
	static JLabel lbl_Waffe1BIcon = new JLabel(" ");
	static JLabel lbl_Waffe2AIcon = new JLabel(" ");
	static JLabel lbl_Waffe2BIcon = new JLabel(" ");
	static JLabel lbl_RueckenIcon = new JLabel(" ");
	static JLabel lbl_Ohrring1Icon = new JLabel(" ");
	static JLabel lbl_Ohrring2Icon = new JLabel(" ");
	static JLabel lbl_AmulettIcon = new JLabel(" ");
	static JLabel lbl_Ring1Icon = new JLabel(" ");
	static JLabel lbl_Ring2Icon = new JLabel(" ");
	static JLabel lbl_ErntesichelIcon = new JLabel(" ");
	static JLabel lbl_HolzaxtIcon = new JLabel(" ");
	static JLabel lbl_SpitzhackeIcon = new JLabel(" ");
	static JLabel lbl_Unterwasserwaffe1Icon = new JLabel(" ");
	static JLabel lbl_Unterwasserwaffe2Icon = new JLabel(" ");
	static JLabel lbl_AtemmaskeIcon = new JLabel(" ");
	static JLabel lbl_HoseIcon = new JLabel(" ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws ParseException 
	 */
	public Main() throws IOException, ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/GuildWars2.PNG")));
		setTitle("Guildwars 2 Charakter Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 887, 1010);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);

		JMenuItem mntmSchlieen = new JMenuItem("Schließen");
		mntmSchlieen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		mntmSchlieen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				InputEvent.ALT_MASK));
		mnDatei.add(mntmSchlieen);

		JMenu mnInfo = new JMenu("Info");
		menuBar.add(mnInfo);

		JMenuItem mntmber = new JMenuItem("Über");
		mnInfo.add(mntmber);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tF_APIToken = new JTextField(
				"A3F25477-8650-BB4B-BC4C-A72DF768B876A4D5E804-779F-4843-9E15-1028996B6CE5");
		tF_APIToken.setToolTipText("Hier API-Token einfügen");
		tF_APIToken.setBounds(112, 16, 385, 26);
		contentPane.add(tF_APIToken);
		tF_APIToken.setColumns(10);

		JLabel lblApitoken = new JLabel("API-Token:");
		lblApitoken.setBounds(15, 19, 82, 20);
		contentPane.add(lblApitoken);

		cB_CharNames.setToolTipText("Deine Charaktere");
		cB_CharNames.setBounds(642, 16, 208, 26);
		contentPane.add(cB_CharNames);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 865, 2);
		contentPane.add(separator);

		JButton btnAbsenden = new JButton("Absenden");
		btnAbsenden.setBounds(512, 15, 115, 29);
		contentPane.add(btnAbsenden);

		JLabel lblKopf = new JLabel("Kopf:");
		lblKopf.setBounds(15, 98, 69, 20);
		contentPane.add(lblKopf);

		lbl_KopfIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_KopfIcon.setLabelFor(lblKopf);
		lbl_KopfIcon.setBounds(112, 76, 64, 64);
		lbl_KopfIcon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(lbl_KopfIcon);

		JLabel lblSchulter = new JLabel("Schulter:");
		lblSchulter.setBounds(15, 178, 69, 20);
		contentPane.add(lblSchulter);

		lbl_SchulterIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_SchulterIcon.setBorder(BorderFactory.createLineBorder(Color.black,
				1));
		lbl_SchulterIcon.setBounds(112, 156, 64, 64);
		contentPane.add(lbl_SchulterIcon);

		JLabel lblHandschuhe = new JLabel("Handschuhe:");
		lblHandschuhe.setBounds(15, 257, 98, 20);
		contentPane.add(lblHandschuhe);

		lbl_HandschuhIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_HandschuhIcon.setBorder(BorderFactory.createLineBorder(Color.black,
				1));
		lbl_HandschuhIcon.setBounds(112, 236, 64, 64);
		contentPane.add(lbl_HandschuhIcon);

		lbl_BrustIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_BrustIcon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lbl_BrustIcon.setBounds(112, 316, 64, 64);
		contentPane.add(lbl_BrustIcon);

		lbl_SchuhIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_SchuhIcon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lbl_SchuhIcon.setBounds(112, 476, 64, 64);
		contentPane.add(lbl_SchuhIcon);

		JLabel lblBrust = new JLabel("Brust:");
		lblBrust.setBounds(15, 338, 69, 20);
		contentPane.add(lblBrust);

		JLabel lblHose = new JLabel("Hose:");
		lblHose.setBounds(15, 418, 69, 20);
		contentPane.add(lblHose);

		JLabel lblSchuhe = new JLabel("Schuhe:");
		lblSchuhe.setBounds(15, 498, 69, 20);
		contentPane.add(lblSchuhe);

		lbl_Waffe1AIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Waffe1AIcon.setBorder(BorderFactory
				.createLineBorder(Color.black, 1));
		lbl_Waffe1AIcon.setBounds(112, 556, 64, 64);
		contentPane.add(lbl_Waffe1AIcon);

		lbl_Waffe1BIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Waffe1BIcon.setBorder(BorderFactory
				.createLineBorder(Color.black, 1));
		lbl_Waffe1BIcon.setBounds(112, 716, 64, 64);
		contentPane.add(lbl_Waffe1BIcon);

		lbl_Waffe2AIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Waffe2AIcon.setBorder(BorderFactory
				.createLineBorder(Color.black, 1));
		lbl_Waffe2AIcon.setBounds(112, 636, 64, 64);
		contentPane.add(lbl_Waffe2AIcon);

		lbl_Waffe2BIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Waffe2BIcon.setBorder(BorderFactory
				.createLineBorder(Color.black, 1));
		lbl_Waffe2BIcon.setBounds(112, 796, 64, 64);
		contentPane.add(lbl_Waffe2BIcon);

		JLabel lblWaffea = new JLabel("Waffe 1A:");
		lblWaffea.setBounds(15, 578, 82, 20);
		contentPane.add(lblWaffea);

		JLabel lblWaffeb = new JLabel("Waffe 1B:");
		lblWaffeb.setBounds(15, 738, 82, 20);
		contentPane.add(lblWaffeb);

		JLabel lblWaffea_1 = new JLabel("Waffe 2A:");
		lblWaffea_1.setBounds(15, 658, 82, 20);
		contentPane.add(lblWaffea_1);

		JLabel lblWaffeb_1 = new JLabel("Waffe 2B:");
		lblWaffeb_1.setBounds(15, 818, 82, 20);
		contentPane.add(lblWaffeb_1);

		lbl_RueckenIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_RueckenIcon.setBorder(BorderFactory
				.createLineBorder(Color.black, 1));
		lbl_RueckenIcon.setBounds(786, 76, 64, 64);
		contentPane.add(lbl_RueckenIcon);

		lbl_Ohrring1Icon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Ohrring1Icon.setBorder(BorderFactory.createLineBorder(Color.black,
				1));
		lbl_Ohrring1Icon.setBounds(786, 156, 64, 64);
		contentPane.add(lbl_Ohrring1Icon);

		lbl_Ohrring2Icon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Ohrring2Icon.setBorder(BorderFactory.createLineBorder(Color.black,
				1));
		lbl_Ohrring2Icon.setBounds(786, 235, 64, 64);
		contentPane.add(lbl_Ohrring2Icon);

		lbl_AmulettIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_AmulettIcon.setBorder(BorderFactory
				.createLineBorder(Color.black, 1));
		lbl_AmulettIcon.setBounds(786, 316, 64, 64);
		contentPane.add(lbl_AmulettIcon);

		lbl_Ring1Icon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Ring1Icon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lbl_Ring1Icon.setBounds(786, 396, 64, 64);
		contentPane.add(lbl_Ring1Icon);

		lbl_Ring2Icon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Ring2Icon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lbl_Ring2Icon.setBounds(786, 476, 64, 64);
		contentPane.add(lbl_Ring2Icon);

		lbl_ErntesichelIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_ErntesichelIcon.setBorder(BorderFactory.createLineBorder(
				Color.black, 1));
		lbl_ErntesichelIcon.setBounds(786, 556, 64, 64);
		contentPane.add(lbl_ErntesichelIcon);

		lbl_HolzaxtIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_HolzaxtIcon.setBorder(BorderFactory
				.createLineBorder(Color.black, 1));
		lbl_HolzaxtIcon.setBounds(786, 636, 64, 64);
		contentPane.add(lbl_HolzaxtIcon);

		lbl_SpitzhackeIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_SpitzhackeIcon.setBorder(BorderFactory.createLineBorder(
				Color.black, 1));
		lbl_SpitzhackeIcon.setBounds(786, 716, 64, 64);
		contentPane.add(lbl_SpitzhackeIcon);

		lbl_Unterwasserwaffe1Icon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Unterwasserwaffe1Icon.setBorder(BorderFactory.createLineBorder(
				Color.black, 1));
		lbl_Unterwasserwaffe1Icon.setBounds(786, 796, 64, 64);
		contentPane.add(lbl_Unterwasserwaffe1Icon);

		JLabel lblRcken = new JLabel("Ruecken:");
		lblRcken.setBounds(621, 98, 69, 20);
		contentPane.add(lblRcken);

		JLabel lblOhrring = new JLabel("Ohrring 1:");
		lblOhrring.setBounds(621, 178, 82, 20);
		contentPane.add(lblOhrring);

		JLabel lblSpitzhacke = new JLabel("Spitzhacke:");
		lblSpitzhacke.setBounds(621, 738, 82, 20);
		contentPane.add(lblSpitzhacke);

		JLabel lblHolzaxt = new JLabel("Holzaxt:");
		lblHolzaxt.setBounds(621, 658, 69, 20);
		contentPane.add(lblHolzaxt);

		JLabel lblErntesichel = new JLabel("Erntesichel:");
		lblErntesichel.setBounds(621, 578, 92, 20);
		contentPane.add(lblErntesichel);

		JLabel lblOhrring_1 = new JLabel("Ohrring 2:");
		lblOhrring_1.setBounds(621, 257, 82, 20);
		contentPane.add(lblOhrring_1);

		JLabel lblAmulett = new JLabel("Amulett:");
		lblAmulett.setBounds(621, 338, 69, 20);
		contentPane.add(lblAmulett);

		JLabel lblRing = new JLabel("Ring 1:");
		lblRing.setBounds(621, 418, 69, 20);
		contentPane.add(lblRing);

		JLabel lblRing_1 = new JLabel("Ring 2:");
		lblRing_1.setBounds(621, 498, 69, 20);
		contentPane.add(lblRing_1);

		lbl_Unterwasserwaffe2Icon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_Unterwasserwaffe2Icon.setBorder(BorderFactory.createLineBorder(
				Color.black, 1));
		lbl_Unterwasserwaffe2Icon.setBounds(786, 876, 64, 64);
		contentPane.add(lbl_Unterwasserwaffe2Icon);

		lbl_AtemmaskeIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_AtemmaskeIcon.setBorder(BorderFactory.createLineBorder(Color.black,
				1));
		lbl_AtemmaskeIcon.setBounds(112, 876, 64, 64);
		contentPane.add(lbl_AtemmaskeIcon);

		JLabel lblAtemmaske = new JLabel("Atemmaske:");
		lblAtemmaske.setBounds(15, 898, 98, 20);
		contentPane.add(lblAtemmaske);

		JLabel lblUnterwas = new JLabel("Unterwasserwaffe 1:");
		lblUnterwas.setBounds(621, 815, 150, 26);
		contentPane.add(lblUnterwas);

		JLabel lblUnterwasserwaffe = new JLabel("Unterwasserwaffe 2:");
		lblUnterwasserwaffe.setBounds(621, 898, 150, 20);
		contentPane.add(lblUnterwasserwaffe);

		lbl_KlasseIcon.setBounds(453, 76, 128, 128);
		contentPane.add(lbl_KlasseIcon);
		textPane.setEditable(false);

		textPane.setBounds(219, 220, 362, 160);
		textPane.setBorder(BorderFactory.createLineBorder(Color.black,
				1));
		contentPane.add(textPane);

		lbl_HoseIcon.setBounds(112, 396, 64, 64);
		contentPane.add(lbl_HoseIcon);
		lbl_HoseIcon.setIcon(new ImageIcon(Main.class
				.getResource("/images/nothing.png")));
		lbl_HoseIcon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		tP_ItemInfo.setEditable(false);
		tP_ItemInfo.setBounds(219, 418, 362, 442);
		tP_ItemInfo.setBorder(BorderFactory.createLineBorder(Color.black,
				1));
		contentPane.add(tP_ItemInfo);
		
		Connection conn = new Connection();
		
		
		/*lbl_KlasseIcon.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					waffe1a.getBasicContent(30704);
					helmet.getBasicContent(48201);
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});*/

		btnAbsenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String APIAcessToken = tF_APIToken.getText();
				try {
					
					if (conn.isAlreadyIn() == false) {
						conn.getCharNames(APIAcessToken);
						JOptionPane.showMessageDialog(contentPane, "Charaktere erfolgreich importiert!");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Charaktere bereits importiert!","Warnung", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}
			}
		});

		cB_CharNames.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(cB_CharNames.getSelectedItem().toString().equals(" "))) {
					String CharName = (String) cB_CharNames.getSelectedItem();
					try {
						Connection.getConnection(CharName);
					} catch (IOException | ParseException | InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
