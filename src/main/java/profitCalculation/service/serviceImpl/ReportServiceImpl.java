package profitCalculation.service.serviceImpl;

import profitCalculation.repository.dao.CategoryDao;
import profitCalculation.repository.dao.TransactionDao;
import profitCalculation.repository.dao.daoImpl.CategoryDaoImpl;
import profitCalculation.repository.dao.daoImpl.TransactionDaoImpl;
import profitCalculation.service.ReportService;

public class ReportServiceImpl implements ReportService {

    private TransactionDao transactionDao = new TransactionDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void getSalesReport(String category, String date) {
        if (category != null & date != null & categoryDao.getCategoryByName(category) != null) {
            String report = transactionDao.getReportByCategoryAndDate(categoryDao.getCategoryByName(category), date);
            if (report != null) {
                System.out.println(report);
            } else {
                System.out.println("NO SALES OF THIS CATEGORY ON THIS DATE");
            }
        } else {
            System.out.println("ERROR");
        }
    }
}
