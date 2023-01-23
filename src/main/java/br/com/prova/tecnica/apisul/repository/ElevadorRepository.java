package br.com.prova.tecnica.apisul.repository;

import br.com.prova.tecnica.apisul.entity.ElevadorEntity;
import br.com.prova.tecnica.apisul.utils.JsonReader;

import java.util.ArrayList;
import java.util.List;

public class ElevadorRepository {

    public static List<ElevadorEntity> getAllFloors() {
        return new ArrayList<>(JsonReader.readFile());
    }
}