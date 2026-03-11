package org.sky.exam.model;

public record Question(String question, String answer) {
    //private final String theme;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return ((Question) obj).question.equals(this.question) && ((Question) obj).answer.equals(this.answer);
    }

}
