package com.iamvickyav.BookBazzar.controller;

import com.iamvickyav.BookBazzar.model.Suggestion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SuggestionController {

    private List<String> bookList = new ArrayList<>();
    private List<String> authorList = new ArrayList<>();

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    Map<String, String> getBook(@RequestParam("id") String id){
        System.out.println(id);
        Map<String, String> map = new HashMap<>();
        map.put("imgId", "spring-book.jpeg");
        map.put("title", "Spring in Action 4 Edition");
        map.put("author", "Craig Walls");
        map.put("productId", id);
        map.put("ratings", "65");
        map.put("reviews", "28");
        map.put("price", "810.00");

        return map;
    }

    @RequestMapping(value = "/suggestion", method = RequestMethod.GET)
    List<Suggestion> getCompleteSuggestion(@RequestParam("q") String search){
        List<String> books = allBookNames();
        List<String> authors = allAuthorNames();

        List<Suggestion> matchingBooks = books.parallelStream()
                .filter(bookName -> bookName.contains(search))
                .map(bookName -> new Suggestion(bookName, "Books"))
                .collect(Collectors.toList());

        List<Suggestion> matchingAuthors = authors.parallelStream()
                .filter(bookName -> bookName.contains(search))
                .map(bookName -> new Suggestion(bookName, "Authors"))
                .collect(Collectors.toList());

        List<Suggestion> finalSuggestion = new ArrayList<>(matchingBooks);
        finalSuggestion.addAll(matchingAuthors);
        return finalSuggestion;
    }

    private List<String> allBookNames() {
        if(bookList.isEmpty()) {
            bookList.add("Agni Siragugal");
            bookList.add("Nirvana Nagaram");
            bookList.add("Anbulla Appa");
            bookList.add("Kadaisi Dhinam");
            bookList.add("Men are from mars and Women are venus");
            bookList.add("Asuran");
            bookList.add("Business in 21st Century");
            bookList.add("Oath of Vayuputras");
            bookList.add("Homo Dues");
        }
        return bookList;
    }

    private List<String> allAuthorNames(){
        if(authorList.isEmpty()) {
            authorList.add("Abdul Kalam");
            authorList.add("Sujatha");
            authorList.add("John Gray");
            authorList.add("Anand Neelakantan");
            authorList.add("Amit");
            authorList.add("Yuvan Harrari");
        }
        return authorList;
    }
}
