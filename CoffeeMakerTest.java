package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	
	public void testAddRecipe2() {
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r1));
	}
	
	public void testAddRecipe3() {
		cm.addRecipe(new Recipe());
		cm.addRecipe(new Recipe());
		cm.addRecipe(new Recipe());
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(new Recipe()));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	public void testEditRecipe2() {
		cm.addRecipe(r1);
		assertFalse(cm.editRecipe(r1,new Recipe()));
	}
	
	public void testEditRecipe3() {
		cm.addRecipe(new Recipe());
		cm.addRecipe(new Recipe());
		cm.addRecipe(new Recipe());
		cm.addRecipe(r1);
		assertFalse(cm.editRecipe(r1,new Recipe()));
	}
	
	
	public void testAddInventory1() {
		Inventory p = i;
		cm.addInventory(50,50,50,50);
		assertSame(p, i);
	}
	
	public void testAddInventory2() {
		assertFalse(cm.addInventory(-1,-1,-1,-1));
	}
	
	public void testCheckInventory() {
		Inventory p = cm.checkInventory();
		assertNotNull(p);
	}
	
	public void testMakeCoffee1() {
		int amtPaid = 51;
		int change =1;
		assertEquals((double)change, (double)cm.makeCoffee(r1,amtPaid), .0001);
	}
	
	public void testMakeCoffee2() {
		int amtPaid = 49;
		assertEquals((double) amtPaid, (double)cm.makeCoffee(r1, amtPaid), .0001);
		
	}
	
	public void testMakeCoffee3() {
		cm.checkInventory().setCoffee(0);
		cm.checkInventory().setMilk(0);
		cm.checkInventory().setSugar(0);
		cm.checkInventory().setChocolate(0);
		int amtPaid = 50;
		assertEquals((double) amtPaid, (double)cm.makeCoffee(r1, amtPaid), .0001);
	}
	
	public void testGetRecipes() {
		assertNotNull(cm.getRecipes());
	}
	
	public void testGetRecipeForName() {
		assertNotNull(cm.getRecipeForName("Coffee"));
	}
} 