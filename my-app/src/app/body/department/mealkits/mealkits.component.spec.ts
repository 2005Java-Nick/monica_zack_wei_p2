import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MealkitsComponent } from './mealkits.component';

describe('MealkitsComponent', () => {
  let component: MealkitsComponent;
  let fixture: ComponentFixture<MealkitsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MealkitsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MealkitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
