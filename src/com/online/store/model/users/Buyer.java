package model.users;

public class Buyer extends User {

    private double walletBalance;

    public Buyer(String username, String email, String phoneNumber, String password, double walletBalance) {
        super(username, email, phoneNumber, password);
        this.walletBalance = walletBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}