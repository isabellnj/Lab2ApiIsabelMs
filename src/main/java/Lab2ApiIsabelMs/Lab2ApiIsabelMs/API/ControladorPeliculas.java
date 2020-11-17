package Lab2ApiIsabelMs.Lab2ApiIsabelMs.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Lab2ApiIsabelMs.Lab2ApiIsabelMs.MODEL.Movie;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {
   
    public static List<Movie>arraylist = new ArrayList(Arrays.asList(
        new Movie(1,"Pulp Fiction", 1994, "foto1.jpg"),
        new Movie(2,"La vida es bella", 1997, "foto5.jpg"),
        new Movie(3,"El club de la lucha (1999)", 1999, "foto4.jpg"),
        new Movie(4,"la lista de Schindler (1993)", 1993, "foto3.jpg"),
        new Movie(5,"la naranja mecánica (1971)", 1971, "foto2.jpg")
        
     ));


    //Ejercicio3 --> sacar lista
    @GetMapping("/movies")
    public List<Movie> getall(){

    return arraylist;
    }

    //Ejercicio4--> filtrado de peliculas por año y/o titulo


    public List<Movie> GetAllPeliculas() {
    ArrayList<Movie>movies = new ArrayList<>();
        for (Movie movie1: arraylist){

            movies.add(new Movie(movie1.getId(), movie1.getTitle(), movie1.getYear(), movie1.getPoster()));
        }
    return movies;
    }


    public List<Movie>GetTitle ( String title){
    ArrayList<Movie>movie = new ArrayList<>();
        for (Movie movie1: arraylist){
             if (movie1.getTitle().contains(title)){
                movie.add(new Movie(movie1.getId(), movie1.getTitle(), movie1.getYear(), movie1.getPoster()));
            }
        }
        return movie;
    }


    public List<Movie>GetYear ( int  year){
    ArrayList<Movie>movies = new ArrayList<>();
        for (Movie movie1: arraylist){
            if (movie1.getYear()==year){
                movies.add(new Movie(movie1.getId(), movie1.getTitle(), movie1.getYear(), movie1.getPoster()));
            }
         }
     return movies;
    }

    public List<Movie>GetYearTitle ( String title,int  year){
    ArrayList<Movie>movie = new ArrayList<>();
        for (Movie movies: arraylist){
            if (movies.getTitle().contains(title) && movies.getYear()==year){
                movie.add(new Movie( movies.getId(), movies.getTitle(), movies.getYear(), movies.getPoster()));
            }
        }
    return movie;
    }


    @GetMapping("/moviesFiltrado")
    public List titleYearfilmm(@RequestParam(name = "title", required = false, defaultValue = "")
    String title, @RequestParam(name= "year", required = false, defaultValue ="0" ) int year){
        if (title.equals("") && year ==0){
            return GetAllPeliculas();
        }

        if (!title.equals("")&& year==0){ 
            return GetTitle(title);
        }

         if (title.equals("") && year!=0){

            return GetYear(year);
        }

        if (!title.equals("")&& year!=0){

            return GetYearTitle(title, year);
        }

    return null;
    }


    //Ejercicio5 --> CRUD


    //Filtrar pelicula por id
    @GetMapping("/movie/{id}")
    public static Movie MovieById(@PathVariable("id") final int id) {
       
        for (final Movie movie: arraylist){
            if (movie.getId() == id){
                return movie;
                
            }
        }
        return null;
    }

    //Añadir pelicula
    @PostMapping("/moviesAdd")
    public Movie addMovie(@RequestBody Movie newMovie) {
        for (Movie movie : arraylist) {
            if (movie.getId() == newMovie.getId()) {
                return null;
            }
        }
        arraylist.add(newMovie);
        return (Movie) newMovie;
    }

    //Modificar pelicula
    @PutMapping("/movies/{id}")
    public Movie Update(@RequestBody Movie updaMovie, @PathVariable("id") int id){
        if (MovieById(id)!=null){
            MovieById(id).setTitle(updaMovie.getTitle());
            MovieById(id).setYear(updaMovie.getYear());
            MovieById(id).setPoster(updaMovie.getPoster());
            return MovieById(id);
        }
    return null;
    }


    //borrar pelicula
    @DeleteMapping("/movies/{id}")
    public Movie deleMovie(@PathVariable("id") int id) {
        for (Movie movie : arraylist) {
            if (movie.getId() == id) {
                    arraylist.remove(movie);
                    return null;
                }
            }
        return null;
    }



    //Ejercicio6 --> multilenguaje


    @GetMapping("/movies/text")
    public String Text (@RequestParam(name = "lang", required = false, defaultValue = "") String lang)
    {
     var locale = new Locale(lang);
      var messages = ResourceBundle.getBundle("i18n\\mesagges", locale);
      return messages.getString("Main.film");
   }



   
    


   
}



