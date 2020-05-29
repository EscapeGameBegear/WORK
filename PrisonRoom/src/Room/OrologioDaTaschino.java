package Room;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OrologioDaTaschino extends Stanza{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Expand() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrologioDaTaschino window = new OrologioDaTaschino();
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
	public OrologioDaTaschino() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 100, 566, 423);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("O");
		
		JButton ClickHere = new JButton("click here");
		
		//listener del bottone
		ClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FogliettoEnigma paper = new FogliettoEnigma();
				paper.Expand();
			}
		});
		
		ClickHere.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		ClickHere.setBackground(new Color(189, 183, 107));
		ClickHere.setBounds(51, 250, 84, 13);
		frame.getContentPane().add(ClickHere);
		
		JLabel OrologioEnigma = new JLabel("");
		OrologioEnigma.setBackground(new Color(0, 0, 0));
		OrologioEnigma.setIcon(new ImageIcon(OrologioDaTaschino.class.getResource("/imageEnigmi/orologioEnig.png")));
		OrologioEnigma.setBounds(-19, 0, 634, 422);
		frame.getContentPane().add(OrologioEnigma);
		
		
		
		
	}

}
