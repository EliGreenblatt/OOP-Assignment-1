import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests
{
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    GroupAdmin ga = new GroupAdmin();
    ConcreteMember member1 = new ConcreteMember();
    ConcreteMember member2 = new ConcreteMember();
    ConcreteMember member3 = new ConcreteMember();
    ConcreteMember member4 = new ConcreteMember();

    @Test
    public void testObservers()
    {
        // we register members to a group admin and check the functionality if it affects all the members
        // in the observers list

        ga.register(member1);
        ga.register(member2);
        ga.register(member3);
        ga.register(member4);

        ga.append("test");
        assertEquals("test" , member1.toString());
        assertEquals("test" , member2.toString());
        assertEquals("test" , member3.toString());
        assertEquals("test" , member4.toString());

        ga.delete(0,2);
        assertEquals("st" , member1.toString());
        assertEquals("st" , member2.toString());
        assertEquals("st" , member3.toString());
        assertEquals("st" , member4.toString());

        ga.undo();
        assertEquals("test" , member1.toString());
        assertEquals("test" , member2.toString());
        assertEquals("test" , member3.toString());
        assertEquals("test" , member4.toString());

    }
    @Test
    public void checkSize()
    {
        // after running this test we conclude each time we register a member to Group Admin
        // its total object size grows by 16 memory blocks
        logger.info(() -> ("Group admin size without registered members ") +JvmUtilities.objectTotalSize(ga));
        ga.register(member1);
        logger.info(() -> ("Group admin size with one registered members ") + JvmUtilities.objectTotalSize(ga));
        ga.register(member2);
        logger.info(() -> ("Group admin size with two registered members ") +JvmUtilities.objectTotalSize(ga));
        ga.register(member3);
        logger.info(() -> ("Group admin size with three registered members ") +JvmUtilities.objectTotalSize(ga));
        ga.register(member4);
        logger.info(() -> ("Group admin size with four registered members ") +JvmUtilities.objectTotalSize(ga));

        // after running this test we conclude when we undo an action we get the same amount of memory usage
        // as before we did the action
        ga.append("t");
        logger.info(() -> ("Group admin size after appending a string ") +JvmUtilities.objectTotalSize(ga));
        ga.undo();
        logger.info(() -> ("Group admin size after undoing previous action ") +JvmUtilities.objectTotalSize(ga));
    }

    @Test
    public void sizeAffected()
    {
        // with this test we can see the fields that were affected when we registered members and appended a string
        logger.info(() -> JvmUtilities.objectFootprint(ga));
        ga.register(member1);
        ga.register(member2);
        ga.register(member3);
        ga.register(member4);
        ga.append("Test");
        logger.info(() -> JvmUtilities.objectFootprint(ga));
    }
}
