package WorkTimerApplication;

import java.util.List;

/**
 * Created by Johan on 12/22/13.
 */
public interface BoardItem {
    String getTitle();

    String getDescription();

    void setDescription(String description);

    void startItemTimer();

    void stopItemTimer();

    long getTotalWorkTime();

    void pauseItemTimer(String reasonForPausing);

    void resumeItemTimer();

    List<Interruption> getInterruptions();

    long getTimeSpentOnInterruptions();

    int getNumberOfInterruptions();
}
