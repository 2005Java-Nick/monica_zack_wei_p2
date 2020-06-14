import { Injectable } from '@angular/core';
import { Department } from '../../types/department';
import { Product } from '../../types/product';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  products: Array<Product> = [
    new Product(1,'Cauliflower', 'Fresh and Organic', 3.48, 87, 'assets/images/cauliflower.png'),
    new Product(2, 'Tomato', 'Tasty', 1.48, 72, 'assets/images/tomatoes.jpg'),
    new Product(3, 'Cucumbers', 'Fresh and Green',1.78, 50, 'assets/images/cucumbers.jpg'),
    new Product(4, 'Asparagus', 'Fresh and Organic', 5.48, 15, 'assets/images/asparagus.jpg'),
    new Product(5, 'Onion', 'Fresh and Organic', 1.25, 64, 'assets/images/onion.jpg'),
    new Product(6, 'Potatoes', 'Idaho potatoes', 2.59, 47, 'assets/images/potatoes.jpg'),
    new Product(7, 'Garlic', 'Keeps vampires away', 0.50, 80, 'assets/images/garlic.jpg'),
    new Product(8, 'Ginger', 'Juicy', 2.09, 36, 'assets/images/ginger.jpg')
  ];

  department: Array<Department> = [
    new Department(1, 'Fresh Produce'),
    new Department(2, 'Bakery'),
    new Department(3, 'Beverages'),
    new Department(4, 'Poultry'),
    new Department(5, 'Meal Kit')
  ];

  constructor() { }
}
