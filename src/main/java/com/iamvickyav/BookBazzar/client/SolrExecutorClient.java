package com.iamvickyav.BookBazzar.client;

import com.iamvickyav.BookBazzar.model.solr.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FacetOptions;
import org.springframework.data.solr.core.query.FacetQuery;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SolrExecutorClient {

    @Autowired
    SolrTemplate solrTemplate;

    public <T> FacetPage<T> executeFacetQuery(FacetQuery facetQuery, String collection, Class<T> type) {
        return solrTemplate.queryForFacetPage(collection, facetQuery, type);
    }

    public FacetQuery prepareFacetQueryForGivenFields(List<String> facetFields) {

        FacetOptions facetOptions = new FacetOptions();

        facetFields.forEach(facetOptions::addFacetOnField);
        facetOptions.setFacetLimit(1000);

        return new SimpleFacetQuery(
                new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD))
                .setFacetOptions(facetOptions);
    }
}
