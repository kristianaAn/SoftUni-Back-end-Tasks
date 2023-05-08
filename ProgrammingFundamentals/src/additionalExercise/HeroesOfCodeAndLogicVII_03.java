package additionalExercise;

import java.util.*;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroAndHpMp = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String hero = scanner.nextLine();
            String heroName = hero.split(" ")[0];
            int hp = Integer.parseInt(hero.split(" ")[1]);
            int mp = Integer.parseInt(hero.split(" ")[2]);

            if (!heroAndHpMp.containsKey(heroName)) {
                heroAndHpMp.put(heroName, new ArrayList<>());
                heroAndHpMp.get(heroName).add(hp);
                heroAndHpMp.get(heroName).add(mp);
            }
        }

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("End")) {
            if (inputCommand.contains("CastSpell")) {
                String hero = inputCommand.split(" - ")[1];
                int mp = Integer.parseInt(inputCommand.split(" - ")[2]);
                String spellName = inputCommand.split(" - ")[3];

                if (heroAndHpMp.containsKey(hero)) {
                    int initialMp = heroAndHpMp.get(hero).get(1);
                    if (initialMp >= mp) {
                        int newMp = initialMp;
                        newMp -= mp;
                        heroAndHpMp.get(hero).set(1, newMp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", hero, spellName, newMp);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", hero, spellName);
                    }
                }

            } else if (inputCommand.contains("TakeDamage")) {
                String hero = inputCommand.split(" - ")[1];
                int damage = Integer.parseInt(inputCommand.split(" - ")[2]);
                String attacker = inputCommand.split(" - ")[3];

                if (heroAndHpMp.containsKey(hero)) {
                   int initialHp = heroAndHpMp.get(hero).get(0);
                   int newHp = initialHp;
                   newHp -= damage;

                   if (newHp > 0) {
                       System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero,damage, attacker, newHp);
                       heroAndHpMp.get(hero).set(0, newHp);
                   } else {
                       heroAndHpMp.remove(hero);
                       System.out.printf("%s has been killed by %s!%n", hero, attacker);
                   }
                }

            } else if (inputCommand.contains("Recharge")) {
                String hero = inputCommand.split(" - ")[1];
                int amountMp = Integer.parseInt(inputCommand.split(" - ")[2]);

                int newMp = 0;
                if (heroAndHpMp.containsKey(hero)) {
                    int initialMp = heroAndHpMp.get(hero).get(1);
                    newMp = initialMp + amountMp;

                    if (newMp > 200) {
                        newMp = 200;
                    }

                    heroAndHpMp.get(hero).set(1, newMp);

                    System.out.printf("%s recharged for %d MP!%n", hero, newMp - initialMp);
                }

            } else if (inputCommand.contains("Heal")) {
                String hero = inputCommand.split(" - ")[1];
                int amountHp = Integer.parseInt(inputCommand.split(" - ")[2]);

                int newHp = 0;
                if (heroAndHpMp.containsKey(hero)) {
                    int initialHp = heroAndHpMp.get(hero).get(0);
                    newHp = initialHp + amountHp;

                    if (newHp > 100) {
                        newHp = 100;
                    }

                    heroAndHpMp.get(hero).set(0, newHp);

                    System.out.printf("%s healed for %d HP!%n", hero, newHp - initialHp);
                }

            }

            inputCommand = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : heroAndHpMp.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            System.out.printf("  HP: %d%n", entry.getValue().get(0));
            System.out.printf("  MP: %d%n", entry.getValue().get(1));
        }

    }
}
