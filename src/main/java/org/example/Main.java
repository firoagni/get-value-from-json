package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // parsing file "test1.json"
        Object obj = new JSONParser().parse(new FileReader("src/main/resources/test3.json"));
        String key = "x/y/z/a";

        System.out.println("object:" + obj.toString());
        System.out.println("key   :" + key);

        if( key.charAt(0) == '/' || key.charAt(key.length() - 1) == '/' ){
            System.out.println("Invalid key. Key cannot start or end with '/'");
            System.exit(-1);
        }

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        getValue(jo,key);

        //printJsonObject(jo);
    }

    public static void getValue(JSONObject jsonObj, String key) {

        int indexOfDelimeter = key.indexOf("/");

        if(indexOfDelimeter == -1) {            // this means the key is currently holding a single element
                                                // either the user has passed a single element as key
                                                // or
                                                // the code has traversed to the last element of the key
                                                // whatever be the case, fact is this is the last element, therefore print its value and exit

            //check what this element's value is in the JSON object
            Object value = jsonObj.get(key);

            if(value==null){ //this means the user provided key chain do not exist in the JSON object
                System.err.println("ERROR: The provided key is not present in the JSON object");
                System.exit(-1);
            }
            else {
                System.out.println("DEBUG: " + key + "-->" + value);
                System.out.println("Value:: " + value);
            }

            return; //job's done. Exit
        }

        //If the key is still holding more than one element, then get the leftmost one
        String leftmostElementinKey = key.substring(0,indexOfDelimeter);
        //check what this element's value is in the JSON object
        Object value = jsonObj.get(leftmostElementinKey);

        if(value==null){ //this means the user provided key chain do not exist in the JSON object
            System.err.println("ERROR: The provided key is not present in the JSON object");
            System.exit(-1);
        }
        System.out.println("DEBUG: " + leftmostElementinKey + "-->" + value);

        if(value instanceof JSONObject){ //the value itself is a nested object
            getValue((JSONObject)value, key.substring(key.indexOf("/")+1));
        }
        else {
            //even after the completion of JSON iteration, we observe that the more that one element
            // is present, then that means the user provided key do not exist in the JSON object
            if(key.contains("/")){
                System.err.println("ERROR: The provided key is not present in the JSON object");
                System.exit(-1);
            }

            System.out.println("Value:: " + value);
        }
    }
}


