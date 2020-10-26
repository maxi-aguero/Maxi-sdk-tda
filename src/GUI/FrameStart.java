package GUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import LOGICA.*;

/**Visualiza el frame del menu principal*/
public class FrameStart extends JFrame {

    JPanel panelCredits,panelLogo;    
	Container contenedor;
	JOptionPane msjError;
	
	FrameStart(String tit){	
		 super(tit);
	   	 setSize(308,278);
         contenedor = getContentPane();
         contenedor.setBackground(Color.GREEN); 
         setLocationRelativeTo(null); 
         setResizable(false);
         
         armarPanelCredits();        
         armarPanelLogo();
	   	 
         add(panelLogo);
         add(panelCredits, BorderLayout.SOUTH);
	 }
	
	 
	 public void armarPanelCredits() { 
			
		 panelCredits = new JPanel();
  		 panelCredits.setLayout(new FlowLayout()); 
  		 panelCredits.setBackground(Color.black);
  		 panelCredits.setBorder(new LineBorder( Color.orange,5));

		 ImageIcon imgCredits=new ImageIcon("img/credits.png");		   		
	   	 JLabel lbCredits=new JLabel();
	   	 lbCredits.setIcon(imgCredits);	   	 
	   	 lbCredits.repaint();
	   	 panelCredits.add(lbCredits); 
	 }
	 
	 public void armarPanelLogo() { 

		 panelLogo = new JPanel();
		 panelLogo.setBorder(new EmptyBorder(5, 5, 5, 5));

	   	 panelLogo.setBackground(Color.black);  
		 Color colorVioleta=new Color(223, 45, 223);
	     panelLogo.setBorder(new LineBorder(colorVioleta,5));
	   	
	   	 ImageIcon imagenLogo=new ImageIcon("img/logo.png");		   		
	   	 JLabel lbLogo=new JLabel("",SwingConstants.CENTER);
	   	 lbLogo.setIcon(imagenLogo);
	   	 lbLogo.repaint();		   
	   	 panelLogo.add(lbLogo);
	   	 
	   	 ImageIcon imagenStart=new ImageIcon("img/start.png");		   		
	   	 JLabel lbStart=new JLabel("",SwingConstants.CENTER);
	   	 Icon imgdos= new  ImageIcon(imagenStart.getImage().getScaledInstance(60, 12, Image.SCALE_SMOOTH)); 
	   	 lbStart.setIcon(imgdos);	
	   	 lbStart.repaint();	
	   	 lbStart.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					setVisible(false);					
					
					Juego nuevojuego = new Juego();					
					if (nuevojuego.getErrordeCarga()==false)
					{
					
						msjError.showMessageDialog(null,"Error en el archivo para cargar el sudoku" , "Msj Error Sudoku", JOptionPane.ERROR_MESSAGE );
						
					}
					else
					{
						FrameJuego ventana = new FrameJuego("SUDOKU",nuevojuego);
			            ventana.setVisible(true);	      

					}
					
				}
			 });		   
	   	 panelLogo.add(lbStart);
	 }
	 
	  	
	     	
	     	
}


	
	