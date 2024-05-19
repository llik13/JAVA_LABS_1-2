package com.example.demo.controllers;

import com.example.demo.models.Genre;
import com.example.demo.models.Customer;
import com.example.demo.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DemoController {
    @GetMapping
    public String index(Model model) {
        //variables
        model.addAttribute("username", "Uncle bob");
        Customer customer = new Customer("Uncle bob");
        model.addAttribute("customer", customer);

        //maps
        Map<String, String> townsOfCountries = new HashMap<>();
        townsOfCountries.put("UK", "London");
        townsOfCountries.put("France", "Paris");
        townsOfCountries.put("Germany", "Berlin");
        model.addAttribute("townsOfCountries", townsOfCountries);

        //arrays and lists
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Lord Byron", "Don Juan"));
        booksList.add(new Book("Stendhal", "Red and Black"));
        booksList.add(new Book("Johann Wolfgang von Goethe", "Faust"));
        model.addAttribute("booksList", booksList);

        //selected objects
        Genre genre = new Genre("Romance","18-19 century");
        model.addAttribute("genre", genre);

        //iteration
        model.addAttribute("languages", List.of("Java", "Kotlin", "Groovy"));
        return "index";
    }
}