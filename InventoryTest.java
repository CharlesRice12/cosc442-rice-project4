package edu.towson.cis.cosc442.project4.coffeemaker;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>InventoryTest</code> contains tests for the class <code>{@link Inventory}</code>.
 *
 *  
 * @author chesney
 * @version $Revision: 1.0 $
 */
public class InventoryTest {
	/**
	 * Run the Inventory() constructor test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	private Inventory fixture;
	private Recipe r;
	
	@Test
	public void testInventory_1()
		throws Exception {

		Inventory result = new Inventory();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", result.toString());
		assertEquals(15, result.getSugar());
		assertEquals(15, result.getMilk());
		assertEquals(15, result.getChocolate());
		assertEquals(15, result.getCoffee());
	}

	/**
	 * Run the boolean enoughIngredients(Recipe) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testEnoughIngredients_1()
		throws Exception {
		Inventory fixture = new Inventory();
		Recipe r = new Recipe();

		boolean result = fixture.enoughIngredients(r);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean enoughIngredients(Recipe) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testEnoughIngredients_2()
		throws Exception {

		boolean result = fixture.enoughIngredients(r);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int getChocolate() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetChocolate_1()
		throws Exception {

		int result = fixture.getChocolate();

		// add additional test code here
		assertEquals(15, result);
	}

	/**
	 * Run the int getCoffee() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetCoffee_1()
		throws Exception {

		int result = fixture.getCoffee();

		// add additional test code here
		assertEquals(15, result);
	}

	/**
	 * Run the int getMilk() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetMilk_1()
		throws Exception {

		int result = fixture.getMilk();

		// add additional test code here
		assertEquals(15, result);
	}

	/**
	 * Run the int getSugar() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetSugar_1()
		throws Exception {
		int result = fixture.getSugar();

		// add additional test code here
		assertEquals(15, result);
	}

	/**
	 * Run the void setChocolate(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetChocolate_1()
		throws Exception {
		int chocolate = -1;

		fixture.setChocolate(chocolate);

		assertEquals(0, fixture.getChocolate());
	}

	/**
	 * Run the void setChocolate(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetChocolate_2()
		throws Exception {
		int chocolate = 1;

		fixture.setChocolate(chocolate);

		assertEquals(chocolate, fixture.getChocolate());
	}

	/**
	 * Run the void setCoffee(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetCoffee_1()
		throws Exception {
		int coffee = -1;

		fixture.setCoffee(coffee);

		assertEquals(0, fixture.getCoffee());
	}

	/**
	 * Run the void setCoffee(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetCoffee_2()
		throws Exception {
		int coffee = 1;

		fixture.setCoffee(coffee);

		assertEquals(coffee, fixture.getCoffee());
	}

	/**
	 * Run the void setMilk(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetMilk_1()
		throws Exception {
		int milk = -1;

		fixture.setMilk(milk);

		assertEquals(0, fixture.getMilk());
	}

	/**
	 * Run the void setMilk(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetMilk_2()
		throws Exception {
		int milk = 1;

		fixture.setMilk(milk);
		assertEquals(milk, fixture.getMilk());

	}

	/**
	 * Run the void setSugar(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetSugar_1()
		throws Exception {
		int sugar = -1;

		fixture.setSugar(sugar);
		assertEquals(0, fixture.getSugar());

		// add additional test code here
	}

	/**
	 * Run the void setSugar(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetSugar_2()
		throws Exception {
		int sugar = 1;

		fixture.setSugar(sugar);
		assertEquals(sugar, fixture.getSugar());

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testToString_1()
		throws Exception {

		assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", fixture.toString());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 *  
	 */
	@Before
	public void setUp()
		throws Exception {
		fixture = new Inventory();
		r = new Recipe();
		r.setName("Coffee");
		r.setPrice(50);
		r.setAmtCoffee(6);
		r.setAmtMilk(1);
		r.setAmtSugar(1);
		r.setAmtChocolate(0);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 *  
	 */
	@After
	public void tearDown()
		throws Exception {
		fixture = null;
		r = null;
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 *  
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(InventoryTest.class);
	}
}