/**
 * Created by arnaudmeersschaut on 23/03/16.
 */

$(document).ready(function () {
    $('#signin, #signup').on('click', showLogin);
    $('.cancel').on('click', closeLogin)
});

function showLogin(e) {
    e.preventDefault();
    var id = $(this).attr('id');
    var selector = $('#loginPage h1');

    $('#loginPage').show();
    if (id == 'signup'){
        selector.text('Sign up');
        $('#validate').show();
    } else {
        selector.text('Login')
    }
}

function closeLogin(e) {
    $('#loginPage').hide();
}