package LOGICA;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**Permite agregar propiedades las imagenes a los objetos de la Clase Celda y Clase Tiempo*/
public class EntidadGrafica {
	private ImageIcon grafico;
	private TitledBorder bordegrafico;
	
	public EntidadGrafica(String ini,LineBorder colorlinea) {
		this.grafico = new ImageIcon(ini);
		LineBorder linea=new LineBorder(Color.pink,1,true);
		this.bordegrafico = new TitledBorder(linea,"");
	}	
	
	
	public EntidadGrafica(String ini) {this.grafico = new ImageIcon(ini);}

	public ImageIcon getGrafico() {return this.grafico;}
	public TitledBorder getbordeGrafico() {return bordegrafico;	}

	public void setGrafico(ImageIcon grafico) {this.grafico = grafico;	}
	
	public void definirColor(int fila,int columna) {
		LineBorder linea=null;
		Color colorVioleta=new Color(223, 45, 223);
		
		
		if ( (fila>=0&&fila<3) &&(columna>=0&&columna<3)) 
				linea= new LineBorder(Color.orange,1,true);				 
	
		else {
			if ( (fila>=0&&fila<3) &&(columna>=3&&columna<6)) {
				linea= new LineBorder(colorVioleta,1,true);
			}
			else {
				if ( (fila>=0&&fila<3) &&(columna>=6&&columna<10)) {
					linea= new LineBorder(Color.orange,1,true);
				}
				else {
					if ( (fila>=3&&fila<6) &&(columna>=0&&columna<3)) {
						linea= new LineBorder(colorVioleta,1,true);
					}
					else {
						if ( (fila>=3&&fila<6) &&(columna>=3&&columna<6)) {
							linea= new LineBorder(Color.orange,1,true);
						}
						else {
							if ( (fila>=3&&fila<6) &&(columna>=6&&columna<10)) {
								linea= new LineBorder(colorVioleta,1,true);
							}
							else {
								if ( (fila>=6&&fila<9) &&(columna>=0&&columna<3)) {
									linea= new LineBorder(Color.orange,1,true);
								}
								else
								if ( (fila>=6&&fila<9) &&(columna>=3&&columna<6)) {
									linea= new LineBorder(colorVioleta,1,true);
								}
								else {
									linea= new LineBorder(Color.orange,1,true);
		
								}
							}
						}
					}
				}
			}
		}
		
		bordegrafico.setBorder( new TitledBorder(linea,""));
		
		
	
	}


}
