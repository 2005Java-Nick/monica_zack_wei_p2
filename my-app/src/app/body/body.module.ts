import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BodyComponent } from './body.component';
import { DepartmentComponent } from './department/department.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [BodyComponent, DepartmentComponent, AdminComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    BodyComponent
  ]
})
export class BodyModule { }
