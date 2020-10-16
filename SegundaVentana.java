/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.agenda;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author joset
 */
public class SegundaVentana {
    public static void mostrarVentana(ArrayList<Contacto> lista_contanto){
        TableView tv=new TableView();
        TableColumn<String, Contacto> columna1 = new TableColumn<>("NOMBRE");
        columna1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<String, Contacto> columna2 = new TableColumn<>("APELLIDO");
        columna2.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        TableColumn<String, Contacto> columna3 = new TableColumn<>("TELEFONO");
        columna3.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tv.getColumns().add(columna1);
        tv.getColumns().add(columna2);
        tv.getColumns().add(columna3);
    
        for (Contacto  c : lista_contanto) {
            tv.getItems().add(c);
        }
        
        Stage ventana=new Stage();
        VBox v=new VBox(20);
        v.getChildren().addAll(tv);
        Scene escena =new Scene(v, 200, 200);
        ventana.setScene(escena);
        ventana.show();
    }

    static void popUp() {
        Label lbl_aviso=new Label("CONTACTO GUARDADO!!");
        Button btn_aceptar=new Button("Aceptar");
        Stage popup=new Stage();
        VBox v=new VBox(20);
        v.getChildren().addAll(lbl_aviso,btn_aceptar);
        Scene escena =new Scene(v, 100, 100);
        popup.setScene(escena);
        popup.show();
        
        btn_aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                popup.close();
            }
        });
        
       
    }
    
}  