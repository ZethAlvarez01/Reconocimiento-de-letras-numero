package Clases;

import java.util.ArrayList;

/**
 *
 * @author Zeth
 */
public class FaseAprendizaje {
    public int[][] matriz;
    private int[][] x;
    private int[][] y;
    Matrix op=new Matrix();
    ArrayList<PatronesEntrenamiento> patrones=new ArrayList<>();
    
    public FaseAprendizaje(ArrayList<PatronesEntrenamiento> patrones){
        this.patrones=patrones;      
    }
    
    public void aprender(){
        for(int i=0;i<patrones.size();i++){
            x=new int[1][patrones.get(i).x[0].length];
            for(int j=0;j<x[0].length;j++){
                x=op.scalar(patrones.get(i).x, -1);
                if(j%50==0){
                    System.out.println();
                }
                System.out.print(x[0][j]);
            }
            System.out.println("\n");
            y=new int[1][patrones.get(i).y[0].length];
            for(int j=0;j<y[0].length;j++){
                y[0][j]=patrones.get(i).y[0][j];
                System.out.print(y[0][j]);
            }
            System.out.println();
            
            y=op.transpose(y);
            
            matriz=op.dot(y, x);    
            
            System.out.println("Arreglo de pesos xi yi");
        
            op.print(matriz);
            
            op.print(y);
            
            
            
        }
        

    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    
}
