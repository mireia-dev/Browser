package modelo;

import beans.Direccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionDirecciones {
    HashSet<Direccion> direcciones;
    Connection cn=null;
    public HashSet <Direccion> buscarDireccion(String clave){
        HashSet<Direccion> encontrados=new HashSet<>();
        try{
            cn=obtenerConexion();                    
            String sql="Select * from direccion where ";
            sql+="keywords like ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //sustitución del parámetro
            ps.setString(1, "%"+clave+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Direccion d=new Direccion(rs.getString("keywords"),
                        rs.getString("url"),
                        rs.getString("descripcion"));
                encontrados.add(d);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }   
        finally{
            cerrarConexion(cn);
        }
        return encontrados;
    }
    
    public void agregar(String keywords, String url, String descripcion){
        try {
            cn=obtenerConexion();
            String sql="insert into direccion(keywords,url,descripcion)";
            sql+="values(?,?,'?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,keywords);
            ps.setString(2,url);
            ps.setString(3,descripcion);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDirecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private Connection obtenerConexion(){
        try {
            //paso1 conexión con la base de datos
            //a: carga del driver
            Class.forName("com.mysql.jdbc.Driver");
            //b: establecer conexión con BD: jdbc:tipo://dir_ip:puerto/basedatos
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/buscador","root","M1r31a_G1l4B3rT");
        }
        catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    } 
    
    private void cerrarConexion(Connection cn){
        try {
                //paso 4 cierre de la conexión
                if(cn!=null){
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
}
