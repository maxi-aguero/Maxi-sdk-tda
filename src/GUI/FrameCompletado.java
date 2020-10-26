package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
/** Permite visualizar una imagen cuando gana el juego*/
public class FrameCompletado extends JFrame {
	
    JPanel panelGanado;

    FrameCompletado(String tit){	
		 super(tit);	     
	   	 setSize(308,278);
	   	 
         armarPanelCompletado();            
         add(panelGanado);         
         setLocationRelativeTo(null); 
	 }
/**Decora el panel con un label que contiene la imagen de juego ganado*/
	 private void armarPanelCompletado() { 
 		 
		 panelGanado = new JPanel();
		 panelGanado.setLayout(new GridLayout(0,1,0,0));
		 Color colorVioleta=new Color(223, 45, 223);
		 panelGanado.setBorder(new LineBorder(colorVioleta,5));
		 panelGanado.setBackground(Color.black);  
	   	
	   	 ImageIcon imagenLogo=new ImageIcon("img/win.png");		   		
	   	 JLabel lbLogo=new JLabel("",SwingConstants.CENTER);
	   	 Icon imgSizeLogo= new  ImageIcon(imagenLogo.getImage().getScaledInstance(120, 65, Image.SCALE_SMOOTH)); 
	   	 lbLogo.setIcon(imgSizeLogo);
	   	 lbLogo.repaint();		   
	   	 panelGanado.add(lbLogo);
	     		  
	 }	 	     	
	     	
}
	