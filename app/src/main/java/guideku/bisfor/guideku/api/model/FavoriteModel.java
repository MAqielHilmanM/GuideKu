package guideku.bisfor.guideku.api.model;

import java.util.List;

public class FavoriteModel {
    public List<String> guide;
    public List<String> place;

    public List<String> getGuide() {
        return guide;
    }

    public List<String> getPlace() {
        return place;
    }

    public FavoriteModel(List<String> guide, List<String> place) {

        this.guide = guide;
        this.place = place;
    }

    public FavoriteModel() {

    }
}
