import { Injectable } from '@angular/core';
import { Department } from '../../types/department';
import { Product } from '../../types/product';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { ProductService } from '../../service/product.service';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  products: Array<Product>;

  departments: Array<Department> = [
    new Department(0, 'Browse'),
    new Department(1, 'Fresh Produce'),
    new Department(2, 'Bakery'),
    new Department(3, 'Beverages'),
    new Department(4, 'Poultry'),
    new Department(5, 'Meal Kit')
  ];

  cart: Map<number, number>;

  selectedDepartment: Department = this.departments[0];
  selectedProduct: Product;

  departmentListUpdated: Subject<Array<Department>> = new Subject<Array<Department>>();
  selectedDepartmentUpdated: Subject<Department> = new Subject<Department>();
  selectAddCartUpdated: Subject<Product> = new Subject<Product>();
  cartUpdated: Subject<Map<number, number>> = new Subject<Map<number, number>>();

  constructor(private route: Router, public productService: ProductService) {
    this.cart = new Map<number, number>();
    this.selectedProduct = new Product();
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

  onDepartmentClick(department) {
    this.selectedDepartmentUpdated.next(department);
    this.route.navigateByUrl('/department');
  }

  onAddCartClick(product, value) {
    this.selectAddCartUpdated.next(product);
    if (value > this.selectedProduct.inventoryQuantity) {
      value = this.selectedProduct.inventoryQuantity;
    }
    const key = product.id;
    if (this.cart.has(key)) {
      const currentAmount = this.cart.get(key);
      this.cart.set(key, currentAmount + value);
    } else {
      this.cart.set(key, value);
    }
    this.selectedProduct.inventoryQuantity -= value;
  }

  removeItem(i) {
    this.productService.getProduct(i).inventoryQuantity += this.cart.get(i);
    this.cart.delete(i);
  }
}
