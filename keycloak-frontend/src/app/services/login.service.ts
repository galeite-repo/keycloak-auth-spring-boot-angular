import { Injectable } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private oAuthService: OAuthService) { }

  public login(): void {
    this.oAuthService.initImplicitFlowInternal();

  }
  public logout(): void {
    this.oAuthService.logOut()
  }
  public getIsLogged(): boolean {
    return (this.oAuthService.hasValidAccessToken() && this.oAuthService.hasValidAccessToken());
  }
  public getName(): string{
    return this.oAuthService.getIdentityClaims()[`name`]
  }

  public getIsAdmin(): boolean {
    const token = this.oAuthService.getAccessToken();
    const payload = token.split('.')[1];
    const payloadDecodedJson = atob(payload);
    const payloadDecoded = JSON.parse(payloadDecodedJson);
    // console.log(payloadDecoded.realm_access.roles);
    return payloadDecoded.realm_access.roles.indexOf('realm-admin') !== -1;
  }
}
