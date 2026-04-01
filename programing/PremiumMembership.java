public class PremiumMembership extends Membership {

    private int trainerSlots; // available slots for adding trainers in a premium gym membership.

    public PremiumMembership(String name, double fee, int duration, String type, int trainerSlots) {
        super(name, fee, duration, type);
        this.trainerSlots = trainerSlots;
    }

    public int getTrainerSlot() {
        return trainerSlots;
    }

    public String addTrainer(String name) {
        if (trainerSlots > 0) {
            trainerSlots--;
            return "Trainer " + name + " added. Slots left: " + trainerSlots;
        } else {
            return "No trainer slots available!";
        }
    }

    @Override
    public String display() {
        return "Premium =  " +
                getName() + ", Fee: " + getFee() +
                ", Duration: " + getDuration() +
                ", Type: " + getType() +
                ", Trainer Slots: " + trainerSlots;
    }
}