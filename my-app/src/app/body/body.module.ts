import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BodyComponent } from './body.component';
import { DepartmentComponent } from './department/department.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { CartComponent } from './cart/cart.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { MealkitsComponent } from './department/mealkits/mealkits.component';
import { ConfirmationComponent } from './purchase/confirmation/confirmation.component';
import { InvoiceviewComponent } from './invoiceview/invoiceview.component';
import { DriverComponent } from './driver/driver.component';



@NgModule({
  declarations: [BodyComponent, DepartmentComponent, AdminComponent, CartComponent,
    PurchaseComponent, InvoiceComponent, MealkitsComponent, ConfirmationComponent, InvoiceviewComponent, DriverComponent],
  imports: [
    CommonModule,
    FormsModule,
  ],
  exports: [
    BodyComponent
  ]
})
export class BodyModule { }
