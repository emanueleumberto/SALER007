package org.example.Esercizi.EsercizioFinale;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileManager {

    private String newLine = System.getProperty("line.separator");

    public Map<String, Veicolo> leggiVeicoliDaFile(File filePath) {

        Map<String, Veicolo> listaVeicoli = new HashMap<String, Veicolo>();

        try {
            String fileText = FileUtils.readFileToString(filePath);
            //System.out.println(fileText);
            String[] rows = fileText.split(";");
            for (String row : rows) {
                //System.out.println(row);
                String[] rowParms = row.split(":");
                Veicolo v = new Veicolo(
                                    rowParms[0],
                                    rowParms[1],
                                    rowParms[2],
                                    Integer.parseInt(rowParms[3]));
                if(rowParms.length > 4) {
                    Arrays.stream(rowParms[4].split("-")).forEach(v::aggiungiIntervento);
                }

                listaVeicoli.put(v.getTarga(), v);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaVeicoli;
    }

    public void scriviVeicoliSuFile(File filePath, Map<String, Veicolo> veicoli) {
        veicoli.values().forEach(v -> {
            String veicoloText = v.getTarga() + ":"
                                + v.getMarca() + ":"
                                + v.getModello() + ":"
                                + v.getAnnoImmatricolazione() + ":"
                                + String.join("-", v.getInterventiManutenzione()) + ";";
            try {
                FileUtils.writeStringToFile(filePath, veicoloText + newLine, true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

}
