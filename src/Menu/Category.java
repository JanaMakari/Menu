/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.util.ArrayList;

public class Category {
    //
    private ArrayList<Food> items = new ArrayList<Food>();
    private String name;
    //
    
    //Constructor
    public Category(String name,ArrayList<Food> items)
    {
        this.name = name;
        this.items = items;
    }
    //
    
    //
    public Food getItemByName(String itemName)
    {
        String modifiedname = itemName.trim();
        String itemmodifiedname;
        for(Food item : items)
        {
            itemmodifiedname = item.getName().trim();
            if(itemmodifiedname.equalsIgnoreCase(modifiedname))
            {
                return item;
            }
        }
        return null;
    }
    //
    
    //
    public String displayCategory()
    {
        String str = this.name+" : \n";
        for(Food item : this.items)
        {
            str+= item.getFoodDescription()+"\n";
        }
        return str;
    }
    //
    
    //Get a single itemFood
    public Food getItem(String id)
    {
        //if(Food.validFoodId(id, name)) Valid ID before enter it as input
        for(Food item : this.items)
        {
            if(item.getId().equals(id))
            {
                return item;
            }
        }
        return null;
    }
    //
    
    //Getters and Setters
    public ArrayList<Food> getItems() 
    {
        return items;
    }

    public void setItems(ArrayList<Food> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
