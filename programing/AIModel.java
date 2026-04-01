public class AIModel {
    private String modelName;
    private double price;
    private int parameterCount;
    private String contextWindow;

    public AIModel(String modelName, double price, int parameterCount, String contextWindow) {
        this.modelName = modelName;
        this.price = price;
        this.parameterCount = parameterCount;
        this.contextWindow = contextWindow;
    }

    public String getModelName() {
        return modelName;
    }

    public double getPrice() {
        return price;
    }

    public int getParameterCount() {
        return parameterCount;
    }

    public String getContextWindow() {
        return contextWindow;
    }

    public String display() {
        return "Model Name: " + modelName
                + "\nPrice (NPR per 1 Lakh tokens): " + price
                + "\nParameter Count (billions): " + parameterCount
                + "\nContext Window: " + contextWindow;
    }
}
