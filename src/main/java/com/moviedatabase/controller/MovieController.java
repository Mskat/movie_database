package com.moviedatabase.controller;

import com.moviedatabase.dao.MovieDAO;
import com.moviedatabase.dto.MovieDTO;
import com.moviedatabase.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MovieController {

    @Autowired
    private MovieDAO movieDao;

    @RequestMapping("/list")
    public String movieList(Model model){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Movie> query = entityManager.createQuery("select m from Movie m", Movie.class);
        model.addAttribute("movies", query.getResultList());

        entityManager.close();
        entityManagerFactory.close();

        return "list";
    }

    @RequestMapping("/add")
    public String addMovie(HttpServletRequest request, @ModelAttribute("movieDto") @Valid MovieDTO movieDto, BindingResult result){
        if(request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()){

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Movie m = new Movie();

            m.setYear(Integer.valueOf(movieDto.getYear()));
            m.setTitle(movieDto.getTitle());
            m.setAuthor(movieDto.getAuthor());

            entityManager.getTransaction().begin();
            entityManager.persist(m);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            movieDao.addMovie(m);

            return "redirect:/list";
        }

        return "add";
    }

    @RequestMapping("/movie-{id}")
    public String showMovie(@PathVariable("id") Long id, Model model) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        model.addAttribute("movie", entityManager.find(Movie.class, id));

        return "details";
    }
}
