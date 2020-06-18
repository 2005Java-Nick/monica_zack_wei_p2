import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Invoice } from '../types/Invoice';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  invoices: Array<Invoice>;

  invoicesUpdated: Subject<Array<Invoice>> = new Subject<Array<Invoice>>();

  constructor(private http: HttpClient) {
    this.invoicesUpdated.subscribe((value) => {
      this.invoices = value;
    });
  }

  getCustomerInvoices() {
    let params = new HttpParams();
    params = params.append('Token', sessionStorage.getItem('Token'));
    this.http.get<any>(environment.invoicesURL, { params: params }).subscribe((value) => {
      console.log(value);
      this.invoices = value;
      console.log(this.invoices);
      this.invoicesUpdated.next(value);
    });
  }

  sendOrder(invoice: Invoice): Observable<boolean> {
    return this.http.post<boolean>(environment.invoicesURL, invoice);
  }

  submitOrder(invoice: Invoice): Observable<boolean> {
    const ob = new Observable<boolean>(
      (obser) => {
        this.sendOrder(invoice).subscribe(
          (data: boolean) => {
            console.log(data);
            if (data == null || data === false) { obser.next(false); }
            if (data != null || data === true) {obser.next(true); }
          }
        );
      }
    );
    return ob;
  }
}
