package models.entities;

public class Contact {
    private String name;
    private int phone;
    private int identifier;
    
    private static int count = 0;

    public Contact() {
    }

    public Contact(String name, int phone) {
        this.name = name;
        this.phone = phone;
        count++;
        identifier = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: " + name);
        sb.append("  Phone: " + phone);
        sb.append("  Identifier: " + identifier);
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getIdentifier() {
        return identifier;
    }
}