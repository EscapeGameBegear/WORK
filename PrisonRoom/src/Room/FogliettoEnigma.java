package Room;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;

public class FogliettoEnigma {

	private JFrame frame;
	private JTextField Testo;

	/**
	 * Launch the application.
	 */
	public static void Expand() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FogliettoEnigma window = new FogliettoEnigma();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FogliettoEnigma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 100, 730, 560);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Che ore sono?");
		
		JLabel FoglioEnigma = new JLabel();
		JLabel Penna = new JLabel("penna");
		JButton Submit = new JButton();
		Submit.setText("✔");
		Testo = new JTextField();
		
		//testo  submit non sono visibili all'iniizo 
		Submit.setVisible(false);
		Testo.setVisible(false);
		
		Penna.setIcon(null);
		Penna.setBounds(488, 463, 99, 47);
		frame.getContentPane().add(Penna);
		
		Penna.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Submit.setVisible(true);
				Testo.setVisible(true);
				
			}
		});
		
		
		Testo.setText("");
		Testo.setFont(new Font("Tekton Pro", Font.PLAIN, 24));
		Testo.setBounds(325, 234, 75, 38);
		frame.getContentPane().add(Testo);
		Testo.setColumns(10);
		
		
		FoglioEnigma.setIcon(new ImageIcon(FogliettoEnigma.class.getResource("/imageEnigmi/enigmaOra.jpg")));
		FoglioEnigma.setBounds(0, 0, 768, 534);
		frame.getContentPane().add(FoglioEnigma);
		
		
		Submit.setBackground(new Color(0, 100, 0));
		Submit.setBounds(399, 232, 48, 38);
		frame.getContentPane().add(Submit);
		Submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String ora = Testo.getText().toString();
				OrologioDaTaschino orario = new OrologioDaTaschino();
				
				if (ora.equals("18:00") || ora.equals("18.00") ) {
					frame.setVisible(false);
				} else {
				Submit.setBackground(new Color(255, 0, 0));
				}
				
			}
		});
		
		
	}
}
