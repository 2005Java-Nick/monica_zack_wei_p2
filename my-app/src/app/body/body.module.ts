import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { BodyComponent } from './body.component';
import { DepartmentComponent } from './department/department.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [SearchBarComponent, BodyComponent, DepartmentComponent, AdminComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    SearchBarComponent,
    BodyComponent
  ]
})
export class BodyModule { }
