package framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadDataFromFile {
//    public void readDataFromProperties() {
//        Properties prop = new Properties();
//        List<String> keys = new ArrayList<>();
//        try (FileInputStream input = new FileInputStream("src/test/resources/categories.properties")) {
//            prop.load(input);
//            Enumeration<?> enumeration = prop.propertyNames();
//            while (enumeration.hasMoreElements()) {
//                keys.add(enumeration.nextElement().toString());
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        } catch (IOException e) {
//            System.out.println("Error reading file.");
//        }
//        System.out.println(keys);
//    }
public static void main(String[] args) {
    Properties prop = new Properties();
    List<String> keys = new ArrayList<>();
    try (FileInputStream input = new FileInputStream("src/test/resources/categories.properties")) {
        prop.load(input);
        Enumeration<?> enumeration = prop.propertyNames();
        while (enumeration.hasMoreElements()) {
            keys.add(enumeration.nextElement().toString());
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
    } catch (IOException e) {
        System.out.println("Error reading file.");
    }
    System.out.println(keys);
}

}
