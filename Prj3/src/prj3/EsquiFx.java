package prj3;

import java.time.LocalDate;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EsquiFx extends Application {

    TextField txtDni = new TextField();
    TextField txtNom = new TextField();
    TextField txtCognom = new TextField();
    
    TextField txtMaxParticipantsCol  = new TextField();
    TextField txtPreuCol  = new TextField();
    
    TextField txtIdCurs = new TextField();
    TextField txtNomCurs = new TextField();
    TextField txtData = new TextField();
    TextField txtIdMonitor = new TextField();
    
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage escenari) {
        // Provem diferents contenidors o layouts de JavaFX
        
        //VBox contenedor = new VBox();// es `pot crear adalt o abaix
        //HBox contenedor = new HBox();
        // hi han varios contenedors: Pane, StackPane, HBox, VBox, FlowPane.
        
        /*contenedor.getChildren().addAll(btn1, btn2, btn3);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);*/
        
        BorderPane bp = new BorderPane();
        bp.setTop(partSuperior());
        
        
        
        bp.setLeft(lateralEsquerra());
        
        bp.setRight(lateralDret());
        
        bp.setCenter(formulariCentral());
        
        Scene escena = new Scene(bp);
        
        Pane inferior = partInferior();
        bp.setBottom(inferior);
        BorderPane.setMargin(inferior, new Insets(20, 20, 20, 20));
        
        escenari.setScene(escena);
        escenari.setMinHeight(720);
        escenari.setMinWidth(1280);
        escenari.show();
    } 
    
    private GridPane formulariCentral(){
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        
        Label lblDni = new Label ("DNI");
        Label lblNom= new Label("Nom");
        Label lblCognom= new Label("Cognom");
        
        txtDni = new TextField();
        txtNom = new TextField();
        txtCognom = new TextField();
        
        gp.add(lblDni, 0, 0);
        gp.add(txtDni, 1, 0);
        gp.add(lblNom, 0, 1);
        gp.add(txtNom, 1, 1);
        gp.add(lblCognom, 0, 2);
        gp.add(txtCognom, 1, 2);
        
        return gp;
    }
    
    private Pane partSuperior(){
        HBox hb = new HBox();
        hb.getChildren().add(new Label ("Llogar cursos d'esquí"));
        hb.setAlignment(Pos.CENTER);
        
        return hb;
    }
    
    private Pane partInferior(){
        Button btn1 = new Button("Consultar");
        Button btn2 = new Button("Llogar");
        Button btn3 = new Button("Desinscriure");
        
        HBox hbinf = new HBox();
        hbinf.setSpacing(10);
        hbinf.getSpacing();
        hbinf.getChildren().addAll(btn1, btn2, btn3);
        hbinf.setAlignment(Pos.CENTER);
        
        return hbinf;
    }
    
    private Pane lateralEsquerra(){
        VBox vb = new VBox();
        vb.getChildren().add(new Label("Navegador"));
        vb.setAlignment(Pos.CENTER);
        
        TableView<Client> tblVehicles = new TableView<>();
        TableColumn<Client, String> colDni =  new TableColumn<>("DNI");
        TableColumn<Client, String> colNom =  new TableColumn<>("Nom");
        TableColumn<Client, String> colCognom =  new TableColumn<>("Cognom");
        
        tblVehicles.getColumns().addAll(colDni, colNom, colCognom);
        
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCognom.setCellValueFactory(new PropertyValueFactory<>("cognom"));
        
        Client c1 = new Client("93567268T","Elsa","Pato","", LocalDate.parse("1999-12-12"), "", "");
        Client c2 = new Client("85675754B","Kein","Becil", "", LocalDate.parse("1998-12-12"), "", "");
        
        tblVehicles.getItems().addAll(c1,c2);
        
        vb.getChildren().add(tblVehicles);
        
        tblVehicles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
        @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue){
            Client client = (Client) newValue;
      
                if (client != null){
                // movem a la pantalla les dades del client seleccionat
                    txtDni.setText(client.getDni()); //txtMarca es un text field
                    txtNom.setText(client.getNom());
                    txtCognom.setText(client.getCognom());
                }
            }
        });
        
        return vb;
    }
    
    private VBox lateralDret() {
        VBox vb = new VBox();

        Label lbl = new Label("Lateral dret");

        // vb.getChildren().addAll(lbl);
        vb.setAlignment(Pos.CENTER);

        TabPane tp = new TabPane();

        Tab tab1 = new Tab("Colectiu", cursosColectius());
        Tab tab2 = new Tab("Competicio", cursosCompeticio());
        Tab tab3 = new Tab("Individual", cursosIndividuals());

        tp.getTabs().addAll(tab1, tab2, tab3);

        vb.getChildren().addAll(lbl, tp);

        return vb;
    }
    
    private Pane cursosColectius(){
        
        VBox vb = new VBox();
        
        TableView<CursColectiu> tblCursosCol = new TableView<>();
        TableColumn<CursColectiu, String> colIdCurs =  new TableColumn<>("ID");
        TableColumn<CursColectiu, String> colNom =  new TableColumn<>("Nom");
        TableColumn<CursColectiu, String> colData =  new TableColumn<>("Data Inici");
        TableColumn<CursColectiu, String> colIdMonitor = new TableColumn<>("Número Monitor");
        TableColumn<CursColectiu, String> colMaxPart = new TableColumn<>("Participants");
        TableColumn<CursColectiu, String> colPreuCol = new TableColumn<>("Preu");
        
        tblCursosCol.getColumns().addAll(colIdCurs, colNom, colData, colIdMonitor, colMaxPart, colPreuCol);
        
        colIdCurs.setCellValueFactory(new PropertyValueFactory<>("id_curs"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom_curs"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colIdMonitor.setCellValueFactory(new PropertyValueFactory<>("id_monitor"));
        colMaxPart.setCellValueFactory(new PropertyValueFactory<>("max_participants"));
        colPreuCol.setCellValueFactory(new PropertyValueFactory<>("preuColectiu"));
        
        CursColectiu crs1 = new CursColectiu(20, 100.00, 1, "Esquí basic", LocalDate.parse("2022-05-09"), 1, "");
        CursColectiu crs2 = new CursColectiu(25, 150, 1, "Snowboarding basic", LocalDate.parse("2022-05-10"), 2, "");
        
        tblCursosCol.getItems().addAll(crs1, crs2);
        vb.getChildren().add(tblCursosCol);
        
        tblCursosCol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
        @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue){
            CursColectiu crsCol = (CursColectiu) newValue;
      
                if (crsCol != null){
                    txtIdCurs.setText(Integer.toString(crsCol.getId_curs()));
                    txtNomCurs.setText(crsCol.getNom_curs());
                    txtData.setText(String.valueOf(crsCol.getData_inici()));
                    txtIdMonitor.setText(String.valueOf(crsCol.getNom_monitor()));
                    txtMaxParticipantsCol.setText(String.valueOf(crsCol.getAforament()));
                    txtPreuCol.setText(String.valueOf(crsCol.getPreuColectiu()));
                }
            }
        });
        
        return vb;
    }
    
    private Pane cursosCompeticio(){
        
        
        
        return null;
    }
    
    private Pane cursosIndividuals(){
        
        
        
        return null;
    }
}