package WorkTimerApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by joe.chandler on 12/22/13.
 */
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

    public List<BoardItem> moveWorkItem(int fromPosition, int toPosition) {
        if (isPositionOutOfRange(fromPosition) || isPositionOutOfRange(toPosition)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Collections.swap(boardItems, fromPosition - 1, toPosition - 1);

        return boardItems;
    }

    private boolean isPositionOutOfRange(int position) {
        if (position - 1 < 0 || position > boardItems.size()) {
            return true;
        }

        return false;
    }
}
