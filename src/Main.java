import GUI.LeecherStage;
import GUI.MainStage;
import GUI.SeederStage;
import Seeder.Seeder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.DatagramSocket;

/**
 * This class is the main entry of the application
 */
public class Main extends Application
{
    /**
     * The main method that runs the javafx application
     * @param args program arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * Overriding the application method start to start the javafx application
     * @param stage the stage where all the scenes will be rendered
     * @throws Exception function can throw any exception
     */
    @Override
    public void start(Stage stage) throws Exception
    {

        /*
            create the stage and scene for the leecher UI
         */
        LeecherStage leecherStage = new LeecherStage(stage);
        Scene LeecherScene = leecherStage.leecherScene();

        /*
            Create the stage and scene for the seeder UI
         */
        SeederStage seederStage = new SeederStage(stage);
        Scene SeederScene = seederStage.seederScene();
        /*
            Create the seeder
         */
        new Seeder(new DatagramSocket(8000), seederStage).start(); // start seeder

        /*
             Set the title of the App
         */
        stage.setTitle("UDP - Based Peer to Peer");

        /*
            Create the Main stage of the App
         */
        MainStage mainStage = new MainStage(stage, LeecherScene, SeederScene);

        /*
            Add the scenes to the stage
         */
        stage.setScene(mainStage.MainStageNodes());

        /*
            Set the functionality to switch to  leecher scene from seeder scene
         */
        seederStage.setButtonFunctionalities(LeecherScene);

        /*
            Set functionality to switch to seeder scene from leecher scene
         */
        leecherStage.addButtonFunctionality(SeederScene);

        /*
            Show app window
         */
        stage.show();
    }
}
