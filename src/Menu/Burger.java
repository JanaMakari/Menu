/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

public class Burger extends Food
{
    public Burger(String id,String name, String[] ingredients, double price)
    {
        super(id,name,ingredients,price);
    }
    
    static String burgerId = "#B";
    
    @Override
    public String toString() {
        return "Burger "+super.toString();
    }
    public String getFoodDescription()
    {
        try
        {
            return this.getId()+" - "+this.getName()+"\t$"+this.getPrice()+"\n"+this.getIngredientsdescription()+"\n";
        }
        catch(NullPointerException e)
        {
            return "Empty\n";
        }
    }
}
