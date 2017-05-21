package com.example.ebonycalloway.klosetkaper.POJO;

import java.util.LinkedHashMap;

/**
 * Created by ebonycalloway on 4/28/17.
 */

public interface ClothingManager {
    LinkedHashMap<String, Clothing> clothingLibrary = new LinkedHashMap<>();//clothing name,clothing

    void createClothing(Clothing clothing, String name);
    void editUser(String name, UserInfo user);
    Clothing getClothing(String name);
    void setClothing(String name, Clothing clothing);
    void findClothing(String name, Clothing clothing);
    void updateClothing(String clothingName, Clothing clothing);
}
