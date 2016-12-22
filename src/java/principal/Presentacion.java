/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import beans.Direccion;
import java.util.HashSet;
import java.util.Scanner;
import modelo.GestionDirecciones;

/**
 *
 * @author USUARIO
 */
public class Presentacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //creamos objeto de la clase de negocio
        GestionDirecciones gdir=new GestionDirecciones();
        System.out.println("Clave: ");
        String clave=sc.nextLine();
        //recuperamos el conjunto de direcciones
        //que tengan la palabra clave solicitada
        HashSet<Direccion> res=gdir.buscarDireccion(clave);
        //recorremos las direcciones encontradas y mostramos su URL
        //y descripción
        for(Direccion d:res){
            System.out.println(d.getUrl());
            System.out.println(d.getDescripcion());
        }
    }
    
}
