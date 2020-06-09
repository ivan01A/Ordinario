/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import excepciones.AlumnoExitenteException;
import excepciones.AlumnoinexistenteException;
import java.util.ArrayList;
import objetos.Alumno;

/**
 *
 * @author Ivan
 */
public class Controlador {
    private ArrayList<Alumno> alumnos;
    
    public Controlador(){
       alumnos = new ArrayList<>(); 
       
    }
    
    public void addAlumno(Alumno alumno) throws AlumnoExitenteException{
       if(alumnos.contains(alumno)){
           throw new AlumnoExitenteException();
       }
        alumnos.add(alumno);
    }
    
    public ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }
    
    public Alumno getAlumno(String matricula) throws AlumnoinexistenteException{
        int index = alumnos.indexOf(new Alumno(matricula));
        if (index < 0){
            throw new  AlumnoinexistenteException();
        }
        return alumnos.get(index);
    }
    
    public Alumno getAlumno(int index){
        return alumnos.get(index);
    }
    
    public int getAlumnosCount(){
        return alumnos.size();
    }
    
  
}