import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Router } from '@angular/router';
import { CartService } from '../cart/services/cart.service';
import { DepartmentService } from '../department/services/department.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  cart: any;
  selectedProduct: any;
  selectAddCartSubscription: any;
  cartSubscripton: any;

  constructor(public productService: ProductService, private route: Router, public cartService: CartService,
              private departmentService: DepartmentService) {
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

}
