package com.iamvickyav.BookBazzar.model.solr;

public class BookFacet {
    String field;
    Long valueCount;

    public BookFacet() {
    }

    public BookFacet(String field, Long valueCount) {
        this.field = field;
        this.valueCount = valueCount;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getValueCount() {
        return valueCount;
    }

    public void setValueCount(Long valueCount) {
        this.valueCount = valueCount;
    }
}
