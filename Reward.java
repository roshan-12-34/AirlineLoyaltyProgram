// File: Reward.java
package jp3;

public class Reward {
    private int rewardId;
    private String name;
    private int milesRequired;
    private boolean available;

    public Reward(int rewardId, String name, int milesRequired) {
        this.rewardId = rewardId;
        this.name = name;
        this.milesRequired = milesRequired;
        this.available = true;
    }

    public String getName() { return name; }
    public int getMilesRequired() { return milesRequired; }
    public boolean isAvailable() { return available; }

    public void redeem() { available = false; }

    @Override
    public String toString() {
        return name + " (Miles: " + milesRequired + ", Available: " + available + ")";
    }
}

