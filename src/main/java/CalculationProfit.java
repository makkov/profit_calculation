import profitCalculation.service.serviceImpl.CategoryServiceImpl;
import profitCalculation.service.serviceImpl.ProductServiceImpl;
import profitCalculation.service.serviceImpl.ReportServiceImpl;

import java.util.Scanner;

public class CalculationProfit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputString = scanner.nextLine();
            String[] inputArray = inputString.split(" ");
            try {
                if (inputArray[0].equals("NEWPRODUCT")) {
                    CategoryServiceImpl categoryService = new CategoryServiceImpl();
                    if (categoryService.addCategory(inputArray[1])) {
                        System.out.println("OK");
                    } else {
                        System.out.println("ERROR");
                    }
                } else if (inputArray[0].equals("PURCHASE")) {
                    ProductServiceImpl productService = new ProductServiceImpl();
                    if (productService.purchaseProducts(
                            inputArray[1],
                            inputArray[2],
                            inputArray[3],
                            inputArray[4]
                    )) {
                        System.out.println("OK");
                    } else {
                        System.out.println("ERROR");
                    }
                } else if (inputArray[0].equals("DEMAND")) {
                    ProductServiceImpl productService = new ProductServiceImpl();
                    if (productService.demandProducts(
                            inputArray[1],
                            inputArray[2],
                            inputArray[3],
                            inputArray[4]
                    )) {
                        System.out.println("OK");
                    } else {
                        System.out.println("ERROR");
                    }
                } else if (inputArray[0].equals("SALESREPORT")) {
                    ReportServiceImpl reportService = new ReportServiceImpl();
                    reportService.getSalesReport(inputArray[1], inputArray[2]);
                } else if (inputArray[0].equals("QUIT")) {
                    System.out.println("Program completed\n");
                    break;
                } else {
                    System.out.println("INPUT ERROR");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("INPUT ERROR");
            }
        }
    }
}
