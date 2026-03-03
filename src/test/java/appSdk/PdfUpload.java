package appSdk;

import io.github.lambdatest.SmartUIConfig;
import io.github.lambdatest.SmartUIPdf;
import io.github.lambdatest.models.FormattedResults;


public class PdfUpload {

  public static void main(String[] args) {

    try {

      SmartUIConfig config = new SmartUIConfig()
        .withProjectToken("2355379#01KEHNHDQC9JBEZ9DE971PEDN2#PDF_name_01")
//        .withPdfNames(new String[] { "apple.pdf","azzzz.pdf","buzz.pdf","google.pdf","googleFail.pdf","test.pdf","zap.pdf" });
        .withPdfNames(new String[] { "1.pdf","2.pdf","3.pdf","4.pdf","5.pdf","6.pdf","7.pdf" });

      SmartUIPdf pdfUploader = new SmartUIPdf(config);

      String pdfPath = System.getProperty("user.dir") + "/upload_testing/pdf";

      pdfUploader.uploadPDF(pdfPath);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}