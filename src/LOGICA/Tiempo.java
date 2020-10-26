package LOGICA;

import javax.swing.ImageIcon;

/**Permite crear objetos de tipo Clase Tiempo que sirve para gestionar el tiempo transcurrido*/
public class Tiempo  {	
	private int pd_segundo;
	private int sd_segundo;
	private int pd_minuto;
	private int sd_minuto;
	private int pd_hora;
	private int sd_hora;
	private int centecima;

	private EntidadGrafica primer_dseg;
	private EntidadGrafica segundo_dseg;
	private EntidadGrafica primer_dmin;
	private EntidadGrafica segundo_dmin;
	private EntidadGrafica primer_dhora;
	private EntidadGrafica segundo_dhora;
	private EntidadGrafica dospuntos;	

	public Tiempo() {
		
		 pd_segundo=0;
		 sd_segundo=0;
		 pd_minuto=0;
		 sd_minuto=0;
		 pd_hora=0;
		 sd_hora=0;
		 centecima=0;
		 String[] imagenes = new String[]{"img/t0.png","img/t1.png", "img/t2.png", "img/t3.png", "img/t4.png","img/t5.png","img/t6.png","img/t7.png","img/t8.png","img/t9.png","img/dospuntos.png"};

	     primer_dseg=new EntidadGrafica(imagenes[0]);
	     segundo_dseg=new EntidadGrafica(imagenes[0]);
	     primer_dmin=new EntidadGrafica(imagenes[0]);
	     segundo_dmin=new EntidadGrafica(imagenes[0]);
	     dospuntos=new EntidadGrafica(imagenes[10]);
	     primer_dhora=new EntidadGrafica(imagenes[0]);
	     segundo_dhora=new EntidadGrafica(imagenes[0]);
		 
	}
	
	public int get_psegundo() {return pd_segundo;}	
	public int get_ssegundo() {return sd_segundo;}	
	public int get_pminuto() {return pd_minuto;}	
	public int get_sminuto() {return sd_minuto;}	
	public int get_phora() {return pd_hora;}	
	public int get_shora() {return sd_hora;}
	
	public void actualizar(){ 
		
		 centecima=centecima+1;
		 if(centecima==50){
			 centecima = 0;
			 sd_segundo=sd_segundo+1;
         }		 
		 if (sd_segundo==10)
	   		 {  sd_segundo=0;	   		 	
	   		 	pd_segundo=pd_segundo+1;
			 }		 
		 if(pd_segundo==6) 
	        {
			 	pd_segundo = 0;				 	
			 	sd_minuto=sd_minuto+1;	            
	        }		 
		 if (sd_minuto==10)
   		 {  sd_minuto=0;	   		 	
   		 	pd_minuto=pd_minuto+1;
		 } 		 
		 if(pd_minuto==6) 
	        {	pd_minuto = 0;	
			 	sd_hora=sd_hora+1;		 	
	        }
		 if (sd_hora==10)
   		 {  sd_hora=0;	   		 	
   		 	pd_hora=pd_hora+1;
		 }		 
		 if (pd_hora==10)
   		 {  pd_hora=0;	   		 	
   		 	sd_segundo=0;
   		 	pd_segundo = 0;				 	
   		 	sd_minuto=0;          
	 	    pd_minuto=0;
	 	    sd_hora=0;	   		 	
		 }
		 
	}	
	
	public void setprimerdigSeg(ImageIcon im) {this.primer_dseg.setGrafico(im);}
	public void setsegundodigSeg(ImageIcon im) {this.segundo_dseg.setGrafico(im);}
	public void setprimerdigMin(ImageIcon im) {this.primer_dmin.setGrafico(im);}
	public void setsegundodigMin(ImageIcon im) {this.segundo_dmin.setGrafico(im);}
	public void setsprimerdigHora(ImageIcon im) {this.primer_dhora.setGrafico(im);}
	public void setssegundodigHora(ImageIcon im) {this.segundo_dhora.setGrafico(im);}
	
	public ImageIcon getprimerdigSeg() {return primer_dseg.getGrafico();}
	public ImageIcon getsegundodigSeg() {return segundo_dseg.getGrafico();}
	public ImageIcon getprimerdigMin() {return primer_dmin.getGrafico();}
	public ImageIcon getsegundodigMin() {return segundo_dmin.getGrafico();}
	public ImageIcon getprimerdigHora() {return primer_dhora.getGrafico();}
	public ImageIcon getsegundodigHora() {return segundo_dhora.getGrafico();}		
	public ImageIcon getpuntos() {return dospuntos.getGrafico();}
	

}