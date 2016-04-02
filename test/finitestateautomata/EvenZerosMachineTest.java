/*
 * The MIT License
 *
 * Copyright 2016 Christopher Wells <cwellsny@nycap.rr.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package finitestateautomata;

import junitparams.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * The <code>EvenZerosMachineTest</code> class contains tests of the
 * <code>EvenZerosMachine</code> class.
 *
 * @see finitestateautomata.EvenZerosMachine
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
@RunWith(JUnitParamsRunner.class)
public class EvenZerosMachineTest {

    /**
     * Tests exception cases of the <code>EvenZerosMachine</code> class.
     */
    @Test
    @Parameters(method = "testMachineExceptionsParameters")
    public void testMachineExceptions(String input, Class expectedException) {
        EvenZerosMachine testMachine;

        try {
            testMachine = new EvenZerosMachine(input);
            assertTrue(false);
        } catch (Exception ex) {
            assertEquals(expectedException, ex.getClass());
        }
    }

    private Object[] testMachineExceptionsParameters() {
        return new Object[] {
            new Object[]{null, new NullPointerException().getClass()},
            new Object[]{"123", new IllegalArgumentException().getClass()},
            new Object[]{"abc", new IllegalArgumentException().getClass()},
            new Object[]{"010101g", new IllegalArgumentException().getClass()},
        };
    }

    /**
     * Test several inputs and outputs for the <code>EvenZerosMachine</code>
     * class.
     */
    @Test
    @Parameters({
        "0, false",
        "01, false",
        "001, true",
        "01010101, true",
        "010101, false",
        "001, true",
        "1, true",
        ", true",
    })
    public void testMachineInput(String input, boolean expectedOutput) {
        EvenZerosMachine machine = new EvenZerosMachine(input);
        assertEquals(expectedOutput, machine.getResult());
    }

}
