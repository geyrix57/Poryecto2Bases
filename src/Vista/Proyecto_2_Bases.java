/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;


import Controlador.ScreensController;
import Modelo.BaseDatos.DataBase;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Geykel
 */
public class Proyecto_2_Bases extends Application {
    
      public static String screen1ID = "categoria";
      public static String screen1File = "Categoria.fxml";
//      public static String screen2ID = "main";
//      public static String screen2File = "vistaGrid.fxml";
      public static Stage STAGE;
    
      @Override
    public void start(Stage stage) throws Exception {
        STAGE = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("Categoria.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
         
       // ScreensController mainContainer = new ScreensController();
        //mainContainer.loadScreen(Proyecto_2_Bases.screen1ID, Proyecto_2_Bases.screen1File);
        //mainContainer.loadScreen(Proyecto_2_Bases.screen2ID, Proyecto_2_Bases.screen2File);
        
        //mainContainer.setScreen(Proyecto_2_Bases.screen1ID);
        
       /* Group root = new Group();
        root.getChildren().addAll(mainContainer);*/
        //Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.initStyle(StageStyle.UTILITY);
//        stage.setTitle("Oracle Data Base Monitor");
//        stage.sizeToScene();
//        
//        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent t) {
//                Platform.exit();
//                try {
//                    DataBase.getInstance().close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Proyecto_2_Bases.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                System.exit(0);
//            }
//        });
         
    }
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
