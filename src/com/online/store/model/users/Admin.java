package model.users;

public class Admin extends User {

    // تنها instance از Admin
    private static Admin instance;

    // constructor خصوصی → جلوگیری از ساختن مستقیم
    private Admin(String username, String email, String phoneNumber, String password) {
        super(username, email, phoneNumber, password);
    }

    // متد Singleton برای گرفتن instance
    public static Admin getInstance(String username, String email, String phoneNumber, String password) {
        if (instance == null) {
            instance = new Admin(username, email, phoneNumber, password);
        }
        return instance;
    }
}