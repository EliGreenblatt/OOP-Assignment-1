package observer;

/**
 * This class is an observer class that implements member Interface
 */
public class ConcreteMember implements Member
{
    UndoableStringBuilder ustb;

    /**
     * in this function we set the observers field to point to the group admins field
     * @param usb - we take in the group admin's undoablestringbuilder
     */
    public void update(UndoableStringBuilder usb)
    {
        ustb = usb;
    }

    /**
     * we print the default to string function from undoablestringbuilder
     * @return the undoablestringbuilder to string function
     */
    public String toString()
    {
        return ustb.toString();
    }
}

