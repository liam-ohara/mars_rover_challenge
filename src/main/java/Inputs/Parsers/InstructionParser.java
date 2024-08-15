package Inputs.Parsers;

import Inputs.Instruction;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class InstructionParser  {

    public static Instruction parseInput(String input) {

        Instruction result = null;

        if (input.isBlank()) {
            return null;
        }
        try {

            if (input.toUpperCase().matches("^(L*R*M*)*")) {

                    switch (input.toUpperCase()) {
                        case "L":
                            result = Instruction.L;
                            break;

                        case "R":
                            result = Instruction.R;
                            break;

                        case "M":
                            result = Instruction.M;
                            break;
                    }
                } else {
                    throw new InputMismatchException();
                }
            }
                 catch (InputMismatchException e) {
                    throw new InputMismatchException ("Instructions must contain only 'L', 'R' or 'M' characters without spaces");
                }
        return result;
    }


    }

