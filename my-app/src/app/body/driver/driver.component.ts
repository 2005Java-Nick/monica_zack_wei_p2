import { Component, OnInit } from '@angular/core';
import { DriverService } from '../service/driver.service';


@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {

  statuses = ['Pending', 'In Progress', 'Completed', 'Delayed', 'Unable to Complete'];

  constructor(public driverService: DriverService) { }

  ngOnInit(): void {
    this.driverService.getCustomerInvoices();
    this.driverService.getDriverShiftStatus();
  }

}
