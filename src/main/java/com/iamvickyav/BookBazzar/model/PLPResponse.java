package com.iamvickyav.BookBazzar.model;

import com.iamvickyav.BookBazzar.model.solr.Book;

import java.util.List;

public class PLPResponse {
    
   List<Book> books;
   List<BookFacetResponse> filter;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<BookFacetResponse> getFilter() {
        return filter;
    }

    public void setFilter(List<BookFacetResponse> filter) {
        this.filter = filter;
    }
}
