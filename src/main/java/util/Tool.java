package util;

public class Tool {
    public void init() {
        try {
            System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
        } catch (IllegalStateException e){
            e.printStackTrace();
            isSystem = false;
        }
    }
    public boolean isSystem() {
        return isSystem;
    }

    public void setSystem(boolean system) {
        isSystem = system;
    }

    private boolean isSystem = true;

}
