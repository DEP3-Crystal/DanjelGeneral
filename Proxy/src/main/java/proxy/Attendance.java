package proxy;

import java.util.Date;

public class Attendance {
    private boolean isPresent;
    private Date date;

    public Attendance(boolean isPresent, Date date) {
        this.isPresent = isPresent;
        this.date = date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
