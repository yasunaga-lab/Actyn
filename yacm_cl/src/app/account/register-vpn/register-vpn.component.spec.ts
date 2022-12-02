import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterVpnComponent } from './register-vpn.component';

describe('RegisterVpnComponent', () => {
  let component: RegisterVpnComponent;
  let fixture: ComponentFixture<RegisterVpnComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterVpnComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterVpnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
