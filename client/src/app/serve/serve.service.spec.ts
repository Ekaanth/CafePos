import { TestBed, inject } from '@angular/core/testing';

import { ServeService } from './serve.service';

describe('ServeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServeService]
    });
  });

  it('should ...', inject([ServeService], (service: ServeService) => {
    expect(service).toBeTruthy();
  }));
});
