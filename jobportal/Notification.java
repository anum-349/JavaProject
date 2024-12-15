package jobportal;
import java.util.Date;

class Notification {
    private String message;
    private Date date;

    public Notification(String message) {
        this.message = message;
        this.date = new Date();
    }
    public void sendNotification() {
        System.out.println("Notification sent: " + message + " on " + date);
    }

    public static Notification createNotification(String eventType, String jobTitle) {
        String message;
        switch (eventType) {
            case "application":
                message = "Your job application for '" + jobTitle + "' has been submitted.";
                break;
            case "recommendation":
                message = "We recommend you check out this new job posting: '" + jobTitle + "'.";
                break;
            case "hired":
                message = "Congratulations! You've been hired for the '" + jobTitle + "' position.";
                break;
            default:
                throw new IllegalArgumentException("Invalid event type: " + eventType);
        }
        return new Notification(message);
    }

    public void deleteNotification() {
        if (message == null) {
            System.out.println("Notification already deleted.");
            return;
        }
        System.out.println("Notification deleted: " + message);
        this.message = null;
        this.date = null;
    }

    public void viewNotification() {
        if (message != null) {
            System.out.println("Notification: " + message + ", Date: " + date);
        } else {
            System.out.println("No notifications available.");
        }
    }
}