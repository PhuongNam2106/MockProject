package model;

public class Address {
    private int addressId;
    private String city, district, subDistrict;
    private int postalCode;
    private double deliveryFee;

    public Address() {
    }

    public Address(int addressId, String city, String district, String subDistrict, int postalCode, double deliveryFee) {
        this.addressId = addressId;
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
        this.deliveryFee = deliveryFee;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", subDistrict='" + subDistrict + '\'' +
                ", postalCode=" + postalCode +
                ", deliveryFee=" + deliveryFee +
                '}';
    }
}
