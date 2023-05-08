package finalExam;

import java.util.*;

public class MessagesManager_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        Map<String, List<Integer>> usernameAndMessagesMap = new LinkedHashMap<>();
        while (!input.equals("Statistics")) {
            if (input.contains("Add")) {
                String username = input.split("=")[1];
                int sent = Integer.parseInt(input.split("=")[2]);
                int received = Integer.parseInt(input.split("=")[3]);

                if (!usernameAndMessagesMap.containsKey(username)) {
                    usernameAndMessagesMap.put(username, new ArrayList<>());
                    usernameAndMessagesMap.get(username).add(sent);
                    usernameAndMessagesMap.get(username).add(received);
                } else {
                    input = scanner.nextLine();
                    continue;
                }

            } else if (input.contains("Message")) {
                String sender = input.split("=")[1];
                String receiver = input.split("=")[2];

                if (usernameAndMessagesMap.containsKey(sender) && usernameAndMessagesMap.containsKey(receiver)) {
                    usernameAndMessagesMap.get(sender).set(0, usernameAndMessagesMap.get(sender).get(0) + 1);
                    usernameAndMessagesMap.get(receiver).set(1, usernameAndMessagesMap.get(receiver).get(1) + 1);

                    int senderMessages = usernameAndMessagesMap.get(sender).get(0) + usernameAndMessagesMap.get(sender).get(1);
                    if (senderMessages >= capacity) {
                        usernameAndMessagesMap.remove(sender);
                        System.out.println(sender + " reached the capacity!");
                    }
                    int receiverMessages = usernameAndMessagesMap.get(receiver).get(0) + usernameAndMessagesMap.get(receiver).get(1);
                    if (receiverMessages >= capacity) {
                        usernameAndMessagesMap.remove(receiver);
                        System.out.println(receiver + " reached the capacity!");
                    }
                }

            } else if (input.contains("Empty")) {
                String username = input.split("=")[1];

                if (username.equals("All")) {
                    usernameAndMessagesMap.clear();
                } else {
                    usernameAndMessagesMap.remove(username);
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Users count: %d%n", usernameAndMessagesMap.size());

        for (Map.Entry<String, List<Integer>> entry : usernameAndMessagesMap.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue().get(0) + entry.getValue().get(1));
        }

    }
}
