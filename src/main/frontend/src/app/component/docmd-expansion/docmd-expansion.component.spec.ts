import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocmdExpansionComponent } from './docmd-expansion.component';

describe('DocmdExpansionComponent', () => {
  let component: DocmdExpansionComponent;
  let fixture: ComponentFixture<DocmdExpansionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocmdExpansionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocmdExpansionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
