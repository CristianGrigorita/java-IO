package IO;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList csvData;
        ArrayList csvDataBis;


        csvData = CSVParser.parseCSV("ski-standings.txt");
        System.out.println(csvData);

//        csvDataBis = OpenCSVParser.parseCSV("ski-standings.txt");
//        System.out.println(csvDataBis);

        System.out.println("---");

        TimeComparator timeComparator = new TimeComparator();
        Set<Athlete> athletes = new TreeSet<>(timeComparator);
        for(Object athleteData: csvData) {
            ArrayList athlete = (ArrayList) athleteData;

            int athleteNumber = Integer.parseInt((String) athlete.get(0));
            String athleteName = (String) athlete.get(1);
            String countryCode = (String) athlete.get(2);
            String skiTimeResult = (String) athlete.get(3);
            String firstShootingRange = (String) athlete.get(4);
            String secondShootingRange = (String) athlete.get(5);
            String thirdShootingRange = (String) athlete.get(6);

            Athlete thisAthlete = new Athlete(athleteNumber, athleteName, countryCode, skiTimeResult,
                    firstShootingRange, secondShootingRange, thirdShootingRange);
            athletes.add(thisAthlete);
        }

        System.out.println("---");
        System.out.println(athletes);

//        Athlete[] athletes = new Athlete[4];
//        athletes[0] = new Athlete(11,"Umar Jorgson", "SK", "30:27",
//                "xxxox","xxxox","xxoxo");
//        athletes[1] = new Athlete(1, "Jimmy Smiles", "UK", "12:15",
//                "xxoox","xooxo","xxxxo");
//        athletes[2] = new Athlete(5, "Jimmy Smiles", "UK", "41:15",
//                "xxoox","xooxo","xxxxo");
//        athletes[3] = new Athlete(19, "Jimmy Smiles", "UK", "29:15",
//                "xxoox","xooxo","xxxxo");

//        System.out.println(Arrays.toString(athletes));
//        Athlete atlet = new Athlete(11,"Umar Jorgson",  "SK", "30:27",
//                "xxxox","xxxox","xxoxo");
//        atlet.addPenalties(30);
    }
}
