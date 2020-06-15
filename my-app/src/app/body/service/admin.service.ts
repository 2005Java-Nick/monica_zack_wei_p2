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
}
