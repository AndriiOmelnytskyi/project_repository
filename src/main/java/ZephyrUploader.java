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

        String TokenOfYourZephyrScaleAPI = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2FuZHJpaW9tZWxueXRza3lpLTE3NDI0MDM3NTE3MTguYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNzEyMDIwOjA0MjZhYTMwLTRkMmYtNGYwMy04ZjIyLWE0NTVlMTY2MjNmMiIsInRva2VuSWQiOiJmODgzMjU4OS1mMGViLTRiZGItOTYwNi01MmQ2MmU1MmZlNDMifX0sImlzcyI6ImNvbS5rYW5vYWgudGVzdC1tYW5hZ2VyIiwic3ViIjoiMzBhNTUxMjMtZjM4YS0zNDA1LThlNzItNjUzMmU1YTE5Yzc4IiwiZXhwIjoxNzczOTQwMDA0LCJpYXQiOjE3NDI0MDQwMDR9.1Cb21gQ3Bdy0ZA2piyz5IhhHexeCOylADxQhZpoWAao";
        File reportFile = new File("test-output/MyTestSuite/mainPageTestsBuild.xml");
        String keyOfYourProject = "SMS";

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