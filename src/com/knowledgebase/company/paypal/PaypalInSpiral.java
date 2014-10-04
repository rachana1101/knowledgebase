package com.knowledgebase.company.paypal;

/**
 * The string "paypal is the faster, safer way to send money" is written in a
clockwise spiral pattern inside a square starting from the upper left
corner:
(you may want to display this pattern in a fixed font for better legibility).

    P A Y P A L
    F E R W A I
    A M O N Y S
    S D Y E T T
    R N E S O H
    E T S A F E

Then read line after line:
    PAYPALFERWAIAMONYSSDYETTRNESOHETSAFE

Write the code that will take a string, calculate the minimum square that
will contain it and return the converted string:

String convert(String text);

convert("paypalisthefastersaferwaytosendmoney") should return
"paypalferwaiamonyssdyettrnesohetsafe" 


 * @author rachana
 *
 */
public class PaypalInSpiral {
    
    public static void main(String[] argv) {
        String input = "paypalisthefastersaferwaytosendmoney";
        System.out.println(convert(input));
    }
    
    private enum Dir {

        RIGHT, DOWN, LEFT, UP;
    }

    public static String convert(String input) {
        double dRoot = Math.sqrt(input.length());
        int root;
        if (Double.compare(dRoot, (int) dRoot) == 0) {
            root = (int) dRoot;
        } else {
            root = (int) dRoot + 1;
        }
        System.out.println(">>>>> "+root);
        char[][] out = new char[root][root];

        spiral(out, 0, 0, root, input);
        StringBuilder sb = new StringBuilder();

        for (char[] line : out) {
            sb.append(line);
        }

        return sb.toString();
    }

    private static void spiral(char[][] out, int i, int j, int size, String input) {
        Dir direction = Dir.RIGHT;

        if (size > 0) {
            if (size == 1) {
                out[i][j] = input.charAt(0);
            } else {
                for (int k = 0; k < 4 * (size - 1); k++) {
                    int di = (k != 0 && k % (size - 1) == 0 ? size - 1 : k % (size - 1));
                    System.out.println(" di "+di);
                    switch (direction) {
                        case RIGHT:
                            out[i][j + di] = input.charAt(k);
                            break;
                        case DOWN:
                            out[i + di][j + size - 1] = input.charAt(k);
                            break;
                        case LEFT:
                            out[i + size - 1][j + size - 1 - di] = input.charAt(k);
                            break;
                        case UP:
                            out[i + size - 1 - di][j] = input.charAt(k);
                            break;
                    }
                    if (k != 0 && (k % (size - 1) == 0)) //Change direction
                    {
                        direction = Dir.values()[direction.ordinal() + 1];
                    }
                }
            }
            spiral(out, i + 1, j + 1, size - 2, input.substring(4 * (size - 1)));
        } else {
            return;
        }
    }
}
