import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../service/admin.service';
import { Token } from 'src/app/login/types/Token';
import { Product } from '../types/product';
import { ProductService } from '../service/product.service';
import { LoginService } from 'src/app/login/services/login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  product: Product;
  file: File;
  token: Token = {
    token: ''
  };

  currentProducts: Product[];

  constructor(private adminService: AdminService, private productServices: ProductService,
              private loginService: LoginService, private route: Router) {
    if (!loginService.isLogin) {
      route.navigateByUrl('/home');
    }
    this.currentProducts = this.productServices.products;
    this.productServices.productListUpdated.subscribe((value) => {
      this.currentProducts = value;
    });
   }

  ngOnInit(): void {
    this.product = new Product();
  }


  onFileSelected(event) {
    this.file = event.target.files;
    console.log(this.file);
  }

  addProduct() {
    this.token.token = sessionStorage.getItem('Token');

    const fd = new FormData();
    fd.append('token', new Blob([JSON.stringify(this.token)],
      {
        type: 'application/json'
      }));
    fd.append('product', new Blob([JSON.stringify(this.product)],
      {
        type: 'application/json'
      }));

    fd.append('file', this.file[0], this.file.name);

    this.adminService.uploadProduct(fd);
  }
  onClick() {
    this.addProduct();
  }



  // Must give product ID, this function updates by ID of product. And needs a product
  updateProduct(i) {
    this.token.token = sessionStorage.getItem('Token');
    const tempVar = { token: this.token, product: this.currentProducts[i] };

    this.adminService.updateProduct(tempVar);
  }

  // Must give product ID, this function updates by ID of product. And needs a product
  deleteProduct(i) {
    this.token.token = sessionStorage.getItem('Token');
    const tempVar = { token: this.token, product: this.currentProducts[i] };
    
    this.adminService.deleteProduct(tempVar);
  }
}
