import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LoginService } from 'src/app/login/login/services/login.service';
import { UserData } from './types/UserData';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: UserData = {
    username: '',
    password: ''
  };


  loginUser() {
    console.log('login submit clicked');
    this.loginService.setToken(this.user).pipe(first()).subscribe(data => {
      if (data === true) {
        this.route.navigateByUrl('/home');
      }
    });
  }

  constructor(private loginService: LoginService, private route: Router) { }

  ngOnInit(): void {
  }

}
