package lection_14_AssociativeArrays_Exercise;

import java.util.*;

public class ForceBook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Map<String, List<String>> forceAndUser = new LinkedHashMap<>();
        while (!inputLine.equals("Lumpawaroo")) {
            if (inputLine.contains("|")) {
                String team = inputLine.split(" \\| ")[0];
                String player = inputLine.split(" \\| ")[1];

                if (!forceAndUser.containsKey(team)) {
                    forceAndUser.put(team, new ArrayList<>());
                }
                boolean isExistingAnywhere = false;

                for (List<String> list : forceAndUser.values()) {
                    if (list.contains(player)) {
                        isExistingAnywhere = true;
                    }
                }

                if (!isExistingAnywhere) {
                    forceAndUser.get(team).add(player);
                }

            } else if (inputLine.contains(" -> ")) {
                String forceUser = inputLine.split(" -> ")[0];
                String forceSide = inputLine.split(" -> ")[1];

                forceAndUser.entrySet().forEach(entry -> entry.getValue().remove(forceUser));

                if (forceAndUser.containsKey(forceSide)) {
                    List<String> currentPlayers = forceAndUser.get(forceSide);
                    currentPlayers.add(forceUser);
                } else {
                    forceAndUser.put(forceSide, new ArrayList<>());
                    forceAndUser.get(forceSide).add(forceUser);
                }

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

            }
            inputLine = scanner.nextLine();
        }

        forceAndUser.entrySet().

                stream().

                filter(entry -> entry.getValue().

                        size() > 0).

                forEach(stringListEntry ->

                        {
                            System.out.printf("Side: %s, Members: %d%n", stringListEntry.getKey(), stringListEntry.getValue().size());
                            stringListEntry.getValue().forEach(entry -> System.out.printf("! %s%n", entry));
                        }
                );

    }
}
