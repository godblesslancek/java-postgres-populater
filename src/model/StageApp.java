package model;

import javafx.stage.Stage;

public final class StageApp {

    private static StageApp instance = null;

    public Stage stage;

    private StageApp() {

    }

    public static StageApp getInstance() {
        if (instance == null) {
            instance = new StageApp();
        }
        return instance;
    }

    public Stage getStage(){
        return stage;

    }
}