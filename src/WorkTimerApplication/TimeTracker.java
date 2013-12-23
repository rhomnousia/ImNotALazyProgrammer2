package WorkTimerApplication;

/**
 * Created by Johan on 12/8/13.
 */
public class TimeTracker {
    public TimeTracker() {
    }

    private long startTime;
    public void startTimeTracking() {
        if (startTime != 0) {
            return;
        }
        startTime = System.nanoTime();
    }

    private long startPauseTime;
    public void pauseTimeTrackingTemporarily() {
        startPauseTime = System.nanoTime();
    }

    private long totalPauseTime;
    private int numberOfPauses;
    public long resumeTimeTracking() {
        long endPauseTime;
        endPauseTime = System.nanoTime();
        totalPauseTime += endPauseTime - startPauseTime;
        numberOfPauses++;

        long elapsedPauseTime;
        elapsedPauseTime = endPauseTime - startPauseTime;

        return elapsedPauseTime;
    }

    private long totalTimeTracked;
    public long endTimeTracking() {
        long endTime;
        endTime = System.nanoTime();
        totalTimeTracked += endTime - startTime - totalPauseTime;

        return totalTimeTracked;
    }

    public void resetTracker() {
        startTime = 0;
        totalTimeTracked = 0;
        totalPauseTime = 0;
        numberOfPauses = 0;
    }

    public long getTotalTimeTrackedInNanoSecs() {
        return totalTimeTracked;
    }

    public long getTotalPauseTimeInNanoSecs() {
        return totalPauseTime;
    }

    public int getNumberOfPauses() {
        return numberOfPauses;
    }

}
