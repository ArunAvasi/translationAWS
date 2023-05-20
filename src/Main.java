import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.translate.TranslateClient;
import software.amazon.awssdk.services.translate.model.TranslateTextRequest;
import software.amazon.awssdk.services.translate.model.TranslateTextResponse;

public class Main {
    public static void main(String[] args) {
        // Set your AWS access and secret keys
        String accessKey = "access";
        String secretKey = "secret";

        // Set the source and target language codes
        String sourceLanguageCode = "en";
        String targetLanguageCode = "es";

        // Set the text to be translated
        String textToTranslate = "Hello, how are you?";

        // Create AWS credentials
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        // Create a TranslateClient with the desired AWS region
        TranslateClient translateClient = TranslateClient.builder()
                .region(Region.US_WEST_2) // Replace with your desired AWS region
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        // Create a TranslateTextRequest with the source language, target language, and text
        TranslateTextRequest translateRequest = TranslateTextRequest.builder()
                .sourceLanguageCode(sourceLanguageCode)
                .targetLanguageCode(targetLanguageCode)
                .text(textToTranslate)
                .build();

        // Call the translateText method of the TranslateClient
        TranslateTextResponse translateResponse = translateClient.translateText(translateRequest);

        // Get the translated text from the response
        String translatedText = translateResponse.translatedText();

        // Print the translated text
        System.out.println("Translated Text: " + translatedText);

        // Close the TranslateClient
        translateClient.close();
    }
}
