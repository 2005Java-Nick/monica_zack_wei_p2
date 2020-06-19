import { Component, OnInit } from '@angular/core';
import { UserAccount } from '../types/UserAccount';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = new UserAccount();

  failedRegister = false;

  constructor(private loginService: LoginService, private route: Router) { }

  makeTypeCustomer(): void {
    this.user.accountType.id = 1;
    this.user.accountType.type = 'customer';
  }

  makeTypeDriver(): void {
    this.user.accountType.id = 2;
    this.user.accountType.type = 'driver';
  }

  ngOnInit(): void {
    this.user.accountType = {
      id: 1,
      type: 'customer'
    };
  }

  onSignUp() {
    console.log('Signup submit clicked');
    this.loginService.sendSignUp(this.user).pipe(first()).subscribe(data => {
      if (data === true) {
        this.route.navigateByUrl('/home');
      } else {
        this.failedRegister = true;
      }
    });
  }

}
