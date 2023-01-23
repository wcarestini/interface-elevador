package br.com.prova.tecnica.apisul.utils;

import br.com.prova.tecnica.apisul.entity.ElevadorEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonReader {

    private static final String FILE_PATH = "input.json";
    private static final String OBJECT_REGEX_PATTERN = "\\{(.*?)\\}";
    private static final String PROP_ANDAR_REGEX_PATTERN = "\"andar\": (\\d+)";
    private static final String PROP_ELEVADOR_REGEX_PATTERN = "\"elevador\": \"(.*?)\"";
    private static final String PROP_TURNO_REGEX_PATTERN = "\"turno\": \"(.*?)\"";

    public static List<ElevadorEntity> readFile() {
        final List<ElevadorEntity> elevadores = new ArrayList<>();

        try {
            final FileReader fileReader = new FileReader(FILE_PATH);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);

            final StringBuilder jsonString = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                jsonString.append(line);
            }

            bufferedReader.close();

            final Pattern pattern = Pattern.compile(OBJECT_REGEX_PATTERN);
            final Matcher matcher = pattern.matcher(jsonString.toString());

            while (matcher.find()) {
                final String jsonObjectString = matcher.group();
                final ElevadorEntity elevador = new ElevadorEntity();

                final Pattern andarPattern = Pattern.compile(PROP_ANDAR_REGEX_PATTERN);
                final Matcher andarMatcher = andarPattern.matcher(jsonObjectString);
                if (andarMatcher.find()) {
                    elevador.setAndar(Integer.parseInt(andarMatcher.group(1)));
                }

                final Pattern elevadorPattern = Pattern.compile(PROP_ELEVADOR_REGEX_PATTERN);
                final Matcher elevadorMatcher = elevadorPattern.matcher(jsonObjectString);
                if (elevadorMatcher.find()) {
                    elevador.setElevador(elevadorMatcher.group(1));
                }

                final Pattern turnoPattern = Pattern.compile(PROP_TURNO_REGEX_PATTERN);
                final Matcher turnoMatcher = turnoPattern.matcher(jsonObjectString);
                if (turnoMatcher.find()) {
                    elevador.setTurno(turnoMatcher.group(1));
                }

                elevadores.add(elevador);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo .json");
        }
        return elevadores;
    }
}
