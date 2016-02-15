/**
 * Created by DrScott on 10/19/15.
 */
public class Person implements Comparable{
    String id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ipAddress;

    public Person(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.email = address;
        this.country = country;
        //this.ipAddress = ipAddress;
    }
    public String toString(){
        return String.format("%s %s from %s \n", firstName, lastName, country);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return lastName.compareTo(p.lastName);
    }
}


