package com.acme.a3csci3130;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the Business class
 * @author dahnbalan
 */
public class BusinessUnitTest {

    private static Business business;
    @Before
    public void setup() {
        business = new Business("LG0nQ9fmpqmCqIFN8Sh", "Westonian", "Fisher", "139 Lancaster Ave", "AB", "902410382");
    }

    @Test
    public void createNewBusiness() {
        assertEquals(business.uid, "LG0nQ9fmpqmCqIFN8Sh");
        assertEquals(business.name, "Westonian");
        assertEquals(business.primaryBusiness, "Fisher");
        assertEquals(business.address, "139 Lancaster Ave");
        assertEquals(business.province, "AB");
        assertEquals(business.number, "902410382");
    }

    @Test
    public void mapBusiness() {
        HashMap<String, Object> result = new HashMap();
        result.put("uid", business.uid);
        result.put("name", business.name);
        result.put("primaryBusiness", business.primaryBusiness);
        result.put("address", business.address);
        result.put("province", business.province);
        result.put("number", business.number);
        assertEquals(result.size(), business.toMap().size());
        assertEquals(result.get("uid"), business.toMap().get("uid"));
        assertEquals(result.get("name"), business.toMap().get("name"));
        assertEquals(result.get("primaryBusiness"), business.toMap().get("primaryBusiness"));
        assertEquals(result.get("address"), business.toMap().get("address"));
        assertEquals(result.get("province"), business.toMap().get("province"));
        assertEquals(result.get("number"), business.toMap().get("number"));
    }
}