/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.agenda;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author joset
 */
public class ClasePrincipal extends Application {
    VBox v;
    TextField nombre;
    TextField apellido;
    TextField telefono;
    String nombre_g="";
    String apellido_g="";
    String telefono_g="";
    String buscado_g="";
    TextField nombre_buscado;
    
    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        v=new VBox(30);
        nombre=new TextField();
        apellido=new TextField();
        telefono=new TextField();
        Button btn_guardar=new Button("Enviar");
        Label lbl_nombre=new Label("Nombre:");
        Label lbl_apellido=new Label("Apellido:");
        Label lbl_telefono=new Label("Telefono:");
        Button btn_recuperar=new Button("Recuperar");
        Label lbl_nombre_buscado=new Label("Nombre a buscar:");
        Button btn_buscar=new Button("Buscar");
        nombre_buscado=new TextField();
        
        btn_guardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                nombre_g=nombre.getText();
                apellido_g=apellido.getText();
                telefono_g=telefono.getText();
                Contacto c=new Contacto(nombre_g, apellido_g, telefono_g);
                AccesoFichero.grabarContacto(c);
                nombre.setText("");
                apellido.setText("");
                telefono.setText("");
                SegundaVentana.popUp();
            }
        });
        
        btn_recuperar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ArrayList<Contacto> lista_contacto=new ArrayList();
                lista_contacto=AccesoFichero.recuperarContactos();
                SegundaVentana.mostrarVentana(lista_contacto);
                
            }
        });
        
        btn_buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                buscado_g=nombre_buscado.getText();
                ArrayList<Contacto> lista_contacto2=new ArrayList();
                ArrayList<Contacto> lista_contacto=new ArrayList();
                lista_contacto=AccesoFichero.recuperarContactos();
                lista_contacto2=AccesoFichero.buscarPorNombre(lista_contacto, buscado_g);
                SegundaVentana.mostrarVentana(lista_contacto2);
            }
        });
        
        v.getChildren().addAll(lbl_nombre,nombre,lbl_apellido,apellido,lbl_telefono,telefono,btn_guardar,btn_recuperar,lbl_nombre_buscado,nombre_buscado,btn_buscar);
        Scene escena=new Scene(v, 600, 600);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
