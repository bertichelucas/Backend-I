package tests;

import main.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    @Test
    @DisplayName("Test Menu Infantil")
    public void TestMenuInfantil(){
        //GIVEN
        Menu menuinf = new MenuInfantil(200, 5);
        String mensajeEsperado = "Menu infantil con " + 5 + "juguetes\n" +
                "Precio: " + 215.0;
        //WHEN
        String mensaje = menuinf.ProcesoPrepararMenu();
        //THEN
        assertEquals(mensaje, mensajeEsperado);
    }

    @Test
    @DisplayName("Test Menu Vegetariano")
    public void TestMenuVegetariano(){
        //GIVEN
        Menu menuveg = new MenuVegetariano(200, 10, 2);
        String mensajeEsperado = "Menu Vegetariano con " + 10 + " especias y " +
                                2 + " salsas\n" +
                            "Precio: " + 224.0;
        //WHEN
        String mensaje = menuveg.ProcesoPrepararMenu();
        //THEN
        assertEquals(mensaje, mensajeEsperado);
    }

    @Test
    @DisplayName("Test menu Clasico")
    public void TestMenuClasico(){
        //GIVEN
        Menu menuclas = new MenuClasico(200);
        String mensajeEsperado = "Menu Clasico\n" + "Precio: " + 200.0;
        //WHEN
        String mensaje = menuclas.ProcesoPrepararMenu();
        //THEN
        assertEquals(mensaje, mensajeEsperado);
    }
}
