package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.claim.ClaimService;
import br.com.cateno.sdk.domain.claim.ReportService;
import br.com.cateno.sdk.domain.establishment.EstablishmentService;
import br.com.cateno.sdk.domain.establishment.MachineService;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import br.com.cateno.sdk.domain.uploader.UploaderService;
import br.com.cateno.sdk.domain.status.DeliveryActionService;
import br.com.cateno.sdk.domain.status.FinanceActionService;
import br.com.cateno.sdk.domain.user.OperationService;
import br.com.cateno.sdk.domain.user.PasswordService;
import br.com.cateno.sdk.domain.user.ProfileService;
import br.com.cateno.sdk.domain.user.UserService;
import br.com.cateno.sdk.domain.messenger.MessageService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
    ApiClientModule.class,
    AuthModule.class,
    RetrofitModule.class
})
public interface IrisClient {

  ClaimService loadClaimService();

  DeliveryActionService loadDeliveryActionService();

  EstablishmentService loadEstablishmentService();

  FinanceActionService loadFinanceActionService();

  IssuerService loadIssuerService();

  MachineService loadMachineService();

  OperationService loadOperationService();

  PasswordService loadPasswordService();

  ProfileService loadProfileService();

  ReportService loadReportService();

  UploaderService loadUploaderService();

  UserService loadUserService();

  MessageService loadMessageService();
}
