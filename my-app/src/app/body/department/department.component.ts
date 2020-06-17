import { Component, OnInit } from '@angular/core';
import { DepartmentService } from './services/department.service';
import { Subscription } from 'rxjs';
import { Product } from '../types/product';
import { Department } from '../types/department';
import { ProductService } from '../service/product.service';
import { CartService } from '../cart/services/cart.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {
  default = 0;
  products: Array<Product>;
  department: Array<Department>;
  selectedDepartment: Department;
  selectedProduct: Product;
  cart: Map<number, number>;

  productSubscription: Subscription;
  departmentSubscription: Subscription;
  selectedDepartmentSubscription: Subscription;
  selectAddCartSubscription: Subscription;
  cartSubscripton: Subscription;

  constructor(public departmentService: DepartmentService, public productService: ProductService, public cartService: CartService) {
    this.cart = departmentService.cart;
    this.selectedProduct = departmentService.selectedProduct;
    this.products = productService.products;
    this.department = departmentService.departments;
    this.selectedDepartment = departmentService.selectedDepartment;
    this.productSubscription = productService.productListUpdated.subscribe((value) => {
      this.products = value;
    });
    this.departmentSubscription = departmentService.departmentListUpdated.subscribe((value) => {
      this.department = value;
    });
    this.selectedDepartmentSubscription = departmentService.selectedDepartmentUpdated.subscribe((value) => {
      this.selectedDepartment = value;
    });
    this.selectAddCartSubscription = departmentService.selectAddCartUpdated.subscribe((value) => {
      this.selectedProduct = value;
    });
    this.cartSubscripton = departmentService.cartUpdated.subscribe((value) => {
      this.cart = value;
    });
  }

  ngOnInit(): void {
  }

}
