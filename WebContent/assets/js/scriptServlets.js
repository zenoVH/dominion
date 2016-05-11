/**
 * Created by arnaudmeersschaut on 11/05/16.
 */

function endTurn() {
    $.get("DominionServlet", function(responseText) {
        $("#currentPlayer").text(responseText);
    });
}

$(document).ready(function () {
    $('#endTurn').on('click', endTurn)
});
