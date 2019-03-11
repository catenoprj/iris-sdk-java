package br.com.cateno.sdk.domain.uploader;

import br.com.cateno.sdk.domain.claim.*;
import br.com.cateno.sdk.domain.establishment.Machine;
import br.com.cateno.sdk.domain.establishment.MachineApiClient;
import br.com.cateno.sdk.domain.establishment.MachineRequestMock;
import br.com.cateno.sdk.domain.establishment.MachineService;
import br.com.cateno.sdk.domain.issuer.Issuer;
import br.com.cateno.sdk.domain.issuer.IssuerApiClient;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import br.com.cateno.sdk.domain.user.*;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;

class UploaderRequestMock implements AuthenticatedStageEnvTest {

    private final String directoryArchive = System.getProperty("user.dir") + "/src/test/java/br/com/cateno/sdk/domain/resources/";

    public String setIssuerMachineUploadArchive(String diretory, String nameArchive) throws IOException {

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        MachineRequestMock machineMock = new MachineRequestMock();

        MachineApiClient machineApiClient = this.getAuthenticatedRetrofit().create(MachineApiClient.class);
        MachineService machineService = new MachineService(machineApiClient);

        IssuerApiClient issuerApiClient = this.getAuthenticatedRetrofit().create(IssuerApiClient.class);
        IssuerService issuerService = new IssuerService(issuerApiClient);

        Machine machineCreateResponse = machineService.create(machineMock.machineRequestMock());

        UserApiClient userApiClient = this.getAuthenticatedRetrofit().create(UserApiClient.class);
        UserService userService = new UserService(userApiClient);

        UserRequestMock userMock = new UserRequestMock();
        User userCreateResponse = userService.create(userMock.userRequestMock(UserType.EMISSOR));

        Issuer issuerResponse = issuerService.fetch(userCreateResponse.getIssuerIds().get(0));

        String cardNumber = fakeValuesService.regexify("[1-9]{16}");

        BufferedReader reader = new BufferedReader(new FileReader(diretory + nameArchive));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        stringBuilder.append(reader.readLine());
        stringBuilder.append(ls);
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(String.format(line, issuerResponse.getIssuerCode(), machineCreateResponse.getNumber(), cardNumber));
            stringBuilder.append(ls);
        }
        // delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        String content = stringBuilder.toString();

        FileUtils.writeByteArrayToFile(new File(diretory + nameArchive), content.getBytes());

        return issuerResponse.getIssuerCode();
    }

    public void copyArchive(String archiveOrign, String archivedDstine) throws IOException {

        File origem = new File(directoryArchive + archiveOrign);
        File destino = new File(directoryArchive + archivedDstine);

        Files.copy(origem.toPath(), destino.toPath());

        //FileUtils.copyFile(origem, destino);
    }

    public void deleteArchive(String directoryArchive, String nameArchive) throws IOException {

        File originArchive = new File(directoryArchive + nameArchive);
        originArchive.delete();
    }

    public Claim returnClaimByUpload(String issuerCode) throws IOException {

        ClaimApiClient claimApiClient = this.getAuthenticatedRetrofit().create(ClaimApiClient.class);
        ClaimService claimService = new ClaimService(claimApiClient);

        Pagination pagination = Pagination.with(10, 0);
        ClaimFilters clamFilters = ClaimFilters.builder().issuer(issuerCode).build();

        List<Claim> claim = claimService.list(clamFilters, pagination);

        System.out.println(claim.get(0));

        return claim.get(0);
    }
}

