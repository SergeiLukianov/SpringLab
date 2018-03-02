package schedule;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;


public class PrintingTask extends TimerTask {

    public void run() {
        ScheduleLog.append("I'm printing task...\n");
    }
}


