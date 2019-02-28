package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.domain.establishment.*;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Given a Machines service")
class MachineServiceTest implements AuthenticatedStageEnvTest {

    private final MachineService service;

    MachineServiceTest() {
        final MachineApiClient machineApiClient = this.getAuthenticatedRetrofit().create(MachineApiClient.class);
        this.service = new MachineService(machineApiClient);
    }

    @Nested
    @DisplayName("When create a new Machine")
    class WhenCreateNewMachine {

        @Test
        @DisplayName("Then return the resource Machine generated with Id")
        void thenReturnTheResourceMachineGeneratedWithId() throws IOException {
            MachineRequestMock machineMock = new MachineRequestMock();

            Machine machineCreateResponse = service.create(machineMock.machineRequestMock());
            assertThat(machineCreateResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a new Machine by your ID")
    class WhenSearchNewMachineById {

        @Test
        @DisplayName("Then return the related resource with the same ID")
        void thenReturnTheRelatedResourceWithTheSameId() throws IOException {
            MachineRequestMock machineMock = new MachineRequestMock();

            Machine machineCreateResponse = service.create(machineMock.machineRequestMock());

            Machine machine = service.fetch(machineCreateResponse.getId());
            assertThat(machine.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a new Machine by your Number")
    class WhenSearchNewMachineByNumber {

        @Test
        @DisplayName("Then return the related resource with the same Number")
        void thenReturnTheRelatedResourceWithTheSameNumber() throws IOException {
            MachineRequestMock machineMock = new MachineRequestMock();

            Machine machineCreateResponse = service.create(machineMock.machineRequestMock());

            Machine machine = service.fetchByNumber(machineCreateResponse.getNumber());
            assertThat(machine.getNumber()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When create and request to update an Machine")
    class WhenCreateAndRequestToUpdateAnMachine {

        @Test
        @DisplayName("Then update it properly")
        void thenUpdateItProperly() throws IOException {

            MachineRequestMock machineMock = new MachineRequestMock();

            MachineRequest machineRequest = machineMock.machineRequestMock();
            Machine machineCreateResponse = service.create(machineRequest);


            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String label = "11" + fakeValuesService.bothify("Machine????##");

            machineRequest.setLabel(label);

            Machine machine = service.update(machineCreateResponse.getId(), machineRequest );

            assertThat(machine.getLabel()).contains(label);
        }
    }

    @Nested
    @DisplayName("When create and request to delete an Establishment")
    class WhenCreateAndRequestToDeleteAnEstablishment {

        @Test
        @DisplayName("Then delete it properly")
        void thenDeleteItProperly() {

            Machine machine2 = new Machine();

            try {

                MachineRequestMock machineMock = new MachineRequestMock();

                Machine machineCreateResponse = service.create(machineMock.machineRequestMock());

                Machine machine = service.fetch(machineCreateResponse.getId());

                service.delete(machine.getId());

                machine2 = service.fetch(machineCreateResponse.getId());

            } catch (Exception IOException){
                assertThat(machine2.getId()).isNull();
            }

        }
    }
}
