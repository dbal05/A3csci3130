package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase database. This is converted to a JSON format
 * @author dahnbalan
 */
public class Business implements Serializable {

    public  String uid;
    public  String name;
    public  String primaryBusiness;
    public  String address;
    public  String province;
    public  String number;

    /**
     * Default Constructor
     */
    public Business() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * Custom Constructor that takes in Business data as params.
     * @param uid
     * @param name
     * @param primaryBusiness
     * @param address
     * @param province
     * @param number
     */
    public Business(String uid, String name, String primaryBusiness, String address, String province, String number){
        this.uid = uid;
        this.name = name;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.province = province;
        this.number = number;
    }

    /**
     * A function that can be used later on for mapping data
     * @return A Hashmap of Business data
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("primaryBusiness", primaryBusiness);
        result.put("address", address);
        result.put("province", province);
        result.put("number", number);

        return result;
    }
}
