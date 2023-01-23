package br.com.prova.tecnica.apisul.application.impl;

import br.com.prova.tecnica.apisul.application.IElevadorService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class ElevadorInterfaceImplTest {

    @Test
    public void shouldReturnAListWithTheFirstThreeLeastUsedFloors() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final List<Integer> response = elevadorService.andarMenosUtilizado();

        final List<Integer> expectedResponse = new ArrayList<>();
        expectedResponse.add(0);
        expectedResponse.add(5);
        expectedResponse.add(6);

        assertArrayEquals(expectedResponse.toArray(), response.toArray());
    }

    @Test
    public void shouldReturnAListOfTheFirstThreeMostFrequentedElevators() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final List<Character> response = elevadorService.elevadorMaisFrequentado();

        final List<Character> expectedResponse = new ArrayList<>();
        expectedResponse.add('C');
        expectedResponse.add('A');
        expectedResponse.add('B');

        assertArrayEquals(expectedResponse.toArray(), response.toArray());
    }

    @Test
    public void shouldReturnAListWithTheFirstThreePeriodsOfGreatestFlowOfEachOfTheMostFrequentedElevators() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final List<Character> response = elevadorService.periodoMaiorFluxoElevadorMaisFrequentado();

        final List<Character> expectedResponse = new ArrayList<>();
        expectedResponse.add('M');
        expectedResponse.add('M');
        expectedResponse.add('V');

        assertArrayEquals(expectedResponse.toArray(), response.toArray());
    }

    @Test
    public void shouldReturnAListOfTheFirstThreeLeastUsedElevators() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final List<Character> response = elevadorService.elevadorMenosFrequentado();

        final List<Character> expectedResponse = new ArrayList<>();
        expectedResponse.add('D');
        expectedResponse.add('E');
        expectedResponse.add('B');

        assertArrayEquals(expectedResponse.toArray(), response.toArray());
    }

    @Test
    public void shouldReturnAListWithTheFirstThreePeriodsOfLessFlowForEachOfTheLessFrequentedElevators() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final List<Character> response = elevadorService.periodoMenorFluxoElevadorMenosFrequentado();

        final List<Character> expectedResponse = new ArrayList<>();
        expectedResponse.add('M');
        expectedResponse.add('M');
        expectedResponse.add('V');

        assertArrayEquals(expectedResponse.toArray(), response.toArray());
    }

    @Test
    public void shouldReturnAListWithThePeriodsOfGreatestUseOfTheSetOfElevators() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final List<Character> response = elevadorService.periodoMaiorUtilizacaoConjuntoElevadores();

        final List<Character> expectedResponse = new ArrayList<>();
        expectedResponse.add('M');
        expectedResponse.add('M');
        expectedResponse.add('V');
        expectedResponse.add('M');
        expectedResponse.add('M');

        assertArrayEquals(expectedResponse.toArray(), response.toArray());
    }

    @Test
    public void shouldReturnThePercentageOfUseOfElevatorA() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final float response = elevadorService.percentualDeUsoElevadorA();

        final float expectedResponse = 34.782608F;

        assertEquals(expectedResponse, response, 0.6);
    }

    @Test
    public void shouldReturnThePercentageOfUseOfElevatorB() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final float response = elevadorService.percentualDeUsoElevadorB();

        final float expectedResponse = 17.391304F;

        assertEquals(expectedResponse, response, 0.6);
    }

    @Test
    public void shouldReturnThePercentageOfUseOfElevatorC() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final float response = elevadorService.percentualDeUsoElevadorC();

        final float expectedResponse = 39.130436F;

        assertEquals(expectedResponse, response, 0.6);
    }

    @Test
    public void shouldReturnThePercentageOfUseOfElevatorD() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final float response = elevadorService.percentualDeUsoElevadorD();

        final float expectedResponse = 4.347826F;

        assertEquals(expectedResponse, response, 0.6);
    }

    @Test
    public void shouldReturnThePercentageOfUseOfElevatorE() {
        final IElevadorService elevadorService = new ElevadorInterfaceImpl();
        final float response = elevadorService.percentualDeUsoElevadorE();

        final float expectedResponse = 4.347826F;

        assertEquals(expectedResponse, response, 0.6);
    }
}