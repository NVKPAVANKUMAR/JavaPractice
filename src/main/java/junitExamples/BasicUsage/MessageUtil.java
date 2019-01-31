package junitExamples.BasicUsage;

class MessageUtil {
    private String message;

    MessageUtil(String message) {
        this.message = message;
    }

    String returnMessage() {
        System.out.println(message);
        return message;
    }
}
