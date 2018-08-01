package guideku.bisfor.guideku.screen.chat.detail;

public class ChatDetailDao {
    String id;
    boolean isOther;
    String text;
    String time;
    String urlPic;

    public ChatDetailDao() {
    }

    public ChatDetailDao(String id, boolean isOther, String text, String time, String urlPic) {
        this.id = id;
        this.isOther = isOther;
        this.text = text;
        this.time = time;
        this.urlPic = urlPic;
    }
}
