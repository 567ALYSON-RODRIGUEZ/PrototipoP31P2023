/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoPeliculas;
/**
 *
 * @author visitante
 */
public class clsPeliculas {
    
    private String IdPeliculas;
    private String NombrePelicula;
    private String ClasificacionPelicula;
    private String GeneroPelicula;
    private String SubtituladoPelicula;
    private String IdiomaPelicula;
    private String PrecioPelicula;

    public clsPeliculas() {
    }

    public clsPeliculas(String IdPeliculas) {
        this.IdPeliculas = IdPeliculas;
    }

    public clsPeliculas(String IdPeliculas, String NombrePelicula) {
        this.IdPeliculas = IdPeliculas;
        this.NombrePelicula = NombrePelicula;
    }

    public clsPeliculas(String IdPeliculas, String NombrePelicula, String ClasificacionPelicula) {
        this.IdPeliculas = IdPeliculas;
        this.NombrePelicula = NombrePelicula;
        this.ClasificacionPelicula = ClasificacionPelicula;
    }

    public clsPeliculas(String IdPeliculas, String NombrePelicula, String ClasificacionPelicula, String GeneroPelicula) {
        this.IdPeliculas = IdPeliculas;
        this.NombrePelicula = NombrePelicula;
        this.ClasificacionPelicula = ClasificacionPelicula;
        this.GeneroPelicula = GeneroPelicula;
    }

    public clsPeliculas(String IdPeliculas, String NombrePelicula, String ClasificacionPelicula, String GeneroPelicula, String SubtituladoPelicula) {
        this.IdPeliculas = IdPeliculas;
        this.NombrePelicula = NombrePelicula;
        this.ClasificacionPelicula = ClasificacionPelicula;
        this.GeneroPelicula = GeneroPelicula;
        this.SubtituladoPelicula = SubtituladoPelicula;
    }

    public clsPeliculas(String IdPeliculas, String NombrePelicula, String ClasificacionPelicula, String GeneroPelicula, String SubtituladoPelicula, String IdiomaPelicula) {
        this.IdPeliculas = IdPeliculas;
        this.NombrePelicula = NombrePelicula;
        this.ClasificacionPelicula = ClasificacionPelicula;
        this.GeneroPelicula = GeneroPelicula;
        this.SubtituladoPelicula = SubtituladoPelicula;
        this.IdiomaPelicula = IdiomaPelicula;
    }

    public clsPeliculas(String IdPeliculas, String NombrePelicula, String ClasificacionPelicula, String GeneroPelicula, String SubtituladoPelicula, String IdiomaPelicula, String PrecioPelicula) {
        this.IdPeliculas = IdPeliculas;
        this.NombrePelicula = NombrePelicula;
        this.ClasificacionPelicula = ClasificacionPelicula;
        this.GeneroPelicula = GeneroPelicula;
        this.SubtituladoPelicula = SubtituladoPelicula;
        this.IdiomaPelicula = IdiomaPelicula;
        this.PrecioPelicula = PrecioPelicula;
    }

    public String getIdPeliculas() {
        return IdPeliculas;
    }

    public void setIdPeliculas(String IdPeliculas) {
        this.IdPeliculas = IdPeliculas;
    }

    public String getNombrePelicula() {
        return NombrePelicula;
    }

    public void setNombrePelicula(String NombrePelicula) {
        this.NombrePelicula = NombrePelicula;
    }

    public String getClasificacionPelicula() {
        return ClasificacionPelicula;
    }

    public void setClasificacionPelicula(String ClasificacionPelicula) {
        this.ClasificacionPelicula = ClasificacionPelicula;
    }

    public String getGeneroPelicula() {
        return GeneroPelicula;
    }

    public void setGeneroPelicula(String GeneroPelicula) {
        this.GeneroPelicula = GeneroPelicula;
    }

    public String getSubtituladoPelicula() {
        return SubtituladoPelicula;
    }

    public void setSubtituladoPelicula(String SubtituladoPelicula) {
        this.SubtituladoPelicula = SubtituladoPelicula;
    }

    public String getIdiomaPelicula() {
        return IdiomaPelicula;
    }

    public void setIdiomaPelicula(String IdiomaPelicula) {
        this.IdiomaPelicula = IdiomaPelicula;
    }

    public String getPrecioPelicula() {
        return PrecioPelicula;
    }

    public void setPrecioPelicula(String PrecioPelicula) {
        this.PrecioPelicula = PrecioPelicula;
    
}
     @Override
    public String toString() {
        return "clsPeliculas{" + "IdPeliculas=" + IdPeliculas + ", NombrePelicula=" + NombrePelicula + ", ClasificacionPelicula=" + ClasificacionPelicula +", GeneroPelicula=" + GeneroPelicula + ", SubtituladoPelicula=" + SubtituladoPelicula +", IdiomaPelicula=" + IdiomaPelicula + ", PrecioPelicula=" + PrecioPelicula+ '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPeliculas getBuscarInformacionPeliculasPorNombre(clsPeliculas pelicula)
    {
        daoPeliculas daopeliculas= new daoPeliculas ();
        return daopeliculas.consultaPeliculasPorNombre(pelicula);
    }
    public clsPeliculas getBuscarInformacionPeliculasPorId(clsPeliculas pelicula)
    {
        daoPeliculas daopeliculas= new daoPeliculas();
        return daopeliculas.consultaPeliculasporId(pelicula);
    }    
    public List<clsPeliculas> getListadoPeliculas()
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        List<clsPeliculas> listadoPeliculas = daopeliculas.consultaPeliculas();
        return listadoPeliculas;
    }
    public int setBorrarPelicula(clsPeliculas pelicula)
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        return daopeliculas.borrarPeliculas(pelicula);
    }          
    public int setIngresarPelicula(clsPeliculas pelicula)
    {
        daoPeliculas daopeliculas = new  daoPeliculas();
        return daopeliculas.ingresaPeliculas(pelicula);
    }              
    public int setModificarPelicula(clsPeliculas pelicula)
    {
        daoPeliculas daopeliculas = new daoPeliculas();
        return daopeliculas.actualizaPeliculas(pelicula);
    }              

}