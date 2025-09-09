// File: LoyaltyAppMain.java
package jp3;
import java.util.Date;

public class LoyalityAppMain {
    public static void main(String[] args) {
        LoyalityService service = new LoyalityService();

        // Enroll members
        member m1 = new member(1, "Alice", "alice@mail.com");
        member m2 = new SilverMember(2, "Bob", "bob@mail.com");
        member m3 = new GoldMember(3, "Charlie", "charlie@mail.com");

        service.enroll(m1);
        service.enroll(m2);
        service.enroll(m3);

        // Add rewards
        service.addReward(new Reward(101, "Free Flight", 15000));
        service.addReward(new Reward(102, "Upgrade", 10000));
        service.addReward(new Reward(103, "Voucher", 5000));

        // Flights
        Flightactivity f1 = new Flightactivity(1, "AI202", new Date(), 1200, "Economy");
        Flightactivity f2 = new Flightactivity(2, "AI305", new Date(), 2000, "Business");

        // Credit miles
        service.creditMiles(1, f1);
        service.creditMiles(2, f2);
        service.creditMiles(3, f2);

        // Redeem
        service.redeemReward(2, 2);
        service.redeemReward(3, 0);

        // Print statements
        service.printStatements();
    }
}

