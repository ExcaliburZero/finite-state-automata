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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The <code>EvenZerosMachineTest</code> class contains tests of the
 * <code>EvenZerosMachine</code> class.
 *
 * @see finitestateautomata.EvenZerosMachine
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class EvenZerosMachineTest {

    /**
     * Runs tests of the <code>EvenZerosMachine</code> class.
     */
    @Test
    public void machineTest() {
        EvenZerosMachine testMachine = new EvenZerosMachine("01010101");
        assertTrue(testMachine.getResult());

        testMachine = new EvenZerosMachine("010101");
        assertFalse(testMachine.getResult());

        testMachine = new EvenZerosMachine("01010");
        assertFalse(testMachine.getResult());

        testMachine = new EvenZerosMachine("0");
        assertFalse(testMachine.getResult());

        testMachine = new EvenZerosMachine("");
        assertTrue(testMachine.getResult());

        try {
            testMachine = new EvenZerosMachine(null);
            assertTrue(false);
        } catch (NullPointerException ex) {
            assertTrue(true);
        }

        try {
            testMachine = new EvenZerosMachine("123");
            assertTrue(false);
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }

}
