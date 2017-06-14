import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingpageComponent } from './billingpage.component';

describe('BillingpageComponent', () => {
  let component: BillingpageComponent;
  let fixture: ComponentFixture<BillingpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillingpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillingpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
