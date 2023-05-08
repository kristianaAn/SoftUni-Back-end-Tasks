package final_Exam_Preparation_01;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> piecesAndComposer = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String pieceData = scanner.nextLine();
            String piece = pieceData.split("\\|")[0];
            String composer = pieceData.split("\\|")[1];
            String button = pieceData.split("\\|")[2];

            piecesAndComposer.put(piece, new ArrayList<>());
            piecesAndComposer.get(piece).add(composer);
            piecesAndComposer.get(piece).add(button);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            if (input.contains("Add")) {
                String pieceToAdd = input.split("\\|")[1];
                String composerToAdd = input.split("\\|")[2];
                String keyToAdd = input.split("\\|")[3];

                if (!piecesAndComposer.containsKey(pieceToAdd)) {
                    piecesAndComposer.put(pieceToAdd, new ArrayList<>());
                    piecesAndComposer.get(pieceToAdd).add(composerToAdd);
                    piecesAndComposer.get(pieceToAdd).add(keyToAdd);
                    System.out.printf("%s by %s in %s added to the collection!%n", pieceToAdd, composerToAdd, keyToAdd);
                } else {
                    System.out.println(pieceToAdd + " is already in the collection!");
                }

            } else if (input.contains("Remove")) {
                String pieceToRemove = input.split("\\|")[1];

                if (piecesAndComposer.containsKey(pieceToRemove)) {
                    piecesAndComposer.remove(pieceToRemove);
                    System.out.println("Successfully removed " + pieceToRemove + "!");
                } else {
                    System.out.println("Invalid operation! " + pieceToRemove + " does not exist in the collection.");
                }

            } else if (input.contains("ChangeKey")) {
                String pieceToChange = input.split("\\|")[1];
                String newKey = input.split("\\|")[2];

                if (piecesAndComposer.containsKey(pieceToChange)) {
                    piecesAndComposer.get(pieceToChange).set(1, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", pieceToChange, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToChange);
                }
            }


            input = scanner.nextLine();
        }

        piecesAndComposer.entrySet().forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

    }
}
