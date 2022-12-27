package observer;
import java.util.Stack;

public class UndoableStringBuilder
{
    StringBuilder st;
    Stack <String> stack = new Stack<>();

    /**
     * class constructor takes no arguments and sets the string builder
     */
    public UndoableStringBuilder()
    {
        st = new StringBuilder();
    }

    /**
     * takes a string from the user and appends it
     * to the current string of the stack builder
     * @param str from user
     * @return this class
     */
    public UndoableStringBuilder append(String str)
    {
        st.append(str);
        stack.push(st.toString());
        return this;
    }

    /**
     * takes two integers from user
     * deletes the string from start
     * index to last index
     * @param start index to delete from
     * @param end index to delete up until
     * @return this class
     */
    public UndoableStringBuilder delete(int start, int end)
    {
        try
        {
            st.delete(start, end);
            stack.push(st.toString());
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.err.println("Can't delete out of bounds exception");
            return null;
        }
        return this;
    }

    /**
     * takes an int and string from user and inserts
     * that string into the string builder string from
     * the starting int as an index
     * @param offset where to start insert from
     * @param str string to insert from the offset
     * @return this class
     */
    public UndoableStringBuilder insert(int offset , String str)
    {
        try
        {
            st.insert(offset, str);
            stack.push(st.toString());
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.err.println("Can't insert , out of bounds");
            return null;
        }

        return this;
    }

    /**
     * takes two integers from the user and a string
     * and replaces the current stack builder string with
     * the replaced one.
     * @param start index to replace from
     * @param end up until where to replace
     * @param str the string to insert instead of what's there
     * @return this class
     */
    public UndoableStringBuilder replace(int start, int end, String str)
    {
        try
        {
            st.replace(start, end, str);
            stack.push(st.toString());
        }
        catch (NullPointerException e)
        {
            System.err.println("Cannot replace the string with a null value");
            return null;
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.err.println("Can't replace, out of bounds exception");
            return null;
        }
        return this;
    }

    /**
     * reverses the string from the string builder
     * @return this class
     */
    public UndoableStringBuilder reverse()
    {
        st.reverse();
        stack.push(st.toString());
        return this;
    }

    /**
     * to string function gets called automatically
     * when we print the object of class
     * @return the string inside the stack
     */
    public String toString()
    {
        if (stack.isEmpty()) return null;
        return stack.peek();
    }

    /**
     * we undo the previous action done by the user
     * if stack is empty we return , if not pop it then check
     * if stack is empty after popping we set the string builder
     * length to 0. if it's not empty , we update the string builder
     * to the relevant string.
     */
    public void undo()
    {
        if(stack.isEmpty())
        {
            return;
        }

        stack.pop();

        if(stack.isEmpty())
        {
            if(!st.isEmpty())
            {
                st.setLength(0);
            }
        }
        else
        {
            st.replace(0,st.length() + 1,stack.peek());
        }

    }

}

