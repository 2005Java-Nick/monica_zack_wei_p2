import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, observable} from 'rxjs';
import { UserData } from '../types/UserData';
import { Token } from '../types/Token';
import { environment } from '../../../../environments/environment';
import { UserAccount } from '../types/UserAccount';

@Injectable({
  providedIn: 'root'
})
export class LoginService{

  isLogin: boolean;

  constructor(private http: HttpClient) {
    this.resetLogin();
  }

  resetLogin(){
    this.isLogin = false;
    sessionStorage.clear();
  }

  authenticate(data: UserData): Observable<UserAccount> {
    return this.http.post<UserAccount>(environment.loginURL, data);
  }


  setToken(data: UserData): Observable<boolean> {

    const ob = new Observable<boolean>(
      (obser) => {
        this.authenticate(data).subscribe(
          (userToken: UserAccount) => {
            console.log(userToken.accountType.type);
            sessionStorage.setItem('Token', userToken.sessionToken);
            console.log(sessionStorage.getItem('Token'));
            if (userToken == null) { obser.next(false); }
            if (userToken != null) { this.isLogin = true; obser.next(true); }
          }
        );
      }
    );
    return ob;
  }
}
