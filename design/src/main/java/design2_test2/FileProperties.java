package design2_test2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {

    private static final long serialVersionUID = -2256749719985770822L;

    @Override
    public void readFromFile(String filename) throws IOException {
        super.load(new FileInputStream(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        super.store(new FileOutputStream(filename), "write by FileProperties");
    }

    @Override
    public void setTime() {
        Calendar calendar = Calendar.getInstance();
        super.setProperty("year", calendar.get(Calendar.YEAR) + "");
        super.setProperty("month", calendar.get(Calendar.MONTH) + "");
        super.setProperty("week", calendar.get(Calendar.WEEK_OF_MONTH) + "");
        super.setProperty("day", calendar.get(Calendar.DAY_OF_MONTH) + "");
        super.setProperty("hour", calendar.get(Calendar.HOUR_OF_DAY) + "");
        super.setProperty("minute", calendar.get(Calendar.MINUTE) + "");
        super.setProperty("second", calendar.get(Calendar.SECOND) + "");
    }

    @Override
    public Date getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(super.getProperty("year")));
        calendar.set(Calendar.MONTH, Integer.parseInt(super.getProperty("month")));
        calendar.set(Calendar.WEEK_OF_MONTH, Integer.parseInt(super.getProperty("week")));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(super.getProperty("day")));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(super.getProperty("hour")));
        calendar.set(Calendar.MINUTE, Integer.parseInt(super.getProperty("minute")));
        calendar.set(Calendar.SECOND, Integer.parseInt(super.getProperty("second")));
        return calendar.getTime();
    }
}