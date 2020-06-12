import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, observable} from 'rxjs';
import { UserData } from '../types/UserData';
import { Token } from '../types/Token';
import { environment } from '../../../../environments/environment';

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

  authenticate(data: UserData): Observable<Token> {
    return this.http.post<Token>(environment.loginURL, data);
  }


  setToken(data: UserData): Observable<boolean> {

    const ob = new Observable<boolean>(
      (obser) => {
        this.authenticate(data).subscribe(
          (userToken: Token) => {
            sessionStorage.setItem('Token', userToken.token);
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
