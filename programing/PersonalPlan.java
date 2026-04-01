public class PersonalPlan extends AIModel {
    private int promptsRemaining;

    public PersonalPlan(String modelName, double price, int parameterCount, String contextWindow, int promptsRemaining) {
        super(modelName, price, parameterCount, contextWindow);
        this.promptsRemaining = promptsRemaining;
    }

    public int getPromptsRemaining() {
        return promptsRemaining;
    }

    public String purchaseAdditionalPrompts(int promptsToAdd) {
        if (promptsToAdd < 0) {
            return "Please enter a positive prompt value or upgrade to Pro Plan.";
        }
        promptsRemaining += promptsToAdd;
        return "Additional prompts added successfully. Remaining prompts: " + promptsRemaining;
    }

    public String givePrompt(String promptText, int responseLength) {
        if (promptsRemaining > 0) {
            promptsRemaining--;
            return "Prompt accepted.\nPrompt: " + promptText
                    + "\nExpected response length (tokens): " + responseLength
                    + "\nRemaining prompts: " + promptsRemaining;
        }
        return "Monthly prompt quota has been reached.";
    }

    public String display() {
        return super.display()
                + "\nPlan Type: Personal Plan"
                + "\nPrompts Remaining: " + promptsRemaining;
    }
}
