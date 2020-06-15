import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { UserData } from '../types/UserData';
import { LoginService } from '../services/login.service';

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

  isLoggedIn: boolean;

  loginUser() {
    console.log('login submit clicked');
    this.loginService.setToken(this.user).pipe(first()).subscribe(data => {
      if (data === true) {
        this.route.navigateByUrl('/home');
      }
    });
  }

  constructor(private loginService: LoginService, private route: Router) {}

  ngOnInit(): void {
  }

}
