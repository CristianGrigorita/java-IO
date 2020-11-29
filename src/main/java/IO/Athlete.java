package IO;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Athlete implements Comparable<Athlete>{
    private static Logger logger = LogManager.getLogger(CSVParser.class);

    public String name;
    public int number;
    public String countryCode;
    public String skiTimeResult;
    public String firstShootingRange;
    public String secondShootingRange;
    public String thirdShootingRange;
    public String timeWithPenalties;

    public Athlete(int number, String name, String countryCode,
                   String skiTimeResult, String firstShootingRange,
                   String secondShootingRange, String thirdShootingRange) {
        this.name = name;
        this.number = number;
        this.countryCode = countryCode;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
        this.skiTimeResult = skiTimeResult;

        int penalties = calculatePenalties();
        System.out.println(penalties);
        addPenalties(penalties * 10);
    }

    public void addPenalties(int penalties){
        int seconds = transformToSeconds(this.skiTimeResult);
        System.out.println("normal seconds: " + seconds + " will add this many seconds as penalties: " + penalties);
        seconds += penalties;
        System.out.println("after penalties addition: " + seconds);

        int sec = seconds % 60;
        int min = (seconds / 60)%60;

        String timeWithPenalties = min + ":" + sec;
        setTimeWithPenalties(timeWithPenalties);
    }

    public void setTimeWithPenalties(String timeWithPenalties) {
        this.timeWithPenalties = timeWithPenalties;
//        System.out.println("time with penalties: " + this.timeWithPenalties);
    }

    public int transformToSeconds(String time){
        String[] timeArray = time.split(":");
        int hours = parseInt(timeArray[0]);
        int seconds = parseInt(timeArray[1]);
        seconds = hours * 60 + seconds;

        return seconds;
    }

    public int calculatePenalties(){
        ArrayList<String> shootingRanges = new ArrayList<>(3);
        shootingRanges.add(this.firstShootingRange);
        shootingRanges.add(this.secondShootingRange);
        shootingRanges.add(this.thirdShootingRange);

        int shootsMissed = 0;
        for (String shoots: shootingRanges) {
            shootsMissed += StringUtils.countMatches(shoots, "o");
        }
        System.out.println("Shoots missed: " + shootsMissed);
        return shootsMissed;
    }

    public String getTimeWithPenalties() {
        return timeWithPenalties;
    }

    public int getNumber() {
        return number;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n Athlete{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult=" + skiTimeResult +
                ", timeWithPenalties=" + timeWithPenalties +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                '}';
    }

    @Override
    public int compareTo(Athlete o) {
        return this.name.compareTo(o.getName());
    }
}
