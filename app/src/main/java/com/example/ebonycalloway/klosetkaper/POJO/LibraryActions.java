package com.example.ebonycalloway.klosetkaper.POJO;

/**
 * Created by ebonycalloway on 4/28/17.
 */

public class LibraryActions implements ClothingManager {

    @Override
    public void createClothing(Clothing clothing, String name) {
        clothing.setName(name);
        //Get from screen
        clothingLibrary.put(name,clothing);
    }

    @Override
    public void editUser(String name, UserInfo user) {

    }

    @Override
    public Clothing getClothing(String name) {
        return null;
    }

    @Override
    public void setClothing(String name, Clothing clothing) {

    }

    @Override
    public void findClothing(String name, Clothing clothing) {

    }

    @Override
    public void updateClothing(String clothingName, Clothing clothing) {

    }
}
