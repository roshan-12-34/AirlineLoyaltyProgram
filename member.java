// File: Member.java
package jp3;

public class member {
    protected int memberId;
    protected String name;
    protected String email;
    protected String tier;
    protected int milesBalance;

    public member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.tier = "Basic";
        this.milesBalance = 0;
    }

    public int getMilesBalance() { return milesBalance; }
    public String getTier() { return tier; }
    public String getName() { return name; }

    // Overloaded methods
    public void creditMiles(int distance) {
        milesBalance += distance; // default earn = distance
    }

    public void creditMiles(int distance, String fareClass) {
        int bonus = fareClass.equalsIgnoreCase("Business") ? 2 : 1;
        milesBalance += distance * bonus;
    }

    public void evaluateTier() {
        if (milesBalance > 50000) tier = "Platinum";
        else if (milesBalance > 25000) tier = "Gold";
        else if (milesBalance > 10000) tier = "Silver";
        else tier = "Basic";
    }

    public boolean redeem(Reward reward) {
        if (reward.isAvailable() && milesBalance >= reward.getMilesRequired()) {
            milesBalance -= reward.getMilesRequired();
            reward.redeem();
            System.out.println(name + " redeemed " + reward.getName());
            return true;
        } else {
            System.out.println(name + " has insufficient miles for " + reward.getName());
            return false;
        }
    }

    public void statement() {
        System.out.println("Member: " + name + " | Tier: " + tier + " | Miles: " + milesBalance);
    }
}

// Subclasses with overriding (bonus multipliers)
class SilverMember extends member {
    public SilverMember(int id, String name, String email) { super(id, name, email); this.tier="Silver"; }
    @Override
    public void creditMiles(int distance) {
        milesBalance += distance * 1.1; // 10% bonus
    }
}
class GoldMember extends member {
    public GoldMember(int id, String name, String email) { super(id, name, email); this.tier="Gold"; }
    @Override
    public void creditMiles(int distance) {
        milesBalance += distance * 1.25; // 25% bonus
    }
}
class PlatinumMember extends member {
    public PlatinumMember(int id, String name, String email) { super(id, name, email); this.tier="Platinum"; }
    @Override
    public void creditMiles(int distance) {
        milesBalance += distance * 1.5; // 50% bonus
    }
}
