package guideku.bisfor.guideku.api.model;

import java.util.Date;

public class ReviewModel {
    private String by;
    private Date date;
    private long rating;
    private String review;
    private String to;

    public ReviewModel() {
    }

    public String getBy() {
        return by;
    }

    public Date getDate() {
        return date;
    }

    public long getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public String getTo() {
        return to;
    }

    public ReviewModel(String by, Date date, long rating, String review, String to) {

        this.by = by;
        this.date = date;
        this.rating = rating;
        this.review = review;
        this.to = to;
    }
}
