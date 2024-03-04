/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

/**
 *
 * @author dell
 */
public class Drink extends Food
{
    public Drink(String id,String name, String[] ingredients, double price)
    {
        super(id,name,ingredients,price);
    }
    
    @Override
    public String toString() {
        return "Drink "+super.toString();
    }
    
}
