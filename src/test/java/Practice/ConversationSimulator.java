package Practice;

import java.util.Scanner;

public class ConversationSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmotionDetector detector = new EmotionDetectorImpl(); // Instantiate your EmotionDetector implementation

        System.out.println("Welcome! Simulate a customer conversation for emotion detection.");
        System.out.println("Type 'exit' to end the conversation.");

        while (true) {
            System.out.print("Customer: ");
            String customerInput = scanner.nextLine();
            if (customerInput.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("AI: " + processCustomerInput(customerInput, detector));
        }

        scanner.close();
    }

    private static String processCustomerInput(String input, EmotionDetector detector) {
        Emotion emotion = detector.detectEmotion(input); // Replace with your detection logic
        String response = "I understand.";

        switch (emotion) {
            case HAPPY:
                response = "That sounds great! How can I help you today?";
                break;
            case ANGRY:
                response = "I'm sorry to hear you're upset. Let's see how I can assist you.";
                break;
            case SAD:
                response = "I'm here to help. What's troubling you?";
                break;
            default:
                break;
        }

        return response;
    }
}

interface EmotionDetector {
    Emotion detectEmotion(String text);
}

class EmotionDetectorImpl implements EmotionDetector {
    @Override
    public Emotion detectEmotion(String text) {
        // Implement your emotion detection logic here
        // For example, you can use a third-party library or a custom algorithm
        // Placeholder implementation returning a random emotion for demonstration purposes
        int random = (int) (Math.random() * 4); // Generate a random number between 0 and 3
        switch (random) {
            case 0:
                return Emotion.HAPPY;
            case 1:
                return Emotion.ANGRY;
            case 2:
                return Emotion.SAD;
            default:
                return Emotion.NEUTRAL;
        }
    }
}

enum Emotion {
    HAPPY, ANGRY, SAD, NEUTRAL
}
