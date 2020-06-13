import { Component, OnInit } from '@angular/core';
import { UserAccount } from '../login/types/UserAccount';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = new UserAccount();

  constructor() { }

  makeTypeCustomer(): void {
    this.user.accountType.id = 1;
    this.user.accountType.type = 'customer';
  }

  makeTypeDriver(): void {
    this.user.accountType.id = 2;
    this.user.accountType.type = 'driver';
  }

  ngOnInit(): void {
    this.user.accountType={
      id:1,
      type:'customer'
    }
  }

}
