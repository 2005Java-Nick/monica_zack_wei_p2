import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderBarComponent } from './header-bar/header-bar.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';



@NgModule({
  declarations: [HeaderBarComponent, NavBarComponent],
  imports: [
    CommonModule
  ],
  exports: [
    HeaderBarComponent
  ]
})
export class HeaderModule { }
