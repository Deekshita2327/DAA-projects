import java.util.*;

public class Project13_Knapsack_BnB {

    static class Item {
        int id, weight, profit;
        double ratio;

        Item(int id, int weight, int profit) {
            this.id = id;
            this.weight = weight;
            this.profit = profit;
            this.ratio = (double) profit / weight;
        }
    }

    static class Node {
        int level, weight, profit;
        double bound;
        String decision;
        Node parent, left, right;
        boolean pruned;
        String path;

        Node(int level, int weight, int profit, double bound,
             String decision, Node parent, String path) {
            this.level = level;
            this.weight = weight;
            this.profit = profit;
            this.bound = bound;
            this.decision = decision;
            this.parent = parent;
            this.path = path;
        }
    }

    static int capacity = 10;
    static Item[] items = {
        new Item(1, 2, 3),
        new Item(2, 3, 4),
        new Item(3, 4, 5),
        new Item(4, 5, 6)
    };

    static int bestProfit = 0;
    static int bestWeight = 0;
    static List<Integer> bestItems = new ArrayList<>();

    static double calculateBound(int level, int weight, int profit) {
        if (weight > capacity) return profit;

        double bound = profit;
        int totalWeight = weight;
        int i = level;

        // Take complete remaining items while possible.
        while (i < items.length && totalWeight + items[i].weight <= capacity) {
            totalWeight += items[i].weight;
            bound += items[i].profit;
            i++;
        }

        // Take a fractional part of the next item for the upper bound.
        if (i < items.length) {
            bound += (capacity - totalWeight) * items[i].ratio;
        }

        return bound;
    }

    static Node buildTree(int level, int weight, int profit,
                          Node parent, String decision, String path) {

        double bound = calculateBound(level, weight, profit);
        Node node = new Node(level, weight, profit, bound, decision, parent, path);

        if (weight > capacity || bound <= bestProfit || level == items.length) {
            node.pruned = (weight > capacity || bound <= bestProfit);
            if (weight <= capacity && profit > bestProfit) {
                bestProfit = profit;
                bestWeight = weight;
                bestItems.clear();
                collectItems(path);
            }
            return node;
        }

        Item current = items[level];

        // Include current item.
        node.left = buildTree(
            level + 1,
            weight + current.weight,
            profit + current.profit,
            node,
            "Include Item " + current.id,
            path + "I"
        );

        // Exclude current item.
        node.right = buildTree(
            level + 1,
            weight,
            profit,
            node,
            "Exclude Item " + current.id,
            path + "E"
        );

        return node;
    }

    static void collectItems(String path) {
        bestItems.clear();
        for (int i = 0; i < path.length() && i < items.length; i++) {
            if (path.charAt(i) == 'I') bestItems.add(items[i].id);
        }
    }

    static void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) return;

        String branch = node.parent == null ? "ROOT" : (isLeft ? "├── " : "└── ");
        String status = node.pruned ? " [PRUNED]" : "";

        System.out.printf(
            "%s%s%s | Level=%d Weight=%d Profit=%d Bound=%.2f%s%n",
            prefix, branch, node.decision,
            node.level, node.weight, node.profit, node.bound, status
        );

        String childPrefix = prefix + (node.parent == null ? "" : (isLeft ? "│   " : "    "));
        printTree(node.left, childPrefix, true);
        printTree(node.right, childPrefix, false);
    }

    static void printAlgorithmInfo() {
        System.out.println("0/1 Knapsack using Branch and Bound");
        System.out.println("====================================");
        System.out.println("Capacity: " + capacity);
        System.out.println("\nItems (sorted by Profit/Weight ratio):");

        for (Item item : items) {
            System.out.printf(
                "Item %d -> Weight=%d, Profit=%d, Ratio=%.2f%n",
                item.id, item.weight, item.profit, item.ratio
            );
        }
    }

    public static void main(String[] args) {
        printAlgorithmInfo();

        Node root = buildTree(0, 0, 0, null, "Root", "");

        System.out.println("\nBranch-and-Bound Tree");
        System.out.println("---------------------");
        printTree(root, "", false);

        System.out.println("\nFinal Result");
        System.out.println("------------");
        System.out.println("Maximum Profit: " + bestProfit);
        System.out.println("Total Weight: " + bestWeight);
        System.out.println("Selected Items: " + bestItems);

        System.out.println("\nPruning Rule:");
        System.out.println("A node is pruned when its weight exceeds capacity or");
        System.out.println("its upper bound is less than or equal to the current best profit.");
    }
}
