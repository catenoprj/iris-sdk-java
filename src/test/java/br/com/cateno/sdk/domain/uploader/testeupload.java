package br.com.cateno.sdk.domain.uploader;

import java.io.IOException;

public class testeupload {

    public static void main(String args[]) throws IOException {
        String nameArchive = "UploadFileClaimsTemporary.txt";

        UploaderRequestMock uploadMock = new UploaderRequestMock();

        uploadMock.copyArchive("UploadFileClaims.txt", nameArchive);

    }
}
