import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from '../types/product';
import { DepartmentService } from '../department/services/department.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  selectedProduct: Product;
  cart: Map<number, number>;

  selectAddCartSubscription: Subscription;
  cartSubscripton: Subscription;

  constructor(public departmentService: DepartmentService, public productService: ProductService) {
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
  }

  get key(){
    return Object.keys(this.cart);
  }

  cartEmpty(): boolean{
    return this.cart.size === 0;
  }

  checkout(){
    console.log('Checkout button clicked');
  }
}
