/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

public class Sides extends Food
{
    private String sauce;
    
    public Sides (String id,String name, String[] ingredients, double price,String sauce)
    {
        super(id,name,ingredients,price);
        this.sauce = sauce;
    }

    @Override
    public String toString() {
        return "Sides{" + "sauce=" + sauce + '}';
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
