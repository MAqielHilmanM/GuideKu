package guideku.bisfor.guideku.screen.favorites.guide;

public class FavoritesGuideDao {
    String id;
    String name;
    String location;
    String urlImage;

    public FavoritesGuideDao(String id, String name, String location, String urlImage) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.urlImage = urlImage;
    }
}
