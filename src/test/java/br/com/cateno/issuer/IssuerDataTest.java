package br.com.cateno.issuer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with Issuer")
public class IssuerDataTest {

    @Nested
    @DisplayName("When create a new Issuer")
    class WhenCreateNewIssuer {

        private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
        private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
        private String issuerId;

        @Test
        @DisplayName("Create a new Issuer")
        void createIssuer() {

            IssuerData issuer = new IssuerData();
            Response issuer_response = issuer.createIssuer(IssuerRequestMock.issuerRequestMock());

            assertThat(issuer_response.getStatus()).isEqualTo(201);
            assertThat(issuer_response).isNotNull();
        }
    }
}
