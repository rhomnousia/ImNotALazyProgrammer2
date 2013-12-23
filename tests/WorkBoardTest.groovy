import WorkTimerApplication.TimeTracker
import WorkTimerApplication.WorkBoard
import WorkTimerApplication.WorkItem

/**
 * Created by Johan on 12/15/13.
 */
class WorkBoardTest extends GroovyTestCase {

    def workItemList = [
                            new WorkItem("work item 1", new TimeTracker()),
                            new WorkItem("work item 2", new TimeTracker()),
                            new WorkItem("work item 3", new TimeTracker())
                       ].toList()

    def timer = new TimeTracker()
    def description = "test description"
    void testAddWorkItemsExpect1FromAddingToEmptyWorkBoard() {
        def workBoard = new WorkBoard("test workday")
        def numOfItems = workBoard.addWorkItem(new WorkItem(description,timer))
        assert numOfItems == 1
    }

    void testWorkBoardSizeWhenItemsOnBoardIs3Expect3() {
        def workBoard = new WorkBoard("test work board", workItemList)
        def workBoardSize = workBoard.getNumberOfWorkItemsOnBoard()
        assert 3 == workBoardSize
    }

    void testRemoveWorkItemFromPosition1Of3ExpectSize2() {
        def workBoard = new WorkBoard("test work board", workItemList)
        def workBoardSize = workBoard.removeWorkItem(1)
        assert 2 == workBoardSize
    }

    void testSwapWorkItemFromPosition3to1ExceptWorkItem3InPosition0() {
        def workBoard = new WorkBoard("test work board", workItemList)
        def itemOne = workItemList.get(0).getTitle()
        def itemThree = workItemList.get(2).getTitle()
        def boardList = workBoard.moveWorkItem(3,1)
        assert itemThree == boardList.get(0).getTitle()
    }
}

