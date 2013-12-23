import WorkTimerApplication.TimeTracker
import WorkTimerApplication.WorkItem

/**
 * Created by Johan on 12/8/13.
 */

class WorkItemTest extends GroovyTestCase {
    void testStopItemTimer() {
        def wItem = new WorkItem("Test Title", new TimeTracker())

        wItem.startItemTimer()
        wItem.stopItemTimer()
        assert wItem.getTotalWorkTime() > 0
    }

    void testPauseItemTimerOnePause() {
        def wItem = new WorkItem("Test Title", new TimeTracker())

        wItem.startItemTimer()
        wItem.pauseItemTimer("Test Pause")
        wItem.resumeItemTimer()
        wItem.stopItemTimer()

        assert wItem.numberOfInterruptions == 1
        assert wItem.timeSpentOnInterruptions > 0
    }


    void testPauseItemTimerTwoPauses() {
        def wItem = new WorkItem("Test Title", new TimeTracker())

        wItem.startItemTimer()

        def startTestTime = System.nanoTime();
        wItem.pauseItemTimer("Test Pause")
        wItem.resumeItemTimer()
        wItem.pauseItemTimer("Test Pause")
        wItem.resumeItemTimer()
        def resultTime = System.nanoTime() - startTestTime

        wItem.stopItemTimer()

        assert wItem.numberOfInterruptions == 2
        assert wItem.timeSpentOnInterruptions <= resultTime
    }

    void startItemTimerTwiceInARow() {

    }
}
