package guideku.bisfor.guideku.screen.chat.list;

public class ChatListDao {
    public String id;
    public String name;
    public double count;
    public String lastText;
    public String time;
    public String urlImage;

    public ChatListDao(String id, String name, Double count, String lastText, String time, String urlImage) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.lastText = lastText;
        this.time = time;
        this.urlImage = urlImage;
    }

    public ChatListDao() {
        this.id = "";
        this.name = "";
        this.count = 0;
        this.lastText = "";
        this.time = "00:00";
        this.urlImage = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public String getLastText() {
        return lastText;
    }

    public void setLastText(String lastText) {
        this.lastText = lastText;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
