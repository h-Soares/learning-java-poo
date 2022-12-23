package entities;

public class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName() + " $ " + totalPrice());
        sb.append(" (Customs fee: $ " + customsFee + ")");
        return sb.toString();
    }

    public double totalPrice() {
        return getPrice() + customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }
}