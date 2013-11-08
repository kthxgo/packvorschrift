/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication1;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jeff
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        HBox hbox = addHBox();
        VBox vbox = addVBox();
        Pane table1 = addTablePane();
        Pane main = getMainPane();
        Pane right = SlidePane(400, 300, table1);
        
        root.setTop(hbox);
        root.setLeft(vbox);
        root.setCenter(main);
        root.setRight(right);
        
        Scene scene = new Scene(root, 750, 500);
        
        primaryStage.setTitle("Packvorschrift SAP");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public HBox addHBox() {
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.AQUA);
        
        Text logo = new Text("Packvorschrift");
        logo.setFont(Font.font("Arial",FontWeight.BOLD, 22));
        logo.setFill(Color.WHITE);
        logo.setEffect(ds);
        logo.setCache(true);
        
        
        hbox.getChildren().addAll(logo);
        
        return hbox;
        
    }
    
    
    public VBox addVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #336699;");
        
        Text title = new Text("Aktionen");
        title.setFont(Font.font("Arial",FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        
        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Erstellen"),
            new Hyperlink("Bearbeiten"),
            new Hyperlink("Anzeigen")
        };
        for (Hyperlink option : options) {
            VBox.setMargin(option, new Insets(0,0,0,10));
            vbox.getChildren().add(option);
        }
        
        return vbox;
        
    }
    
    final private TableView table = new TableView();
    
    public Pane addTablePane() {
        
        Pane gp = new Pane();
        gp.setPrefWidth(500);
        gp.setStyle("-fx-background-color: #777777;");
        
        table.setEditable(false);
        
        TableColumn name = new TableColumn("Name");
        TableColumn id = new TableColumn("ID");
        TableColumn hight = new TableColumn("Höhe");
        TableColumn width = new TableColumn("Breite");
        TableColumn cool = new TableColumn("Cool");
        TableColumn hot = new TableColumn("Hot");
        
        table.getColumns().addAll(name, id, hight, width, cool, hot);
        
        gp.getChildren().add(table);
        
        return gp;
        
    }
    
    public Pane SlidePane(final double width, final double diff, Node... nodes) {
        
        Pane p = new Pane();
        
        double save;
        final VBox vb = new VBox();
        vb.setPrefWidth(width);
        
        final Button controlButton = new Button();
        controlButton.setText("choose");
        
        controlButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                final Animation hidePane = new Transition() {
                    { setCycleDuration(Duration.millis(1000)); }
                    @Override
                    protected void interpolate(double d) {
                        vb.setPrefWidth(width - diff * d);
                    }
                };
                hidePane.onFinishedProperty().set(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        controlButton.setText("show");
                    }
                });
                final Animation showPane = new Transition() {
                    { setCycleDuration(Duration.millis(1000)); }
                    @Override
                    protected void interpolate(double d) {
                        vb.setPrefWidth((width-diff) + diff * d);
                    }
                };
                showPane.onFinishedProperty().set(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        controlButton.setText("choose");
                    }
                });
                if(controlButton.getText().equals("choose")) {
                    hidePane.play();
                } else {
                    showPane.play();
                }
            };
        });
        
        vb.getChildren().addAll(nodes);
        vb.getChildren().add(controlButton);
        p.getChildren().add(vb);
        
        return p;
        
    }
    
    public Pane getMainPane() {
        Pane p = new Pane();
        
        HBox hb = new HBox();
        VBox vb = new VBox();
        vb.setPrefWidth(200);
        vb.setPadding(new Insets(10, 10, 10, 10));
        VBox vb2 = new VBox();
        vb2.setPrefWidth(200);
        vb2.setPadding(new Insets(10, 10, 10, 10));
        
        Label l = new Label("Hier steht mal was!");
        Label l2 = new Label("und hier noch was");
        
        Label namel = new Label("\nName: ");
        TextField name = new TextField();
        Label idl = new Label("\nID: ");
        TextField id = new TextField();
        Label widthl = new Label("\nWidth: ");
        TextField width = new TextField();
        Label heightl = new Label("\nHeight: ");
        TextField height = new TextField();
        Label cooll = new Label("\nCool: ");
        TextField cool = new TextField();
        Label hotl = new Label("\nHot: ");
        TextField hot = new TextField();
        
        Label namel2 = new Label("\nName: ");
        TextField name2 = new TextField();
        Label idl2 = new Label("\nID: ");
        TextField id2 = new TextField();
        Label widthl2 = new Label("\nWidth: ");
        TextField width2 = new TextField();
        Label heightl2 = new Label("\nHeight: ");
        TextField height2 = new TextField();
        Label cooll2 = new Label("\nCool: ");
        TextField cool2 = new TextField();
        Label hotl2 = new Label("\nHot: ");
        TextField hot2 = new TextField();
        
        vb.getChildren().addAll(l, namel, name, idl, id, widthl, width, heightl, 
                height, cooll, cool, hotl, hot);
        vb2.getChildren().addAll(l2, namel2, name2, idl2, id2, widthl2, width2, heightl2, 
                height2, cooll2, cool2, hotl2, hot2);
        hb.getChildren().addAll(vb, vb2);
        p.getChildren().add(hb);
        
        return p;
    }
    
}
