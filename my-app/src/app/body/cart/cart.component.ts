import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from '../types/product';
import { DepartmentService } from '../department/services/department.service';
import { ProductService } from '../service/product.service';
import { Router } from '@angular/router';
import { CartService } from './services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  subtotal: number;
  deliveryFee: number;
  total: number;
  selectedProduct: Product;
  cart: Map<number, number>;

  selectAddCartSubscription: Subscription;
  cartSubscripton: Subscription;
  originalOrder = (a, b): number => {
    return 0;
  }

  constructor(public departmentService: DepartmentService, public productService: ProductService, private route: Router,
              public cartService: CartService) {
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
    this.onChangeTotal();
  }

  get key() {
    return Object.keys(this.cart);
  }

  cartEmpty(): boolean {
    return this.cartService.cart.length === 0;
  }

  calculateSubtotal() {
    let subtotal = 0;
    for (const item of this.cart) {
      subtotal += ((this.productService.getProduct(item[0]).price * 100) * item[1]) / 100;
    }
    console.log(subtotal);
    this.subtotal = subtotal;
  }

  checkout() {
    console.log('Checkout button clicked');
  }

  onClickContinueShopping() {
    this.route.navigateByUrl('/department');
  }


  
  onChangeTotal() {
    this.subtotal = 0;
  for (const item of this.cartService.cart) {
    this.subtotal += item.quantity * item.product.price;
    }
    this.deliveryFee = 6.44;
    this.total = this.subtotal + this.deliveryFee;
}
}
