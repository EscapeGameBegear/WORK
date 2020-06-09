package Room;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//import EnigmaOrologio.FogliettoEnigma;
//import InterfacciaGrafica.Gioco;

public class EnigmaDelQuindici extends JPanel {
	


	/* Per creare il gioco del quindici mi servirà: variabili per misura tass, mis griglia, colore, etc... metodi per: 
	 * - calcolare la grandezza della griglia e dei tasselli
	 * - mescolare i tasselli di nuovo
	 * - restart dopo un game over
	 * - l'ultimo tassello vuoto deve stare in fondo
	 * - scriveresul tassello
	 * - messaggi di errore
	 * - disegnare griglia a schermo
	 * - controllare le posiizoni dei tasselli

	 */

		//posizione del tassello vuoto
		private int PosEmptyTass;

		//istanziare misura gioco 		- size
		private int MisuraGioco;

		//dimensione della griglia (interfaccia utente)			-dimension
		private int DimensioneGridUI;

		//margine per la griglia sul frame
		private int MarginGrid;

		//dimensione della griglia size UI				-gridsize
		private int DimGrid;				

		//colore griglia
		private static final Color COLOREGRIGLIA= new Color(70, 70, 35);

		//numero dei tasselli			-nbtiles
		private int NumTass;		

		//dimensione dei tasselli				tilessize
		private int DimTass;

		//oggetto casuale per mescolare le tessere
		private static final Random RANDOM= new Random();

		//memorizzare le tessere in una array (int)
		private int [] tasselli;
//		private String [] tasselli= {"la", "tua", "fine", "è", "vicina"};
		

		//true se il gioco finisce, altrimenti false. 
		private boolean gameOver;

		static boolean resultQui= false;
		
		
		//metodo per calcolare grandezza, dimensione e margine. 

		public EnigmaDelQuindici(int Mis, int Dim,int Margin) {
			this.MisuraGioco= Mis; 
			DimensioneGridUI =  Dim; 
			MarginGrid=  Margin; 

			//visualizzazione delle piastrelle
			NumTass = Mis * Mis - 1; 		 //Il -1 serve per non contare il tassello vuoto 
			tasselli = new int [Mis * Mis];

			//calcolo della grandezza della griglia e dei tasselli
			DimGrid = (Dim -2 * MarginGrid);
			DimTass = DimGrid / Mis;

			setPreferredSize(new Dimension(DimensioneGridUI, DimensioneGridUI + MarginGrid));
			setBackground(Color.BLACK);
			setForeground(COLOREGRIGLIA);
			setFont(new Font("Chiller", Font.BOLD, 60));

			gameOver= true;

			
	//impostare metodo per click del mouse
			addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {

					//consentire all'utente di interagire sulla griglia facendo clic
					//poter interagire al click del mouse
					//muovere tasselli
					if(gameOver) {
						newGame();
					}else {
						//posizione al click
						int ex= e.getX() - Margin;
						int ey= e.getY() - Margin;

						//cliccare solo nella griglia
						if (ex < 0 || ex > DimGrid || ey < 0 || ey > DimGrid) 
							return;

						// posizione nella griglia
						int c1 = ex / DimTass;
						int r1 = ey / DimTass;

						//posizione del tassello vuoto
						int c2 = PosEmptyTass % MisuraGioco;
						int r2 = PosEmptyTass / MisuraGioco;

						//coordinate
						int clickTas = r1 * MisuraGioco + c1;

						int dir= 0;

						//direzione
						if (c1 == c2 && Math.abs(r1 -r2) > 0) 
							dir = (r1 -r2)> 0 ? MisuraGioco : -MisuraGioco;
							else if (r1 == r2 && Math.abs(c1 -c2) > 0)
								dir = (c1 -c2)> 0 ? 1 : - 1;

								if (dir != 0) {
									do {
										int newPosEmptyTass = PosEmptyTass + dir;
										tasselli[PosEmptyTass] = tasselli[newPosEmptyTass];
										PosEmptyTass = newPosEmptyTass;
									} while(PosEmptyTass != clickTas);

									tasselli[PosEmptyTass] = 0;
								}

								//se il gioco è RISOLTO
								gameOver = isSolved();
								
					}

					repaint();			//muove i tasti al click
				
				}

			});

			newGame();
			resultQui= true;
		}

		
		private void newGame() {
			do {
				reset(); 	//resettare gioco
				shuffle();	//mescolare tasselli

			} while (!isSalvable());	//finchè non sarà salvata

			gameOver= false;
		}

		private void reset() {
			for (int i = 0; i < tasselli.length; i++) {
				tasselli[i] = (i +1) % tasselli.length;		//calcolare il resto dei tasselli 
			}

			//impostare il tassello vuoto alla fine
			PosEmptyTass = tasselli.length -1; 
		}

		private void shuffle() {

			int n= NumTass;			//non comprendere il tassello vuoto perchè deve rimanere per ultimo

			while (n > 1) {
				int r = RANDOM.nextInt(n--);
				int tmp= tasselli[r];
				tasselli[r] = tasselli[n];
				tasselli[n] = tmp;

			}

		}

		//solo metà ordinamento del puzzle sarà salvabile. 
		//ogni volta che un tassello sarà preceduto da una tassello con un valore più alto, 
		//verrà eseguita un'inversione. con il tassello vuoto in ultima posizione,
		//il numero di inversione deve essere pari affinché il puzzle sia salvabile

		private boolean isSalvable() {
			int Invers = 0;

			for (int i = 0; i < NumTass; i++) {
				for (int j = 0; j < i; j++) {
					if (tasselli[j] > tasselli[i])
						Invers ++;
				}

			}
			return Invers %2 == 0;
		}


		private boolean isSolved() {
			if (tasselli[tasselli.length -1] != 0)		//se il tassello vuoto non è ultimo, non salvare
				return false;

			for (int i = NumTass -1; i >= 0; i--) {
				if (tasselli[i] != i +1) 
					return false;
			}

			return true;

		}	


		private void drawGrid(Graphics2D g) {
			
			
			
			for (int i = 0; i < tasselli.length; i++) {

				//convertire in un array 2D
				int r = i / MisuraGioco;
				int c = i % MisuraGioco;

				//coordinate
				int x= MarginGrid + c * DimTass;
				int y= MarginGrid + r * DimTass;

				//controllo del tassello vuoto
				if (tasselli[i] == 0) {
					if (gameOver) {
						g.setColor(COLOREGRIGLIA);
						drawCenteredString(g, "✔" , x, y);
					}
				//	Risultato result = new Risultato();
					continue;
				}

				//per gli altri tasselli
				g.setColor(getForeground());
				g.fillRoundRect(x, y, DimTass, DimTass, 25, 25);
				g.setColor(Color.BLACK);
				g.drawRoundRect(x, y, DimTass, DimTass, 25, 25);
				g.setColor(Color.WHITE);

				drawCenteredString(g, String.valueOf(tasselli[i]), x , y);
			}

		}

		

		//mandare messaggio per gameover
		private void drawStartMessage(Graphics2D g) {
			if (gameOver) {
				g.setFont(getFont().deriveFont(Font.BOLD, 18));
				g.setColor(COLOREGRIGLIA);
				String s= "Ricomincia";

				g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) /2, getHeight() - MarginGrid);	//ottenre spaziatura dei caratteri,
				//altezza e larghezza
			}
		}

		private void drawCenteredString(Graphics2D g,String finish, int x, int y) {

			//centrare la stringa nella tessera
			FontMetrics fMetr = g.getFontMetrics();
			int asc = fMetr.getAscent();			//salire
			int desc = fMetr.getDescent();			//scendere
			g.drawString(finish, x + (DimTass - fMetr.stringWidth(finish)) / 2, y + (asc + (DimTass -(asc - desc)) /2)); //centrare la stringa
		}

		//documentazione:  https://docs.oracle.com/javase/tutorial/2d/advanced/quality.html
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2D = (Graphics2D) g;

			//impostare rendering grafico
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			drawGrid(g2D);
			drawStartMessage(g2D);
		}


		public static void Expand() {
			SwingUtilities.invokeLater(() -> {
				JFrame frame = new JFrame();
		//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setTitle("Enigma del 15");
				frame.setResizable(false);
				frame.add(new EnigmaDelQuindici(2, 550, 30), BorderLayout.CENTER);
				frame.pack();

				//posizionarla al cnetro dello schermo
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				
				//frame.getContentPane().add(finish);
			});
		}

	/*	public static void Expand() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiaroDiUnDetenuto window = new DiaroDiUnDetenuto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
		
	}
