import { TestBed } from '@angular/core/testing';

import { searchuserservice } from './searchuserservice';

describe('searchuserservice', () => {
  let service: searchuserservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(searchuserservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});