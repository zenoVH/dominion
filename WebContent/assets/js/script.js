/**
 * Created by arnaudmeersschaut on 23/03/16.
 */
function showLogin(e) {
    e.preventDefault();
    var id = $(this).attr('id');
    var selector = $('#loginPage h1');

    $('#loginPage').show('clip', '500');
    if (id == 'signup') {
        selector.text('Sign up');
        $('#validate').show();
    } else {
        selector.text('Login');
        $('#validate').hide();
    }
    document.getElementById("username").focus();
}

function showMenu(e) {
    e.preventDefault();

    $('#startPage').hide();
    $('#loginPage').hide();
    $('#menu').show();
}

function closeLogin(e) {
    e.preventDefault();
    $('#loginPage').hide();
}

function draggable() {
    $('#loginPage').draggable({cursor: "move", containment: "document"});
}

function checkPass(e) {
    e.preventDefault();
    var pass1 = document.getElementById('password');
    var pass2 = document.getElementById('vpassword');

    var message = document.getElementById('match');

    var goodColor = "#66cc66";
    var badColor = "#ff6666";

    if (pass1.value == pass2.value) {
        message.style.color = goodColor;
        message.innerHTML = "Passwords match!"
    } else {
        message.style.color = badColor;
        message.innerHTML = "Passwords do not match!";
        setTimeout(function () {
            message.innerHTML = "";
        }, 4000);
    }
}

function muteMusic(e) {
    e.preventDefault();
    muted = document.getElementById('music').muted;

    if (muted == false){
        document.getElementById('music').muted = true;
        $('#mute').css('background-image', 'url("assets/media/mute.png")');
    } else {
        document.getElementById('music').muted = false;
        $('#mute').css('background-image', 'url("assets/media/sound.png")');
    }
}

$(document).ready(function () {
    draggable();
    $('#vpassword').on('keyup', checkPass);
    $('#signin, #signup').on('click', showLogin);
    $('.cancel').on('click', closeLogin);
    $('#mute').on('click', muteMusic);
    $('#play').on('click', showMenu);
});