import { Component, OnInit } from '@angular/core';
import { Product } from '../types/product';
import { Department } from '../types/department';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {

  products: Array<Product>;

  department: Array<Department>;

  constructor() { }

  ngOnInit(): void {
  }

}

                    
                 