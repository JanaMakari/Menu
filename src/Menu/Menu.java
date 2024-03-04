/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.util.ArrayList;

public class Menu {
    //
    private String name;
    private ArrayList<Category> categories;
    //
    
    //Constructor
    public Menu(String name,ArrayList<Category> categories) 
    {
        this.name = name;
        this.categories = categories;
    }
    //
    
    public Food getFoodByCategoryName(String categoryname,String itemName)
    {
        try
        {
            Category category = this.getCategoryByName(categoryname);
            return category.getItemByName(itemName);
        }
        catch(NullPointerException e)
        {
            return null;    
        }
    }
    
    public Category getCategoryByName(String categoryname)
    {
        String modifiedInputName = categoryname.trim();
        String modifiedCategoryName;
        for(Category category : categories)
        {
            modifiedCategoryName = category.getName().trim();
            if(modifiedCategoryName.equalsIgnoreCase(modifiedInputName))
            {
                return category;
            }
        }
        return null;
    }
    
    //
    public String displayMenu()
    {
        String s="";
        String str = "\t-- "+this.name+" Menu --\n";
        try
        {
           for(Category category : categories)
            {
                s+=category.displayCategory()+"\n\t----------------------\n";
            }
            return str+=s; 
        }
        catch(NullPointerException e)
        {
            return "Categories are Empty\n";
        }
    }
    //
    
    //Add Category to list
    public void addCategory(Category c)
    {
        if(c==null)
        {
            throw new NullPointerException();
        }
        this.categories.add(c);
    }
    //
    
    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    
}
