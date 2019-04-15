package profitCalculation.service.serviceImpl;

import profitCalculation.repository.dao.CategoryDao;
import profitCalculation.repository.dao.ReportDao;
import profitCalculation.repository.dao.daoImpl.CategoryDaoImpl;
import profitCalculation.repository.dao.daoImpl.ReportDaoImpl;
import profitCalculation.service.ReportService;

public class ReportServiceImpl implements ReportService {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    private ReportDao reportDao = new ReportDaoImpl();

    @Override
    public void getSalesReport(String category, String date) {

        if (category != null & date != null & categoryDao.getCategoryByName(category) != null) {
            String report = reportDao.getProfitOnCategoryOnDate(categoryDao.getCategoryByName(category), date);
            if (report != null) {
                System.out.println(report);
            } else {
                System.out.println("NO DATA - TRY DIFFERENT DATE OR CATEGORY");
            }
        } else {
            System.out.println("ERROR");
        }
    }
}
