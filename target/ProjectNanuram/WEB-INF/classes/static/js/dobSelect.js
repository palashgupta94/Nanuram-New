$(document).ready(function(){

    $('.dobSelect').datepicker({
        dateFormat: 'dd-mm-yy',
        changeMonth: true,
        changeYear: true,
        yearRange: '1940:' + new Date().getFullYear().toString(),
        showAnim : "fadeIn"
    });

});