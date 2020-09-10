import { TestBed } from '@angular/core/testing';

import { IpoDetailService } from './ipo-detail.service';

describe('IpoDetailService', () => {
  let service: IpoDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IpoDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
