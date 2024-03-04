/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.math.BigDecimal;

public class Order {
    //
    private static int idcount = 0;
    private String id;
    private String nameofitem;
    private int quantity;
    private double itemprice;
    private BigDecimal totalprice;
    //
    
    static String orderIdFormat = "#o";

    //Constructor
    public Order(String nameofitem,int quantity,double itemprice) 
    {
        idcount++;
        this.id = orderIdFormat+idcount;
        this.nameofitem = nameofitem;
        this.quantity = quantity;
        this.itemprice = itemprice;
        this.totalprice = Calculatetotalprice(this.quantity ,this.itemprice);
    }
    //
    
    //
    public String getOrderDescription()
    {
        try
        {
            return "Order "+this.id+" : \n"+this.nameofitem+" :\t "+this.quantity+" :\t "+this.totalprice+"\n";
        }
        catch(NullPointerException e)
        {
            return "Empty Order";
        }
    }
    //
    
    //
    public BigDecimal Calculatetotalprice(int quantity,double itemprice)
    {
        try
        {
            BigDecimal quantitybigdecimal = BigDecimal.valueOf(quantity);
            BigDecimal itempricebigdecimal = BigDecimal.valueOf(itemprice);
            return quantitybigdecimal.multiply(itempricebigdecimal);
        }
        catch(NullPointerException | NumberFormatException e)
        {
            return BigDecimal.ZERO;
        }
    }
    //
    
    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return nameofitem;
    }

    public void setName(String name) {
        this.nameofitem = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    public String getNameofitem() {
        return nameofitem;
    }

    public void setNameofitem(String nameofitem) {
        this.nameofitem = nameofitem;
    }
    //
    
    //
    public static boolean validOrderId(String Id)
    {
        if(Id==null || Id.length()<3)
        {
            return false;
        }
        String regex = orderIdFormat+ ".*";
        return Id.matches(regex);
    }
}
