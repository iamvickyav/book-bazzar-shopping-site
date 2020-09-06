package com.iamvickyav.BookBazzar.model;

import com.iamvickyav.BookBazzar.model.solr.BookFacet;

import java.util.List;

public class BookFacetResponse {
    public BookFacetResponse() {
    }

    public BookFacetResponse(String filterName, List<BookFacet> bookFacets) {
        this.filterName = filterName;
        this.bookFacets = bookFacets;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public List<BookFacet> getBookFacets() {
        return bookFacets;
    }

    public void setBookFacets(List<BookFacet> bookFacets) {
        this.bookFacets = bookFacets;
    }

    String filterName;
    List<BookFacet> bookFacets;
}
