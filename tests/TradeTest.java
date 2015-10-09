
/*
 *    Team15Alpha
 *    AppName: SkillTradiez (Subject to change)
 *    Copyright (C) 2015  Stephen Andersen, Falon Scheers, Elyse Hill, Noah Weninger, Cole Evans
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class TradeTest {
	public void testInitTrade() {
		UserDatabase db = new UserDatabase();
		User user = db.createUser("u", "p");
		User user2 = db.createUser("u2", "p");

		Trade trade = user.getTradeList().createTrade(user, user2, new Skill("illlllll", "LLLLLLLLLLLLLLLL"));
		assertEquals(user.getTradeList().getMostRecentTrade(), trade);
		assertEquals(user2.getTradeList().getMostRecentTrade(), trade);
	}

	public void testAcceptTradeRequest() {
		UserDatabase db = new UserDatabase();
		User user = db.createUser("u", "p");
		User user2 = db.createUser("u2", "p");

		Trade trade = user.getTradeList().createTrade(user, user2, new Skill("illlllll", "iLLLLLLLLLLLLLLLL"));
		user2.getTradeList().getMostRecentTrade().setAccepted(user2);
		assertTrue(user.getTradeList().getMostRecentTrade().getAccepted(user2));
	}

	public void testRefuseTradeRequest() {
		UserDatabase db = new UserDatabase();
		User user = db.createUser("u", "p");
		User user2 = db.createUser("u2", "p");

		Trade trade = user.getTradeList().createTrade(user, user2, new Skill("illlllll", "iLLLLLLLLLLLLLLLL"));
		// decline the trade
		trade.setDeclined(user2);
		assertTrue(trade.getDeclined(user2));
		// delete the trade
		user2.getTradeList().delete(user2.getTradeList().getMostRecentTrade());
		assertTrue(user.getTradeList().getActiveTrades().size() == 0);
	}

	public void testCounterOfferTradeRequest() {
		UserDatabase db = new UserDatabase();
		User user = db.createUser("u", "p");
		User user2 = db.createUser("u2", "p");

		Trade trade = user.getTradeList().createTrade(user, user2, new Skill("illlllll", "iLLLLLLLLLLLLLLLL"));
		trade.setDeclined(user2);
		trade.setCounterOffer(new List { new Skill("Counter skill", "meta") });
		assertEquals(trade.getCounterOffer(), new List { new Skill("Counter skill", "meta") });
	}
}
