package ITRex.ITRex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Task_l1Test {

    @Test
    public void testSimplify_text() {
	String actual = Task_l1.simplifyText("success");
	assertEquals("sukses", actual);
    }

}
