/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.AlumnoListener;
import controlador.Controlador;
import excepciones.AlumnoExitenteException;
import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import objetos.Alumno;
import objetos.Carrera;
import objetos.Fecha;

/**
 *
 * @author Ivan
 */
public class PrincipalFrame extends JFrame {
    
    private EncabezadoPanel pnlEncabezado;
    private WorkPanel pnlWork;
    private BusquedaPanel pnlBusqueda;
    private Controlador controlador;
    
    private AlumnoDialogo dlgAlumno;
    
    
    public PrincipalFrame(){
        super("Control escolar");
        super.setLayout(new BorderLayout());
        super.setSize(800, 500);
        super.setLocationRelativeTo(null);
    
        dlgAlumno= new AlumnoDialogo(this);
        dlgAlumno.setListener(new AlumnoListener(){
            @Override
            public void aceptarButtonClik(Alumno alumno) {
              try{
               controlador.addAlumno(alumno);
               dlgAlumno.setVisible(false);
              }catch (AlumnoExitenteException ex){
                  
               JOptionPane.showMessageDialog(PrincipalFrame.this, 
                                             "La Matricula ya ha sido ocupada",
                                             "Matricula Invalida", JOptionPane.ERROR_MESSAGE);
              }
            }
        });
        controlador= new Controlador();
        cargaIncial();
        
        pnlEncabezado = new EncabezadoPanel();
        pnlWork = new WorkPanel(controlador);
        pnlBusqueda = new BusquedaPanel();
        
        super.setJMenuBar(createMenu());
        
        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.add(pnlWork, BorderLayout.CENTER);
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void cargaIncial(){
        Alumno a = new Alumno("9999922","ivan alejandro","perez","barragan", new Fecha(4,9,1997), Carrera.SISTEMAS);
        Alumno b = new Alumno("b");
        Alumno c = new Alumno("c");
        Alumno d = new Alumno("d");
        
        try {
        controlador.addAlumno(a);
        controlador.addAlumno(b);
        controlador.addAlumno(c);
        controlador.addAlumno(d);
        }catch(AlumnoExitenteException ex){
            ex.printStackTrace();
        }
    }
   private JMenuBar createMenu(){
     JMenuBar nbMain = new JMenuBar();
     
     JMenu mmArchivo = new JMenu("Archivo");
     JMenuItem miNuevo = new JMenuItem("Nuevo Alumno...");
     miNuevo.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
           dlgAlumno.setVisible(true);
         }
         
     });
     JMenuItem miSalir = new JMenuItem("Salir");
     miSalir.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
     });
       
   
     mmArchivo.add(miNuevo);
     mmArchivo.addSeparator();
     mmArchivo.add(miSalir);
     
     JMenu mmAyuda = new JMenu("Ayuda");
     JMenuItem miAcerca = new JMenuItem("Acerca de..");
     mmAyuda.add(miAcerca);
     
     nbMain.add(mmArchivo);
     nbMain.add(mmAyuda);
     
     return nbMain;
   }

   
}
