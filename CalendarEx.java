package Calendar클래스;

import java.time.Year;
import java.util.Calendar;

// Calendar 클래스는 추상클래스이므로 객체 생성없이 사용,
public class CalendarEx {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int mon = now.get(Calendar.MONTH)+1;

    }
}
