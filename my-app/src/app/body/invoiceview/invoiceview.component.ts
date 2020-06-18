import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../service/orders.service';

@Component({
  selector: 'app-invoiceview',
  templateUrl: './invoiceview.component.html',
  styleUrls: ['./invoiceview.component.css']
})
export class InvoiceviewComponent implements OnInit {

  constructor(public ordersService: OrdersService) { }

  ngOnInit(): void {
    this.ordersService.getCustomerInvoices();
  }
}
