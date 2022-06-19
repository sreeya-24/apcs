
/**
 * This is the contact class.
 *
 * @author Sreeya Gambhirrao
 * @version 05/02/2022
 */
public class Contact
{
    // instance variables - replace the example below with your own
    private String contactName;
    private String contactRelation;
    private String contactBday;
    private String contactPhone;
    private String contactEmail;

    /**
     * Constructor for objects of class Contact
     */
    public Contact(String name, String relation, String bday, String phone, String email)
    {
        // initialise instance variables
        contactName = name;
        contactRelation = relation;
        contactBday = bday;
        contactPhone = phone;
        contactEmail = email;
    }

    public String getName()
    {
        return contactName;
    }
    public String getRelation()
    {
        return contactRelation;
    }
    public String getBDay()
    {
        return contactBday;
    }
    public String getBMonth()
    {
        String b = contactBday.substring(0,3);
        return b;
    }
    public String getPhone()
    {
        return contactPhone;
    }
    public String getEmail()
    {
        return contactEmail;
    }
    public String toString()
    {
        String a = getName() + "  " + getRelation() + "     " + getBDay() + "       " + getPhone() + " " + getEmail();
        return a;
    }
}
