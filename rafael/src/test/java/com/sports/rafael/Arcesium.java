package com.sports.rafael;

import com.google.gson.Gson;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Arcesium {


    private String getApiResponse() {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                sb.append(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    private String getField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
       // Map<Class, Object> map = new HashMap<>();
        String result = null;
        if(fieldName.contains(".")) {
            int location = fieldName.indexOf('.');
            String childFieldName = fieldName.substring(0, location);
            Field field = object.getClass().getDeclaredField(childFieldName);
            field.setAccessible(true);
            Object childFieldInstance = field.get(object);
            //in my case below check is not necessary
            if (childFieldInstance == null) {
                Class<?> type = field.getType();
                //invoking no argument constructor
                childFieldInstance = type.getConstructor().newInstance();
                field.set(object, childFieldInstance);
            }
            field.setAccessible(false);
            //call again to get property of childField
            result = getField(childFieldInstance, fieldName.substring(location + 1));

        }else {
            Field field = object.getClass().getDeclaredField(fieldName);
            Class clazz = field.getClass();
            field.setAccessible(true);
            Object value = field.get(object);
            //clazz.cast(value);
            field.setAccessible(false);
            System.out.println(value);
            return (String) value;
        }
        return result;
    }

    @Test
    public void testAPIResponse() {

        String jsonString = getApiResponse();

        //proces it
        Gson gson = new Gson();
        Contact[] contacts = gson.fromJson(jsonString, Contact[].class);
        List<Contact> list = Arrays.stream(contacts).collect(Collectors.toList());
        System.out.println(list);
        String fieldName = "username";
        String operation = "EQUALS";
        String filter = "vinayk";

        String fieldName1 = "address.city";
        String operation1 = "IN";
        String filter1 = "Kolkata";

        List<Contact> filtered = list.stream().filter(contact -> {
            try {
                String value = getField(contact, fieldName1);
                if(filter1.equals(value))
                    return true;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());

        System.out.println(filtered);
    }

    @ToString
    class Contact {
        int id;
        String name;
        public String username;
        String email;
        public Address address;
        String website;
        Company company;

    }
    @ToString
    private class Address {
        String stree;
        String suite;
        public String city;
        String zipcode;
        Geo geolocation;
    }
    @ToString
    private class Company {

    }
    @ToString
    private class Geo {
        String lat;
        String lng;
    }


    /**
     *   String value = getField(contact, fieldName);
     *
     *                 //Class clazz = contact.getClass();
     *                 //System.out.println(clazz.getSimpleName());
     *                 if(fieldName.contains(".")) {
     *                     String[] nested = fieldName.split("\\.");
     *                     String upper = nested[0];
     *                     String lower = nested[1];
     *                     Field field = contact.getClass().getField(upper);
     *                     Class<?> type = field.getType();
     *                     System.out.println("Type: "+type);
     *
     *                     //Field actualField = field.getClass().getField(lower);
     *                     //field = contact.getClass().getField(nested[0]).getClass().getField(nested[1]);
     *                     //Object obj = actualField.get(contact).getClass().cast(actualField);
     *                    // System.out.println(obj);
     *
     *
     *
     *                 }else {
     *                     Field field = contact.getClass().getField(fieldName);
     *                     Class<?> type = field.getType();
     *                     System.out.println("Type: "+type);
     *                     Object value = field.get(contact);
     *                     String val = (String)value;
     *                     System.out.println("Value: "+value);
     *                     if(val.equals(filter)) {
     *                         return true;
     *                     }
     *                 }
     */

}
