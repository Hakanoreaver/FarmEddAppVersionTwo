package com.csit321.farmeddversion2.Objects;


public class ResponseResponse {
    int questionId;
    String question;
    String reply;

    public ResponseResponse() {
        super();
    }

    public ResponseResponse(int questionId, String reply, String question) {
        this.question = question;
        this.questionId = questionId;
        this.reply = reply;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String toString() {
        return questionId + " " + question;
    }
}
