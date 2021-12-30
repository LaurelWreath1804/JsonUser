package com.example.jsonuser;

public class ItemModel {
    private String username;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String company;
    private String avatar;
    private String photo;

    public ItemModel(String username, String name, String email, String avatar, String address,
                     String company, String phone, String photo)
    {
        this.username = username;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.company = company;
        this.phone = phone;
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; };

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
