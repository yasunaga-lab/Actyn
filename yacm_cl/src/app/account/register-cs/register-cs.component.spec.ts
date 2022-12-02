import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCsComponent } from './register-cs.component';

describe('RegisterCsComponent', () => {
  let component: RegisterCsComponent;
  let fixture: ComponentFixture<RegisterCsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterCsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterCsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
