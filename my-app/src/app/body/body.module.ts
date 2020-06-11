import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { BodyComponent } from './body.component';



@NgModule({
  declarations: [SearchBarComponent, BodyComponent],
  imports: [
    CommonModule
  ],
  exports: [
    SearchBarComponent,
    BodyComponent
  ]
})
export class BodyModule { }
