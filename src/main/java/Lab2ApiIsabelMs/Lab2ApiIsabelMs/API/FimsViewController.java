package Lab2ApiIsabelMs.Lab2ApiIsabelMs.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Lab2ApiIsabelMs.Lab2ApiIsabelMs.MODEL.Movie;


import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FimsViewController {



  

    @GetMapping("/moviess")
   public ModelAndView movies(){
       ModelAndView modelo=new ModelAndView("listMovies");
       modelo.addObject("movies", ControladorPeliculas.arraylist);
       return modelo;
   }
    

   @GetMapping("/moviess/{id}")
   public ModelAndView PeliculaDetail(@PathVariable("id") int id) {
      ModelAndView mv = new ModelAndView("detailMovie");
      mv.addObject("movies", ControladorPeliculas.MovieById(id));
      return mv;

   }

   

   

   
}

