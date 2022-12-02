import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LanMapComponent } from './lan-map.component';

describe('LanMapComponent', () => {
  let component: LanMapComponent;
  let fixture: ComponentFixture<LanMapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LanMapComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LanMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
