package edu.towson.cis.cosc442.project4.coffeemaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Starts the console UI for the CoffeeMaker
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Main {
    private static CoffeeMaker coffeeMaker;

    public static void mainMenu() {
        System.out.println("1. Add a recipe");
        System.out.println("2. Delete a recipe");
        System.out.println("3. Edit a recipe");
        System.out.println("4. Add inventory");
        System.out.println("5. Check inventory");
        System.out.println("6. Make coffee");
        System.out.println("0. Exit"+java.lang.System.getProperty("line.separator"));
        
        //Get user input
        final int userInput = stringToInt(inputOutput("Please press the number that corresponds to what you would like the coffee maker to do."));
        
        if(userInput == 1) addRecipe();
        if(userInput == 2) deleteRecipe();
        if(userInput == 3) editRecipe();
        if(userInput == 4) addInventory();
        if(userInput == 5) checkInventory();
        if(userInput == 6) makeCoffee();
        if(userInput == 0) System.exit(0);
    }
	public static void addRecipe() {
	    //Read in recipe name
	    final String name = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the recipe name: ");
	    
	    //Read in recipe price
	    final String priceString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the recipe price: $");
	    final int price = stringToInt(priceString);
	    if(price < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt coffee
	    final String coffeeString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of coffee in the recipe: ");
	    final int amtCoffee = stringToInt(coffeeString);
	    if(amtCoffee < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt milk
	    final String milkString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of milk in the recipe: ");
	    final int amtMilk = stringToInt(milkString);
	    if(amtMilk < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt sugar
	    final String sugarString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of sugar in the recipe: ");
	    final int amtSugar = stringToInt(sugarString);
	    if(amtSugar < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt chocolate
	    final String chocolateString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of chocolate in the recipe: ");
	    final int amtChocolate = stringToInt(chocolateString);
	    if(amtChocolate < 0) {
	    	mainMenu();
	    }
	    
	    boolean recipeAdded = false;
	    final Recipe r = new Recipe();
		r.setName(name);
		r.setPrice(price);
		r.setAmtCoffee(amtCoffee);
		r.setAmtMilk(amtMilk);
		r.setAmtSugar(amtSugar);
		r.setAmtChocolate(amtChocolate);
		   
		recipeAdded = coffeeMaker.addRecipe(r);
	    
	    if(recipeAdded) System.out.println(name + " successfully added.");
	    else System.out.println(name + "could not be added.");
	    
	    mainMenu();
    }
    
    public static void deleteRecipe() {
    	final Recipe [] recipes = coffeeMaker.getRecipes();
        for(int i = 0; i < recipes.length; i++) {
            System.out.println((i+1) + ". " + recipes[i].getName());
        }
        final  String recipeToDeleteString = inputOutput("Please select the number of the recipe to delete.");
        final int recipeToDelete = stringToInt(recipeToDeleteString) - 1;
	    if(recipeToDelete < 0) {
	    	mainMenu();
	    }
        
	    final boolean recipeDeleted = coffeeMaker.deleteRecipe(recipes[recipeToDelete]);
        
        if(recipeDeleted) System.out.println(recipes[recipeToDelete].getName() + " successfully deleted.");
	    else System.out.println(recipes[recipeToDelete].getName() + "could not be deleted.");
        
        mainMenu();
    }
    
    public static void editRecipe() {
    	final Recipe [] recipes = coffeeMaker.getRecipes();
        for(int i = 0; i < recipes.length; i++) {
            System.out.println((i+1) + ". " + recipes[i].getName());
        }
        final String recipeToEditString = inputOutput("Please select the number of the recipe to edit.");
        final int recipeToEdit = stringToInt(recipeToEditString) -1;
	    if(recipeToEdit < 0) {
	    	mainMenu();
	    }
        
	    final Recipe oldRecipe = recipes[recipeToEdit];
        
	    //Read in recipe name
	    final String name = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the recipe name: ");
	    
	    //Read in recipe price
	    final String priceString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the recipe price: $");
	    final int price = stringToInt(priceString);
	    if(price < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt coffee
	    final String coffeeString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of coffee in the recipe: ");
	    final int amtCoffee = stringToInt(coffeeString);
	    if(amtCoffee < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt milk
	    final String milkString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of milk in the recipe: ");
	    final int amtMilk = stringToInt(milkString);
	    if(amtMilk < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt sugar
	    final String sugarString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of sugar in the recipe: ");
	    final int amtSugar = stringToInt(sugarString);
	    if(amtSugar < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt chocolate
	    final String chocolateString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of chocolate in the recipe: ");
	    final int amtChocolate = stringToInt(chocolateString);
	    if(amtChocolate < 0) {
	    	mainMenu();
	    }
	    
	    final Recipe newRecipe = new Recipe();
	    newRecipe.setName(name);
	    newRecipe.setPrice(price);
	    newRecipe.setAmtCoffee(amtCoffee);
	    newRecipe.setAmtMilk(amtMilk);
	    newRecipe.setAmtSugar(amtSugar);
	    newRecipe.setAmtChocolate(amtChocolate);
        
	    final boolean recipeEdited = coffeeMaker.editRecipe(oldRecipe, newRecipe);
        
        if(recipeEdited) System.out.println(oldRecipe.getName() + " successfully edited.");
	    else System.out.println(oldRecipe.getName() + "could not be edited.");
        
        mainMenu();
    }
    
    public static void addInventory() {
	    //Read in amt coffee
    	final String coffeeString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of coffee to add: ");
    	final int amtCoffee = stringToInt(coffeeString);
	    if(amtCoffee < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt milk
	    final String milkString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of milk to add: ");
	    final int amtMilk = stringToInt(milkString);
	    if(amtMilk < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt sugar
	    final String sugarString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of sugar to add: ");
	    final int amtSugar = stringToInt(sugarString);
	    if(amtSugar < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt chocolate
	    final String chocolateString = inputOutput(java.lang.System.getProperty("line.separator")+"Please enter the units of chocolate to add: ");
	    final int amtChocolate = stringToInt(chocolateString);
	    if(amtChocolate < 0) {
	    	mainMenu();
	    }
	    
        coffeeMaker.addInventory(amtCoffee, amtMilk, amtSugar, amtChocolate);
        mainMenu();
    }
    
    public static void checkInventory() {
    	final Inventory inventory = coffeeMaker.checkInventory();
        System.out.println(inventory.toString());
        mainMenu();
    }
    
    public static void makeCoffee() {
    	final Recipe [] recipes = coffeeMaker.getRecipes();
        for(int i = 0; i < recipes.length; i++) {
            System.out.println((i+1) + ". " + recipes[i].getName());
        }
        final String recipeToPurchaseString = inputOutput("Please select the number of the recipe to purchase.");
        final  int recipeToPurchase = stringToInt(recipeToPurchaseString) -1;
	    if(recipeToPurchase < 0) {
	    	mainMenu();
	    }
        
	    final String amountPaid = inputOutput("Please enter the amount you wish to pay");
	    final int amountToPay = stringToInt(amountPaid);
	    if(amountToPay < 0) {
	    	mainMenu();
	    }
        
	    final Recipe recipe = recipes[recipeToPurchase];
	    final int change = coffeeMaker.makeCoffee(recipe, amountToPay);
        
        System.out.println("Your change is: " + change + java.lang.System.getProperty("line.separator"));
        mainMenu();
    }
    
    /**
     * Method inputOutput.
     * @param message String
     * @return String
     */
    public static String inputOutput(String message) {
        System.out.println(message);
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error reading in value");
	        mainMenu();
	    }
	    return returnString;
    }
    
    /**
     * Method stringToInt.
     * @param value String
     * @return int
     */
    private static int stringToInt(String value) {
        int returnInt = -1;
        try {
            returnInt = Integer.parseInt(value);
        }
        catch (NumberFormatException e) {
            System.out.println("Please input an integer"+java.lang.System.getProperty("line.separator"));
        }
        return returnInt;
    }
    
    /**
     * Method main.
     * @param args String[]
     */
    public static void main(String[] args) {
	    coffeeMaker = new CoffeeMaker();
	    System.out.println("Welcome to the CoffeeMaker!"+java.lang.System.getProperty("line.separator"));
	    mainMenu();
	}
}
