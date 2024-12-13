package jobportal;

import java.util.Date;

public class Notification {
    private String message;
    private Date date;

    public Notification(String message) {
        this.message = message;
        this.date = new Date(); // Automatically set the current date and time
    }

    public void sendNotification() {
        System.out.println("Notification sent: " + message + " on " + date);
    }

    public void deleteNotification() {
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
