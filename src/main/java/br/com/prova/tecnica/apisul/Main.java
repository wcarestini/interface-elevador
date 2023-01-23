package br.com.prova.tecnica.apisul;

import br.com.prova.tecnica.apisul.application.IElevadorService;
import br.com.prova.tecnica.apisul.application.impl.ElevadorInterfaceImpl;

public class Main {

    public static void main(String[] args) {
        final IElevadorService app = new ElevadorInterfaceImpl();

        System.out.println("Os andares menos utilizados: " + app.andarMenosUtilizado());
        System.out.println("Os elevadores mais utilizados: " + app.elevadorMaisFrequentado());
        System.out.println("Periodo de maior fluxo nos elevadores mais utilizados: " + app.periodoMaiorFluxoElevadorMaisFrequentado());
        System.out.println("Os três elevadores menos utilizados: " + app.elevadorMenosFrequentado());
        System.out.println("Periodo de menor fluxo nos elevadores menos frequentados: " + app.periodoMenorFluxoElevadorMenosFrequentado());
        System.out.println("Periodo de maior utilização no conjunto de elevadores: " + app.periodoMaiorUtilizacaoConjuntoElevadores());
        System.out.println("Percentual de uso do elevador A: " + app.percentualDeUsoElevadorA());
        System.out.println("Percentual de uso do elevador B: " + app.percentualDeUsoElevadorB());
        System.out.println("Percentual de uso do elevador C: " + app.percentualDeUsoElevadorC());
        System.out.println("Percentual de uso do elevador D: " + app.percentualDeUsoElevadorD());
        System.out.println("Percentual de uso do elevador E: " + app.percentualDeUsoElevadorE());
    }
}