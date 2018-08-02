package guideku.bisfor.guideku.screen.edutour.list;

public class EdutourListDao {
    String id;
    String urlImage;
    Category category;
    String description;
    String location;
    boolean isFavorite;

    public EdutourListDao(String id, String urlImage, Category category, String description, String location, boolean isFavorite) {
        this.id = id;
        this.urlImage = urlImage;
        this.category = category;
        this.description = description;
        this.location = location;
        this.isFavorite = isFavorite;
    }

    enum Category{
        FriendlyTrips,
        SweetTrips
    }

    public String getCategory(){
        switch (category){
            case SweetTrips: return "SweetTrips";
            case FriendlyTrips: return "FriendlyTrips";
            default: return "";
        }
    }
}
