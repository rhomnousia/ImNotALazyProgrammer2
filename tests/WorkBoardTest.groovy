import WorkTimerApplication.BoardItem
import WorkTimerApplication.TimeTracker
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
        assert 2 == workBoard.getNumberOfWorkItemsOnBoard()
    }

    void testMoveWorkItemToPositionInTheFront() {

    }

    void testMoveWorkItemToPositionAtTheEnd() {

    }

    void testMoveWorkItemToPositionNumberTwo() {

    }

}

public class WorkBoard {

    private List<BoardItem> boardItems;
    private String name;
    public WorkBoard(String name, List<BoardItem> boardItems) {
        this.boardItems = boardItems;
        this.name = name;
    }
    public WorkBoard(String name) {
        this(name, new ArrayList<BoardItem>());
    }

    public int getNumberOfWorkItemsOnBoard() {
        return boardItems.size();
    }

    public int addWorkItem(WorkItem workItem) {
        boardItems.add(workItem);
        return boardItems.size();
    }

    public int removeWorkItem(int position) {
        boardItems.remove(position);
        return boardItems.size();
    }

    public void moveWorkItem(int fromPosition, int toPosition) {
        Collections.swap(boardItems, fromPosition, toPosition);

    }
}