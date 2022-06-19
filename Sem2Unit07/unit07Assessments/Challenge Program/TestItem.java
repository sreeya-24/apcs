
/**
 * This program displays the concept of insertion sort, selection sort, and merge sort.
 *
 * @author Sreeya Gambhirrao
 * @version 04/30/2022
 */
public class TestItem
{
   public static Item[] hardware = new Item[6];
   
   public static Item[] sortID(Item[] source, int order)
   {
       Item[] dest = new Item[source.length];
       if(order == 1)
       {
           for(int i = 0; i < source.length; i++)
           {
               Item next = source[i];
               int insertindex = 0;
               int k = i;
               
               while((k > 0) && (insertindex == 0))
               {
                   if(next.getItemID().compareTo(dest[k - 1].getItemID()) > 0)
                   {
                       insertindex = k;
                   } else
                   {
                       dest[k] = dest[k - 1];
                   }
                   k--;
               }
               dest[insertindex] = next;
           }
           return dest;
       } else if(order == 2)
       {
           for(int i = 0; i < source.length; i++)
           {
               Item next = source[i];
               int insertindex = 0;
               int k = i;
               
               while((k > 0) && (insertindex == 0))
               {
                   if(next.getItemID().compareTo(dest[k-1].getItemID()) < 0)
                   {
                       insertindex = k;
                   } else
                   {
                       dest[k] = dest[k - 1];
                   }
                   k--;
               }
               dest[insertindex] = next;
           }
           return dest;
       } else
       {
           System.out.println("Please enter a valid order number!");
       }
       return dest;
   }
   
   public static Item[] sortName(Item[] source, int order)
   {
       Item[] dest = new Item[source.length];
       
       if(order == 1)
       {
           for(int i = 0; i < source.length;i++)
           {
               Item next = source[i];
               int insertindex = 0;
               int k = i;
               
               while((k > 0) && (insertindex == 0))
               {
                   if(next.getItemID().compareTo(dest[k - 1].getItemID()) > 0)
                   {
                       insertindex = k;
                   } else
                   {
                       dest[k] = dest[k - 1];
                   }
                   k--;
               }
               dest[insertindex] = next;
           }
           return dest;
       } else if(order == 2)
       {
           for(int i = 0; i < source.length; i++)
           {
               Item next = source[i];
               int insertindex = 0;
               int k = i;
               
               while((k > 0) && (insertindex == 0))
               {
                   if(next.getItemID().compareTo(dest[k-1].getItemID()) < 0)
                   {
                       insertindex = k;
                   } else
                   {
                       dest[k] = dest[k - 1];
                   }
                   k--;
               }
               dest[insertindex] = next;
           }
           return dest;
       } else
       {
           System.out.println("Please enter a valid order number!");
       }
       return dest;
   }
   
   public static void sortInStore(Item[] source, int order)
   {
       if(order == 1)
       {
           int posmax;
           Item temp;
           
           for(int i = source.length - 1; i > 0; i--)
           {
               posmax = 0;
               
               for(int k = 1; k <= i; k++)
               {
                   if(source[k].getInStore() > source[posmax].getInStore())
                   {
                       posmax = k;
                   }
                   temp = source[i];
                   source[i] = source[posmax];
                   source[posmax] = temp;
               }
           }
       } else if(order == 2)
       {
           int posmax;
           Item temp;
           
           for(int i = source.length - 1; i > 0; i--)
           {
               posmax = 0;
               for(int k = 1; k <= i; k++)
               {
                   if(source[k].getInStore() < source[posmax].getInStore())
                   {
                       posmax = k;
                   }
                   temp = source[i];
                   source[i] = source[posmax];
                   source[posmax] = temp;
               }
           }
       } else 
       {
           System.out.println("Please enter a valid order number!");
       }
   } 
   
   public static void sortPrice(Item[] source, int low, int high)
   {
       if(low == high)
       {
           return;
       }
       
       int mid = (low + high)/2;
       sortPrice(source,low,mid);
       sortPrice(source,mid + 1, high);
       
       mergePrice(source,low,mid,high);
   }
   
   public static void mergePrice(Item[] source, int low, int mid, int high)
   {
       Item[] temp = new Item[high - low + 1];
       
       int i = low;
       int j = mid + 1;
       int n = 0;
       
       while((i <= mid) || (j <= high))
       {
           if(i > mid)
           {
               temp[n] = source[j];
               j++;
           } else if(j > high)
           {
               temp[n] = source[i];
               i++;
           } else if(source[i].getPrice() < source[j].getPrice())
           {
               temp[n] = source[i];
               i++;
           } else
           {
               temp[n] = source[j];
               j++;
           }
           n++;
       }
       
       for(int k = low; k <= high; k++)
       {
           source[k] = temp[k - low];
       }
   }
   
   public static void printInventory(Item[] inventory)
   {
       System.out.printf("%s%11s%14s%9s%\n", "itemID", "itemName", "inStore", "price");
       System.out.println("--------------------------------------------");

       for (Item item : inventory) 
       {
            System.out.println(item);
       }
   }
   
   public static void main(String[] args)
   {
        Item i1 = new Item("1011","Air Filter",200,10.5);  
        Item i2 = new Item("1034","Door Knobs",60,21.5);  
        Item i3 = new Item("1101","Hammers",90,9.99);  
        Item i4 = new Item("1600","Levels",80,19.99);  
        Item i5 = new Item("1500","Ceiling Fans",100,59);  
        Item i6 = new Item("1201","Wrench Sets",55,80);
          
        hardware[0] = i1;
        hardware[1] = i2;
        hardware[2] = i3;
        hardware[3] = i4;
        hardware[4] = i5;
        hardware[5] = i6;
          
        Item[] dest = new Item[hardware.length];
          
        System.out.println("Original Array:");
        System.out.println();
        printInventory(hardware);
        System.out.println();
        
        System.out.println("Sorted by ID:");
        dest = sortID(hardware, 1);
        System.out.println();
        printInventory(dest);
        System.out.println();
        
        System.out.println("Sorted by Name:");
        dest = sortName(hardware, 1);
        System.out.println();
        printInventory(dest);
        System.out.println();
        
        System.out.println("Sorted by inStore");
        sortInStore(hardware, 1);
        System.out.println();
        printInventory(hardware);
        System.out.println();
        
        System.out.println("Sorted by Price");
        sortPrice(hardware, 0, hardware.length - 1);
        System.out.println();
        printInventory(hardware);
   }
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
