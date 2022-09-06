package proxy;

public class StudentProxy extends  Student{

    public  StudentProxy(Attendance attendance) {
        super(attendance);
    }
    public void attendLesson() {
        if(super.getAttendance().isPresent())
        super.attendLesson();
        else throw new RuntimeException("student is not present");
    }
}
