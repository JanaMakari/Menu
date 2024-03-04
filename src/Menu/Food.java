/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

public class Food {
    //
    private String name;
    private String id;
    private String[] ingredients;
    private double price;
    //
    
    //Constructor
    public Food(String id,String name, String[] ingredients, double price)
    {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients;
        this.price = price;
    }
    //
    
    //
    public static boolean validFoodId(String id, String regex)
    {
        if( id==null || id.length() < 3)
        {
            return false;
        }
        String modifiedRegex = regex + ".*";
        return id.matches(modifiedRegex);
    }
    //
    
    //Method returns Food ID - Name - Price
    public String getFoodDescription()
    {
        try
        {
            return this.id+" - "+this.name+"\t$"+this.price+"\n"+this.getIngredientsdescription()+"\n";
        }
        catch(NullPointerException e)
        {
            return "Empty\n";
        }
    }
    //

    //
    @Override
    public String toString() {
        return "{" +" id= " + id + "name= " + name + ", ingredients= " + getIngredientsdescription() + ", price= " + price + " }\n";
       
    }
    public String getIngredientsdescription() {
        if(this.ingredients == null)
        {
            return "No ingredients";
        }
        return String.join(",", ingredients);
    }
    //
    
    //Methods
    
    ///
    public String getIngredient(int index) {
        try
        {
            return this.ingredients[index];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return "Invalid Index";
        }
        catch(NullPointerException ne)
        {
            return "Ingredients are Empty";
        }
    }
    //
    
    // Getters and Setters
    public String[] getIngredients() {
        return this.ingredients;
    }
    
    public void setIngredients( String[] ingredients) {
        this.ingredients = ingredients;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
