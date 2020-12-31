import static java.lang.Integer.parseInt;

public class MyInteger {

    public static Integer decode(String nm) throws NumberFormatException {
        int radix = 10;
        int index = 0;
        boolean negative = false;
        if (nm.isEmpty()) {
            throw new NumberFormatException("Zero length string");
        } else {
            char firstChar = nm.charAt(0);
            if (firstChar == '-') {
                negative = true;
                ++index;
            } else if (firstChar == '+') {
                ++index;
            }

            if (!nm.startsWith("0x", index) && !nm.startsWith("0X", index)) {
                if (nm.startsWith("#", index)) {
                    ++index;
                    radix = 16;
                } else if (nm.startsWith("0", index) && nm.length() > 1 + index) {
                    ++index;
                    radix = 8;
                }
            } else {
                index += 2;
                radix = 16;
            }

            if (!nm.startsWith("-", index) && !nm.startsWith("+", index)) {
                Integer result;
                try {
                    result = valueOf(nm.substring(index), radix);
                    result = negative ? -result : result;
                } catch (NumberFormatException var8) {
                    String constant = negative ? "-" + nm.substring(index) : nm.substring(index);
                    result = valueOf(constant, radix);
                }

                return result;
            } else {
                throw new NumberFormatException("Sign character in wrong position");
            }
        }
    }

    private static Integer valueOf(String s, int radix) throws NumberFormatException {
        return parseInt(s, radix);
    }
}
