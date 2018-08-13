import java.sql.SQLException;
import java.util.Scanner;

public class ManagementDB {
    private Scanner scanner;
    private String request;
    private String[] values;

    public ManagementDB() {

        scanner = new Scanner(System.in);
        start();
    }

    public void start(){
        while(true){
            request = scanner.nextLine();
            if(request.startsWith("/цена")){
                values = request.split(" ");
                try {
                    System.out.println("Цена " + values[1] + " = " + DBService.getCost(values[1]));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(request.startsWith("/сменитьцену")){
                values = request.split(" ");
                if(values.length < 3 || values[2].matches(".*\\D.*")){
                    System.out.println("Неверный формат запроса");
                    continue;
                }

                try {
                    DBService.setCost(values[1],Integer.parseInt(values[2]));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(request.startsWith("/товарыпоцене")){
                values = request.split(" ");
                if(values.length < 3 || values[1].matches(".*\\D.*") || values[2].matches(".*\\D.*")){
                    System.out.println("Неверный формат запроса");
                    continue;
                }
                if(Integer.parseInt(values[1]) >= Integer.parseInt(values[2])){
                    swap(values);
                }
                try {
                    System.out.println(DBService.productsInBetween(Integer.parseInt(values[1]),Integer.parseInt(values[2])));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void swap(String[] values) {
        String str = values[2];
        values[2] = values[1];
        values[1] = str;
    }
}
