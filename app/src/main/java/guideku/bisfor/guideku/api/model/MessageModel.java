package guideku.bisfor.guideku.api.model;

import java.util.Date;

public class MessageModel {
    private String by;
    private Date date;
    private String message;
    private String state;

    public String getBy() {
        return by;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getState() {
        return state;
    }

    public MessageModel(String by, Date date, String message, String state) {

        this.by = by;
        this.date = date;
        this.message = message;
        this.state = state;
    }

    public MessageModel() {

    }
}
