package Vistas;

import Clases.FaseAprendizaje;
import Clases.PatronesEntrenamiento;
import Clases.leerImagen;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Zeth
 */
public class Clasificador extends javax.swing.JFrame {
    public ArrayList<PatronesEntrenamiento> patrones;

    public Clasificador() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jButton1)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        leerImagen img=new leerImagen();
        //filechooser para seleccionar la carpeta de las imagenes de la fase de aprendizaje
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(this);
        File path=chooser.getSelectedFile();
        
        //Path de la carpeta de imagenes
        File carpeta = new File(path.getPath());
        try{
            img.listar(carpeta); //Lee todas las imagenes de la carpeta
            patrones=img.getPatrones();
           
        }catch(Exception e){
            System.out.println("Error: "+e);
        }

        FaseAprendizaje apren=new FaseAprendizaje(patrones);
        apren.aprender();
        
        System.out.println();
        for(int i=0;i<patrones.size();i++){
            for(int j=0;j<patrones.get(i).x[0].length;j++){
                if(j%50==0){
                    System.out.println();
                }
                System.out.print(patrones.get(i).x[0][j]);
                
            }
            System.out.println();
            System.out.println(patrones.get(i).getNombre());
            for(int j=0;j<patrones.get(i).y[0].length;j++){
                System.out.print(patrones.get(i).y[0][j]);
            }
            System.out.println();
        }
        

       
        
        


    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clasificador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
