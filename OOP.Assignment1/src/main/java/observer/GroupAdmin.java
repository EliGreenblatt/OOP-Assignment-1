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
     * we insert a string into the group admin's UndaobleStringBuilder then update observers
     * @param offset - same as UndaobleStringBuilder
     * @param obj - same as UndoableStringBuilder
     */
    @Override
    public void insert(int offset, String obj)
    {
        ustb.insert(offset,obj);
        updateObserervers();
    }

    /**
     * we append a string to the group admin's UndoableStringBuilder then update observers
     * @param obj - same as UndoableStringBuilder
     */
    @Override
    public void append(String obj)
    {
        ustb.append(obj);
        updateObserervers();
    }

    /**
     * we delete from a starting index to an ending index then update observers
     * @param start - same as UndoableStringBuilder
     * @param end - same as UndoableStringBuilder
     */
    @Override
    public void delete(int start, int end)
    {
        ustb.delete(start,end);
        updateObserervers();
    }

    /**
     * we undo the previous action done to the group admin's UndoableStringBuilder then update observers
     */
    @Override
    public void undo()
    {
        ustb.undo();
        updateObserervers();
    }

    /**
     * we call this function after every change, to update all the observers of the change in the
     * UndoableStringBuilder
     */
    public void updateObserervers()
    {
        for ( Member member : observers)
        {
            member.update(ustb);
        }
    }
}