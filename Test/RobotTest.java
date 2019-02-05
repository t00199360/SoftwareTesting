
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;



public class RobotTest
{
    Robot buddy = new Robot("buddy", 4);
    
    @Rule
    public Timeout globalTimeout = Timeout.millis(100);

    @Test
    public void testGetName()
    {
       assertEquals("buddy", buddy.getName());
    }

    @Test (expected=IllegalArgumentException.class)
    public void testNoGetName()
    {
        Robot Jeff = new Robot("",5);
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void testGetAge()
    {
        assertEquals(4,buddy.getAge());
    }

    @Test
    public void testIsNotWorking()
    {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void testIsWorking()
    {
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void testWorkingMessage()
    {
        buddy.talkToRobot();
        assertEquals("i am working",buddy.getWorkingMessage());
    }

    @Test (expected= IllegalStateException.class)
    public void testNotWorkingMessage()
    {
        assertEquals("i am working",buddy.getWorkingMessage());
    }

    @Test
    public void testWaitTillWorking()
    {
        buddy.waitTillWorking();
    }
}
