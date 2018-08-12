package guideku.bisfor.guideku.api.model;

import android.location.Location;

import com.google.firebase.firestore.GeoPoint;

import java.util.Date;
import java.util.List;

public class UserModel {
    private Date birthDate;
    private String email;
    private String gender;
    private long level;
    private GeoPoint location;
    private long love;
    private String name;
    private String phoneNumber;
    private Double rating;
    private List<String> service;
    private String urlImage;
    private String username;

    public UserModel() {
    }

    public UserModel(Date birthDate, String email, String gender, long level, GeoPoint location, long love, String name, String phoneNumber, Double rating, List<String> service, String urlImage,String username) {
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.level = level;
        this.location = location;
        this.love = love;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.service = service;
        this.urlImage = urlImage;
        this.username = username;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public long getLevel() {
        return level;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public long getLove() {
        return love;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Double getRating() {
        return rating;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getService() {
        return service;
    }

    public String getUrlImage() {
        return urlImage;
    }


}
