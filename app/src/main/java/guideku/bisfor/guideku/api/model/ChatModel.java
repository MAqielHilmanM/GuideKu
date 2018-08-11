package guideku.bisfor.guideku.api.model;

import java.util.Date;

public class ChatModel {
    private String guide;
    private long guideUnread;
    private String lastMessage;
    private Date lastModified;
    private String user;
    private long userUnread;

    public String getGuide() {
        return guide;
    }

    public long getGuideUnread() {
        return guideUnread;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getUser() {
        return user;
    }

    public long getUserUnread() {
        return userUnread;
    }

    public ChatModel(String guide, long guideUnread, String lastMessage, Date lastModified, String user, long userUnread) {

        this.guide = guide;
        this.guideUnread = guideUnread;
        this.lastMessage = lastMessage;
        this.lastModified = lastModified;
        this.user = user;
        this.userUnread = userUnread;
    }

    public ChatModel() {

    }
}
