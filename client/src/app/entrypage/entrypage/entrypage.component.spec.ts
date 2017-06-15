import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrypageComponent } from './entrypage.component';

describe('EntrypageComponent', () => {
  let component: EntrypageComponent;
  let fixture: ComponentFixture<EntrypageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntrypageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrypageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
