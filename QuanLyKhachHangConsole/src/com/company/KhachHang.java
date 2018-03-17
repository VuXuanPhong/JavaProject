package com.company;

import java.io.Serializable;

/**
 * Created by Vu Xuan Phong on 07/05/2017.
 */
public class KhachHang implements Serializable, Comparable<KhachHang> {
    private int id;
    private String name;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public KhachHang() {

    }

    public KhachHang(int id, String name, String phone) {

        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public int compareTo(KhachHang o) {
        return this.phone.compareToIgnoreCase(o.phone);
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.name + "\t" + this.phone;
    }
}
