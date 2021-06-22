(document).ready(function(){

    $('.reset').on('click' , function(){

        var id = $(this).attr('id');
        document.getElementById(id).reset();

    });


});