package general;

import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

public class wallet extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5024777681131116744L;
	private JPanel contentPane;
	static JList list = new JList();
	static DefaultListModel listModel = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wallet frame = new wallet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public wallet() {
				
		setIconImage(Toolkit.getDefaultToolkit().getImage(wallet.class.getResource("/images/GuildWars2.PNG")));
		setTitle("Geldbörse");
		setDefaultCloseOperation(wallet.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		list.setBounds(10, 11, 223, 469);
		contentPane.add(list);
		try {
			Connection.getWallet(Main.tF_APIToken.getText().toString());
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
