package LOGICA;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

/**Permite que cada objeto celdas tenga una imagenm, valor asociado y propiedades mismas para las imagenes*/
public class Celda {
	private Integer valor;	
	private String[] imagenes;
	private String[] imagenesromperegla;
	private EntidadGrafica grafico;
	
	/**Crea un objeto Celda e inicializa sus atributos*/
	public Celda(int valor) {
		this.valor = valor;
		this.imagenes = new String[]{"img/zero.png","img/one.png", "img/two.png", "img/three.png", "img/four.png","img/five.png","img/six.png","img/seven.png","img/eight.png","img/nine.png"};
		this.imagenesromperegla = new String[]{"img/zero.png","img/uno.png","img/dos.png","img/tres.png","img/cuatro.png","img/cinco.png","img/seis.png","img/siete.png","img/ocho.png","img/nueve.png"};
		LineBorder colorborde= new LineBorder(Color.blue,1,true);
		grafico= new EntidadGrafica(this.imagenes[this.valor],colorborde);
	}
	
	/**Actualiza el valor de un objeto Celda*/
	public void actualizar() {
		if (valor==9) {
			valor=0;
		}
		else valor++;				
		
	}
    /**Getters y setter de los atributos propios de la clase Celda*/
	public int getCantElementos() {return this.imagenes.length;	}	
	public Integer getValor() {return this.valor;}
	public String [] getImagenes() {return this.imagenes;}
	public String [] getImagenesRompeRegla() {return this.imagenesromperegla;}	
	public EntidadGrafica getGrafico() {return this.grafico;}
	
	/**Setter de los atributos propios de la clase Celda*/
	public void setImagenes(String[] s) {this.imagenes=s;}	
	public void setGrafico(ImageIcon im) {this.grafico.setGrafico(im);}
	
}
