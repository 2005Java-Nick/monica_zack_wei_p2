import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ProductService } from './product.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient, private productsService: ProductService) { }


  uploadProduct(fd: FormData) {
    this.http.post(environment.productsURL, fd).subscribe(data => {
      console.log(data);
      this.productsService.getProducts();
    });
  }

  updateProduct(obj) {
    this.http.put(environment.productsURL, obj).subscribe(data => {
      console.log(data);
      this.productsService.getProducts();
    });
  }

  deleteProduct(obj) {
    this.http.put(environment.productsDeleteURL, obj).subscribe(data => {
      console.log(data);
      this.productsService.getProducts();
    });
  }
}
