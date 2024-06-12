import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // Create maps for sales reps and companies
        // using HashMap to store data
        Map<String, SalesRep> salesRepMap = new HashMap<>();
        Map<String, List<Company>> companyMap = new HashMap<>();

        try {
            // read the sales csv
            BufferedReader salesRepReader = new BufferedReader(new FileReader("/Users/lulutofulucas/Desktop/Java Projects/MiniHackathon/SalesReps.csv"));
            String line;
            while ((line = salesRepReader.readLine()) != null) {
                String[] data = line.split(",");
                SalesRep salesRep = new SalesRep(data[0], data[1], data[2], data[3], data[4], data[5]);
                salesRepMap.put(data[2].toLowerCase(), salesRep); // use last name
            }
            salesRepReader.close();

            // read the company csv
            BufferedReader companyReader = new BufferedReader(new FileReader("/Users/lulutofulucas/Desktop/Java Projects/MiniHackathon/Company.csv"));
            while ((line = companyReader.readLine()) != null) {
                String[] data = line.split(",");
                Company company = new Company(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
                companyMap.computeIfAbsent(data[2], k -> new ArrayList<>()).add(company); // use Sales RepId
            }
            companyReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ask users to input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please Enter Sales Last Name or exit to stop：");
            String lastName = scanner.nextLine().toLowerCase();

            if(lastName.equals("exit")) {
                break;
            }

            // search and display company data
            SalesRep salesRep = salesRepMap.get(lastName);
            if (salesRep != null) {
                List<Company> companies = companyMap.get(salesRep.getUserId());
                if (companies == null) {
                    System.out.println(salesRep);
                }

                if (companies != null) {
                    System.out.println("Found the Company：");
                    for (Company company : companies) {
                        System.out.println(company);
                        System.out.println(salesRep);
                    }
                } else {
                    System.out.println("Can't find the Company。");
                }
            } else {
                System.out.println("Can't find the Sales");
            }
        }
    }
}




