import java.util.HashMap;
import java.util.Scanner;

public class Exercise5 {
    static HashMap<Integer, HashMap<String, String>> employees = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public void main(String[] args) {
        // Initialize some employees
        addEmployee(1, "Chan Dara", "800", "ITE");
        addEmployee(2, "Sok Sophea", "900", "BioE");
        addEmployee(3, "Keo Tola", "500", "TEE");

        // Display the menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Display all employees");
            System.out.println("2. Add a new employee");
            System.out.println("3. Delete employee by id");
            System.out.println("4. Update employee by id");
            System.out.println("5. Search employee by id");
            System.out.println("6. Exit the program");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    displayAllEmployees();
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    deleteEmployeeById();
                    break;
                case 4:
                    updateEmployeeById();
                    break;
                case 5:
                    searchEmployeeById();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addEmployee(int id, String name, String salary, String department) {
        HashMap<String, String> employeeDetails = new HashMap<>();
        employeeDetails.put("Name", name);
        employeeDetails.put("Salary", salary);
        employeeDetails.put("Department", department);
        employees.put(id, employeeDetails);
    }

    private static void displayAllEmployees() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("ID\tName\t\tSalary\tDepartment");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Integer id : employees.keySet()) {
            HashMap<String, String> details = employees.get(id);
            System.out.println(id + "\t" + details.get("Name") + "\t" + details.get("Salary") + "\t" + details.get("Department"));
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private void addNewEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        String salary = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        addEmployee(id, name, salary, department);
        System.out.println("Employee added successfully.");
    }

    private void deleteEmployeeById() {
        System.out.print("Enter ID of the employee to delete: ");
        int id = scanner.nextInt();
        if (employees.containsKey(id)) {
            employees.remove(id);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }


    private void updateEmployeeById() {
        System.out.print("Enter ID of the employee to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (employees.containsKey(id)) {
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Salary: ");
            String salary = scanner.nextLine();
            System.out.print("Enter new Department: ");
            String department = scanner.nextLine();

            addEmployee(id, name, salary, department);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void searchEmployeeById() {
        System.out.print("Enter ID of the employee to search : ");
        int id = scanner.nextInt();
        if (employees.containsKey(id)) {
            HashMap<String, String> details = employees.get(id);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("ID\tName\t\tSalary\tDepartment");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println(id + "\t" + details.get("Name") + "\t" + details.get("Salary") + "\t" + details.get("Department"));
            System.out.println("-------------------------------------------------------------------------------------");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
