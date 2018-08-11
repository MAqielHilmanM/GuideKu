package guideku.bisfor.guideku.api.model;

public class ServiceModel {
    private String category;
    private String icon;
    private String name;
    private long price;

    public ServiceModel() {
    }

    public String getCategory() {
        return category;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public ServiceModel(String category, String icon, String name, long price) {

        this.category = category;
        this.icon = icon;
        this.name = name;
        this.price = price;
    }
}
