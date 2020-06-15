import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../login/services/login.service';
import { Subscription } from 'rxjs';
import { Product } from '../../body/types/product';
import { DepartmentService } from '../../body/department/services/department.service';
import { Department } from '../../body/types/department';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  isLogin: boolean;
  isLoginSubscription: Subscription;

  products: Array<Product>;
  departments: Array<Department>;
  selectedDepartment: Department;
  selectAddCart: Product;
  cart: Array<Product>;

  productSubscription: Subscription;
  departmentSubscription: Subscription;
  selectedDepartmentSubscription: Subscription;
  selectAddCartSubscription: Subscription;
  cartSubscripton: Subscription;

  constructor(private route: Router, private loginService: LoginService, public departmentService: DepartmentService) {
    this.isLogin = loginService.isLogin;
    this.isLoginSubscription = loginService.loginStatusChanged.subscribe((value) => {
      this.isLogin = value;
    });
    this.products = departmentService.products;
    this.departments = departmentService.departments;
    this.selectedDepartment = departmentService.selectedDepartment;
    this.productSubscription = departmentService.productListUpdated.subscribe((value) => {
      this.products = value;
    });
    this.departmentSubscription = departmentService.departmentListUpdated.subscribe((value) => {
      this.departments = value;
    });
    this.selectedDepartmentSubscription = departmentService.selectedDepartmentUpdated.subscribe((value) => {
      this.selectedDepartment = value;
    });
    this.selectAddCartSubscription = departmentService.selectAddCartUpdated.subscribe((value) => {
      this.selectAddCart = value;
    });
    this.cartSubscripton = departmentService.cartUpdated.subscribe((value) => {
      this.cart = value;
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
