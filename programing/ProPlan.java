public class ProPlan extends AIModel {
    private int availableTeamSlots;

    public ProPlan(String modelName, double price, int parameterCount, String contextWindow, int availableTeamSlots) {
        super(modelName, price, parameterCount, contextWindow);
        this.availableTeamSlots = availableTeamSlots;
    }

    public String addTeamMember(String teamMemberName) {
        if (availableTeamSlots > 0) {
            availableTeamSlots--;
            return "Team member \"" + teamMemberName + "\" added. Available slots: " + availableTeamSlots;
        }
        return "No team slots available in this Pro Plan.";
    }

    public String removeTeamMember(String teamMemberName) {
        availableTeamSlots++;
        return "Team member \"" + teamMemberName + "\" removed. Available slots: " + availableTeamSlots;
    }

    public int getAvailableTeamSlots() {
        return availableTeamSlots;
    }

    public String display() {
        return super.display()
                + "\nPlan Type: Pro Plan"
                + "\nAvailable Team Slots: " + availableTeamSlots;
    }
}
