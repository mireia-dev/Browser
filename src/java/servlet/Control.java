/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Direccion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionDirecciones;

/**
 *
 * @author USUARIO
 */
public class Control extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opcion=request.getParameter("opcion");
            if (opcion.equals("buscar")){
                /* TODO output your page here. You may use following sample code. */
                String clave=request.getParameter("clave");
                GestionDirecciones direcciones= new GestionDirecciones();
                HashSet<Direccion> listadoEncontrados = new HashSet<>();
                listadoEncontrados=direcciones.buscarDireccion(clave);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Sitios encontrados</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Sitios encontrados:</h1>");
                out.println("<ul>");
                if (listadoEncontrados.isEmpty()){
                    out.println("No se encontraron sitios web.....");
                }else{
                    for(Direccion d:listadoEncontrados){
                        out.println("<li> <a href=\"http://" + d.getUrl()+"\">"+d.getUrl()+"</a> </li>");
                    }
                }
                out.println("</ul>");
                out.println("<a href=\"http://index.html>\" Volver </a>");
                out.println("</body>");
                out.println("</html>");
        }else{
                String claves=request.getParameter("keywords");
                String URL=request.getParameter("url");
                String descripcion=request.getParameter("descripcion");
                GestionDirecciones direcciones= new GestionDirecciones();
                direcciones.agregar(claves, URL, descripcion);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Sitios encontrados</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Se ha dado de alta el registro</h1><br>");
                out.println("<a href=\"http://index.html>\" Volver </a><br>");
                out.println("</body>");
                out.println("</html>");
            }}
    }
}
