import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;

public class ZephyrUploader {

    /** Клас для завантаження звітів до Zephyr scale після пробігу автоматизованих тестів */
    public static void main(String[] args) {

        /* Для використання даного класу слід додати Token ZephyrScale та Ключ вашого проекту в Jira */
        String TokenOfYourZephyrScaleAPI = "TokenOfYourZephyrScaleAPI";
        File reportFile = new File("test-output/MyTestSuite/mainPageTestsBuild.xml");
        String keyOfYourProject = "keyOfYourProject";

        /* URL Zephyr Scale */
        String zephyrApiUrl = "https://api.zephyrscale.smartbear.com/v2/automations/executions/junit";

        /* Створюємо HTTP клієнт */
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(zephyrApiUrl + "?projectKey=" + keyOfYourProject + "&autoCreateTestCases=true");

            post.setHeader("Authorization", "Bearer " + TokenOfYourZephyrScaleAPI);

            /* Створюємо запит до Zephyr Scale у вигляді звіту */
            HttpEntity entity = MultipartEntityBuilder.create()
                    .addBinaryBody("file", reportFile, ContentType.APPLICATION_XML, reportFile.getName())
                    .build();
            post.setEntity(entity);

            /* виконання запиту*/
            HttpResponse response = httpClient.execute(post);
            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}