import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../service/admin.service';
import { Token } from 'src/app/login/types/Token';
import { Product } from '../types/product';
import { ProductService } from '../service/product.service';


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


  constructor(private adminService: AdminService, private productServices: ProductService) { }

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

}