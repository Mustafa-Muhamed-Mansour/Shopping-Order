package com.shoppingorder.model;

public class OrderModel
{
    String category_image;
    String category_name;
    String category_price;
    String number_quantity;

    public OrderModel()
    {
    }

//    public ConfirmModel(String confirm_user_profile, String confirm_user_name, String confirm_phone_number, String confirm_building_number, String confirm_address, String confirm_total_price)
//    {
//        this.confirm_user_profile = confirm_user_profile;
//        this.confirm_user_name = confirm_user_name;
//        this.confirm_phone_number = confirm_phone_number;
//        this.confirm_building_number = confirm_building_number;
//        this.confirm_address = confirm_address;
//        this.confirm_total_price = confirm_total_price;
//    }


    public String getCategory_image() {
        return category_image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getCategory_price() {
        return category_price;
    }

    public String getNumber_quantity() {
        return number_quantity;
    }
}
