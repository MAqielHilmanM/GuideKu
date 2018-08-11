package guideku.bisfor.guideku.api.model;

import android.location.Location;

import java.util.List;

public class PlaceModel {
    private String closeTime;
    private String description;
    private String funFact;
    private Location location;
    private String locationName;
    private List<String> moreImages;
    private String name;
    private String openTime;
    private String price;
    private String status;
    private String urlImage;
    private String urlVideo;

    public PlaceModel() {
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getDescription() {
        return description;
    }

    public String getFunFact() {
        return funFact;
    }

    public Location getLocation() {
        return location;
    }

    public String getLocationName() {
        return locationName;
    }

    public List<String> getMoreImages() {
        return moreImages;
    }

    public String getName() {
        return name;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public PlaceModel(String closeTime, String description, String funFact, Location location, String locationName, List<String> moreImages, String name, String openTime, String price, String status, String urlImage, String urlVideo) {

        this.closeTime = closeTime;
        this.description = description;
        this.funFact = funFact;
        this.location = location;
        this.locationName = locationName;
        this.moreImages = moreImages;
        this.name = name;
        this.openTime = openTime;
        this.price = price;
        this.status = status;
        this.urlImage = urlImage;
        this.urlVideo = urlVideo;
    }
}
