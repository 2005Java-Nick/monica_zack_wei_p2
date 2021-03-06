import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Invoice } from '../types/Invoice';
import { Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Driver } from '../types/driver';
import { Token } from 'src/app/login/types/Token';


@Injectable({
  providedIn: 'root'
})
export class DriverService {
  driverOrders: Array<Invoice>;
  driverOrdersUpdated: Subject<Array<Invoice>> = new Subject<Array<Invoice>>();

  driverShiftStatus: Driver;
  driverShiftStatusUpdates: Subject<Driver> = new Subject<Driver>();

  onShift: boolean;
  onShiftUpdates: Subject<boolean> = new Subject<boolean>();
  constructor(private http: HttpClient) {
    this.driverOrdersUpdated.subscribe((value) => {
      this.driverOrders = value;
    });

    this.driverShiftStatusUpdates.subscribe((value) => {
      this.driverShiftStatus = value;
    });

    this.onShiftUpdates.subscribe((value) => {
      this.onShift = value;
    });
  }


  getCustomerInvoices() {
    let params = new HttpParams();
    params = params.append('Token', sessionStorage.getItem('Token'));
    this.http.get<any>(environment.driverURL, { params: params }).subscribe((value) => {
      console.log(value);
      this.driverOrders = value;
      console.log(this.driverOrders);
      this.driverOrdersUpdated.next(value);
    });
  }

  updateDriverOrder(data: Invoice) {
    console.log(data);
    console.log(this.driverOrders);
    this.http.put(environment.driverURL, data).subscribe(data => {
      console.log(data);
    });
  }

  getDriverShiftStatus() {
    let params = new HttpParams();
    params = params.append('Token', sessionStorage.getItem('Token'));
    this.http.get<Driver>(environment.driverShiftStatusURL, { params: params }).subscribe((value) => {
      console.log(value);
      this.driverShiftStatus = value;
      console.log(this.driverShiftStatus);
      this.driverShiftStatusUpdates.next(value);
      this.onShiftUpdates.next(value.onShift);
    });
  }

  driverShiftToggle() {
    const token = new Token();
    token.token = sessionStorage.getItem('Token');
    this.http.put<boolean>(environment.driverShiftToggleURL, token).subscribe(data => {
      console.log(data);
      this.onShiftUpdates.next(data);
    });
  }
}
