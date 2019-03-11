package br.com.cateno.sdk.domain.uploader;

import br.com.cateno.sdk.domain.claim.Claim;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Given a Uploader service")
class UploaderServiceTest implements AuthenticatedStageEnvTest {

    private final UploaderService service;
    private final String directoryArchive = System.getProperty("user.dir") + "/src/test/java/br/com/cateno/sdk/domain/resources/";
    private final String nameArchive = "UploadFileClaimsTemporary.txt";
    private final UploaderRequestMock uploadMock;

    UploaderServiceTest() throws IOException {
        final UploaderApiClient uploaderApiClient = this.getAuthenticatedRetrofit().create(UploaderApiClient.class);
        this.service = new UploaderService(uploaderApiClient);

        uploadMock = new UploaderRequestMock();
        uploadMock.copyArchive("UploadFileClaims.txt", nameArchive);
    }

    @Nested
    @DisplayName("When upload a new Claim")
    class whenUploadANewClaim {

        @Test
        @DisplayName("Then upload a new claims into application")
        void thenUploadANewClaimsIntoApplication() throws IOException {

            String issuerCode = uploadMock.setIssuerMachineUploadArchive(directoryArchive, nameArchive);

            service.upload(directoryArchive + nameArchive);

            uploadMock.deleteArchive(directoryArchive,nameArchive);

            Claim claimResponse = uploadMock.returnClaimByUpload(issuerCode);

            assertThat(claimResponse.getId()).isNotNull();
        }
    }
}