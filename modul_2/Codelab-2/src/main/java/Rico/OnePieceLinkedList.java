class Island {
    String name;
    Island next;

    // 1. Map Structure: Constructor
    public Island(String name) {
        this.name = name;
        this.next = null;
    }
}

public class OnePieceLinkedList {
    private Island head;

    // Chart Course: Add to end
    public void addIsland(String name) {
        Island newIsland = new Island(name);
        if (head == null) {
            head = newIsland;
            return;
        }
        Island temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newIsland;
    }

    // 2. Buster Call: Delete island
    public void busterCall(String name) {
        if (head == null) return;
        if (head.name.equals(name)) {
            head = head.next;
            return;
        }
        Island current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // 3. Logbook: Traversal
    public void printLogbook() {
        Island temp = head;
        System.out.print("Grand Line Route: ");
        while (temp != null) {
            System.out.print(temp.name + (temp.next != null ? " -> " : " (End)\n"));
            temp = temp.next;
        }
    }

    // 4. Check: Search
    public boolean isIslandOnRoute(String name) {
        Island temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return true;
            temp = temp.next;
        }
        return false;
    }

    // 5. Adventure Count: Tally
    public int countIslands() {
        int count = 0;
        Island temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        OnePieceLinkedList route = new OnePieceLinkedList();
        route.addIsland("Alabasta");
        route.addIsland("Skypiea");
        route.addIsland("Water 7");
        route.addIsland("Enies Lobby");

        route.printLogbook();
        System.out.println("Visited Fishman Island? " + route.isIslandOnRoute("Fishman Island"));

        System.out.println("Buster Call initiated on Enies Lobby!");
        route.busterCall("Enies Lobby");

        route.printLogbook();
        System.out.println("Total Islands visited: " + route.countIslands());
    }
}