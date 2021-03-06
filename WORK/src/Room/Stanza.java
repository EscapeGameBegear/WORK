package Room;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class Stanza {

	private JFrame frame;
	//public static mousepressed();
	//public static extends(); 

	//bottoni per enigmi
	JButton EXIT = new JButton("EXIT");
	private JTextField SCAPPA;
	
	JLabel diario = new JLabel();
	JLabel orologio = new JLabel("");
	JLabel EnigmaDel15 = new JLabel("");

	//immagini visuali
	private final JLabel Front = new JLabel();
	JLabel Desk = new JLabel();
	JLabel Retro = new JLabel();
	JLabel Bed = new JLabel();
	JLabel corridoio = new JLabel();

	//bottoni visuali
	JButton ZoomFront = new JButton();
	JButton ZoomDesk = new JButton();
	JButton ZoomRetro = new JButton("");
	JButton ZoomBed = new JButton();
	JButton ZoomBed2 = new JButton("");
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stanza window = new Stanza();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//	DiaroDiUnDetenuto diario = new DiaroDiUnDetenuto();
		//	boolean controllo = DiaroDiUnDetenuto.result;

		//	FogliettoEnigma orologio = new FogliettoEnigma();
		//	boolean controllo1 = FogliettoEnigma.resultOr;

		//	EnigmaDelQuindici gioco = new EnigmaDelQuindici(0, 0, 0);
		//	boolean controllo2 = EnigmaDelQuindici.resultQui;

	}

	/**
	 * Create the application.
	 */
	public Stanza() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 20, 1113, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		//Inserire immagini visuali

		//label enigmi
		diario.setIcon(new ImageIcon(Stanza.class.getResource("/imageEnigmi/Diario.png")));
		diario.setBounds(577, 406, 133, 112);
		frame.getContentPane().add(diario);

		orologio.setIcon(new ImageIcon(Stanza.class.getResource("/imageEnigmi/orologio-removebg-preview (1).png")));
		orologio.setBounds(783, 291, 101, 81);
		frame.getContentPane().add(orologio);

		EnigmaDel15.setIcon(new ImageIcon(Stanza.class.getResource("/imageEnigmi/15.png")));
		EnigmaDel15.setBounds(381, 476, 80, 81);
		frame.getContentPane().add(EnigmaDel15);

		//gli enigmi non sono visibili con l'inizio del gioco
		orologio.setVisible(false);
		diario.setVisible(false);
		EnigmaDel15.setVisible(false);


		//saranno visibili solo ZoomDesk e ZoomBed
		ZoomDesk.setVisible(true);
		ZoomBed.setVisible(true);
		ZoomFront.setVisible(false);
		ZoomRetro.setVisible(false);
		ZoomBed2.setVisible(false);
		ZoomFront.setVisible(false);
		
		//bottone per uscire dalla stanza
		SCAPPA = new JTextField();
		SCAPPA.setBackground(Color.DARK_GRAY);
		EXIT.setVisible(false);

		//Desk
		Desk.setIcon(new ImageIcon(Stanza.class.getResource("/immaginiStanza/scrivania.jpg")));
		Desk.setBounds(-103, -80, 1200, 814);
		frame.getContentPane().add(Desk);
		Desk.setVisible(false);

		ZoomDesk.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				diario.setVisible(true);
				Desk.setVisible(true);
				ZoomDesk.setVisible(false);
				ZoomBed.setVisible(false);	
				ZoomBed2.setVisible(true);

			}
		});

		//Retro
		Retro.setIcon(new ImageIcon(Stanza.class.getResource("/immaginiStanza/retro.jpg")));
		Retro.setBounds(0, -17, 1200, 692);
		frame.getContentPane().add(Retro);
		Retro.setVisible(false);

		EXIT.setForeground(Color.WHITE);
		EXIT.setBounds(567, 174, 74, 23);
		EXIT.setBackground(Color.RED);
		frame.getContentPane().add(EXIT);
		
		SCAPPA.setForeground(Color.RED);
		SCAPPA.setFont(new Font("Tahoma", Font.PLAIN, 70));
		SCAPPA.setText("SCAPPA FINCHE' SEI IN TEMPO!");
		SCAPPA.setBounds(32, 35, 1013, 91);
		frame.getContentPane().add(SCAPPA);
		SCAPPA.setColumns(10);
		SCAPPA.setVisible(false);
		
		corridoio.setIcon(new ImageIcon(Stanza.class.getResource("/imageEnigmi/corridoio.jpg")));
		corridoio.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(corridoio);
		corridoio.setVisible(false);	

		
		

		ZoomRetro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EXIT.setVisible(true);
				ZoomFront.setVisible(true);
				Retro.setVisible(true);
				ZoomRetro.setVisible(false);
				orologio.setVisible(false);
				EnigmaDel15.setVisible(true);

			}
		});

		ZoomFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Front.setVisible(true);
				ZoomDesk.setVisible(true);
				ZoomBed.setVisible(true);
				Desk.setVisible(false);
				Retro.setVisible(false);
				Bed.setVisible(false);
				EnigmaDel15.setVisible(false);
				ZoomFront.setVisible(false);
			}
		});

		//bed
		Bed.setIcon(new ImageIcon(Stanza.class.getResource("/immaginiStanza/bed.jpg")));
		Bed.setBounds(4, -42, 1200, 738);
		frame.getContentPane().add(Bed);
		Bed.setVisible(false);

		ZoomBed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bed.setVisible(true);
				ZoomBed.setVisible(false);
				ZoomDesk.setVisible(false);
				orologio.setVisible(true);
				ZoomRetro.setVisible(true);
				diario.setVisible(false);
			}
		});
		ZoomBed2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ZoomRetro.setVisible(true);
				Desk.setVisible(false);
				diario.setVisible(false);
				Front.setVisible(false);
				Retro.setVisible(false);
				Bed.setVisible(true);
				ZoomBed2.setVisible(false);
				orologio.setVisible(true);
			}
		});


		//Desk
		ZoomDesk.setBackground(new Color(105, 105, 105));
		ZoomDesk.setBounds(773, 339, 45, 9);
		frame.getContentPane().add(ZoomDesk);

		//Retro
		ZoomRetro.setBackground(Color.DARK_GRAY);
		ZoomRetro.setBounds(100, 108, 33, 18);
		frame.getContentPane().add(ZoomRetro);

		//Bed
		ZoomBed.setBackground(new Color(105, 105, 105));
		ZoomBed.setBounds(465, 457, 19, 18);
		frame.getContentPane().add(ZoomBed);

		//bed2
		ZoomBed2.setBackground(Color.DARK_GRAY);
		ZoomBed2.setBounds(400, 316, 45, 9);
		frame.getContentPane().add(ZoomBed2);

		//front
		ZoomFront.setBackground(Color.DARK_GRAY);
		ZoomFront.setBounds(596, 208, 45, 9);
		frame.getContentPane().add(ZoomFront);




		//Aprire gli enigmi



		//aprire enigma del 15
		EnigmaDel15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				EnigmaDelQuindici.Expand();
			}
		});

		//aprire enigma diario

		diario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				DiaroDiUnDetenuto.Expand();
			}
		});

		//aprire enigma orologio
		Front.setIcon(new ImageIcon(Stanza.class.getResource("/ImmaginiStanza/cell.jpg")));
		Front.setBounds(0, 0, 1204, 652);
		frame.getContentPane().add(Front);
		
		

		orologio.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				OrologioDaTaschino.Expand();
			}

		});	

		//controllo per uscire dalla stanza 


		EXIT.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (DiaroDiUnDetenuto.result == true && FogliettoEnigma.resultOr == true && EnigmaDelQuindici.resultQui == true ) {
					
					SCAPPA.setVisible(true);
					corridoio.setVisible(true);
					
					ZoomDesk.setVisible(false);
					ZoomBed.setVisible(false);
					ZoomFront.setVisible(false);
					ZoomRetro.setVisible(false);
					ZoomBed2.setVisible(false);
					
					Front.setVisible(false);
					Retro.setVisible(false);
					Bed.setVisible(false);
					Desk.setVisible(false);
					
					EXIT.setVisible(false);
	
					EnigmaDel15.setVisible(false);
					diario.setVisible(false);
					orologio.setVisible(false);
			
				} else {
					System.out.println("FAIL");
				} 
			}
		});  

	}
}
