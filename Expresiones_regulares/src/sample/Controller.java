package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML
    TextField entrada;
    @FXML
    ListView casos;
    @FXML
    Label resultado;
    @FXML protected void initialize(){
        casos.getItems().addAll("ejercicio 1","Ejercicio 2","validar password");
    }

    public void procesar(){
        int seleccion = casos.getSelectionModel().getSelectedIndex();
        String expresion="";
        switch(seleccion){
            case 0: {
               expresion="^[_][^p]([a-zA-Z0-9]{3,})[q|w]$";
                break;
            }
            case 1: {
                expresion="[a-zA-Z]+";
                break;
            }
            case 2:{
                //normalmente las contraseñas siempre piden que contenga letras mayusculas y minusculas,numeros, y caracteres especiales
                //y de una longitud de  8-16 digitos
                expresion="((^[A-Z]{2,4})([a-z]{2,4})([0-9]{2,4})([*|#]{2,4}$))";
                System.out.println("aqui");

            }
        }
        String texto=entrada.getText();
        Pattern patron=Pattern.compile(expresion);
        Matcher matcher=patron.matcher(texto);
        if (matcher.matches()){
            resultado.setText("si cumple");
        }else {
            resultado.setText("no cumple");
        }

    }
}
