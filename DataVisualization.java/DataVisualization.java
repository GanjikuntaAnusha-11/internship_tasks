import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataVisualization {

    private static List<Map<String, String>> data = new ArrayList<>();
    private static List<String> columns = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Console Data Visualization Tool ===");

        // 1. Load CSV
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        try {
            loadCSV(filePath);
        } catch (Exception e) {
            System.out.println("Failed to load CSV: " + e.getMessage());
            return;
        }

        // Menu loop
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Show columns");
            System.out.println("2. Display column histogram");
            System.out.println("3. Display column bar chart");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showColumns();
                    break;
                case "2":
                    System.out.print("Enter column name: ");
                    String col1 = sc.nextLine();
                    displayHistogram(col1);
                    break;
                case "3":
                    System.out.print("Enter column name: ");
                    String col2 = sc.nextLine();
                    displayBarChart(col2);
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Load CSV into list of maps
    private static void loadCSV(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        if (line == null) throw new IOException("Empty CSV file");
        columns = Arrays.asList(line.split(","));
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Map<String, String> row = new HashMap<>();
            for (int i = 0; i < columns.size(); i++) {
                row.put(columns.get(i), i < values.length ? values[i] : "");
            }
            data.add(row);
        }
        br.close();
        System.out.println("CSV loaded successfully! Rows: " + data.size());
    }

    // Show all columns
    private static void showColumns() {
        System.out.println("Columns in dataset:");
        for (String col : columns) {
            System.out.println("- " + col);
        }
    }

    // Display simple frequency histogram for a column
    private static void displayHistogram(String column) {
        if (!columns.contains(column)) {
            System.out.println("Column not found.");
            return;
        }

        Map<String, Long> freq = data.stream()
                .map(row -> row.get(column))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println("Histogram for column: " + column);
        freq.forEach((k,v) -> System.out.println(k + " : " + "*".repeat(Math.toIntExact(v))));
    }

    // Display simple numeric bar chart
    private static void displayBarChart(String column) {
        if (!columns.contains(column)) {
            System.out.println("Column not found.");
            return;
        }

        // parse numeric values
        List<Double> nums = new ArrayList<>();
        for (Map<String, String> row : data) {
            try {
                nums.add(Double.parseDouble(row.get(column)));
            } catch (NumberFormatException ignored) {}
        }

        if (nums.isEmpty()) {
            System.out.println("No numeric data found in column.");
            return;
        }

        double max = Collections.max(nums);
        System.out.println("Bar chart for column: " + column);
        for (int i = 0; i < nums.size(); i++) {
            int barLength = (int)((nums.get(i)/max)*50); // scale to max 50 chars
            System.out.printf("%3d | %s %.2f%n", i+1, "#".repeat(barLength), nums.get(i));
        }
    }
}

