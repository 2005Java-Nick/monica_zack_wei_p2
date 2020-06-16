import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Product } from '../types/product';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Array<Product>;

  productListUpdated: Subject<Array<Product>> = new Subject<Array<Product>>();

  constructor(private http: HttpClient) {
    this.productListUpdated.subscribe((value) => {
      this.products = value;
    });
   }

  getProducts() {
    this.http.get<any>(environment.productsURL).subscribe((value) => {
      console.log(value);
      this.products = value;
      console.log(this.products);
      this.productListUpdated.next(value);
    });
  }

  getProduct(id: number): Product {
    console.log('Products: ' + this.products);
    return this.products.find(product => product.id === id);
  }
}
