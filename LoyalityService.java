// File: LoyaltyService.java
package jp3;
import java.util.*;

public class LoyalityService {
    private Map<Integer, member> members = new HashMap<>();
    private List<Reward> rewards = new ArrayList<>();

    public void enroll(member member) {
        members.put(member.memberId, member);
        System.out.println("Enrolled: " + member.getName());
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public void creditMiles(int memberId, Flightactivity flight) {
        member m = members.get(memberId);
        if (m != null) {
            int miles = flight.calculateMiles();
            m.creditMiles(miles);
            m.evaluateTier();
            System.out.println(m.getName() + " earned " + miles + " miles.");
        }
    }

    public void redeemReward(int memberId, int rewardIndex) {
        member m = members.get(memberId);
        if (m != null && rewardIndex < rewards.size()) {
            m.redeem(rewards.get(rewardIndex));
        }
    }

    public void printStatements() {
        for (member m : members.values()) {
            m.statement();
        }
    }
}
