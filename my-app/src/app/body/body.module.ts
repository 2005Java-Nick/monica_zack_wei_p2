import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { BodyComponent } from './body.component';
import { DepartmentComponent } from './department/department.component';



@NgModule({
  declarations: [SearchBarComponent, BodyComponent, DepartmentComponent],
  imports: [
    CommonModule
  ],
  exports: [
    SearchBarComponent,
    BodyComponent
  ]
})
export class BodyModule { }
