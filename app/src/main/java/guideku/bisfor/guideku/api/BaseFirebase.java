package guideku.bisfor.guideku.api;

public class BaseFirebase {
//    TODO: 8/10/2018 ALWAYS UPDATE THIS TABLE IF UPDATE FIREBASE COLLECTION / STRUCTURE

//    COLLECTION USER
    public static String KEY_USER               = "User";
    public static String KEY_USER_BIRTHDATE     = "birthDate";
    public static String KEY_USER_EMAIL         = "email";
    public static String KEY_USER_GENDER        = "gender";
    public static String KEY_USER_LEVEL         = "level";
    public static String KEY_USER_LOCATION      = "location";
    public static String KEY_USER_LOVE          = "love";
    public static String KEY_USER_NAME          = "name";
    public static String KEY_USER_PHONENUMBER   = "phoneNumber";
    public static String KEY_USER_RATING        = "rating";
    public static String KEY_USER_SERVICE       = "service";
    public static String KEY_USER_URLIMAGE      = "urlImage";
    public static String KEY_USER_USERNAME      = "username";

//    COLLECTION TRANSACTION
    public static String KEY_TRANSACTION                    = "Transaction";
    public static String KEY_TRANSACTION_BY                 = "by";
    public static String KEY_TRANSACTION_DATE               = "date";
    public static String KEY_TRANSACTION_DATE_CREATED       = "created";
    public static String KEY_TRANSACTION_DATE_FROM          = "from";
    public static String KEY_TRANSACTION_DATE_MODIFIED      = "modified";
    public static String KEY_TRANSACTION_DATE_TO            = "to";
    public static String KEY_TRANSACTION_DATE_DEADLINE      = "deadline";
    public static String KEY_TRANSACTION_GUIDE              = "guide";
    public static String KEY_TRANSACTION_PLACE              = "place";
    public static String KEY_TRANSACTION_POINTS             = "points";
    public static String KEY_TRANSACTION_PRICE              = "price";
    public static String KEY_TRANSACTION_PRICE_DISCOUNT     = "discount";
    public static String KEY_TRANSACTION_PRICE_SERVICE      = "service";
    public static String KEY_TRANSACTION_PRICE_TICKET       = "ticket";
    public static String KEY_TRANSACTION_PRICE_TICKETFEE    = "ticketFee";
    public static String KEY_TRANSACTION_PRICE_TOTAL        = "total";
    public static String KEY_TRANSACTION_SERVICE            = "services";
    public static String KEY_TRANSACTION_STATUS             = "status";
    public static String KEY_TRANSACTION_STATUS_ISDONE      = "isDone";
    public static String KEY_TRANSACTION_STATUS_ISPAYED     = "isPayed";

//    COLLECTION SERVICE
    public static String KEY_SERVICE            = "Service";
    public static String KEY_SERVICE_CATEGORY   = "category";
    public static String KEY_SERVICE_ICON       = "icon";
    public static String KEY_SERVICE_NAME       = "name";
    public static String KEY_SERVICE_PRICE      = "price";

//    COLLECTION REVIEW
    public static String KEY_REVIEW             = "Review";
    public static String KEY_REVIEW_BY          = "by";
    public static String KEY_REVIEW_DATE        = "date";
    public static String KEY_REVIEW_RATING      = "rating";
    public static String KEY_REVIEW_REVIEW      = "review";
    public static String KEY_REVIEW_TO          = "to";

//    COLLECTION PLACE
    public static String KEY_PLACE              = "Place";
    public static String KEY_PLACE_CLOSETIME    = "closeTime";
    public static String KEY_PLACE_DESCRIPTION  = "description";
    public static String KEY_PLACE_FUNFACT      = "funFact";
    public static String KEY_PLACE_LOCATION     = "location";
    public static String KEY_PLACE_LOCATIONNAME = "locationName";
    public static String KEY_PLACE_MOREIMAGES   = "moreImages";
    public static String KEY_PLACE_NAME         = "name";
    public static String KEY_PLACE_OPENTIME     = "openTime";
    public static String KEY_PLACE_PRICE        = "price";
    public static String KEY_PLACE_STATUS       = "status";
    public static String KEY_PLACE_URLIMAGE     = "urlImage";
    public static String KEY_PLACE_URLVIDEO     = "urlVideo";

//    COLLECTION FAVORITE
    public static String KEY_FAVORITE       = "Favorite";
    public static String KEY_FAVORITE_GUIDE = "guide";
    public static String KEY_FAVORITE_PLACE = "place";

//    COLLECTION CHAT
    public static String KEY_CHAT               = "Chat";
    public static String KEY_CHAT_GUIDE         = "guide";
    public static String KEY_CHAT_GUIDEUNREAD   = "guideUnread";
    public static String KEY_CHAT_LASTMESSAGE   = "lastMessage";
    public static String KEY_CHAT_LASTMODIFIED  = "lastModified";
    public static String KEY_CHAT_USER          = "user";
    public static String KEY_CHAT_USERUNREAD    = "userUnread";

//    COLLECTION CHAT_MESSAGE
    public static String KEY_CHAT_MESSAGE           = "Message";
    public static String KEY_CHAT_MESSAGE_BY        = "by";
    public static String KEY_CHAT_MESSAGE_DATE      = "date";
    public static String KEY_CHAT_MESSAGE_MESSAGE   = "message";
    public static String KEY_CHAT_MESSAGE_STATE     = "state";

}
