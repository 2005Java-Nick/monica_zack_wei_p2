import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdersService } from '../../service/orders.service';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent implements OnInit {

  constructor(private route: Router, public ordersService: OrdersService) { }

  ngOnInit(): void {
  }

  onClickContinueShopping() {
    this.route.navigateByUrl('/department');
  }
}
