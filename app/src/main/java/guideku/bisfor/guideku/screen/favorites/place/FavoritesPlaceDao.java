package guideku.bisfor.guideku.screen.favorites.place;

public class FavoritesPlaceDao {
    String id;
    String urlImage;
    public String title;
    public String location;

    public FavoritesPlaceDao(String id, String urlImage, String title, String location) {
        this.id = id;
        this.urlImage = urlImage;
        this.title = title;
        this.location = location;
    }
}
