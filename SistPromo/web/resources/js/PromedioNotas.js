$(document).ready(function() {

 CalcularTotal();

});
function CalcularTotal()
{
var totals = [0, 0, 0, 0, 0, 0, 0, 0];
 var $filas= $("#tabla tr:not('.total, .encabezado')");

  $filas.each(function() {
    $(this).find('td').each(function(i) {
      if (i != 0)
        totals[i - 1] += parseInt($(this).html());
    });
  });
  $(".total td").each(function(i) {
    if (i != 0)
      $(this).html(totals[i - 1]);
  });
}