import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }


  uploadProduct(fd: FormData) {
    this.http.post(environment.productsURL, fd).subscribe(data => {
      console.log(data);
    });
  }

  updateProduct(fd: FormData) {
    this.http.put(environment.productsURL, fd).subscribe(data => {
      console.log(data);
    });
  }

  deleteProduct(fd: FormData) {
    this.http.put(environment.productsDeleteURL, fd).subscribe(data => {
      console.log(data);
    });
  }
}
