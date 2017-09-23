import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BillDetatilComponent } from './bill-detatil.component';

describe('BillDetatilComponent', () => {
  let component: BillDetatilComponent;
  let fixture: ComponentFixture<BillDetatilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillDetatilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillDetatilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
