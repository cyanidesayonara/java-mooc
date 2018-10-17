
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Puhelinluettelo extends Application {

    private TableView<Yhteystieto> table;
    private ObservableList<Yhteystieto> data;

    public Puhelinluettelo() {
        this.table = new TableView<>();
        this.data = FXCollections.observableArrayList();
    }

    @Override
    public void start(Stage stage) {
        table = new TableView<>();
        data = FXCollections.observableArrayList();

        Scene scene = new Scene(new Group());
        stage.setWidth(700);
        stage.setHeight(500);

        table.setEditable(true);

        TableColumn nimiSarake = new TableColumn("Nimi");
        nimiSarake.setMinWidth(200);
        nimiSarake.setCellValueFactory(new PropertyValueFactory<>("nimi"));

        TableColumn puhelinnumeroSarake = new TableColumn("Puhelinnumero");
        puhelinnumeroSarake.setMinWidth(200);
        puhelinnumeroSarake.setCellValueFactory(new PropertyValueFactory<>("puhelinnumero"));

        TableColumn katuosoiteSarake = new TableColumn("Katuosoite");
        katuosoiteSarake.setMinWidth(200);
        katuosoiteSarake.setCellValueFactory(new PropertyValueFactory<>("katuosoite"));

        table.setItems(data);
        table.getColumns().addAll(nimiSarake, puhelinnumeroSarake, katuosoiteSarake);

        final HBox hb = new HBox();

        final TextField nimiKentta = new TextField();
        nimiKentta.setPromptText("Nimi");
        nimiKentta.setMinWidth(nimiSarake.getMinWidth());
        
        final TextField puhelinnumeroKentta = new TextField();
        puhelinnumeroKentta.setMinWidth(puhelinnumeroSarake.getMinWidth());
        puhelinnumeroKentta.setPromptText("Puhelinnumero");
        
        final TextField katuosoiteKentta = new TextField();
        katuosoiteKentta.setMinWidth(katuosoiteSarake.getMinWidth());
        katuosoiteKentta.setPromptText("Katuosoite");

        final Button lisaaNappi = new Button("Lisää");
        lisaaNappi.setOnAction((ActionEvent e) -> {
            Yhteystieto yhteystieto = new Yhteystieto(nimiKentta.getText(), puhelinnumeroKentta.getText(), katuosoiteKentta.getText());
            
            // ratkaisu
            if (!nimiKentta.getText().isEmpty() && !puhelinnumeroKentta.getText().isEmpty()&& !katuosoiteKentta.getText().isEmpty()) {
                data.add(yhteystieto);
            }
            
            nimiKentta.clear();
            puhelinnumeroKentta.clear();
            katuosoiteKentta.clear();
        });

        hb.getChildren().addAll(nimiKentta, puhelinnumeroKentta, katuosoiteKentta, lisaaNappi);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
