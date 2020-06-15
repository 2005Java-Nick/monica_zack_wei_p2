import { Injectable } from '@angular/core';
import { Department } from '../../types/department';
import { Product } from '../../types/product';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  products: Array<Product> = [
    new Product(1, 'Cauliflower', 'Fresh and Organic', 3.48, 87, 'Cauliflower', 'assets/images/cauliflower.png', 'Fresh Produce'),
    new Product(2, 'Tomato', 'Tasty', 1.48, 72, 'Tomatoes', 'assets/images/tomatoes.jpg', 'Bakery'),
    new Product(3, 'Cucumbers', 'Fresh and Green', 1.78, 50, 'Cucumbers', 'assets/images/cucumbers.jpg', 'Fresh Produce'),
    new Product(4, 'Asparagus', 'Fresh and Organic', 5.48, 15, 'Asparagus', 'assets/images/asparagus.jpg', 'Fresh Produce'),
    new Product(5, 'Onion', 'Fresh and Organic', 1.25, 64, 'Onion', 'assets/images/onion.jpg', 'Fresh Produce'),
    new Product(6, 'Potatoes', 'Idaho potatoes', 2.59, 47, 'Potatoes', 'assets/images/potatoes.jpg', 'Fresh Produce'),
    new Product(7, 'Garlic', 'Keeps vampires away', 0.50, 80, 'Garlic', 'assets/images/garlic.jpg', 'Fresh Produce'),
    new Product(8, 'Ginger', 'Juicy', 2.09, 36, 'Ginger', 'assets/images/ginger.jpg', 'Fresh Produce')
  ];

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
