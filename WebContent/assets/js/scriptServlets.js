/**
 * Created by arnaudmeersschaut on 11/05/16.
 */

function startGame() {
	window.location.href = "inGame.html";
	$.get("DominionServlet", {"function":"startGame", "players":"1"});
}

function endTurn() {
    $.get("DominionServlet", {"function":"endTurn"}, function(responseText) {
        $("#hand").html(responseText);
    });
}

function getHandCards(){
	$.get("DominionServlet", {"function":"getHandCards"}, function(responseText) {
        $("#hand").html(responseText);
    });
}

function getActionCards(){
	$.get("DominionServlet", {"function":"getActionCards"}, function(responseText) {
        $("#kingdomCardsShop").html(responseText);
    });
}

function playCard(e){
    e.preventDefault();
    
    $.get("DominionServlet", {"function":"playCard", "cardIndex": "2"}, function(responseText) {
		$('#playedCards').html(responseText);
    });
    
}

$(document).ready(function () {
	$('#startGame').on('click', startGame);
    $('#endTurn').on('click', endTurn);
    
    if (top.location.pathname === '/Dominion/inGame.html')
    {
    	getActionCards();
    	setTimeout(getHandCards(), 5000);
    }
    window.onbeforeunload = window.history.forward();
});

$(document).on("click","#hand .card", playCard);
