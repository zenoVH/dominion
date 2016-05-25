
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

import gameEngine.*;

/**
 * Servlet implementation class DominionServlet
 */
public class DominionServlet extends HttpServlet {

	private GameEngine engine = new GameEngine();
	private ActionHandler ah = new ActionHandler(engine);
	
	private static final long serialVersionUID = 1L;
	private String text;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DominionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramValue = request.getParameter("function");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		switch (paramValue) {
		case "startGame":
			String[] players = request.getParameterValues("players[]");
			
			engine.init(players.length, 20);
			
			for (int i = 0; i < players.length - 1; i++){
				engine.getPlayerX(i).setName(players[i]);
			}
			
			response.getWriter().write(engine.getPlayerX(0).getName());
			break;

		case "getActionCards":
			for (int i = 0; i < engine.getActionCards().size(); i++) {
				String cardName = engine.getActionCards().get(i).getName().toLowerCase();
				text = "<img src=\"images/cards/" + cardName + ".png\" alt=\"" + cardName + "\" class=\"card buyable\" />";
				response.getWriter().write(text);
			}
			break;

		case "getHandCards":
			ArrayList<gameEngine.card> inHand = engine.getPlayer().getHandCards();

			for (int i = 0; i < inHand.size(); i++) {
				String cardName = inHand.get(i).getName().toString().toLowerCase();
				String cardType = inHand.get(i).getType();
				text = "<img src=\"images/cards/" + cardName + ".png\" alt=\"" + cardType + "\" class=\"card\" />";
				response.getWriter().write(text);
			}
			break;

		case "getPlayedCards":
			ArrayList<gameEngine.card> playedCards = engine.getPlayer().getPlayedCards();
			for (int i = 0; i < playedCards.size(); i++) {
				String cardName = playedCards.get(i).getName().toString().toLowerCase();
				text = "<img src=\"images/cards/" + cardName + ".png\" alt=\"" + cardName + "\" class=\"card\" />";
				response.getWriter().write(text);
			}
			break;

		case "playCard":
			engine.cardInHandClicked(Integer.parseInt(request.getParameter("cardIndex")));
			break;

		case "buyCard":
			String card = (request.getParameter("card"));
			buyCard(card);
			
			break;

		case "getCoins":
			response.getWriter().write(Integer.toString(engine.getPlayer().getCurrentCoins()));
			break;

		case "getBuys":
			response.getWriter().write(Integer.toString(engine.getPlayer().getBuys()));
			break;
			
		case "getActions":
			response.getWriter().write(Integer.toString(engine.getPlayer().getActions()));
			break;

		case "endTurn":
			engine.nextTurn();
			break;

		case "getCurrentPlayer":
			String currentPlayer = engine.getPlayer().getName();
			response.getWriter().write(currentPlayer);
			break;
		}
	}

	private void buyCard(String card) {
		switch (card) {
		
		case "copper":
			engine.buyCard(cardtype.COPPER.add());
			break;
			
		case "silver":
			engine.buyCard(cardtype.SILVER.add());
			break;
			
		case "gold":
			engine.buyCard(cardtype.GOLD.add());
			break;
			
		case "estate":
			engine.buyCard(cardtype.ESTATE.add());
			break;
			
		case "duchy":
			engine.buyCard(cardtype.DUTCHY.add());
			break;
			
		case "province":
			engine.buyCard(cardtype.PROVINCE.add());
			break;
		default:
			ah.buyCard(card);
		}
	}

	// private void startGame(int players){
	// engine.getPlayer().setName("Arnaud");

	// for (int i = 0; i < engine.getAllPlayers().size(); i++){
	// engine.getAllPlayers().get(i).setName("name");
	// }
	// }

}
