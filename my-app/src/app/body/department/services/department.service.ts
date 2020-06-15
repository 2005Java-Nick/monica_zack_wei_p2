import { Injectable } from '@angular/core';
import { Department } from '../../types/department';
import { Product } from '../../types/product';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  products: Array<Product>;

  departments: Array<Department> = [
    new Department(1, 'Fresh Produce'),
    new Department(2, 'Bakery'),
    new Department(3, 'Beverages'),
    new Department(4, 'Poultry'),
    new Department(5, 'Meal Kit')
  ];

  cart: Array<Product>;

  selectedDepartment: Department = this.departments[0];
  selectedProduct: Product;

  productListUpdated: Subject<Array<Product>> = new Subject<Array<Product>>();
  departmentListUpdated: Subject<Array<Department>> = new Subject<Array<Department>>();
  selectedDepartmentUpdated: Subject<Department> = new Subject<Department>();
  selectAddCartUpdated: Subject<Product> = new Subject<Product>();
  cartUpdated: Subject<Array<Product>> = new Subject<Array<Product>>();

  constructor(private route: Router) {
    this.cart = new Array<Product>();
    this.productListUpdated.subscribe((value) => {
      this.products = value;
    });
    this.departmentListUpdated.subscribe((value) => {
      this.departments = value;
    });
    this.selectedDepartmentUpdated.subscribe((value) => {
      this.selectedDepartment = value;
    });
    this.selectAddCartUpdated.subscribe((value) => {
      this.selectedProduct = value;
    });
    this.cartUpdated.subscribe((value) => {
      this.cart = value;
    });
  }

  onDepartmentClick(department){
    this.route.navigateByUrl('/department');
    this.selectedDepartmentUpdated.next(department);
  }
  onAddCartClick(product){
    this.selectAddCartUpdated.next(product);
    this.cart.push(product);
  }
  showCart(){
    console.log(this.cart);
  }
}
