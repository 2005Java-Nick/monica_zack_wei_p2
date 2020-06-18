import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart/services/cart.service';
import { Product } from '../types/product';
import { Subscription } from 'rxjs';
import { DepartmentService } from '../department/services/department.service';
import { ProductService } from '../service/product.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/services/login.service';
import { Invoice } from '../types/Invoice';
import { OrdersService } from '../service/orders.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {

  invoice: Invoice;

  states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida',
    'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine',
    'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada',
    'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma',
    'Oregan', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont',
    'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];

  paymentMethods = ['Credit Card', 'Debit Card'];

  subtotal: number;
  tax: number;
  deliveryFee: number;
  total: number;
  selectedProduct: Product;
  cart: Map<number, number>;
  shipDate: string;
  customerComments: string;
  paymentMethod: string;
  valueChosen: string;
  cardNumber: string;
  orderConfirmation: boolean;

  selectAddCartSubscription: Subscription;
  cartSubscripton: Subscription;
  originalOrder = (a, b): number => {
    return 0;
  }

  constructor(public departmentService: DepartmentService, public productService: ProductService, private route: Router,
              public cartService: CartService, public loginService: LoginService, private ordersService: OrdersService) {
    /* this.invoice.cardNumber = ''; */
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
    this.invoice = new Invoice();
  }

  choose(event) {
    this.valueChosen = (event);
    this.paymentMethod = event.target.value;
    console.log(this.paymentMethod);
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

  onConfirm() {
    this.invoice.shippingDate = this.shipDate;
    const year = new Date().getFullYear();
    const month = new Date().getMonth();
    const date = new Date().getDate();
    this.invoice.purchaseDate = year.toString() + '-' + month.toString() + '-' + date.toString();
    this.invoice.subTotal = this.subtotal;
    this.invoice.tax = this.tax;
    this.invoice.deliveryCharge = this.deliveryFee;
    this.invoice.finalPrice = this.total;
    this.invoice.status = 'pending';
    this.invoice.customerComments = this.customerComments;
    this.invoice.paymentMethod = this.paymentMethod;
    this.invoice.cardNumber = this.cardNumber;
    this.invoice.customer = this.loginService.user;
    this.invoice.itemList = this.cartService.cart;
    console.log(this.invoice);
    this.ordersService.submitOrder(this.invoice).subscribe((value) => {
      this.orderConfirmation = value;
      console.log(this.orderConfirmation);
    });
  }

  onClickContinueShopping() {
    this.route.navigateByUrl('/department');
  }



  onChangeTotal() {
    this.subtotal = 0;
    for (const item of this.cartService.cart) {
      this.subtotal += item.quantity * item.product.price;
    }
    const tax = (((this.subtotal * 100) * 0.05) * 100) / 10000;
    this.tax = tax;
    if (this.subtotal >= 50) {
      this.deliveryFee = 0;
    } else {
      this.deliveryFee = 6.44;
    }
    this.total = this.subtotal + this.deliveryFee + tax;
  }

  print(item) {
    console.log('Cart item:' + item);
  }
}
