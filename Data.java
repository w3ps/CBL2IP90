
public class Data {
    private Controller controller;
    private Settings settings;
    
    public int level;
    public int bestTime;
    public int volume;

    public Data(int level, int volume, int bestTime) {
        controller = new Controller(new Main());
        settings = new Settings(controller);
        this.level = level;
        this.volume = volume;
        this.bestTime = bestTime;
    }

    public int getLevel() {
        return controller.getCurrentLevel();
    }

    public int getVolume() {
        return settings.getVolume();
    }
}
