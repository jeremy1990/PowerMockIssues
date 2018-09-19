public enum EnumInnerClassContext {
    MEMBER1 {
        @Override
        public void toBeOverriden() {
            final CreationInEnumInnerClass innerClass = new CreationInEnumInnerClass();
            if (innerClass.isCorrect("A")) {
                printCorrect();
            } else {
                printIncorrect();
            }
        }
    };

    public void printCorrect() {
        System.out.println("correct");
    }

    public void printIncorrect() {
        System.out.println("incorrect");
    }

    public abstract void toBeOverriden();
}

class CreationInEnumInnerClass {
    boolean isCorrect(final String toTest) {
        return "A".equals(toTest);
    }
}
