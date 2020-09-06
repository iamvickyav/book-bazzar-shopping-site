$(document).ready(function () {
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/location/test',
    success: function (bookResponse) {
      // Book Search Result Section Rendering

      var bookList = bookResponse.books;
      $.each(bookList, function (i, bookContent) {
        var t = document.querySelector('#search-result-template');
        t.content.querySelector('.book-id').innerHTML =
          'Product Id: ' + bookContent.id;
        t.content.querySelector('.book-title').innerHTML = bookContent.title;
        t.content.querySelector('.book-author').innerHTML =
          'By ' + bookContent.author;
        t.content.querySelector('.book-src').src =
          'images/b' + bookContent.id + '.png';
        var clone = document.importNode(t.content, true);
        $('#search-results').append(clone);
      });

      // Book Search Result Section Rendering Complete

      // Filter Section Rendering
      var filterList = bookResponse.filter;
      $.each(filterList, function (i, filterContent) {
        var t = document.querySelector('#filter-template');

        t.content
          .querySelector('.accordion')
          .setAttribute('id', 'accordion' + i);

        t.content
          .querySelector('.card-header a')
          .setAttribute('href', '#collapse' + i);

        t.content
          .querySelector('.card-header a')
          .setAttribute('data-parent', '#accordion' + i);

        t.content.querySelector('.collapse').setAttribute('id', 'collapse' + i);

        t.content
          .querySelector('.collapse')
          .setAttribute('data-parent', '#accordion' + i);

        t.content.querySelector('.card-header a').innerHTML =
          filterContent.filterName +
          '<i class="fa fa-angle-down rotate-icon"></i>';

        var checkBoxes = '<div class="form-check">';
        var facetEntries = filterContent.bookFacets;
        $.each(facetEntries, function (j, facetEntry) {
          var checkBoxDiv =
            '<input type="checkbox" class="form-check-input filter-checkbox">' +
            '<label class="form-check-label">' +
            facetEntry.field +
            '(' +
            facetEntry.valueCount +
            ')' +
            '</label><br/>';

          checkBoxes += checkBoxDiv;
        });

        var result = checkBoxes + '<br/></div>';

        t.content.querySelector('.card-body').innerHTML = result;
        var clone = document.importNode(t.content, true);
        $('#filter-sidebar').append(clone);
      });
      // Filter Section Complete
    },
  });
});
