package top.q0o0p.wow_four;

import android.text.Editable;

public class Data {
    private String Phone;
    private String Name;


    public Data(Editable Phone, Editable Name) {}


    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Data( String name,String phone) {
        Phone = phone;
        Name = name;
    }
}
