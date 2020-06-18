import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvoiceviewComponent } from './invoiceview.component';

describe('InvoiceviewComponent', () => {
  let component: InvoiceviewComponent;
  let fixture: ComponentFixture<InvoiceviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvoiceviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvoiceviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
