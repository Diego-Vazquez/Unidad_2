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
        casos.getItems().addAll(
                "ejercicio 1",
                "Ejercicio 2",
                "validar password",
                "validar que no comienza con db",
                "validar que termina con count",
                "validar dos nombres",
                "validar mac address",
                "validar palabra que comience\n y termine con mayuscula",
                "validar palabra que comience con mayuscula\n y termine con minuscula",
                "validar numero binario de 8 digitos",
                "validar numero hexadecimal",
                "validar operacion de un digito",
                "validar numero de control ITSNCG",
                "validar curp"
                );
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
                break;

            } case 3:{expresion="(^[^db])([a-zA-Z0-9]+)";break;}
            case 4:{expresion="([\\w]+)([count]$)";break;}
            case 5:{expresion="[a-zA-Z\\s]+";break;}
            case 6:{expresion="^([0-9a-f]{1,2}[:]){5}([0-9a-f]{1,2})$";break;}
            case 7:{expresion="(^[A-Z]+)([a-zA-Z]+)([A-Z]+$)";break;}
            case 8:{expresion="(^[A-Z]+)([a-zA-Z]+)([a-z]+$)";break;}
            case 9:{expresion="^[0-1]+$";break;}
            case 10:{expresion="^[0-9a-fA-F]+$";break;}
            case 11:{expresion="(^[0-9]{1,1})([+|-|*|/]+)([0-9]{1,1}$)";break;}
            case 12:{expresion="(^[0-9]{2,2})([cg]{2,2})([0-9]{4,4}$)";break;}
            case 13:{expresion="^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$";break;}

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
