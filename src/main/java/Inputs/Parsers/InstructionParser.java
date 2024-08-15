package Inputs.Parsers;

import Inputs.Instruction;

public class InstructionParser  {

    public static Instruction parseInput(String input) {

        Instruction result = null;

        if (input.isBlank()) {
            return null;
        }
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

        return result;
    }
}
