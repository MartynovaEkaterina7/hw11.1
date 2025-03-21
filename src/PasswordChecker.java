public class PasswordChecker {
    private int minPasswordLength;
    private int maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Значение не должно быть меньше нуля");
        } else {
            this.minPasswordLength = minLength;
        }

    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Значение не должно быть меньше или равно нулю");
        } else {
            this.maxRepeats = maxRepeats;
        }

    }

    public boolean verify(String password) {
        if (minPasswordLength == -1 || maxRepeats == -1) {
            throw new IllegalArgumentException("Не установлены критерии проверки");
        }
        if (password.length() < minPasswordLength) {
            return false;
        }
        int count = 1;
        char prevSymbol = password.charAt(0);
        for (char symbol : password.toCharArray()) {
            if (symbol == prevSymbol) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxRepeats) {
                return false;
            }
            prevSymbol = symbol;
        }
        return true;
    }
}

