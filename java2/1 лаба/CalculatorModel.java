public class CalculatorModel {
    public double calculate(String expression) {
        try {
            return evaluate(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка в выражении: " + expression);
        }
    }

    private double evaluate(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length())
                    throw new RuntimeException("Неожиданный символ: " + (char) ch);
                return x;
            }
            
            double parseExpression() {
                double x = parseTerm();
                while (true) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parsePower();
                while (true) {
                    if (eat('*')) x *= parsePower();
                    else if (eat('/')) x /= parsePower();
                    else if (eat('%')) x %= parsePower();
                    else if (eat('/') && eat('/')) x = Math.floor(x / parsePower());
                    else return x;
                }
            }

            double parsePower() {
                double x = parseFactor();
                while (eat('^')) {
                    x = Math.pow(x, parseFactor());
                }
                return x;
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;

                if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else if (eat('(')) {
                    x = parseExpression();
                    if (!eat(')')) {
                        throw new RuntimeException("Пропущена закрывающая скобка");
                    }
                } else {
                    throw new RuntimeException("Неожиданный символ: " + (char) ch);
                }
                return x;
            }
        }.parse();
    }
}