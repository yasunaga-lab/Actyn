import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CsMonitoringComponent } from './cs-monitoring.component';

describe('CsMonitoringComponent', () => {
  let component: CsMonitoringComponent;
  let fixture: ComponentFixture<CsMonitoringComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CsMonitoringComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CsMonitoringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
