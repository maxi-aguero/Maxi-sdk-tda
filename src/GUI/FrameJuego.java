package GUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import LOGICA.*;


public class FrameJuego extends JFrame {
		
    JPanel panelJuego,panelControles,panelTiempo;	
    JLabel lb_phora,lb_shora,lb_dospuntoi,lb_pmin,lb_smin,lb_dospuntof,lb_pseg,lb_sseg;    	
	JLabel [][] lb_entrada=new JLabel[9][9];
    Container contenedor;	
	Timer reloj;
	Juego vjuego;
	 	
	FrameJuego(String tit,Juego juego){	
		 super(tit);	     
	   	 setSize(456,469);
         contenedor = getContentPane();
         contenedor.setBackground(Color.GREEN);        
	 	 vjuego=juego;	
	 	 
         armarPanelJuego();
         armarPanelControles();
         armarPaneltiempo();
         
         contenedor.add(panelJuego);      
         contenedor.add(panelControles,BorderLayout.SOUTH);
         contenedor.add(panelTiempo,BorderLayout.NORTH);
                 
         setLocationRelativeTo(null);      
	 }	 

/***Agrega un label  que tiene la particularidad de iniciar de nuevo la partida*/
	 private void armarPanelControles() {	
		 
		 panelControles= new JPanel();		 
		 panelControles.setLayout(new GridLayout(1,1,10,10)); 
		 panelControles.setBounds(20,20,600,300);
		 panelControles.setBorder(new LineBorder( Color.orange,5));		 
		 panelControles.setBackground(Color.black); 
	
		 ImageIcon img_tryagain=new ImageIcon("img/tryagain.png");		   		
	   	 JLabel lbTryagain=new JLabel("",SwingConstants.CENTER);
	   	 lbTryagain.setIcon(img_tryagain);
	   	 lbTryagain.repaint();
	   	 lbTryagain.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Juego nuevojuego = new Juego();
					FrameJuego ventana= new FrameJuego("SUDOKU",nuevojuego);					
					ventana.setVisible(true);
					
				}
			 });		
	   	 panelControles.add(lbTryagain);	   	 
	 }	 
	 
/**gestiona el tiempo y setea los labels que contiene los numeros para mostrar el tiempo transcurrido desde iniciar partida*/ 
	 private void armarPaneltiempo() { 
		 
		 	 lb_pseg=new JLabel();
		 	 lb_sseg=new JLabel();	         
		 	 lb_dospuntof=new JLabel();
	         lb_pmin=new JLabel();
	         lb_smin=new JLabel();
	         lb_dospuntoi=new JLabel();
	         lb_phora=new JLabel();
	         lb_shora=new JLabel();	
	         
		 	 Tiempo t = vjuego.getTiempo();		 	 
			 reloj=new Timer(10,new ActionListener(){
	 			public void actionPerformed(ActionEvent e){ 		     	
	 				
	 				vjuego.accionar(t);		 		       
	   		
	 		   		vjuego.getTiempo().setprimerdigSeg(new ImageIcon("img/t"+vjuego.getTiempo().get_psegundo()+".png"));
	 		   		vjuego.getTiempo().setsegundodigSeg(new ImageIcon("img/t"+vjuego.getTiempo().get_ssegundo()+".png"));
	 		   		
	 		   		vjuego.getTiempo().setsegundodigMin(new ImageIcon("img/t"+vjuego.getTiempo().get_sminuto()+".png"));
	 		   		vjuego.getTiempo().setprimerdigMin(new ImageIcon("img/t"+vjuego.getTiempo().get_pminuto()+".png"));
	 		   		
	 		   		vjuego.getTiempo().setsprimerdigHora(new ImageIcon("img/t"+vjuego.getTiempo().get_phora()+".png"));
	 		   		vjuego.getTiempo().setssegundodigHora(new ImageIcon("img/t"+vjuego.getTiempo().get_shora()+".png"));

	 		   		ImageIcon img_primerdigseg=vjuego.getTiempo().getprimerdigSeg();
	 		   		ImageIcon img_segdigseg=vjuego.getTiempo().getsegundodigSeg();
	 		   		
	 		   		ImageIcon img_segdigmin=vjuego.getTiempo().getsegundodigMin();
	 		   		ImageIcon img_primerdigmin=vjuego.getTiempo().getprimerdigMin();
	 		   		
	 		   		ImageIcon img_primerdighora=vjuego.getTiempo().getprimerdigHora();
	 		   		ImageIcon img_segundodighora=vjuego.getTiempo().getsegundodigHora();
	 		   		
	 		   		ImageIcon img_puntos=vjuego.getTiempo().getpuntos();
	 		   	
	 		   		lb_phora.setIcon(img_primerdighora);
	 		   		lb_phora.repaint();
	 		   		panelTiempo.add(lb_phora);
	 		   		
	 		   		lb_shora.setIcon(img_segundodighora);
	 		   		lb_shora.repaint();
	 		   		panelTiempo.add(lb_shora);
	 		   		
	 		   		lb_dospuntoi.setIcon(img_puntos);
	 		   		lb_dospuntoi.repaint();
			   		panelTiempo.add(lb_dospuntoi); 
			   		
			   		lb_pmin.setIcon(img_primerdigmin);
			   		lb_pmin.repaint();
			   		panelTiempo.add(lb_pmin); 		   		
	 		   		
			   		lb_smin.setIcon(img_segdigmin);
			   		lb_smin.repaint();
			   		panelTiempo.add(lb_smin);
			   		
			   		lb_dospuntof.setIcon(img_puntos);
			   		lb_dospuntof.repaint();
			   		panelTiempo.add(lb_dospuntof); 
			   		
			   		lb_sseg.setIcon(img_primerdigseg);
			   		lb_sseg.repaint();
	 		   		panelTiempo.add(lb_sseg);
			   		
	 		   		lb_pseg.setIcon(img_segdigseg);
	 		   		lb_pseg.repaint();
			   		panelTiempo.add(lb_pseg); 		   		
	 		   }});	 		   
	 		   
			 panelTiempo = new JPanel();
			 panelTiempo.setLayout(new FlowLayout()); 
			 panelTiempo.setBounds(400,400,600,300);		 
			 panelTiempo.setBackground(Color.black);
			 panelTiempo.setBorder(new LineBorder( Color.orange,5));
			 
	         reloj.start();	
	 }

/** Crea un conjunto de label que contiene la partida del juego y se visualiza la imagen de label como roja cuando se rompe una regla de juego
 * Tambien gestiona cuando el juego ha sido completado.*/
	 private void armarPanelJuego() { 
 
		 panelJuego= new JPanel(); 	
		 panelJuego.setLayout(new GridLayout(1,1,0,0)); 
		 panelJuego.setBackground(Color.WHITE);
		 Color colorVioleta=new Color(223, 45, 223);
		 panelJuego.setBorder(new LineBorder(colorVioleta,5));
		
	     for(int i=0;i<9;i++){	
	        	panelJuego.setLayout(new GridLayout(9,3,2,2));
	   		 	
				for(int j =0; j<9; j++) {
					Celda c = vjuego.getCelda(i,j);
					
					lb_entrada[i][j]=new JLabel();										
					lb_entrada[i][j].setHorizontalAlignment(JLabel.CENTER);					
					c.getGrafico().definirColor(i,j);	
					lb_entrada[i][j].setBorder(c.getGrafico().getbordeGrafico());
					lb_entrada[i][j].setIcon(c.getGrafico().getGrafico());
					panelJuego.add(lb_entrada[i][j]);
					int fila=i; 
					int columna=j;					   
					if(vjuego.getCelda(fila,columna).getValor()==0)
						
						lb_entrada[fila][columna].addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							
							vjuego.accionar(c);
														
							if (vjuego.comprobarCelda(fila, columna)==false)
								   c.setGrafico(new ImageIcon (c.getImagenesRompeRegla()[c.getValor()]));
							else   c.setGrafico(new ImageIcon (c.getImagenes()[c.getValor()]));
							
							lb_entrada[fila][columna].setIcon(c.getGrafico().getGrafico());					
							
							lb_entrada[fila][columna].repaint();
							
						boolean novalido=false;	
						for(int fil=0;novalido==false&&fil<vjuego.getCantFilas();fil++)
						{
							for(int col=0;col<vjuego.getCantFilas();col++)
					     	{					    		
								String [] arrImagenes=c.getImagenesRompeRegla();								
								 
								for (int pos=0;novalido==false&&pos<arrImagenes.length;pos++)
									if (vjuego.getCelda(fil,col).getGrafico().getGrafico().toString()==arrImagenes[pos])
												novalido=true;									
					     	 }							
							
						 }
								if (novalido==false)
								{	
							        reloj.stop();
									FrameCompletado frame = new FrameCompletado("Completed");
									frame.setVisible(true);																									
								}
								
							
						}
					});	  	
	   		 	
			    
					}
				
				
	 		
	     	}
	     
	     	
	  
	 }}
	
	 