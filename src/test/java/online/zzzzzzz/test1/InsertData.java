package online.zzzzzzz.test1;

/**
 * @author zZZ.... <br/>
 * @description <br/>
 * @date 2024/1/11$  <br/>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InsertData {

  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true";
  private static final String USER = "root";
  private static final String PASSWORD = "root";
  private static final int URL_LENGTH = 100;
  private static final int TOTAL_RECORDS = 10000000;
  private static final int BATCH_SIZE = 1000;

  public static void main(String[] args) {
    try {
      ExecutorService executorService = Executors.newFixedThreadPool(10);

      for (int i = 0; i < 10; i++) {
        final int recordNumber = i;
        executorService.submit(() -> insertRecords(recordNumber));
      }

      executorService.shutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  // 在你的 insertRecord 方法中
  private static void insertRecords(int recordNumber) {
    int baw=1000000;
    try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
      connection.setAutoCommit(false);

      String insertQuery = "INSERT INTO urls (url) VALUES (?)";
      int i1 = baw / BATCH_SIZE;
      for (int j = 0; j < i1; j++) {


      try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
        for (int i = 0; i < BATCH_SIZE; i++) {
          String randomUrl = generateRandomUrl();
          preparedStatement.setString(1, randomUrl);
          preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        connection.commit();
      }
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }finally {

    }
  }

  private static void insertRecord(int recordNumber) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
      String insertQuery = "INSERT INTO urls (url) VALUES (?)";

      try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
        connection.setAutoCommit(false);

        // 生成随机 URL，确保长度至少为 100 个字符
        String randomUrl = generateRandomUrl();
        preparedStatement.setString(1, randomUrl);

        preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static String generateRandomUrl() {
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder urlBuilder = new StringBuilder(URL_LENGTH);

    Random random = new Random();
    for (int i = 0; i < URL_LENGTH; i++) {
      urlBuilder.append(characters.charAt(random.nextInt(characters.length())));
    }

    return "http://example.com/" + urlBuilder.toString();
  }
}
