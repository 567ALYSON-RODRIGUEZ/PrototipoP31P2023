            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsPeliculas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPeliculas {
    
    private static final String SQL_SELECT = "SELECT idPelicula, Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio FROM peliculas";
    private static final String SQL_INSERT = "INSERT INTO peliculas(idPelicula, Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio) VALUES(?, ? ,?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE peliculas SET Nombre=?, Clasificacion=?, Genero=?, Subtitulado=?, Idioma=?, precio=?WHERE idPelicula = ?";
    private static final String SQL_DELETE = "DELETE peliculas WHERE idPelicula=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT  idPelicula, Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio FROM peliculas WHERE idPelicula = ?";
    private static final String SQL_SELECT_ID = "SELECT idPelicula, Nombre, Clasificacion, Genero, Subtitulado, Idioma, precio FROM peliculas  WHERE idPelicula = ?";    

    public List<clsPeliculas> consultaPeliculas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPeliculas> peliculas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("idPelicula");
                String nombre = rs.getString("Nombre");
                String clasificacion = rs.getString("Clasificacion");
                String genero = rs.getString("Genero");
                String subtitulado = rs.getString("Subtitulado");
                String idioma = rs.getString("Idioma");
                String precio = rs.getString("precio");
                clsPeliculas pelicula = new clsPeliculas();
                pelicula.setIdPeliculas(id);
                pelicula.setNombrePelicula(nombre);
                pelicula.setClasificacionPelicula(clasificacion);
                pelicula.setGeneroPelicula(genero);
                pelicula.setSubtituladoPelicula(subtitulado);
                pelicula.setIdiomaPelicula(idioma);
                pelicula.setPrecioPelicula(precio);
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return peliculas;
    }

    public int ingresaPeliculas(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getNombrePelicula());
            stmt.setString(2, pelicula.getNombrePelicula());
            stmt.setString(3, pelicula.getClasificacionPelicula());
            stmt.setString(4, pelicula.getGeneroPelicula());
            stmt.setString(5, pelicula.getSubtituladoPelicula());
            stmt.setString(6, pelicula.getIdiomaPelicula());
            stmt.setString(7, pelicula.getPrecioPelicula());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaPeliculas(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getNombrePelicula());
            stmt.setString(2, pelicula.getNombrePelicula());
            stmt.setString(3, pelicula.getClasificacionPelicula());
            stmt.setString(4, pelicula.getGeneroPelicula());
            stmt.setString(5, pelicula.getSubtituladoPelicula());
            stmt.setString(6, pelicula.getIdiomaPelicula());
            stmt.setString(7, pelicula.getPrecioPelicula());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarPeliculas(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, pelicula.getIdPeliculas());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsPeliculas consultaPeliculasPorNombre(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + pelicula);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, pelicula.getNombrePelicula());
            rs = stmt.executeQuery();
            while (rs.next()) {       
                String id = rs.getString("idPelicula");
                String nombre = rs.getString("Nombre");
                String clasificacion = rs.getString("Clasificacion");
                String genero = rs.getString("Genero");
                String subtitulado = rs.getString("Subtitulado");
                String idioma = rs.getString("Idioma");
                String precio = rs.getString("precio");
                        
                //pelicula = new clsPeliculas();
                
                pelicula.setIdPeliculas(id);
                pelicula.setNombrePelicula(nombre);
                pelicula.setClasificacionPelicula(clasificacion);
                pelicula.setGeneroPelicula(genero);
                pelicula.setSubtituladoPelicula(subtitulado);
                pelicula.setIdiomaPelicula(idioma);
                pelicula.setPrecioPelicula(precio);
                System.out.println(" registro consultado: " + pelicula);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return pelicula;
    }
    public clsPeliculas consultaPeliculasporId(clsPeliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + pelicula);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, pelicula.getIdPeliculas());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("idPelicula");
                String nombre = rs.getString("Nombre");
                String clasificacion = rs.getString("Clasificacion");
                String genero = rs.getString("Genero");
                String subtitulado = rs.getString("Subtitulado");
                String idioma = rs.getString("Idioma");
                String precio = rs.getString("precio");

                //usuario = new clsUsuario();
                pelicula.setIdPeliculas(id);
                pelicula.setNombrePelicula(nombre);
                pelicula.setClasificacionPelicula(clasificacion);
                pelicula.setGeneroPelicula(genero);
                pelicula.setSubtituladoPelicula(subtitulado);
                pelicula.setIdiomaPelicula(idioma);
                pelicula.setPrecioPelicula(precio);
                System.out.println(" registro consultado: " + pelicula);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return pelicula;
    }    
}
