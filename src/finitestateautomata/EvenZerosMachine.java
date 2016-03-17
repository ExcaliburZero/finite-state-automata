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

import static finitestateautomata.EvenZerosMachineState.*;

/**
 * The <code>EvenZerosMachine</code> is used to represent a finite state
 * automata that accepts Strings containing an even number of zeros.
 * <br><br>
 * It accepts Strings over the language {0,1}.
 *
 * @see finitestateautomata.EvenZerosMachineState
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class EvenZerosMachine {

    private EvenZerosMachineState state;
    private final boolean result;

    /**
     * Initializes a <code>EvenZerosMachine</code> object with the given input
     * String.
     *
     * @param inputString The input of the machine.
     */
    public EvenZerosMachine(String inputString) {
        // Check for valid input
        if (inputString == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) != '0' && inputString.charAt(i) != '1') {
                throw new IllegalArgumentException();
            }
        }

        this.state = EVEN_ZEROS;
        this.result = this.processInput(inputString);
    }

    /**
     * Returns the result of the processing of the machine.
     *
     * @return <code>true</code> if the input was accepted, and
     * <code>false</code> if it was rejected.
     */
    public boolean getResult() {
        return this.result;
    }

    /**
     * Processes the input of the machine and returns the result.
     *
     * @param inputString The input of the machine.
     * @return <code>true</code> if the input was accepted, and
     * <code>false</code> if it was rejected.
     */
    private boolean processInput(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            this.delta(inputString.charAt(i));
        }

        return this.state == EVEN_ZEROS;
    }

    /**
     * Performs a move of the machine.
     *
     * @param inputCharacter The character representing the move of the machine.
     */
    private void delta(char inputCharacter) {
        if (inputCharacter == '0') {
            switch (this.state) {
                case EVEN_ZEROS:
                    this.state = ODD_ZEROS;
                    break;
                case ODD_ZEROS:
                    this.state = EVEN_ZEROS;
                    break;
            }
        }
    }
}
