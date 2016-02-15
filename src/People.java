import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by DrScott on 10/19/15.
 */
public class People {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Person>> map = new HashMap();
        String fileContent = readFile("people.csv");
        String[] lines = fileContent.split("\n"); //
        String printStr = "";
        int x = 0;
        ArrayList<Person> allPeople = new ArrayList<>();

        for (String line : lines) {

            if (x != 0){
            String[] columns = line.split(",");
            String id = columns[0];
            String firstName = columns[1];
            String lastName = columns[2];
            String email = columns[3];
            String country = columns[4];
            String ipAddress = columns[5];

              Person p = new Person(firstName, lastName, country); //new country object is created with the abbreviation and name
              allPeople.add(p);
                String name = String.valueOf(lastName);
              ArrayList<Person> list = map.get(country);

              if (list == null) {
                  list = new ArrayList();
                  list.add(p);
                  map.put(p.country, list);
              } else {
                  list.add(p);
              }
              x++;
              Collections.sort(list);
          }
            x++;

        }//for

        for (String countryName : map.keySet()){
            for (Person p : map.get(countryName)){
                printStr += String.format("%s %s from %s\n", p.firstName, p.lastName, p.country);
            }
        }

        System.out.println(printStr);

    }//end main


    static String readFile(String fileName) {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }

    static void writeFile(String fileName, String fileContent){
        File f = new File(fileName);
        try{
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        } catch (Exception e){

        }
    }
}//end class
