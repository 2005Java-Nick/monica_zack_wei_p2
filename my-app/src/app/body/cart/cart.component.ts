import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from '../types/product';
import { DepartmentService } from '../department/services/department.service';
import { ProductService } from '../service/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  subtotal: number;

  selectedProduct: Product;
  cart: Map<number, number>;

  selectAddCartSubscription: Subscription;
  cartSubscripton: Subscription;
  originalOrder = (a, b): number => {
    return 0;
  }

  constructor(public departmentService: DepartmentService, public productService: ProductService, private route: Router) {
    this.cart = departmentService.cart;
    this.selectedProduct = departmentService.selectedProduct;
    this.selectAddCartSubscription = departmentService.selectAddCartUpdated.subscribe((value) => {
      this.selectedProduct = value;
    });
    this.cartSubscripton = departmentService.cartUpdated.subscribe((value) => {
      this.cart = value;
    });
  }

  ngOnInit(): void {
    this.calculateSubtotal();
  }

  get key() {
    return Object.keys(this.cart);
  }

  cartEmpty(): boolean {
    return this.cart.size === 0;
  }

  calculateSubtotal() {
    let subtotal = 0;
    for (const item of this.cart) {
      subtotal += ((this.productService.getProduct(item[0]).price * 100) * item[1]) / 100;
    }
    this.subtotal = subtotal;
  }

  checkout() {
    console.log('Checkout button clicked');
  }

  onClickContinueShopping() {
    this.route.navigateByUrl('/department');
  }
onChangeTemp(){

}
}
