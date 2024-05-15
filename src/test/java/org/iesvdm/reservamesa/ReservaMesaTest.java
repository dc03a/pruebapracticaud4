package org.iesvdm.reservamesa;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

public class ReservaMesaTest {

    private int tamanioMesa;
    private int[] arrayTest = new int[tamanioMesa];

    @Test
    void testSetMesa() {
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        reservaMesa.setMesas(arrayTest);
        Mockito.verify(reservaMesa, Mockito.times(1)).setMesas(arrayTest);
    }

    @Test
    void testGetMesa() {
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        Mockito.when(reservaMesa.getMesas()).thenReturn(arrayTest);
    }

    @Test
    void testSetTamanioMesa() {
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        reservaMesa.setTamanioMesa(2);
        Mockito.verify(reservaMesa, Mockito.times(1)).setTamanioMesa(2);
    }

    @Test
    void testGetTamanioMesa() {
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        Mockito.when(reservaMesa.getTamanioMesa()).thenReturn(tamanioMesa);
    }


    @Test
    void testRellenarMesas() {
        int array[] = {};
        int tamanio = 4;
        ReservaMesa reservamesa = new ReservaMesa();
        reservamesa.setMesas(array);
        reservamesa.setTamanioMesa(tamanio);
        reservamesa.rellenarMesas();
    }

    @Test
    void testBuscarPrimeraMesaVacia() {
        int array[] = {3,2,0};
        int tamanio = 3;
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        reservaMesa.setMesas(array);
        reservaMesa.setTamanioMesa(tamanio);

        Mockito.when(reservaMesa.buscarPrimeraMesaVacia()).thenReturn(2);
        assertThat(reservaMesa.buscarPrimeraMesaVacia()).isEqualTo(2);

        Mockito.verify(reservaMesa, Mockito.times(1));
    }

    @Test
    void testBuscarMesaParaCompartir() {
        int array[] = {4,3,4,2};
        int tamanio = 4;
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        reservaMesa.setMesas(array);
        reservaMesa.setTamanioMesa(tamanio);

        Mockito.when(reservaMesa.buscarMesaParaCompartir(2)).thenReturn(3);
        assertThat(reservaMesa.buscarMesaParaCompartir(2)).isEqualTo(3);

        Mockito.verify(reservaMesa, Mockito.times(1));
    }

    @Test
    void testBuscarMesaCompartirMasCercaDe() {
        int array[] = {4,3,2,1};
        int tamanio = 4;
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        reservaMesa.setMesas(array);
        reservaMesa.setTamanioMesa(tamanio);

        Mockito.when(reservaMesa.buscarMesaCompartirMasCercaDe(3, 2)).thenReturn(3);
        assertThat(reservaMesa.buscarMesaCompartirMasCercaDe(3, 2)).isEqualTo(3);

        Mockito.verify(reservaMesa, Mockito.times(1));
    }

    @Test
    void testBuscarMesaCompartirMasAlejadaDe() {
        int array[] = {1,3,3,1};
        int tamanio = 4;
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        reservaMesa.setMesas(array);
        reservaMesa.setTamanioMesa(tamanio);

        Mockito.when(reservaMesa.buscarMesaCompartirMasAlejadaDe(3,2)).thenReturn(0);
        assertThat(reservaMesa.buscarMesaCompartirMasAlejadaDe(3,2)).isEqualTo(0);

        Mockito.verify(reservaMesa, Mockito.times(1));
    }

    @Test
    void testbuscarCompartirNMesasConsecutivas() {
        int array[] = {1,1,3,3,4};
        int tamanio = 4;
        ReservaMesa reservaMesa = Mockito.mock(ReservaMesa.class);
        reservaMesa.setMesas(array);
        reservaMesa.setTamanioMesa(tamanio);

        Mockito.when(reservaMesa.buscarCompartirNMesasConsecutivas(2,2)).thenReturn(2);
        assertThat(reservaMesa.buscarCompartirNMesasConsecutivas(2,2)).isEqualTo(2);

        Mockito.verify(reservaMesa, Mockito.times(1));
    }

    @Test
    void testComensalesTotales() {
        int array[] = {1, 2};
        int comensales  = 3;
        ReservaMesa reservaMesa = new ReservaMesa();
        reservaMesa.setMesas(array);
        assertThat(reservaMesa.comensalesTotales()).isEqualTo(comensales);
    }
}
