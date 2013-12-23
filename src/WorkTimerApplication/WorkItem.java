package WorkTimerApplication;

import WorkTimerApplication.BasicInterruption;
import WorkTimerApplication.Interruption;
import WorkTimerApplication.TimeTracker;

import java.util.ArrayList;
import java.util.List;

public class WorkItem implements BoardItem {

    private final String title;
    private final TimeTracker timeTracker;
    private List<Interruption> interruptions;
    public WorkItem(String title, TimeTracker timeTracker) {
        this.title = title;
        this.timeTracker = timeTracker;
        interruptions = new ArrayList<Interruption>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    private String description;
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void startItemTimer() {
        timeTracker.startTimeTracking();
    }

    private long totalWorkTime;
    @Override
    public void stopItemTimer() {
        totalWorkTime += timeTracker.endTimeTracking();
        timeTracker.resetTracker();
    }

    @Override
    public long getTotalWorkTime() {
        return totalWorkTime;
    }

    private BasicInterruption basicInterruption;
    @Override
    public void pauseItemTimer(String reasonForPausing) {
        timeTracker.pauseTimeTrackingTemporarily();
        basicInterruption = new BasicInterruption(reasonForPausing);
    }

    @Override
    public void resumeItemTimer() {
        final long elapsedPausedTime;
        elapsedPausedTime = timeTracker.resumeTimeTracking();
        basicInterruption.setLengthOfTimeOfInterruption(elapsedPausedTime);

        interruptions.add(basicInterruption);
    }

    @Override
    public List<Interruption> getInterruptions() {
        return interruptions;
    }

    @Override
    public long getTimeSpentOnInterruptions() {
        long timeSpentOnInterruptions = 0;
        for(Interruption stoppage : interruptions) {
            timeSpentOnInterruptions += stoppage.getLengthOfTimeOfInterruption();
        }

        return timeSpentOnInterruptions;
    }

    @Override
    public int getNumberOfInterruptions() {
        return interruptions.size();
    }
}
