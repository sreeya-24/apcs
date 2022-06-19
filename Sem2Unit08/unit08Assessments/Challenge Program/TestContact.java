
/**
 * This program demonstrates the concept of sorting and searching used in one place.
 *
 * @author Sreeya Gambhirrao
 * @version 05/02/2022
 */
public class TestContact
{
    // instance variables - replace the example below with your own
    private static Contact[] myContacts = new Contact[6];

    public static Contact[] sortNames(Contact[] contact)
    {
        Contact[] newlist = new Contact[contact.length];
        for(int i=0;i<contact.length;i++)
        {
            String next = contact[i].getName();
            int insert = 0;
            int k =i;
            while(k>0 && insert == 0)
            {
                if(next.compareTo( newlist[k-1].getName() ) > 0)
                {
                    insert = k;
                }
                else
                {
                    newlist[k] = newlist[k-1];
                }
                k--;
            }
            newlist[insert]=contact[i];
        }
        return newlist;
    }
    
    public static int findByName(Contact[] contact, String toFind )
    {
        int high = contact.length;
        int low = -1;
        int probe;
        while ( high - low > 1 )
        {
            probe = ( high + low ) / 2;
            if ( contact[probe].getName().compareTo(toFind) > 0)
            {    
                high = probe;
            }
            else
            {
                low = probe;
            }
        }
        if ( (low >= 0) && (contact[low].getName().compareTo(toFind) == 0 ))
        {
            return low;
        }
        else
        {
            return -1;
        }
    }
    
     public static void findByRelation(Contact[] contact, String toFind)
    {
        int found = 0;
        System.out.println("Find Relation - " + toFind);
        System.out.println("Find Results:");
        for(int i = 0; i < contact.length; i++)
        {
            if (contact[i].getRelation().compareTo(toFind) == 0)
            {
                System.out.println("Found: " + contact[i].toString());
                found++;
            }
        }
        if (found == 0)
        {
            System.out.println("There are no listings for " + toFind);
        }
        else
        {
            System.out.println("There were " + found + " listings for " + toFind);
        }
        System.out.println();
    }
    
    public static void findByBMonth(Contact[] contact, String toFind)
    {
        int found = 0;
        System.out.println("Find Bday - " + toFind);
        System.out.println("Find Results:");
        for(int i = 0; i < contact.length; i++)
        {
            if (contact[i].getBMonth().compareTo(toFind) == 0)
            {
                System.out.println("Found: " + contact[i].toString());
                found++;
            }
        }
        if (found == 0)
        {
            System.out.println("There are no listings for " + toFind);
        }
        else
        {
            System.out.println("There were " + found + " listings for " + toFind);
        }
        System.out.println();
    }
    
    public static void findByPhone(Contact[] contact, String toFind)
    {
        int found = 0;
        System.out.println("Find Phone - " + toFind);
        System.out.println("Find Results:");
        for(int i = 0; i < contact.length; i++)
        {
            if (contact[i].getPhone().compareTo(toFind) == 0)
            {
                System.out.println("Found: " + contact[i].toString());
                found++;
            }
        }
        if (found == 0)
        {
            System.out.println("There are no listings for " + toFind);
        }
        else
        {
            System.out.println("There were " + found + " listings for " + toFind);
        }
        System.out.println();
    }
    
    public static Contact[] sortEmail(Contact[] contact)
    {
        Contact[] newlist = new Contact[contact.length];
        for(int i=0;i<contact.length;i++)
        {
            String next = contact[i].getEmail();
            int insert = 0;
            int k =i;
            while(k>0 && insert == 0)
            {
                if(next.compareTo( newlist[k-1].getEmail() ) > 0)
                {
                    insert = k;
                }
                else
                {
                    newlist[k] = newlist[k-1];
                }
                k--;
            }
            newlist[insert]=contact[i];
        }
        return newlist;
    }
    
    public static int findByEmail(Contact[] contact, String toFind )
    {
        int high = contact.length;
        int low = -1;
        int probe;
        while ( high - low > 1 )
        {
            probe = ( high + low ) / 2;
            if ( contact[probe].getEmail().compareTo(toFind) > 0)
            {    
                high = probe;
            }
            else
            {
                low = probe;
            }
        }
        if ( (low >= 0) && (contact[low].getEmail().compareTo(toFind) == 0 ))
        {
            return low;
        }
        else
        {
            return -1;
        }
    }
    
    public static void printContacts(Contact[] contact)
    {
        System.out.println("Name          Relation    Birthday    Phone         Email");
        System.out.println("---------------------------------------------------------");
        for(int i = 0; i < contact.length; i++)
        {
            System.out.println(contact[i]);
        }
        System.out.println();
    }
    
    
    public static void main(String[] args)
    {
        int test = 0;
        
        myContacts[0] = new Contact("John Carter","brother","Mar 3","(342)555-7069","jcarter@carter.com");
        myContacts[1] = new Contact("Elise Carter","mom","Apr 19","(342)555-7011","carterMom@carter.com");
        myContacts[2] = new Contact("Ellie Carter","me","Jun 10","(342)555-8102","ecarter@carter.com");
        myContacts[3] = new Contact("Sue Ellen","friend","Mar 9","(341)555-9182","susieE@hotmail.com");
        myContacts[4] = new Contact("Frank Carter","dad","Dec 1","(342)555-7011","carterDad@carter.com");
        myContacts[5] = new Contact("Johnnie","friend","Jan 21","(341)555-7789","jDawg5555@yahoo.com");
        System.out.println("                         Contact List");
        System.out.println();
        printContacts(myContacts);
        //search names
        System.out.println("Find Name - Johnnie");
        sortNames(myContacts);
        test = findByName(myContacts, "Johnnie");
        if (test != -1)
        {
            System.out.println("Found:" + myContacts[test].toString());
        }
        else
        {   
            System.out.println("Not found.");
        }
        System.out.println();
        System.out.println("Find Name - Sam Parker");
        sortNames(myContacts);
        test = findByName(myContacts, "Sam Parker");
        if (test != -1)
        {
            System.out.println("Found:" + myContacts[test].toString());
        }
        else
        {   
            System.out.println("Not found.");
        }
        //search relations
        System.out.println();
        findByRelation(myContacts,"friend");
        findByRelation(myContacts,"Aunt");
        //search phones
        findByPhone(myContacts,"(333)555-8989");
        findByPhone(myContacts,"(342)555-7011");
        //search birthdays
        findByBMonth(myContacts,"May");
        findByBMonth(myContacts,"Mar");
        //search emails
        System.out.println("Find Email - rgoodman@hotmail.com");
        myContacts = sortEmail(myContacts);
        test = findByEmail(myContacts, "rgoodman@hotmail.com");
        if (test != -1)
        {
            System.out.println("Found:" + myContacts[test].toString());
        }
        else
        {   
            System.out.println("Not found.");
        }
        System.out.println();System.out.println("Find Email - susieE@hotmail.com");
        myContacts = sortEmail(myContacts);
        test = findByEmail(myContacts, "susieE@hotmail.com");
        if (test != -1)
        {
            System.out.println("Found:" + myContacts[test].toString());
        }
        else
        {   
            System.out.println("Not found.");
        }
    }
}
