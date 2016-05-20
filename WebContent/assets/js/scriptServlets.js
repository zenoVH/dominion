/**
 * Created by arnaudmeersschaut on 11/05/16.
 */

function startGame() {
	window.location.href = "inGame.html";
	$.get("DominionServlet", {"function":"startGame", "players":"2"}, function(responseText) {
        $("#currentPlayer").html(responseText);
    });
}

function endTurn() {
    $.get("DominionServlet", {"function":"endTurn"}, function(responseText) {
        $("#currentPlayer").html(responseText);
    });
    getHandCards();
    getBuys();
    getCoins();
    getPlayedCards();
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

function getPlayedCards(){
	$.get("DominionServlet", {"function":"getPlayedCards"}, function(responseText) {
        $('#playedCards').html(responseText);
    });
}

function getCoins(){
	$('#money span').text("");
	$.get("DominionServlet", {"function":"getCoins"}, function(responseText) {
        $('#money span').html(responseText);
    });
}

function getBuys(){
	$('#buys span').text("");
	$.get("DominionServlet", {"function":"getBuys"}, function(responseText) {
        $('#buys span').html(responseText);
    });
}

function playCard(e){
    e.preventDefault();
    var index = $('#hand img').index(this);
    
    $.get("DominionServlet", {"function":"playCard", "cardIndex": index}, function(responseText) {
        $('#playedCards').html(responseText);
    });
    
    getPlayedCards();
    getCoins();
    
    if($(this).attr('alt') != "Victory"){  
        $(this).remove();
    }
    
}

function buyCard(e) {
	e.preventDefault();
	
	console.log("buy card");
	
	var cardName = $(this).attr('alt');
	
	$.get("DominionServlet", {"function":"buyCard", "card": cardName});
	
	getCoins();
	getBuys();
}

$(document).ready(function () {
	$('#startGame').on('click', startGame);
    $('#endTurn').on('click', endTurn);
    
    if (top.location.pathname === '/Dominion/inGame.html')
    {
    	getActionCards();
    	getCoins();
    	setTimeout(getPlayedCards(), 5000);
    	setTimeout(getHandCards(), 5000);
    }
    window.onbeforeunload = window.history.forward();
});

$(document).on("click","#hand .card", playCard);
$(document).on("click", ".buyable", buyCard)
