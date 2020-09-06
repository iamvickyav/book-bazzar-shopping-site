$(document).ready(function () {
  $('#pincode-submit').click(function () {
    var pincode = $('#pincode-id').val();
    if (pincode >= 100000 && pincode <= 900000) {
      $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/location/pincode/' + pincode,
        success: function (location) {
          if (location.status === 'success' || location.status === 'SUCCESS') {
            $('#pincode-display').html(
              'Deliver to : ' +
                location.location +
                ', ' +
                location.state +
                ' (' +
                location.pincode +
                ')'
            );
            $('#pincode-show').show();
            $('#pincode-enter').hide();
          } else {
            $('#pincode-warning').show();
          }
        },
      });
    } else {
      $('#pincode-warning').show();
    }
  });

  $('#pincode-id').keyup(function () {
    $('#pincode-warning').hide();
    $('#pincode-show').hide();
  });

  $('#pincode-display').click(function () {
    $('#pincode-show').hide();
    $('#pincode-enter').show();
  });
});
