package br.com.prova.tecnica.apisul.service;

import br.com.prova.tecnica.apisul.entity.ElevadorEntity;
import br.com.prova.tecnica.apisul.repository.ElevadorRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toSet;

public class ElevadorService {
    private static final int LIMIT = 3;

    public List<Integer> floorLessUsed() {
        return ElevadorRepository.getAllFloors()
                .stream()
                .collect(Collectors.groupingBy(ElevadorEntity::getAndar, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .map(Map.Entry::getKey)
                .limit(LIMIT)
                .collect(Collectors.toList());
    }

    public List<Character> elevatorMostUsed() {
        return ElevadorRepository.getAllFloors()
                .stream()
                .collect(Collectors.groupingBy(ElevadorEntity::getElevador, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey().charAt(0))
                .limit(LIMIT)
                .collect(Collectors.toList());
    }

    public List<Character> periodMinorFlowElevatorLessFrequented() {
        final List<Map.Entry<String, Set<ElevadorEntity>>> elevators = ElevadorRepository.getAllFloors()
                .stream()
                .collect(Collectors.groupingBy(ElevadorEntity::getElevador, toSet()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> e.getValue().size()))
                .limit(LIMIT)
                .collect(Collectors.toList());

        if (elevators.isEmpty()) {
            return Collections.emptyList();
        }

        return elevators.stream()
                .map(entry -> entry.getValue().stream()
                        .collect(Collectors.groupingBy(ElevadorEntity::getTurno, counting()))
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                        .map(entryElevator -> entryElevator.getKey().charAt(0))
                        .orElseThrow(() -> new IllegalArgumentException("Turno não encontrado")))
                .collect(Collectors.toList());
    }

    public List<Character> elevatorLessUsed() {
        return ElevadorRepository.getAllFloors()
                .stream()
                .collect(Collectors.groupingBy(ElevadorEntity::getElevador, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .map(entry -> entry.getKey().charAt(0))
                .limit(LIMIT)
                .collect(Collectors.toList());
    }

    public List<Character> periodHighestFlowMostFrequentedElevator() {
        final List<Map.Entry<String, Set<ElevadorEntity>>> elevators = ElevadorRepository.getAllFloors()
                .stream()
                .collect(Collectors.groupingBy(ElevadorEntity::getElevador, toSet()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .limit(LIMIT)
                .collect(Collectors.toList());


        if (elevators.isEmpty()) {
            return Collections.emptyList();
        }

        return elevators.stream()
                .map(entry -> entry.getValue().stream()
                        .collect(Collectors.groupingBy(ElevadorEntity::getTurno, counting()))
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(entryElevator -> entryElevator.getKey().charAt(0))
                        .orElseThrow(() -> new IllegalArgumentException("Turno não encontrado")))
                .collect(Collectors.toList());
    }

    public List<Character> periodIncreasedUseSetElevators() {
        final List<Map.Entry<String, Set<ElevadorEntity>>> elevators = ElevadorRepository.getAllFloors()
                .stream()
                .collect(Collectors.groupingBy(ElevadorEntity::getElevador, toSet()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .collect(Collectors.toList());

        return elevators.stream()
                .map(entry -> entry.getValue().stream()
                        .collect(Collectors.groupingBy(ElevadorEntity::getTurno, counting()))
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(entryElev -> entryElev.getKey().charAt(0))
                        .orElseThrow(() -> new IllegalArgumentException("Turno não encontrado")))
                .collect(Collectors.toList());
    }

    public float percentageOfElevatorUse(final String elevator) {
        final List<Map.Entry<String, Set<ElevadorEntity>>> elevators = ElevadorRepository.getAllFloors()
                .stream()
                .collect(Collectors.groupingBy(ElevadorEntity::getElevador, toSet()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .collect(Collectors.toList());

        final int totalUses = elevators.stream().mapToInt(e -> e.getValue().size()).sum();
        final int elevatorUses = elevators.stream()
                .filter(e -> e.getKey().equals(elevator))
                .findFirst()
                .map(Map.Entry::getValue)
                .map(Set::size)
                .orElse(0);

        return (float) elevatorUses / totalUses * 100;
    }
}
