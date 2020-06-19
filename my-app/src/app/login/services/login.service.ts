import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, observable, Subject} from 'rxjs';
import { environment } from './../../../environments/environment';
import { UserData } from '../types/UserData';
import { UserAccount } from '../types/UserAccount';


@Injectable({
  providedIn: 'root'
})
export class LoginService{

  user: UserAccount;

  isLogin: boolean;

  loginStatusChanged: Subject<boolean> = new Subject<boolean>();

  constructor(private http: HttpClient) {
    this.resetLogin();
    this.loginStatusChanged.subscribe((value) => {
      this.isLogin = value;
  });
}


  resetLogin(){
    this.isLogin = false;
    sessionStorage.clear();
    this.loginStatusChanged.next(false);
  }

  authenticate(data: UserData): Observable<UserAccount> {
    return this.http.post<UserAccount>(environment.loginURL, data);
  }


  setToken(data: UserData): Observable<boolean> {

    const ob = new Observable<boolean>(
      (obser) => {
        this.authenticate(data).subscribe(
          (userToken: UserAccount) => {
            console.log(userToken);
            if (userToken == null) { obser.next(false); }
            if (userToken != null) {this.loginStatusChanged.next(true); obser.next(true); this.user = userToken;
                                    sessionStorage.setItem('Token', userToken.sessionToken);
            }
          }
        );
      }
    );
    return ob;
  }


  authenticateSignUp(data: UserAccount): Observable<UserAccount> {
    return this.http.post<UserAccount>(environment.signupURL, data);
  }
  sendSignUp(data: UserAccount): Observable<boolean> {

    const ob = new Observable<boolean>(
      (obser) => {
        this.authenticateSignUp(data).subscribe(
          (userToken: UserAccount) => {
            console.log(userToken);
            if (userToken == null) { obser.next(false); }
            if (userToken != null) {this.loginStatusChanged.next(true); obser.next(true);
                                    this.user = userToken; sessionStorage.setItem('Token', userToken.sessionToken); }
          }
        );
      }
    );
    return ob;
  }


}
