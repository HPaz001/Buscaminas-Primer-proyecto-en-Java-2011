

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.JToolBar;
import java.awt.Container;
import java.awt.GridBagLayout;**/
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

public class TableroVisual {

	private JFrame jFrame = null;//  @jve:decl-index=0:visual-constraint="10,10"
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem intermedioMenuItem = null;
	private JMenuItem principianteMenuItem = null;
	private JMenuItem expertoMenuItem = null;
	//private JMenuItem reiniciar = null;
	private JMenuItem aboutMenuItem = null;
	private JDialog aboutDialog = null;  //  @jve:decl-index=0:visual-constraint="352,46"
	private JPanel aboutContentPane = null;
	private JTextArea aboutVersionText = null;
	private JPanel jPanel = null;
	//private int enQueDificultadStoy;// lo usaba para el reiniciar

	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(310, 326);
			jFrame.setContentPane(getJPanel());
			jFrame.setTitle("Buscaminas");
			jFrame.setResizable(false);//no poder maximizar ni cambiar el tamaño con el raton
		}
		return jFrame;
	}

	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("Juego");
			fileMenu.add(getPrincipianteMenuItem());
			fileMenu.add(getIntermedioMenuItem());
			fileMenu.add(getExpertoMenuItem());
			fileMenu.add(getExitMenuItem());							
		}
		return fileMenu;
	}
	

	private void refrescarTablero(int pInt){
		int numComponentes= jPanel.getComponentCount();//cuenta los componentes del jpanel
		for(int x=0;x<numComponentes;x++){//for que recorre del cero al numero de componentes todos ellos
			if (jPanel.getComponent(x) instanceof JButton){
				JButton botonAux = (JButton) jPanel.getComponent(x);
				Casilla casi = JuegoNuevo.getMiJuegoNuevo().getNTablero().buscarCasillaporIdString(botonAux.getName());
				if (pInt==0){//camino refrescar mientras siga el juego
					if(casi.getMarcado()==true){
						botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\banderita_roja.icon"));
						}
					else if (casi.getPulsado()){
						botonAux.setEnabled(false);
						int bombas = JuegoNuevo.getMiJuegoNuevo().getNTablero().contarBombasAlrededor(casi.getPosicion());
						if(bombas!=0){
							//meto el numero por iconos
							if (bombas == 1)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\1.png"));}
							else if (bombas == 2)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\2.png"));}
							else if (bombas == 3)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\3.png"));}
							else if (bombas == 4)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\4.png"));}
							else if (bombas == 5)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\5.png"));}
							else if (bombas == 6)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\6.png"));}
							else if (bombas == 7)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\7.png"));}
							else if (bombas == 8)
							{botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\8.png"));}
						}
					}				
				}
				else if(pInt==2){// en el caso de que halla ganado
					if(JuegoNuevo.getMiJuegoNuevo().getNTablero().esBomba(casi.getPosicion())){
						botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\banderita_roja.icon"));
					}
					botonAux.setEnabled(false);
				}
				else{ //camino sacar bombas si pierdes
					if(JuegoNuevo.getMiJuegoNuevo().getNTablero().esBomba(casi.getPosicion())){
						botonAux.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\mina.png"));
					}
					botonAux.setEnabled(false);
				}
			}
		}
		
	}
	
	private void crearBotones(int pDimension){
		int x=3 ;
		int y=3 ;
		int numNombre=0;
		for(int filas=0;filas<pDimension;filas++){//for que recorre las filas
			for(int columnas=0;columnas<pDimension;columnas++){//for que recorre las columnas
			//creamos boton
				JButton jB = new JButton();
				jB.setSize(new Dimension(25, 25));
				//jB.setEnabled(true);
				jB.setLocation(new Point(x, y));
				jB.setName("b"+numNombre);
				numNombre++;				
			//eventos
				jB.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						JButton botonPulsado = (JButton) e.getComponent(); //e.getComponent() seria el elemento que a lanzado el evento (en este caso un botn del tablero)
						Casilla casi = JuegoNuevo.getMiJuegoNuevo().getNTablero().buscarCasillaporIdString(botonPulsado.getName());
						
						//JOptionPane.showMessageDialog(null, ""+JuegoNuevo.getMiJuegoNuevo().getNTablero().cuantasQuedan());
						if (botonPulsado.getIcon()==null||casi.getMarcado()&&casi.getPulsado()==false){
							
							if(e.getButton()==1 && casi.getMarcado()==false){//1= click izq, 2= click central, 3= click der
								   if (casi.getMarcado()==false){
									if(JuegoNuevo.getMiJuegoNuevo().getNTablero().esBomba(casi.getPosicion())==true){
										casi.mostrarCasilla();
										JOptionPane.showMessageDialog(null, "Has Perdido  :( ");
										refrescarTablero(1);//el 1 saca bombas y pone todo a disabled
									}
									else if(JuegoNuevo.getMiJuegoNuevo().getNTablero().cuantasQuedan()==1&& JuegoNuevo.getMiJuegoNuevo().getNTablero().esBomba(casi.getPosicion())==false){
										JOptionPane.showMessageDialog(null, "Has Ganado!!! ");
										refrescarTablero(2);
									}
									else{
										int bombas = JuegoNuevo.getMiJuegoNuevo().getNTablero().contarBombasAlrededor(casi.getPosicion());
										casi.mostrarCasilla();
										refrescarTablero(0);//el 0 refresca el tablero con todas las casillas marcadas previamente
									}
								}
								botonPulsado.setEnabled(false);
							}
							
							if(e.getButton()==3){
								//JOptionPane.showMessageDialog(null, "Has pulsado el boton der");
								//e.getComponent(); devuelve el componente que me ha llamado
								//JOptionPane.showMessageDialog(null, "LA CASILLA ESTA MARCADA?: "+casi.getMarcado());
								if (casi.getMarcado()==false){
									botonPulsado.setIcon(new ImageIcon("C:\\Users\\Helen\\Dropbox\\Workspace_proyecto\\workspace\\Proyecto\\Imagenes\\banderita_roja.icon"));
									casi.marcarDesmarcar();
								}
								else{
									botonPulsado.setIcon(null);
									casi.marcarDesmarcar();	
								}
							}	
						}
					}
				});
				
				jPanel.add(jB, null);//añado boton al jpanel
				x=x+25;
			}
		x=3;
		y=y+25;
		}
	}
	
	private JMenuItem getPrincipianteMenuItem() {
		if (principianteMenuItem == null) {
			principianteMenuItem = new JMenuItem();
			principianteMenuItem.setText("Principiante");	
			principianteMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{	//enQueDificultadStoy=0;
					JuegoNuevo.getMiJuegoNuevo().juego(10, 15);
					//jPanel = new JPanel();
					jPanel.removeAll();
					crearBotones(10);
					jPanel.repaint();
					jFrame.setSize(262, 307);
					jFrame.setLocationRelativeTo(null);//centra la ventana en la pantalla
					JOptionPane.showMessageDialog(null, "Tienes 15 minas, Buena Suerte");
				}
			});
		}	
		
		return principianteMenuItem;
	}
	
	private JMenuItem getIntermedioMenuItem() {
		if (intermedioMenuItem == null) {
			intermedioMenuItem = new JMenuItem();
			intermedioMenuItem.setText("Intermedio");	
			intermedioMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{	//enQueDificultadStoy=1;
					JuegoNuevo.getMiJuegoNuevo().juego(15, 30);
					jPanel.removeAll();
					crearBotones(15);
					jPanel.repaint();
					jFrame.setSize(387, 432);
					jFrame.setLocationRelativeTo(null);//centra la ventana en la pantalla
					JOptionPane.showMessageDialog(null, "Tienes 30 minas, Buena Suerte");
				}
			});
		}
		
		return intermedioMenuItem;
	}

	private JMenuItem getExpertoMenuItem() {
		if (expertoMenuItem == null) {
			expertoMenuItem = new JMenuItem();
			expertoMenuItem.setText("Experto");	
			expertoMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{	//enQueDificultadStoy=2;
					JuegoNuevo.getMiJuegoNuevo().juego(20,100);
					jPanel.removeAll();
					crearBotones(20);
					jPanel.repaint();
					jFrame.setSize(512, 557);
					jFrame.setLocationRelativeTo(null);//centra la ventana en la pantalla
					JOptionPane.showMessageDialog(null, "Tienes 100 minas, Buena Suerte");
				}
			});
		}
		return expertoMenuItem;
	} 
	
	/**No lo use, ya q no puede ponerlo en la barra de menu principal
	 * 
	 * private JMenuItem getReiniciar() {
		if (expertoMenuItem == null) {
			expertoMenuItem = new JMenuItem();
			expertoMenuItem.setText("Reiniciar");	
			expertoMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{	
					if (enQueDificultadStoy==0){
						principianteMenuItem.doClick();
					}else if (enQueDificultadStoy==1){
						intermedioMenuItem.doClick();
					}else if (enQueDificultadStoy==2){
						expertoMenuItem.doClick();
					}	
				}
			}
		}
		return reiniciar;
	}*/
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}
	
	// INICIO AYUDA
	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Ayuda");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("Ayuda");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog	
	 * 	
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("Ayuda");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionText(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JTextArea getAboutVersionText() {
		if (aboutVersionText == null) {
			aboutVersionText = new JTextArea();
			aboutVersionText.setText("OBJETIVO DEL JUEGO:\nEncontrar todas las minas que haya y sin descubrir ninguna.\n\nExisten tres grados de dificultad dentro del juego: \nPrincipiante.\nIntermedio\nExperto.\n\nINSTRUCCIONES:\n• Cuando desees descubrir un cuadro, presiona el botón izquierdo del mouse.\n Si es una mina habrás perdido. \nSi aparece un número, te indicará cuantas minas hay en los recuadros que lo rodean.\n• Para marcar un recuadro del que sospeches que contiene una mina, \npresiona el botón derecho del mouse para poner la bandera, \npara desmarcarlo presiona nuevamente el botón derecho.\n");
			aboutVersionText.setEditable(false);
		}
		return aboutVersionText;
	}
	//FIN AYUDA

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setPreferredSize(new Dimension(20, 20));
			principianteMenuItem.doClick();//realiza la accion de clickear el principiante
		}
		return jPanel;
	}

	/** Launches this application*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroVisual application = new TableroVisual();
				application.getJFrame().setVisible(true);
			}
		});
	}

}