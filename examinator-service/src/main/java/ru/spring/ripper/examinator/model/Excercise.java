package ru.spring.ripper.examinator.model;

/**
 * Created by dkorolev on 9/5/2018.
 */
public class Excercise {

    private String question;

    private String answer;



    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
