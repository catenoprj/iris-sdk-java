package br.com.cateno.issuer;

import br.com.cateno.DefaultIrisClient;
import br.com.cateno.auth.Authentication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with Issuer")
public class IssuerDataTest {

    @Nested
    @DisplayName("When create a new Issuer")
    class WhenCreateNewIssuer {

        private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
        private static final String ACCESS_TOKEN = "28bc88eb-c9bd-381e-abb5-dd4251213949";
        private String issuerId;

        @Test
        @DisplayName("Create a new Issuer")
        void createIssuer() {

            Authentication authentication = new Authentication();
            authentication.setAccessToken(ACCESS_TOKEN);
            authentication.setAuthorities(new ArrayList<>());
            authentication.setName("name");
            authentication.setRefreshToken("refreshToken");
            authentication.setUserId("userId");
            authentication.setUserName("userName");
            authentication.setAuthorities(new ArrayList<>());
            DefaultIrisClient defaultIrisClient = new DefaultIrisClient(authentication, CLIENT_ID);
            Response issuer_response = defaultIrisClient.createIssuer(IssuerRequestMock.issuerRequestMock());

            assertThat(issuer_response.getStatus()).isEqualTo(201);
            assertThat(issuer_response).isNotNull();
        }
    }
}
