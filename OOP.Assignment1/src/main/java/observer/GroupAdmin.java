package observer;

import java.util.ArrayList;

/**
 * This is the observable class , we hold an object of type undoablestringbuilder
 * when someone wishes to observe we register him to the observer list and update his object of type
 * UndoableStringBuilder to ours.
 */
public class GroupAdmin implements Sender
{
    UndoableStringBuilder ustb = new UndoableStringBuilder();
    ArrayList<Member> observers = new ArrayList<Member>();


    /**
     * we add the incoming member to our array list and update his UndoableStringBuilder to the admin's one
     * @param obj - the observer who would like to observe the UndoableStringBuilder in this class
     */
    @Override
    public void register(Member obj)
    {
        observers.add(obj);
        obj.update(ustb);
    }

    /**
     * we remove the incoming member from our array list
     * @param obj
     */
    @Override
    public void unregister(Member obj)
    {
        observers.remove(obj);
    }

    /**
     * we insert a string into the group admin's UndaobleStringBuilder
     * @param offset - same as UndaobleStringBuilder
     * @param obj - same as UndoableStringBuilder
     */
    @Override
    public void insert(int offset, String obj)
    {
        ustb.insert(offset,obj);
    }

    /**
     * we append a string to the group admin's UndoableStringBuilder
     * @param obj - same as UndoableStringBuilder
     */
    @Override
    public void append(String obj)
    {
        ustb.append(obj);
    }

    /**
     * we delete from a starting index to an ending index
     * @param start - same as UndoableStringBuilder
     * @param end - same as UndoableStringBuilder
     */
    @Override
    public void delete(int start, int end)
    {
        ustb.delete(start,end);
    }

    /**
     * we undo the previous action done to the group admin's UndoableStringBuilder
     */
    @Override
    public void undo()
    {
        ustb.undo();
    }
}