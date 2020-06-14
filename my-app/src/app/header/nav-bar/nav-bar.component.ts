import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/services/login.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  isLogin: boolean;
  isLoginSubscription: Subscription;
  constructor(private route: Router, private loginService: LoginService) {
    this.isLogin = loginService.isLogin;
    this.isLoginSubscription = loginService.loginStatusChanged.subscribe((value) => {
      this.isLogin = value;
    });
  }

  ngOnInit(): void {
  }


  onHomeClick() {
    this.route.navigateByUrl('/home');
  }
  onLoginClick() {
    this.route.navigateByUrl('/login');
  }
  onRegisterClick(){
    this.route.navigateByUrl('/register');
  }

}
