package LOGICA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;
/**Gestiona instancias de la clase Juego*/
public class Juego {
	private Celda [][] tablero;
	private int cantFilas;
	private boolean errordecarga=false;
	private Tiempo tiempo;
/**Inicializa sus atributos,
 * En tiempo se asigna una nueva instacia de Tiempo
 * Se lee por archivo la partida, verifica si es valida y es asignada al tablero
 * ***/
	public Juego() {
		this.tiempo = new Tiempo();
		Scanner arc=null;
		this.cantFilas = 9;
		tablero = new Celda[this.cantFilas][this.cantFilas];
		try {
			arc=new Scanner(new File("archivo/datos.dat"));
			
	/**Se ingresa en una matriz el contenido del archivo para verificar que sea una partida correcta*/
			boolean valida=true;
			Integer[][] nuevamatriz=new Integer[9][9];
		try {
			for (int i =0; i<9; i++) {
				for (int j =0; j<9; j++) {
						
						if (arc.hasNext())
							{
								int numero =Integer.parseInt(arc.next());
								nuevamatriz[i][j]=numero;
								if (numero<0 || numero>9)
									valida=false;					
							}	
						else valida=false;
					
				}
				
			}
		} catch ( NumberFormatException e1) {errordecarga=false;//El archivo tiene contenido distinto a numeros del 0 al 9.
		nuevamatriz=null;}

			
			if (arc.hasNext())
				valida=false;
			if (valida==false) nuevamatriz=null;
			errordecarga=valida; //significa que no hay errores
			
			
			/**controlar que la matriz nuevamatriz, si tiene elementos repetidos el cuadrado o en la fila o columna
			 en caso de haber repetidos, exepto el 0.*/
			
			if (errordecarga==true)//no hay errores
			{			
				for (int nfila=0; errordecarga==true&&nfila<nuevamatriz[0].length; nfila++){
		            {
			           //recorrer fila            
		              for (int ncol=0; errordecarga==true&&ncol<nuevamatriz[0].length; ncol++){
		                for (int segcol=ncol+1; errordecarga==true&&segcol<nuevamatriz[0].length; segcol++){
		                		if ((nuevamatriz[nfila][ncol]!=0)&&(nuevamatriz[nfila][segcol]!=0))
		                        	
		                				if(nuevamatriz[nfila][ncol] == nuevamatriz[nfila][segcol])
		                					errordecarga=false;
		                        	               		
		                }
		              }
		              
		              //recorrer columna           
		              for (int segfila=nfila+1; errordecarga==true&&segfila<nuevamatriz[0].length; segfila++){
		                      for (int poscol=0; errordecarga==true&&poscol<nuevamatriz[0].length; poscol++)	                    	      
		                    		  if ((nuevamatriz[nfila][poscol]!=0)&&(nuevamatriz[segfila][poscol]!=0))
		                    			  if(nuevamatriz[nfila][poscol] == nuevamatriz[segfila][poscol])
		                    				  errordecarga=false;
		              }
		              
		              for (int ncolumna=0; ncolumna<nuevamatriz[0].length; ncolumna++){
		             //recorrer cuadrado
		            	  switch (ncolumna) 
			              {
			            	case 0:case 3:case 6: { 								            		
								            		switch (nfila) 
										            {
								            		case 0:case 3:case 6:{
						                    			  if(nuevamatriz[nfila][ncolumna]!=0)
						                    			  {
																if (nuevamatriz[nfila+1][ncolumna+1]==nuevamatriz[nfila][ncolumna]	
																	||nuevamatriz[nfila+1][ncolumna+2]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+2][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+2][ncolumna+2]==nuevamatriz[nfila][ncolumna]
																	)																	
																	
																	errordecarga=false;					                    				  
						                    			  }
								            		}
								            		break;
								            		case 1:case 4:case 7:{
						                    			  if(nuevamatriz[nfila][ncolumna]!=0)
						                    			  {
						                    				   if (nuevamatriz[nfila+1][ncolumna+1]==nuevamatriz[nfila][ncolumna]
						                    					   ||nuevamatriz[nfila+1][ncolumna+2]==nuevamatriz[nfila][ncolumna]
																   ||nuevamatriz[nfila-1][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																   ||nuevamatriz[nfila-1][ncolumna+2]==nuevamatriz[nfila][ncolumna]
																   )
																errordecarga=false;
						                    			  }					                    			  
								            		}
								            		break;
								            		case 2:case 5:case 8:{
						                    			  if(nuevamatriz[nfila][ncolumna]!=0)
						                    			  {
																if (nuevamatriz[nfila-1][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-1][ncolumna+2]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-2][ncolumna+2]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-2][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	)
																errordecarga=false;
						                    			  }
								            		}
								            		break;								                
									            	default: System.out.println("fila invalida");;
									            	break; 
										            }
			            		      		
			            		
			                	   				  }	
			                break; 
			            	
			            	case 1:case 4:case 7: {
								            		switch (nfila) 
										            {
								            		case 0:case 3:case 6:{
						                    			  if(nuevamatriz[nfila][ncolumna]!=0)
						                    			  {
																if (nuevamatriz[nfila+1][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+1][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+2][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+2][ncolumna-1]==nuevamatriz[nfila][ncolumna]																
																	)
																errordecarga=false;														
						                    			  }	
								            		}
								            		break;
								            		case 1:case 4:case 7:{
						                    			  if(nuevamatriz[nfila][ncolumna]!=0)
						                    			  {
																if (nuevamatriz[nfila+1][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+1][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-1][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-1][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	)											 			
																errordecarga=false;														
						                    			  }	
								            		}
								            		break;
								            		case 2:case 5:case 8:{
						                    			  if(nuevamatriz[nfila][ncolumna]!=0)
						                    			  {
																if (nuevamatriz[nfila-1][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-1][ncolumna-1]==nuevamatriz[nfila][ncolumna]	
																	||nuevamatriz[nfila-2][ncolumna+1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-2][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	)											 				
																errordecarga=false;
						                    			  }	
								            		}
								            		break;
								            	 	default: System.out.println("fila invalida");;
									            	break; 
										            }
			            		
			            		
			            		
			            	}
			            	break;
			            	case 2:case 5:case 8:{

								            		switch (nfila) 
										            {
								            		case 0:case 3:case 6:{
								            			if (nuevamatriz[nfila][ncolumna]!=0)
														{
																if (nuevamatriz[nfila+1][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+1][ncolumna-2]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+2][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+2][ncolumna-2]==nuevamatriz[nfila][ncolumna]
																	)										 				
																errordecarga=false;
														}	
								            		}
								            		break;
								            		case 1:case 4:case 7:{
								            			if (nuevamatriz[nfila][ncolumna]!=0)
														{
																if (nuevamatriz[nfila+1][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila+1][ncolumna-2]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-1][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-1][ncolumna-2]==nuevamatriz[nfila][ncolumna]
																	)											 				
																errordecarga=false;
														}		
								            		}
								            		break;
								            		case 2:case 5:case 8:{
								            			if (nuevamatriz[nfila][ncolumna]!=0)
														{
																if (nuevamatriz[nfila-1][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-1][ncolumna-2]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-2][ncolumna-1]==nuevamatriz[nfila][ncolumna]
																	||nuevamatriz[nfila-2][ncolumna-2]==nuevamatriz[nfila][ncolumna]																
																	)											 				
																errordecarga=false;
														}		
								            		}
								            		break;
								            	 	default: System.out.println("fila invalida");;
									            	break; 
										            }
			            	            				        		
			            	}
			            	break;
			                
			            	default: System.out.println("columna invalida");;
		                break; 
		                }	            	 
		              
		              }
		              
		            }
		            	           
		        }
				///si es correcta la partida se ingresa en el tablero
				if (errordecarga==true)			
					if (nuevamatriz!=null)
					for (int i =0; i<cantFilas; i++) {
							for (int j =0; j<cantFilas; j++) {					
								tablero[i][j] = new Celda(nuevamatriz[i][j]);
							}
						}	

			}		
			
			
			
			
			
			
				
		} catch (FileNotFoundException e) {	errordecarga=false;//No se encontro al archivo que contiene la partida
			
		}
	
		

	}
	/**Getter de la Clase Juego*/
	public boolean getErrordeCarga() {return errordecarga;}
	public Celda getCelda(int i, int j) {return this.tablero[i][j];}
	public int getCantFilas() {return this.cantFilas;}
	public Tiempo getTiempo() {return this.tiempo;}
	
	/**Actualiza el valor del tiempo*/
	public void accionar(Tiempo t) {t.actualizar();}
	
	/**Perminte actualizar el valor de la celda */
	public void accionar(Celda c) {c.actualizar();}	

	/**Compueba que la celda no rompa las reglas del juego*/	
	public boolean comprobarCelda(int fila,int columna) {
		boolean es_valida=true;
        //recorrer fila            

        for (int poscol=0;es_valida==true&&poscol<9;poscol++) {	            						
     		if(poscol!=columna)	
     				if (this.getCelda(fila,poscol).getValor()==this.getCelda(fila,columna).getValor())
     					es_valida=false;				         									

        }
        //recorrer columna            

        if (es_valida==true)
        {
				for (int posfila=0;es_valida==true&&posfila<9;posfila++){		            						
							if(posfila!=fila) 
								if (this.getCelda(posfila,columna).getValor()==this.getCelda(fila,columna).getValor())
										es_valida=false;									
				}
				
		        if (es_valida==true)
		        {
		        	//recorre el cuadrado
		        	switch (columna) 
		            {
		            	case 0:case 3:case 6: { 								            		
							            		switch (fila) 
									            {
							            		case 0:case 3:case 6:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila+1,columna+1).getValor()==this.getCelda(fila,columna).getValor())
											 					es_valida=false;
															if (this.getCelda(fila+1,columna+2).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
															if (this.getCelda(fila+2,columna+1).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
															if (this.getCelda(fila+2,columna+2).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
													}	
							            		}
							            		break;
							            		case 1:case 4:case 7:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila+1,columna+1).getValor()==this.getCelda(fila,columna).getValor())
											 					es_valida=false;
															if (this.getCelda(fila+1,columna+2).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
															if (this.getCelda(fila-1,columna+1).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
															if (this.getCelda(fila-1,columna+2).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
													}
							            		}
							            		break;
							            		case 2:case 5:case 8:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila-1,columna+1).getValor()==this.getCelda(fila,columna).getValor())
											 					es_valida=false;		
															if (this.getCelda(fila-1,columna+2).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
															if (this.getCelda(fila-2,columna+1).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
															if (this.getCelda(fila-2,columna+2).getValor()==this.getCelda(fila,columna).getValor())
																es_valida=false;
													}
							            		}
							            		break;
								                
								            	default: System.out.println("fila invalida");;
								            	break; 
									            }
		            		      		
		            		
		                	   				  }	
		                break; 
		            	
		            	case 1:case 4:case 7:{
							            		switch (fila) 
									            {
							            		case 0:case 3:case 6:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila+1,columna+1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila+1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila+1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila+1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																)										 				
																es_valida=false;
													}	
							            		}
							            		break;
							            		case 1:case 4:case 7:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if(this.getCelda(fila+1,columna+1).getValor()==this.getCelda(fila,columna).getValor()
															   ||this.getCelda(fila+1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
															   ||this.getCelda(fila-1,columna+1).getValor()==this.getCelda(fila,columna).getValor()
															   ||this.getCelda(fila-1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
															   )
															   es_valida=false;
													}	
							            		}
							            		break;
							            		case 2:case 5:case 8:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila-1,columna+1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-2,columna+1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-2,columna-1).getValor()==this.getCelda(fila,columna).getValor()
															    )
																es_valida=false;
													}	
							            		}
							            		break;
							            	 	default: System.out.println("fila invalida");;
								            	break; 
									            }
		            		
		            		
		            		
		            	}
		            	break;
		            	case 2:case 5:case 8:{

							            		switch (fila) 
									            {
							            		case 0:case 3:case 6:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila+1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila+1,columna-2).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila+2,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila+2,columna-2).getValor()==this.getCelda(fila,columna).getValor()
																)
																es_valida=false;
													}	
							            		}
							            		break;
							            		case 1:case 4:case 7:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila+1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila+1,columna-2).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-1,columna-2).getValor()==this.getCelda(fila,columna).getValor()
																)
																es_valida=false;
													}		
							            		}
							            		break;
							            		case 2:case 5:case 8:{
							            			if (this.getCelda(fila,columna).getValor()!=0)
													{
															if (this.getCelda(fila-1,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-1,columna-2).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-2,columna-1).getValor()==this.getCelda(fila,columna).getValor()
																||this.getCelda(fila-2,columna-2).getValor()==this.getCelda(fila,columna).getValor()
																)
																es_valida=false;
													}		
							            		}
							            		break;
							            	 	default: System.out.println("fila invalida");;
								            	break; 
									            }
							            		
		            	}
		            	break;
		                
		            	default: System.out.println("columna invalida");;
	                break; 
	                }
						
		        }
        }
        
	
		return es_valida;

	}
	

	
		
	

}
