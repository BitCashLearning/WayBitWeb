package us.bitcash.apps.waybitweb.domain;

import us.bitcash.apps.waybitweb.data.WaybitDAO;

import java.util.UUID;

public class Waybitmoji {

    private final WaybitDAO dataServiceObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String uuid;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private double price;

    public Waybitmoji(WaybitDAO dataServiceObject, String name, double price) {
        this.name = name;
        this.price = price;
        this.dataServiceObject = dataServiceObject;
        this.uuid = "item_"+UUID.randomUUID().toString();

    }





}
