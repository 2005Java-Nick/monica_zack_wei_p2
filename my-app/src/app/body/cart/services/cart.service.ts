import { Injectable } from '@angular/core';
import { Subscription } from 'rxjs';
import { ProductService } from '../../service/product.service';
import { Product } from '../../types/product';
import { ItemList } from '../../types/itemlist';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: ItemList[] = [];
  products: Product[];
  productSubscription: Subscription;

  constructor(private productService: ProductService) {
    this.products = productService.products;
    this.productSubscription = productService.productListUpdated.subscribe(data => {
      this.products = data;
    });
  }

  addItem(item: Product, amount: number) {
    console.log("Products Updated");
    console.log(this.cart);
    this.cart.push(new ItemList(item, amount));
  }
  removeItem(index) {
    this.cart.splice(index, 1);
  }

  updateCart(index: number, amount: number) {
    this.cart[index].quantity = amount;
  }
}
