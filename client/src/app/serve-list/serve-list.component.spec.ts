import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServeListComponent } from './serve-list.component';

describe('ServeListComponent', () => {
  let component: ServeListComponent;
  let fixture: ComponentFixture<ServeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
