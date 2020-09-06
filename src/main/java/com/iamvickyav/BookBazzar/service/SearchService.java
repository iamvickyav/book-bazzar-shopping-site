package com.iamvickyav.BookBazzar.service;

import com.iamvickyav.BookBazzar.client.SolrExecutorClient;
import com.iamvickyav.BookBazzar.model.BookFacetResponse;
import com.iamvickyav.BookBazzar.model.PLPResponse;
import com.iamvickyav.BookBazzar.model.solr.Book;
import com.iamvickyav.BookBazzar.model.solr.BookFacet;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.FacetFieldEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    SolrExecutorClient solrClient;

    public PLPResponse process() {

        List<String> facetFields = Arrays.asList("tags", "author", "language");
        List<BookFacetResponse> filterResponse = new ArrayList<>();

        FacetQuery query = solrClient.prepareFacetQueryForGivenFields(facetFields);

        FacetPage<Book> page = solrClient.executeFacetQuery(query, "bookbazzar2", Book.class);

        for(String facetFieldName : facetFields) {
            List<FacetFieldEntry> facetFieldEntries = page.getFacetResultPage(facetFieldName).getContent();

            List<BookFacet> facetResult = facetFieldEntries.stream()
                    .map(f -> new BookFacet(f.getValue(), f.getValueCount()))
                    .collect(Collectors.toList());
            filterResponse.add(new BookFacetResponse(facetFieldName, facetResult));
        }

        PLPResponse plpResponse = new PLPResponse();
        plpResponse.setBooks(page.getContent());
        plpResponse.setFilter(filterResponse);
        return plpResponse;
    }
}
