public class InterviewBot {
    private String botName;
    private String technology;

    public InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    public void conductInterview() {
        System.out.println(botName + " is conducting an interview on " + technology);
    }

    public static void main(String[] args) {
        InterviewBot bot1 = new InterviewBot("JavaBot", "Java");
        InterviewBot bot2 = new InterviewBot("PyBot", "Python");
        InterviewBot bot3 = new InterviewBot("WebBot", "JavaScript");

        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}
