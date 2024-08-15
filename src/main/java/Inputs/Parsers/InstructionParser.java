package Inputs.Parsers;

import Inputs.Instruction;
import java.util.List;
import java.util.ArrayList;


import java.util.InputMismatchException;


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

                        default:
                            throw new InputMismatchException();
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

    public static List<Instruction> parseInstructions (String input) {

        List<Instruction> instructions = new ArrayList<>();
        if (input.isBlank()) {
            return null;
        }
        for (int i = 0; i < input.length(); i++) {
            instructions.add(parseInput(String.valueOf(input.charAt(i))));
        }
        return instructions;
    }


    }

