public class BasicMembership extends Membership {

    private int sessions; // number of remaining workout sessions for a basic membership and decreases
     // each time

    public BasicMembership(String name, double fee, int duration, String type, int sessions) {
        super(name, fee, duration, type);
        this.sessions = sessions;
    }

    public int getSessions() {
        return sessions;
    }

    public String useSession() {
        if (sessions > 0) {
            sessions--;
            return "Workout done. Remaining sessions: " + sessions;
        } else {
            return "No sessions left!";
        }
    }
    

    // Override abstract method
    @Override
    public String display() {
        return "Basic =  " + "Name : " +
                getName() + ", Fee: " + getFee() +
                ", Duration: " + getDuration() +
                ", Type: " + getType() +
                ", Sessions: " + sessions;
    }
}