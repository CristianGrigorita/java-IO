package IO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class TimeComparator implements Comparator<Athlete> {
    @Override
    public int compare(Athlete o1, Athlete o2){
        int skiTimeResultO1 = o1.transformToSeconds(o1.getTimeWithPenalties());
        int skiTimeResultO2 = o2.transformToSeconds(o2.getTimeWithPenalties());

        return skiTimeResultO1 - skiTimeResultO2;
    }
}
