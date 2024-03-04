/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author dell
 */
public class Receipt {
    private ArrayList<Order> orders = new ArrayList<Order>();
    private LocalDate currentDate ;
    private static int count = 0;
    private String id = "#R";
    private BigDecimal sumTotal;
    private double deliverytax = 1.0;
    private BigDecimal total;
    
    public Receipt() 
    {
        count++;
        this.id = "#R: "+count;
        this.currentDate = LocalDate.now();
    }
    
    public String printReceipt()
    {
        String orderstr = printOrders(this.orders);
        this.sumTotal = this.sumOrdersPrice(this.orders);
        this.total = calculateTotal(this.sumTotal,this.deliverytax);
        String str = "\t// Receipt //\t"+this.currentDate+"\nOrder Name :\tQuantity :\tPrice\n" + orderstr+"---------------\nSumPrices : "+this.sumTotal+"\n+Delivery Tax : "+this.deliverytax+"\n---------------\nTotal : "+this.total+"$\n";
        return str;
    }
    
    public BigDecimal calculateTotal(BigDecimal sumtotal, double deliverytax)
    {
        try
        {
            BigDecimal deliverytaxbigdecimal = BigDecimal.valueOf(deliverytax);
            return sumtotal.add(deliverytaxbigdecimal);
        }
        catch(NullPointerException e)
        {
            return BigDecimal.ZERO;
        }
    }
    
    public BigDecimal sumOrdersPrice(ArrayList<Order> orders)
    {
        BigDecimal sumtotal = BigDecimal.ZERO;
        try
        {
            for(Order order : orders)
            {
                sumtotal = sumtotal.add(order.getTotalprice());
            }
            return sumtotal;
        }
        catch(NullPointerException e)
        {
            return BigDecimal.ZERO;
        }
    }
    
    public String printOrders(ArrayList<Order> orders)
    {
        String str="";
        for(Order order : orders)
        {
            str+= order.getOrderDescription();
        }
        return str;
    }
    //
    
    //
    public void addOrders(Order order)
    {
        if(order==null)
        {
            throw new IllegalArgumentException("Order Operation Failed\n");
        }
        this.orders.add(order);
    }
    //

    @Override
    public String toString() {
        return "Receipt{" + "orders=" + orders + ", currentDate=" + currentDate + ", id=" + id + '}';
    }
   
    //
    public Order getItem(String id) {       
        for(Order item : this.orders)
        {
            if(item.getId().equalsIgnoreCase(id))
            {
                return item;
            }
        }
        return null;
    }
    //
    
    //Setter and Getters
    public ArrayList<Order> getItems() {
        return orders;
    }

    public void setItems(ArrayList<Order> items) {
        this.orders = items;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Receipt.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(BigDecimal SumTotal) {
        this.sumTotal = SumTotal;
    }

    public double getDeliveryTax() {
        return deliverytax;
    }

    public void setDeliveryTax(double DeliveryTax) {
        this.deliverytax = DeliveryTax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal Total) {
        this.total = Total;
    }
    
}
