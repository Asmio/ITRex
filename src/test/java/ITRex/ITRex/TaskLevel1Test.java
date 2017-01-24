package ITRex.ITRex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TaskLevel1Test {

    @Test
    public void testSimplify_text() {
	String actual = TaskLevel1.simplifyText("success");
	assertEquals("sukses", actual);
    }

}
