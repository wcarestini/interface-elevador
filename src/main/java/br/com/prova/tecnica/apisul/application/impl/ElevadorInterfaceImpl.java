package br.com.prova.tecnica.apisul.application.impl;

import br.com.prova.tecnica.apisul.application.IElevadorService;
import br.com.prova.tecnica.apisul.service.ElevadorService;

import java.util.List;

public class ElevadorInterfaceImpl implements IElevadorService {

    private final ElevadorService elevadorService = new ElevadorService();

    @Override
    public List<Integer> andarMenosUtilizado() {
        return elevadorService.floorLessUsed();
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        return elevadorService.elevatorMostUsed();
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        return elevadorService.periodHighestFlowMostFrequentedElevator();
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        return elevadorService.elevatorLessUsed();
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        return elevadorService.periodMinorFlowElevatorLessFrequented();
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        return elevadorService.periodIncreasedUseSetElevators();
    }

    @Override
    public float percentualDeUsoElevadorA() {
        return elevadorService.percentageOfElevatorUse("A");
    }

    @Override
    public float percentualDeUsoElevadorB() {
        return elevadorService.percentageOfElevatorUse("B");
    }

    @Override
    public float percentualDeUsoElevadorC() {
        return elevadorService.percentageOfElevatorUse("C");
    }

    @Override
    public float percentualDeUsoElevadorD() {
        return elevadorService.percentageOfElevatorUse("D");
    }

    @Override
    public float percentualDeUsoElevadorE() {
        return elevadorService.percentageOfElevatorUse("E");
    }
}