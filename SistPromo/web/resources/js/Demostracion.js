// ----- Reset by method 1 -----
document.getElementById('reset1').addEventListener('click', function() {
  document.getElementById('new_customer').reset();
  // If you are using jQuery then: $('#new_customer')[0].reset();
});

// ----- Reset by method 2 -----
$( "#reset2" ).click(function() {
  $('#new_customer')
    .find(':input')
    .not(':button, :submit, :reset, :hidden')
    .val('')
    .prop('checked', false)
    .prop('selected', false);
});



// Prevent from submiting the form
document.getElementById('new_customer').addEventListener('submit', function(event) {
  event.preventDefault();
});