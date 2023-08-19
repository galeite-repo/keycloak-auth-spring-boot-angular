import { Component } from '@angular/core';
import { AuthConfig, NullValidationHandler, OAuthService } from 'angular-oauth2-oidc';
import { MessageService } from './services/message.service';
import { LoginService } from './services/login.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'keycloak-frontend';
  username!: string;
  isLogged!: boolean;
  isAdmin!: boolean;

  constructor(private loginService: LoginService,
    private oAuthService: OAuthService, private messageService: MessageService) {
    this.configure();
  }

  authConfig: AuthConfig = {
    issuer: 'http://localhost:8082/realms/tutorial',
    clientId: 'frontend',
    responseType: 'code',
    redirectUri: window.location.origin,
    scope: 'openid offline_access profile email',
    showDebugInformation: true,
    // oidc: true,
  };

  configure(): void {
    this.oAuthService.configure(this.authConfig);
    this.oAuthService.tokenValidationHandler = new NullValidationHandler();
    this.oAuthService.setupAutomaticSilentRefresh();
    this.oAuthService.loadDiscoveryDocument().then(() => this.oAuthService.tryLogin())
      .then(() => {
        if (this.oAuthService.getIdentityClaims()) {
          this.isLogged = this.loginService.getIsLogged()
          this.isAdmin = this.loginService.getIsAdmin();
          this.username = this.loginService.getName();
          this.messageService.sendMessage(this.username);
        }
      })
  }
 
}
