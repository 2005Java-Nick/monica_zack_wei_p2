import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BodyComponent } from './body.component';
<<<<<<< HEAD
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
=======
import { DepartmentComponent } from './department/department.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { CartComponent } from './cart/cart.component';
>>>>>>> zack



@NgModule({
<<<<<<< HEAD
  declarations: [SearchBarComponent, BodyComponent, AdminComponent],
=======
  declarations: [BodyComponent, DepartmentComponent, AdminComponent, CartComponent],
>>>>>>> zack
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    BodyComponent
  ]
})
export class BodyModule { }
