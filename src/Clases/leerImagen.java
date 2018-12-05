package Clases;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
/**
 *
 * @author Zeth
 */
public class leerImagen {
    public ArrayList<Integer> image=new ArrayList<>();
    public ArrayList<PatronesEntrenamiento> patrones=new ArrayList<>();
    PatronesEntrenamiento patron;
    
    public void listar(final File carpeta) throws IOException {
        for (final File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                listar(ficheroEntrada);
            } else {
                try{
                //System.out.println(ficheroEntrada.getName());
                String name=ficheroEntrada.getName();
                char[] cad=name.toCharArray();
                String nombre="";
                for(int i=0;i<cad.length;i++){
                    if(cad[i]=='.'){
                        break;
                    }else{
                        nombre+=cad[i];
                    }
                }
                //System.out.println(nombre);
                
                BufferedImage img = ImageIO.read(new File(ficheroEntrada.getPath()));
                for(int i=0;i<img.getHeight();i++){
                    for(int j=0;j<img.getWidth();j++){
                        int rgb=img.getRGB(j, i);
                        if(rgb==-1){
                            //System.out.print(0);   
                            image.add(0);
                        }else{
                            //System.out.print(1);
                            image.add(1);
                        }
                    }
                    //System.out.println();
                }
                
                int[][] arreglo=new int[1][image.size()];
        
                for(int i=0;i<image.size();i++){
                    arreglo[0][i]=image.get(i);
                }
                image.clear();
                patron=new PatronesEntrenamiento();
                patron.setX(arreglo);
                patron.setNombre(nombre);
                patrones.add(patron);
                
                
                
                }catch(Exception e){
                    System.out.println("Error: "+e);
                }
                
            }
        }
        
        
        for(int i=0;i<patrones.size();i++){
            int[][] y=new int[1][patrones.size()];
            for(int j=0;j<y[0].length;j++){
                if(j==i){
                    y[0][j]=1; 
                }else{
                    y[0][j]=0;
                }
            }
            patrones.get(i).setY(y);
        }
        

        
        
    }
    
    public ArrayList<PatronesEntrenamiento> getPatrones(){
        
        return patrones;
    }

    
}
