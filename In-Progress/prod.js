$(document).ready(function () {
  $.urlParam = function (name) {
    var results = new RegExp('[?&]' + name + '=([^&#]*)').exec(
      window.location.href
    );
    if (results == null) {
      return null;
    }
    return decodeURI(results[1]) || 0;
  };

  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/book' + '?id=' + $.urlParam('id'),
    success: function (book) {
      var t = document.querySelector('#book-detail');
      // Image tag
      t.content.querySelector('#book-img').src = 'image/' + book.imgId;

      // <h1>
      t.content.querySelector('#title').textContent = book.title;

      // <p>
      t.content.querySelector('#author').innerHTML =
        'by ' + book.author + ' (Author)';

      // <span>
      t.content.querySelector('#productId').innerHTML =
        'Product Id: ' + book.productId;

      // <span>
      t.content.querySelector('#ratings').innerHTML = book.ratings;

      // <button>
      t.content.querySelector('#reviews').innerHTML = book.reviews + ' reviews';

      // <h2>
      t.content.querySelector('#price').textContent = '₹ ' + book.price;
      var clone = document.importNode(t.content, true);
      $('#main-body').append(clone);
    },
  });
});
